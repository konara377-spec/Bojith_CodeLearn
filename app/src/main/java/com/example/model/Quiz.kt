package com.example.model

data class QuizQuestion(
    val id: Int,
    val courseType: CourseType,
    val question: String,
    val codeSnippet: String? = null,
    val options: List<String>,
    val correctOptionIndex: Int,
    val explanation: String
)
