package org.angelldca.helloworld.screen.ui.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlinproject.composeapp.generated.resources.Res
import kotlinproject.composeapp.generated.resources.back
import org.angelldca.helloworld.getPlatform
import org.angelldca.helloworld.screen.ui.back.OnBack
import org.angelldca.helloworld.screen.ui.screen
import org.jetbrains.compose.resources.stringResource


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dashboard(back:()-> Unit){
    screen {
        Scaffold (
            topBar = { OnBack(back) },
        ){ innerPadding ->
            Row (
                modifier =
                Modifier.padding(innerPadding)

            ){
                if (getPlatform().isWeb) {
                    SideBar(listOf("test 1", "test 2", "test3"))
                }
                DashboardPanel()
            }
        }
    }
}