package com.example.pendapetro.presentation.ui.screen.test_sreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pendapetro.presentation.ui.components.QuestionCard
import com.example.pendapetro.ui.theme.gradients.MangoLimeGradientBackground

@Composable
fun TestScreen(

) {
    val maxScore = 7

    Box(
        modifier = Modifier
            .fillMaxSize()
            .MangoLimeGradientBackground()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp, bottom = 10.dp, start = 20.dp, end = 20.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(6.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
//                repeat(maxScore) { index ->
//                    Box(
//                        modifier = Modifier
//                            .weight(1f)
//                            .height(6.dp)
//                            .clip(RoundedCornerShape(50))
//                            .background(if (index < currentIndex) Color.White else Color.Gray)
//                    )
//                    if (index != maxScore - 1) {
//                        Spacer(modifier = Modifier.width(1.dp))
//                    }
//                }
            }
            QuestionCard()
        }
    }
}


