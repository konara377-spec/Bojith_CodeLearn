package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.Terminal
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.CourseType
import com.example.ui.components.CourseCard
import com.example.ui.theme.DarkBorder
import com.example.ui.theme.DarkCanvas
import com.example.ui.theme.DarkSurface
import com.example.ui.theme.DarkSurfaceVariant
import com.example.ui.theme.NeonCssBlue
import com.example.ui.theme.NeonGreen
import com.example.ui.theme.NeonHtmlOrange
import com.example.ui.theme.NeonJsYellow
import com.example.ui.theme.TextMuted
import com.example.ui.theme.TextPrimary
import com.example.ui.theme.TextSecondary

@Composable
fun HomeScreen(
    htmlCompleted: Int,
    cssCompleted: Int,
    jsCompleted: Int,
    onOpenCourse: (CourseType) -> Unit,
    onOpenPlayground: () -> Unit,
    onOpenQuiz: () -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    val totalCompleted = htmlCompleted + cssCompleted + jsCompleted
    val totalLessons = 60

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(DarkCanvas)
            .verticalScroll(scrollState)
            .padding(horizontal = 20.dp, vertical = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // App Header Brand
        Box(
            modifier = Modifier
                .clip(CircleShape)
                .background(
                    Brush.radialGradient(
                        listOf(NeonCssBlue.copy(alpha = 0.2f), Color.Transparent)
                    )
                )
                .border(1.dp, DarkBorder, CircleShape)
                .padding(horizontal = 14.dp, vertical = 6.dp)
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(NeonGreen)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "BEGINNER CODING ACADEMY",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp,
                    color = NeonGreen
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Large CODELEARN Title
        Text(
            text = "CODELEARN",
            fontSize = 36.sp,
            fontWeight = FontWeight.Black,
            letterSpacing = 2.sp,
            color = TextPrimary,
            textAlign = TextAlign.Center,
            modifier = Modifier.testTag("app_home_title")
        )

        Spacer(modifier = Modifier.height(6.dp))

        // Subtitle
        Text(
            text = "Learn HTML • CSS • JavaScript",
            fontSize = 17.sp,
            fontWeight = FontWeight.SemiBold,
            color = NeonCssBlue,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Master the three core pillars of web development step by step through interactive code and live previews.",
            fontSize = 13.5.sp,
            lineHeight = 20.sp,
            color = TextSecondary,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 12.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Progress Pill Card
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(16.dp))
                .background(DarkSurface)
                .border(1.dp, DarkBorder, RoundedCornerShape(16.dp))
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "Your Overall Progress",
                    fontSize = 12.sp,
                    color = TextMuted,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = "$totalCompleted of $totalLessons Lessons",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary
                )
            }

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(NeonGreen.copy(alpha = 0.15f))
                    .border(1.dp, NeonGreen.copy(alpha = 0.5f), CircleShape)
                    .padding(horizontal = 14.dp, vertical = 6.dp)
            ) {
                Text(
                    text = "${((totalCompleted.toFloat() / totalLessons) * 100).toInt()}% Done",
                    color = NeonGreen,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Section Title: Learning Tracks
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Learning Courses",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = TextPrimary
            )
        }

        Spacer(modifier = Modifier.height(14.dp))

        // 3 Large Animated Learning Cards
        CourseCard(
            courseType = CourseType.HTML,
            completedCount = htmlCompleted,
            onClick = { onOpenCourse(CourseType.HTML) }
        )

        Spacer(modifier = Modifier.height(16.dp))

        CourseCard(
            courseType = CourseType.CSS,
            completedCount = cssCompleted,
            onClick = { onOpenCourse(CourseType.CSS) }
        )

        Spacer(modifier = Modifier.height(16.dp))

        CourseCard(
            courseType = CourseType.JAVASCRIPT,
            completedCount = jsCompleted,
            onClick = { onOpenCourse(CourseType.JAVASCRIPT) }
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Quick Tools Row: Playground & Quizzes
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            // Playground Quick Card
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(16.dp))
                    .background(DarkSurface)
                    .border(1.dp, NeonGreen.copy(alpha = 0.4f), RoundedCornerShape(16.dp))
                    .clickable(onClick = onOpenPlayground)
                    .padding(16.dp)
            ) {
                Column {
                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(NeonGreen.copy(alpha = 0.15f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Terminal,
                            contentDescription = null,
                            tint = NeonGreen,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Playground",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary
                    )
                    Text(
                        text = "Live HTML/CSS/JS code sandbox",
                        fontSize = 11.5.sp,
                        lineHeight = 16.sp,
                        color = TextSecondary,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }

            // Quiz Quick Card
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(16.dp))
                    .background(DarkSurface)
                    .border(1.dp, NeonJsYellow.copy(alpha = 0.4f), RoundedCornerShape(16.dp))
                    .clickable(onClick = onOpenQuiz)
                    .padding(16.dp)
            ) {
                Column {
                    Box(
                        modifier = Modifier
                            .size(36.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(NeonJsYellow.copy(alpha = 0.15f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Quiz,
                            contentDescription = null,
                            tint = NeonJsYellow,
                            modifier = Modifier.size(20.dp)
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Quizzes",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary
                    )
                    Text(
                        text = "Test your beginner skills & score",
                        fontSize = 11.5.sp,
                        lineHeight = 16.sp,
                        color = TextSecondary,
                        modifier = Modifier.padding(top = 4.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))
    }
}
