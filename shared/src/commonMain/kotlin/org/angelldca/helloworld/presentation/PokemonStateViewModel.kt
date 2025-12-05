package org.angelldca.helloworld.presentation

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import org.angelldca.helloworld.data.repository.PokemonRepository

data class PokemonUiState(
    val query: String = "",
    val isLoading: Boolean = false,
    val result: String? = null,
    val error: String? = null
)

class PokemonSearchViewModel(
    //private val api: PokeApiService,
    private val repository: PokemonRepository,
    private val debounceMs: Long = 200L
) {
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

    private var searchJob: Job? = null

    private val _state = MutableStateFlow(PokemonUiState())
    val state: StateFlow<PokemonUiState> = _state

    fun onQueryChange(newQuery: String) {
        _state.update { it.copy(query = newQuery, error = null) }

        val q = newQuery.trim().lowercase()

        // Cancela búsqueda anterior
        searchJob?.cancel()

        // Si es muy corto, limpia y no llama
        if (q.length < 3) {
            _state.update { it.copy(isLoading = false, result = null, error = null) }
            return
        }

        searchJob = scope.launch {
            delay(debounceMs)

            _state.update { it.copy(isLoading = true, error = null) }

            runCatching { repository.getPokemon(q) }
                .onSuccess { dto ->
                    _state.update { it.copy(isLoading = false, result = "name: ${dto.name} height: ${dto.height} weight: ${dto.weight}", error = null) }
                }
                .onFailure { e ->
                    _state.update { it.copy(isLoading = false, result = null, error = e.message ?: "Error") }
                }
        }
    }

    fun onSearch() {
        onQueryChange(_state.value.query)
    }

    fun clear() {
        searchJob?.cancel()
        scope.cancel()
    }
}