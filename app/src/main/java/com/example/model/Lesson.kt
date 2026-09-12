package com.example.model

data class CodeExample(
    val title: String,
    val code: String,
    val description: String = ""
)

data class LineExplanation(
    val lineSnippet: String,
    val explanation: String
)

data class Lesson(
    val id: String,
    val courseType: CourseType,
    val lessonNumber: Int,
    val title: String,
    val explanation: String,
    val importantPoints: List<String>,
    val codeExamples: List<CodeExample>,
    val lineExplanations: List<LineExplanation>,
    val defaultRunnableCode: String,
    val notes: String
)
