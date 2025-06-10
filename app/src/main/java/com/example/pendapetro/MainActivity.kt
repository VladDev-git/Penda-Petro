package com.example.pendapetro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
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

        WindowCompat.setDecorFitsSystemWindows(window, false)

        val controller = WindowInsetsControllerCompat(window, window.decorView)
        controller.hide(WindowInsetsCompat.Type.navigationBars())
        controller.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE

        setContent {
            val navController = rememberNavController()

            PendaPetroTheme {
                NavHost(
                    navController = navController,
                    startDestination = HomeScreenObject,
                ) {
                    composable<HomeScreenObject> {
                        HomeScreen(
                            onNavQuestionScreen = {
                                navController.navigate(TestScreenObject)
                            }
                        )
                    }
                    composable<TestScreenObject> {
                        TestScreen(
                            onNavResultScreen = {
                                navController.navigate(ResultScreenObject) {
                                    popUpTo(HomeScreenObject) { inclusive = true }
                                }
                            },
                        )
                    }
                    composable<ResultScreenObject> {
                        ResultScreen(
                            onNavHomeScreen = {
                                navController.navigate(HomeScreenObject) {
                                    popUpTo(HomeScreenObject) { inclusive = true }
                                }
                            },
                            onNavRetakeTest = {
                                navController.navigate(TestScreenObject) {
                                    popUpTo(HomeScreenObject) { inclusive = true }
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}


