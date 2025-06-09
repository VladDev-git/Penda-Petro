package com.example.pendapetro.presentation.ui.screen.home_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pendapetro.R
import com.example.pendapetro.presentation.ui.components.CategoryItemButton
import com.example.pendapetro.ui.theme.DarkBlue
import com.example.pendapetro.ui.theme.customFont_Ruberoid_ExtraBold
import com.example.pendapetro.ui.theme.gradients.MangoLimeGradientBackground

@Composable
fun HomeScreen(

) {
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
                .verticalScroll(rememberScrollState())
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
            CategoryItemButton(
                label = "Los conceptos básicos de la inversión en petróleo y gas",
                description = "Para que los principiantes comprendan los principios básicos.",
                imgId = R.drawable.oil_drum,
                onClick = { /* Acción al hacer clic en la categoría 1 */ }
            )
            Spacer(modifier = Modifier.height(10.dp))
            CategoryItemButton(
                label = "Análisis de mercado y precios",
                description = "Para usuarios que quieran entender qué influye en los cambios en los precios del petróleo y el gas.",
                imgId = R.drawable.grafik,
                onClick = { /* Acción al hacer clic en la categoría 2 */ }
            )
            Spacer(modifier = Modifier.height(10.dp))
            CategoryItemButton(
                label = "Infraestructura y empresas",
                description = "Para inversores que estudian empresas energéticas y cadenas de suministro.",
                imgId = R.drawable.factory,
                onClick = { /* Acción al hacer clic en la categoría 3 */ }
            )
            Spacer(modifier = Modifier.height(10.dp))
            CategoryItemButton(
                label = "Instrumentos y estrategias financieras",
                description = "Para usuarios experimentados que quieran dominar herramientas y estrategias de inversión.",
                imgId = R.drawable.money,
                onClick = { /* Acción al hacer clic en la categoría 4 */ }
            )
            Spacer(modifier = Modifier.height(15.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(62.dp))
                    .MangoLimeGradientBackground()
                    .clickable {  }
                    .padding(vertical = 24.dp)
            ) {
                Text(
                    text = "Iniciar prueba",
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