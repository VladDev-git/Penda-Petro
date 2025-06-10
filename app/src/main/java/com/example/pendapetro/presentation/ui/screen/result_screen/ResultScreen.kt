package com.example.pendapetro.presentation.ui.screen.result_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pendapetro.presentation.ui.components.ResultCard
import com.example.pendapetro.presentation.viewmodel.TestViewModel
import com.example.pendapetro.ui.theme.gradients.MangoLimeGradientBackground
import org.koin.androidx.compose.koinViewModel

@Composable
fun ResultScreen(
    onNavHomeScreen: () -> Unit,
    onNavRetakeTest: () -> Unit,
    viewModel: TestViewModel = koinViewModel()
) {
    val score = viewModel.score.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .MangoLimeGradientBackground()
            .padding(horizontal = 15.dp),
        contentAlignment = Alignment.Center
    ) {
        ResultCard(
            score = score.value,
            onRetakeTest = {
                viewModel.restartQuiz()
                onNavRetakeTest()
            },
            onNavHomeScreen = { onNavHomeScreen()}
        )
    }
}