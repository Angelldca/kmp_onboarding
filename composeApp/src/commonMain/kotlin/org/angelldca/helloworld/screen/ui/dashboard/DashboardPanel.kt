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
import org.angelldca.helloworld.presentation.SearchViewModel
import org.angelldca.helloworld.screen.ui.Search
import org.angelldca.helloworld.screen.ui.doc_test.CenterAlignedTopAppBarExample
import org.angelldca.helloworld.screen.ui.screen

import org.koin.compose.koinInject


@Composable
fun DashboardPanel(){
    println("++++++Recomposable Dashboard Panel+++++++++++++++++++++++++++++++++")
    val vm: SearchViewModel = koinInject()
    DisposableEffect(Unit) {
        onDispose { vm.clear() }
    }
    val suggestions by vm.suggestions.collectAsState()

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
                Search(vm = vm)

                Spacer(Modifier.height(12.dp))
                when {
                    suggestions.isEmpty() -> CenterAlignedTopAppBarExample("Buscando...")
                    // state.error != null ->CenterAlignedTopAppBarExample("Error: ${state.error}")
                    //  state.result != null ->CenterAlignedTopAppBarExample("Result: ${state.result}")
                    else -> CenterAlignedTopAppBarExample(suggestions)

                }
            }

        }
    }
}


