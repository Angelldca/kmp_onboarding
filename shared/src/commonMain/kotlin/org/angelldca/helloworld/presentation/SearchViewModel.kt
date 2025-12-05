package org.angelldca.helloworld.presentation

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import org.angelldca.helloworld.data.repository.PokemonRepository

class SearchViewModel(
    private val repository: PokemonRepository,
) {

    // --- Estados ---
    private val _query = MutableStateFlow("")
    val query: StateFlow<String> = _query.asStateFlow()

    private val _suggestions = MutableStateFlow<String>("")
    val suggestions: StateFlow<String> = _suggestions.asStateFlow()

    private val _detail = MutableStateFlow<String?>(null)
    val detail: StateFlow<String?> = _detail.asStateFlow()

    private val viewModelScope = CoroutineScope(Dispatchers.Default + SupervisorJob())
    private var searchJob: Job? = null
    init {
        observeQuery()
        println("_______________________Se ejecuta el init__________________")
    }

    fun onQueryChanged(newQuery: String) {
        _query.value = newQuery
    }

    fun onSuggestionSelected(selection: String) {
        _detail.value = null // limpiamos antes
        viewModelScope.launch {
            val result = detailApi(selection)
            _detail.value = result
        }
    }

    private fun observeQuery() {

        searchJob?.cancel()

      searchJob = viewModelScope.launch {
            _query
                .debounce(4000)  // Espera 2 segundos después de escribir
                .filter { it.isNotBlank() }
                .collect { q ->
                   // val results = searchApi(q)
                    println("---------------ObserverQuery inside---------------------")
                    runCatching { repository.getPokemon(q) }
                        .onSuccess { dto ->
                            _suggestions.update {  "name: ${dto.name} height: ${dto.height} weight: ${dto.weight}"}
                        }
                        .onFailure { e ->
                           // _state.update { it.copy(isLoading = false, result = null, error = e.message ?: "Error") }
                        }
                    //_suggestions.value = results
                }
        }
    }

    fun clear() {
        println("---------------ObserverQuery---------------------")
        searchJob?.cancel()
        viewModelScope.cancel()

    }
}

// --- Simulaciones de API ---
suspend fun searchApi(query: String): List<String> {
    delay(500)
    return listOf("$query Result 1", "$query Result 2", "$query Result 3")
}

suspend fun detailApi(selection: String): String {
    delay(500)
    return "Detail info for $selection"
}