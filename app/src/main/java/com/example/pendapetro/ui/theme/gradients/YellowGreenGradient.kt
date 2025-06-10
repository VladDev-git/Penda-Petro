package com.example.pendapetro.ui.theme.gradients

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.addOutline
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

fun Modifier.MangoLimeGradientBackground(): Modifier {
    return this.then(
        Modifier.drawWithContent {
            drawRect(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFFFC107),
                        Color(0xFFCDDC39),
                        Color(0xFFB2FF59),
                    ),
                    startY = size.height,
                    endY = 0f
                )
            )
            drawContent()
        }
    )
}

fun Modifier.MangoLimeGradientBorder(
    borderWidth: Float = 4f,
    shape: Shape = RoundedCornerShape(8.dp)
): Modifier {
    return this.then(
        Modifier.drawWithCache {
            val path = Path()
            val outline = shape.createOutline(size, layoutDirection, this)
            path.addOutline(outline)

            val brush = Brush.verticalGradient(
                colors = listOf(
                    Color(0xFFFFC107),
                    Color(0xFFCDDC39),
                    Color(0xFFB2FF59)
                ),
                startY = size.height,
                endY = 0f
            )

            onDrawWithContent {
                drawPath(
                    path = path,
                    brush = brush,
                    style = Stroke(width = borderWidth)
                )
                drawContent()
            }
        }
    )
}

fun mangoLimeGradientTextStyle(): TextStyle {
    return TextStyle(
        fontWeight = FontWeight.Bold,
        brush = Brush.linearGradient(
            colors = listOf(
                Color(0xFFFFC107),
                Color(0xFFCDDC39),
                Color(0xFFB2FF59)
            ),
            start = Offset(0f, 80f),
            end = Offset(0f, 0f)
        )
    )
}

