package com.example.pendapetro.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.pendapetro.data.dao.CategoryDao
import com.example.pendapetro.data.entitys.Question
import com.example.pendapetro.data.entitys.QuestionCategory
import com.example.pendapetro.data.dao.QuestionDao
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TestViewModel(
    private val categoryDao: CategoryDao, private val questionDao: QuestionDao
) : ViewModel() {

    @OptIn(DelicateCoroutinesApi::class)
    val categories = categoryDao.getAllCategories().stateIn(
        GlobalScope, SharingStarted.Lazily, emptyList()
    )

    private val _questions = MutableStateFlow<List<Question>>(emptyList())
    val questions: StateFlow<List<Question>> = _questions

    private val _currentIndex = MutableStateFlow(0)
    val currentIndex: StateFlow<Int> = _currentIndex

    private val _score = MutableStateFlow(0)
    val score: StateFlow<Int> = _score

    private val _selectedCategory = MutableStateFlow<QuestionCategory?>(null)
    val selectedCategory: StateFlow<QuestionCategory?> = _selectedCategory

    @OptIn(DelicateCoroutinesApi::class)
    fun loadQuestions(category: QuestionCategory) {
        try {
            GlobalScope.launch(Dispatchers.IO) {
                _selectedCategory.emit(category)
                _questions.emit(emptyList())

                val newQuestions = questionDao.getQuestionsByCategory(category.name)

                withContext(Dispatchers.Main) {
                    _questions.value = newQuestions
                    _score.emit(0)
                    _currentIndex.emit(0)
                }
            }
        } catch (e: Exception) {
            Log.e("QuizViewModel", "Wrong in launch: ${e.message}", e)
        }
    }

    fun submitAnswer(selectedIndex: Int) {
        val currentQuestion = _questions.value.getOrNull(_currentIndex.value)
        if (currentQuestion != null && selectedIndex == currentQuestion.correctAnswerIndex) {
            _score.value += 1
            Log.d("QuizViewModel", "Respond true! Score: ${_score.value}")
        } else {
            Log.d("QuizViewModel", "Respond wrong. Score: ${_score.value}")
        }

        if (_currentIndex.value < _questions.value.size - 1) {
            _currentIndex.value += 1
        }
    }

    fun restartQuiz() {
        _score.value = 0
        _currentIndex.value = 0
    }

    fun goToPreviousQuestion() {
        if (_currentIndex.value > 0) {
            _currentIndex.value -= 1
        }
    }
}