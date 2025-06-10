package com.example.pendapetro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pendapetro.presentation.ui.screen.home_screen.HomeScreen
import com.example.pendapetro.presentation.ui.screen.home_screen.data.HomeScreenObject
import com.example.pendapetro.presentation.ui.screen.result_screen.ResultScreen
import com.example.pendapetro.presentation.ui.screen.result_screen.data.ResultScreenObject
import com.example.pendapetro.presentation.ui.screen.test_sreen.TestScreen
import com.example.pendapetro.presentation.ui.screen.test_sreen.data.TestScreenObject
import com.example.pendapetro.ui.theme.PendaPetroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            PendaPetroTheme {
                NavHost(
                    navController = navController,
                    startDestination = ResultScreenObject,
                ) {
                    composable<HomeScreenObject> {
                        HomeScreen()
                    }
                    composable<TestScreenObject> {
                        TestScreen()
                    }
                    composable<ResultScreenObject> {
                        ResultScreen()
                    }
                }
            }
        }
    }
}


