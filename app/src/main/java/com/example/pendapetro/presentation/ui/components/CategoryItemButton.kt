package com.example.pendapetro.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pendapetro.data.entitys.Category
import com.example.pendapetro.ui.theme.CategoryItemBackgroundSelected
import com.example.pendapetro.ui.theme.DarkBlue
import com.example.pendapetro.ui.theme.TextBlackYellow
import com.example.pendapetro.ui.theme.TextGreyYellow
import com.example.pendapetro.ui.theme.customFont_Ruberoid_ExtraBold

@Composable
fun CategoryItemButton(
    category: Category,
    onClick: (Category) -> Unit,
) {
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(CategoryItemBackgroundSelected)
            .border(
                width = 2.dp,
                color = DarkBlue,
                shape = RoundedCornerShape(16.dp)
            )
            .clickable { onClick(category) }
            .padding(10.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Image(
                painter = painterResource(id = category.categoryIcon),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 10.dp, end = 3.dp)
                    .size(36.dp)
            )
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                Text(
                    text = category.categoryName,
                    fontSize = 16.sp,
                    lineHeight = 21.sp,
                    color = TextBlackYellow,
                    fontWeight = FontWeight(700),
                    fontFamily = customFont_Ruberoid_ExtraBold,
                )
                Spacer(modifier = Modifier.height(7.dp))
                Text(
                    text = category.categoryDescription,
                    fontSize = 12.sp,
                    color = TextGreyYellow,
                    fontWeight = FontWeight(400),
                    fontFamily = customFont_Ruberoid_ExtraBold,
                )
            }
        }
    }
}