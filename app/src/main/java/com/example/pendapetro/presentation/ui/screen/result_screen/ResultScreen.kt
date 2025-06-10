package com.example.pendapetro.presentation.ui.screen.result_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pendapetro.presentation.ui.components.ResultCard
import com.example.pendapetro.ui.theme.gradients.MangoLimeGradientBackground

@Composable
fun ResultScreen(

) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .MangoLimeGradientBackground()
            .padding(horizontal = 15.dp),
        contentAlignment = Alignment.Center
    ) {
        ResultCard()
    }
}