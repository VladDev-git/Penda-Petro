package com.example.pendapetro.data.entitys

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

enum class QuestionCategory {
    BASICS_OF_INVESTING_1, MARKET_ANALYSIS_AND_PRICING_2,
    INFRASTRUCTURE_AND_COMPANIES_3, FINANCIAL_INSTRUMENTS_AND_STRATEGIES_4
}

@Serializable
@Entity(tableName = "questions")
data class Question(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val questionText: String,
    val answers: List<String>,
    val correctAnswerIndex: Int,
    val category: QuestionCategory,
)