package com.example.model

import androidx.compose.ui.graphics.Color
import com.example.ui.theme.NeonCssBlue
import com.example.ui.theme.NeonHtmlOrange
import com.example.ui.theme.NeonJsYellow

enum class CourseType(
    val title: String,
    val shortName: String,
    val emoji: String,
    val description: String,
    val accentColor: Color,
    val totalLessons: Int = 20
) {
    HTML(
        title = "HTML",
        shortName = "HTML",
        emoji = "🟠",
        description = "Learn how to create the structure of websites.",
        accentColor = NeonHtmlOrange,
        totalLessons = 20
    ),
    CSS(
        title = "CSS",
        shortName = "CSS",
        emoji = "🔵",
        description = "Learn how to style and design websites.",
        accentColor = NeonCssBlue,
        totalLessons = 20
    ),
    JAVASCRIPT(
        title = "JavaScript",
        shortName = "JS",
        emoji = "🟡",
        description = "Learn how to make websites interactive.",
        accentColor = NeonJsYellow,
        totalLessons = 20
    )
}
