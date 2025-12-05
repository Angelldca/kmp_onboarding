package org.angelldca.helloworld.screen.ui.dashboard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun SideBar(itemsElements: List<String>,modifier: Modifier = Modifier){
    val sidebarColor = Color(0xFF2B4C80)
    val shape = RoundedCornerShape(
       // topStart = 24.dp,   // esquina superior izquierda
        topEnd = 24.dp,     // esquina superior derecha
        bottomEnd = 24.dp   // esquina inferior derecha
        // bottomStart = 0.dp // si la quieres recta pegada a la pantalla
    )
    Surface(
        color = sidebarColor,
        //shape = shape,
       // shadowElevation = 12.dp,
        modifier = modifier
            .width(280.dp)
            .fillMaxHeight()
            //.clip(shape)
    ) {
        //Spacer(Modifier.width(12.dp))
        Column(
           // modifier = modifier.padding(top = 0.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment= Alignment.Start,
        ) {
            itemsElements.map {
                Text(
                    modifier =
                        Modifier.fillMaxWidth()
                            .padding(start = 15.dp),
                    text = it,
                    color = Color(0xFFF1E7E7),
                    textAlign = TextAlign.Start
                )
            }
        }
    }
}