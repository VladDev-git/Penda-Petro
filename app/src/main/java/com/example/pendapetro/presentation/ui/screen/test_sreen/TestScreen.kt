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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pendapetro.R
import com.example.pendapetro.data.entitys.QuestionCategory
import com.example.pendapetro.presentation.ui.components.QuestionCard
import com.example.pendapetro.presentation.viewmodel.TestViewModel
import com.example.pendapetro.ui.theme.gradients.MangoLimeGradientBackground
import org.koin.androidx.compose.koinViewModel

@Composable
fun TestScreen(
    onNavResultScreen : () -> Unit,
    viewModel: TestViewModel = koinViewModel()
) {
    val maxScore = 7
    val questions by viewModel.questions.collectAsState(initial = emptyList())
    val currentIndex by viewModel.currentIndex.collectAsState()
    val currentQuestion = if (questions.isNotEmpty() && currentIndex < questions.size) {
        questions[currentIndex]
    } else {
        null
    }
    val img = when (currentQuestion?.category) {
        QuestionCategory.BASICS_OF_INVESTING_1 -> R.drawable.category_1_img
        QuestionCategory.MARKET_ANALYSIS_AND_PRICING_2 -> R.drawable.category_2_img
        QuestionCategory.INFRASTRUCTURE_AND_COMPANIES_3 -> R.drawable.category_3_img
        QuestionCategory.FINANCIAL_INSTRUMENTS_AND_STRATEGIES_4 -> R.drawable.category_4_img
        null -> R.drawable.category_1_img
    }
    val selectedOption = remember {
        mutableStateOf(-1)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .MangoLimeGradientBackground()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 70.dp, bottom = 10.dp, start = 20.dp, end = 20.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(6.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                repeat(maxScore) { index ->
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(6.dp)
                            .clip(RoundedCornerShape(50))
                            .background(if (index < currentIndex) Color.White else Color.Gray)
                    )
                    if (index != maxScore - 1) {
                        Spacer(modifier = Modifier.width(1.dp))
                    }
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            QuestionCard(
                currentQuestion = currentQuestion ?: return@Column,
                selectedOption = selectedOption,
                img = img,
                onOptionSelected = {
                    if (selectedOption.value != -1) {
                        viewModel.submitAnswer(selectedOption.value)
                        selectedOption.value = -1
                    }
                    if (currentIndex >= maxScore - 1) {
                        onNavResultScreen()
                    }
                }
            )
        }
    }
}


