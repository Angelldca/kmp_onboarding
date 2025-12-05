package org.angelldca.helloworld.screen.ui.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

import org.angelldca.helloworld.presentation.PokemonSearchViewModel
import org.angelldca.helloworld.screen.ui.Search
import org.angelldca.helloworld.screen.ui.screen

import org.koin.compose.koinInject


@Composable
fun DashboardPanel(){
    println("++++++Recomposable Dashboard Panel+++++++++++++++++++++++++++++++++")
    //val vm = remember { PokemonSearchViewModel(api) }
    val vm: PokemonSearchViewModel = koinInject()
    DisposableEffect(Unit) {
        onDispose { vm.clear() }
    }
    val state by vm.state.collectAsState()

    screen {
        val shape = RoundedCornerShape(12.dp)

        Box(
          modifier = Modifier.fillMaxWidth()
              .fillMaxHeight()
              .background(Color(0xFFcccccc))
              .clip(shape)
              .padding(20.dp)
        ){
            Column {
                //RecomposeCounter("DashboardPanel")
                Search(
                    query = state.query,
                    onQueryChange = vm::onQueryChange, // ✅ aquí se dispara la lógica
                    onSearch = vm::onSearch
                )

                Spacer(Modifier.height(12.dp))
                when {

                    state.isLoading -> LoggingText("Buscando...")
                    state.error != null -> LoggingText("Error: ${state.error}")
                    state.result != null -> LoggingText("Encontrado: ${state.result} ")
                }
            }

        }
    }
}

@Composable
fun LoggingText(
    text: String,
    tag: String = "LoggingText"
) {
    println("++++++++++====[$tag] Recompuesto con texto: '$text' +++++++++++++++++++++++++++++++")
    Text(text = text)
}
