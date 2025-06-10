package com.example.pendapetro.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pendapetro.data.entitys.Question
import com.example.pendapetro.ui.theme.CategoryItemBackground
import com.example.pendapetro.ui.theme.DarkBlue
import com.example.pendapetro.ui.theme.TextBlackYellow
import com.example.pendapetro.ui.theme.customFont_Ruberoid_ExtraBold
import com.example.pendapetro.ui.theme.gradients.MangoLimeGradientBackground

@Composable
fun QuestionCard(
    currentQuestion: Question,
    selectedOption: MutableState<Int>,
    img: Int,
    onOptionSelected: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(32.dp))
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ) {
            Image(
                painter = painterResource(id = img),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(144.dp)
                    .clip(RoundedCornerShape(20.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = currentQuestion.questionText,
                fontSize = 20.sp,
                lineHeight = 26.sp,
                color = TextBlackYellow,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight(700),
                fontFamily = customFont_Ruberoid_ExtraBold,
            )
            Spacer(modifier = Modifier.height(20.dp))

            currentQuestion.answers.forEachIndexed { index, answer ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(50.dp))
                        .background(if (selectedOption.value == index) CategoryItemBackground else Color.White)
                        .padding(10.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = selectedOption.value == index,
                                onClick = {
                                    selectedOption.value = index
                                }
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = selectedOption.value == index,
                            onClick = {
                                selectedOption.value = index
                            },
                            colors = RadioButtonDefaults.colors(
                                selectedColor = Color.White,
                                unselectedColor = Color.Gray
                            ),
                            modifier = Modifier.size(32.dp)
                        )
                        Text(
                            text = answer,
                            color = Color.Black,
                            fontSize = 16.sp,
                            lineHeight = 21.sp,
                            fontWeight = FontWeight(400),
                            fontFamily = customFont_Ruberoid_ExtraBold,
                        )
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(62.dp))
                    .MangoLimeGradientBackground()
                    .clickable {
                        onOptionSelected()
                    }
                    .padding(vertical = 24.dp)
            ) {
                Text(
                    text = "Continuar",
                    fontSize = 20.sp,
                    lineHeight = 24.sp,
                    color = DarkBlue,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth(),
                    fontFamily = customFont_Ruberoid_ExtraBold,
                )
            }
        }
    }
}


