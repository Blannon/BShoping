package com.blannon_network.bshoping

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.blannon_network.bshoping.screens.SigningScreen
import com.blannon_network.bshoping.ui.theme.BShopingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        installSplashScreen()
        setContent {
            BShopingTheme {
                SigningScreen()
            }
        }
    }
}

