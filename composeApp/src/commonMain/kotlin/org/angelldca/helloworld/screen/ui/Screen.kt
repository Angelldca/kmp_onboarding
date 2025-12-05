package org.angelldca.helloworld.screen.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.angelldca.helloworld.getPlatform


@Composable
fun screen (modifier:Modifier = Modifier, content: @Composable ()-> Unit){
    val isDarkMode = isSystemInDarkTheme()
    val colorSchema = if(isDarkMode) darkColorScheme() else lightColorScheme()

    val scheme = if (getPlatform().isWeb) MaterialTheme.colorScheme else colorSchema

    MaterialTheme(colorScheme = scheme) {
        Surface(Modifier.fillMaxWidth(), content = content)
    }

}