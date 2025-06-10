package com.example.pendapetro.data.entitys

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "categories")
data class Category(
    @PrimaryKey val category: QuestionCategory,
    val categoryName: String,
    val categoryDescription: String,
    val categoryIcon: Int,
    val categoryImg: Int,
)
