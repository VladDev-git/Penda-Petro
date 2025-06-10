package com.example.pendapetro.presentation.ui.screen.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pendapetro.presentation.ui.components.CategoryItemButton
import com.example.pendapetro.presentation.viewmodel.TestViewModel
import com.example.pendapetro.ui.theme.DarkBlue
import com.example.pendapetro.ui.theme.customFont_Ruberoid_ExtraBold
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    onNavQuestionScreen: () -> Unit,
    viewModel: TestViewModel = koinViewModel()
) {
    val categories = viewModel.categories.collectAsState(initial = emptyList())

    Box(
        modifier = Modifier
            .fillMaxSize()
            //.alpha(0.6f)
            //.MangoLimeGradientBackground(),
            .background(Color.White)
            .padding(top = 50.dp, bottom = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                //.verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Seleccione una categoría",
                fontSize = 30.sp,
                lineHeight = 34.sp,
                color = DarkBlue,
                textAlign = TextAlign.Center,
                fontFamily = customFont_Ruberoid_ExtraBold,
            )
            Spacer(modifier = Modifier.height(20.dp))
            LazyColumn (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                items(categories.value) { categoryItem ->
                    CategoryItemButton(
                        category = categoryItem,
                        onClick = {
                            viewModel.loadQuestions(categoryItem.category)
                            onNavQuestionScreen()
                        }
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
    }
}