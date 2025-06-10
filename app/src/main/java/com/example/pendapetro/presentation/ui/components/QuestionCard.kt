package com.example.pendapetro.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pendapetro.R
import com.example.pendapetro.ui.theme.CategoryItemBackground
import com.example.pendapetro.ui.theme.DarkBlue
import com.example.pendapetro.ui.theme.TextBlackYellow
import com.example.pendapetro.ui.theme.customFont_Ruberoid_ExtraBold
import com.example.pendapetro.ui.theme.gradients.MangoLimeGradientBackground

@Composable
fun QuestionCard(

) {
    var selectedOption by remember { mutableStateOf(-1) }

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
                painter = painterResource(id = R.drawable.category_1_img),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(144.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "¿Qué es la diversificación?",
                fontSize = 20.sp,
                lineHeight = 26.sp,
                color = TextBlackYellow,
                fontWeight = FontWeight(700),
                fontFamily = customFont_Ruberoid_ExtraBold,
            )

            Spacer(modifier = Modifier.height(20.dp))

//            Box(
//                modifier = Modifier
//                    .width(300.dp)
//                    .height(79.dp)
//                    .clip(RoundedCornerShape(50.dp))
//                    .background(if (selectedOption == -1) Color.White else CategoryItemBackground)
//            ) {
//                Row(
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(start = 20.dp)
//                        .selectable(
//                            selected = selectedOption == index,
//                            onClick = {
//                                selectedOption = index
//                            }
//                        ),
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    RadioButton(
//                        selected = selectedOption == index,
//                        onClick = {
//                            selectedOption = index
//                        },
//                        colors = RadioButtonDefaults.colors(
//                            selectedColor = Color.White,
//                            unselectedColor = LightGrey
//                        ),
//                        modifier = Modifier.size(32.dp)
//                    )
//                    Text(
//                        text = answer,
//                        color = Color.White,
//                        fontSize = 18.sp,
//                        modifier = Modifier.padding(start = 8.dp)
//                    )
//                }
//            }
            Spacer(modifier = Modifier.height(10.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(62.dp))
                    .MangoLimeGradientBackground()
                    .clickable {  }
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


