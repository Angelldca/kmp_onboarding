package org.angelldca.helloworld.utils

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color


@Composable
fun RecomposeCounter(tag: String, modifier: Modifier = Modifier) {
    val count = remember { mutableIntStateOf(0) }
    SideEffect { count.intValue++ } // se ejecuta tras cada recomposición exitosa

    Text(
        text = "$tag recomposed: ${count.intValue}",
        modifier = modifier,
        color = Color.Red
    )
}