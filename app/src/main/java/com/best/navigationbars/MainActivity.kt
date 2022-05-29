package com.best.navigationbars

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.best.navigationbars.lightpanel.LightRayBottomNavView
import com.best.navigationbars.lightpanel.builder.LightRayBottomNavViewSetup
import com.best.navigationbars.lightpanel.builder.LightRayViewSetup
import com.best.navigationbars.model.NavigationBarItems
import com.best.navigationbars.ui.theme.BrightRed
import com.best.navigationbars.ui.theme.NavigationBarsTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationBarsTheme {
                val systemUiController = rememberSystemUiController()
                SideEffect {
                    systemUiController.setSystemBarsColor(
                        color = Color.LightGray
                    )
                }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.LightGray), verticalArrangement = Arrangement.Center
                ) {

                    DefaultNavigationPanel()

                    Spacer(modifier = Modifier.height(16.dp))

                    RedNavigationPanel()
                }
            }
        }
    }

    @Composable
    private fun DefaultNavigationPanel() {
        var currentItem by remember {
            mutableStateOf(
                NavigationBarItems.Home
            )
        }
        LightRayBottomNavView(
            currentItemId = currentItem.id
        ) {
            currentItem = it
        }
    }

    @Composable
    private fun RedNavigationPanel() {
        var currentItem by remember {
            mutableStateOf(
                NavigationBarItems.Home
            )
        }
        val redLightNavigationSetup = LightRayViewSetup.Builder()
            .lightColor(Color.Red)
            .lightPanelColor(BrightRed)
            .build()

        val navigationSetup =
            LightRayBottomNavViewSetup.Builder()
                .iconColor(Color.Gray)
                .selectedIconColor(BrightRed)
                .lightRayViewSetup(redLightNavigationSetup)
                .build()

        LightRayBottomNavView(
            navigationSetup,
            currentItemId = currentItem.id
        ) {
            currentItem = it
        }
    }
}


