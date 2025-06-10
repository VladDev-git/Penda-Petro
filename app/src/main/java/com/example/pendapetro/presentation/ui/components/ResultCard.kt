package com.example.pendapetro.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.pendapetro.ui.theme.TextGreyYellow
import com.example.pendapetro.ui.theme.customFont_Ruberoid_ExtraBold
import com.example.pendapetro.ui.theme.gradients.MangoLimeGradientBackground

@Composable
fun ResultCard(

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
                .padding(15.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id = R.drawable.category_1_img),
                contentDescription = null,
                modifier = Modifier
                    .size(110.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "¡Felicitaciones! Has aprobado el test de inversión y has descubierto más sobre tu potencial.",
                fontSize = 16.sp,
                lineHeight = 21.sp,
                color = TextGreyYellow,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight(400),
                fontFamily = customFont_Ruberoid_ExtraBold,
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Su resultado:",
                fontSize = 20.sp,
                lineHeight = 26.sp,
                color = TextBlackYellow,
                fontWeight = FontWeight(700),
                fontFamily = customFont_Ruberoid_ExtraBold,
            )
            Spacer(modifier = Modifier.height(10.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(DarkBlue)
                    .padding(15.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "3/7",
                    fontSize = 30.sp,
                    lineHeight = 34.sp,
                    color = Color.White,
                    fontWeight = FontWeight(700),
                    fontFamily = customFont_Ruberoid_ExtraBold,
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(CategoryItemBackground)
                    .padding(15.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "¡Seguro que puedes hacerlo mejor!",
                    fontSize = 16.sp,
                    lineHeight = 21.sp,
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight(400),
                    fontFamily = customFont_Ruberoid_ExtraBold,
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(62.dp))
                    .MangoLimeGradientBackground()
                    .clickable {  }
                    .padding(vertical = 24.dp)
            ) {
                Text(
                    text = "Pasar de nuevo",
                    fontSize = 20.sp,
                    lineHeight = 24.sp,
                    color = DarkBlue,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth(),
                    fontFamily = customFont_Ruberoid_ExtraBold,
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(62.dp))
                    .MangoLimeGradientBackground()
                    .clickable {  }
                    .padding(vertical = 24.dp)
            ) {
                Text(
                    text = "Hogar",
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


