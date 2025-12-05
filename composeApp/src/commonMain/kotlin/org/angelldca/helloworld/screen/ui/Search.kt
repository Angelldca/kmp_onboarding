package org.angelldca.helloworld.screen.ui


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction

import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Search(
    query: String,
    onQueryChange: (String) -> Unit,
    onSearch: () -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "Search your task here..."
) {
    println("++++++++++++++++++++++++++++recomposable Search+++++++++++++++++++++++++++++++++")
    val shape = RoundedCornerShape(12.dp)
    MaterialTheme {
        Surface(
            shape = shape,
            shadowElevation = 10.dp,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .height(64.dp)

        ) {
            Row(
                modifier = modifier
                    .fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                     TextField(
                         value = query,
                         onValueChange = onQueryChange,
                         placeholder = { Text(placeholder) },
                         singleLine = true,
                         modifier = Modifier.weight(1f),
                         colors = TextFieldDefaults.colors(
                             focusedContainerColor = Color.Transparent,
                             unfocusedContainerColor = Color.Transparent,
                             disabledContainerColor = Color.Transparent,
                             focusedIndicatorColor = Color.Transparent,
                             unfocusedIndicatorColor = Color.Transparent,
                             cursorColor = Color.Black
                         ),
                         keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                         keyboardActions = KeyboardActions(onSearch = { onSearch() }),
                         )

                    IconButton(
                        onClick = onSearch,
                        modifier = Modifier
                            .size(64.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color(0xFF2655CE))

                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search",
                            tint = Color.White
                        )
                    }
                }

        }
    }
}
