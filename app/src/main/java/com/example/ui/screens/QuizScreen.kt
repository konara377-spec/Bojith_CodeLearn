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
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.QuizData
import com.example.model.CourseType
import com.example.model.QuizQuestion
import com.example.ui.theme.CodeBackground
import com.example.ui.theme.DarkBorder
import com.example.ui.theme.DarkCanvas
import com.example.ui.theme.DarkSurface
import com.example.ui.theme.DarkSurfaceElevated
import com.example.ui.theme.DarkSurfaceVariant
import com.example.ui.theme.NeonGreen
import com.example.ui.theme.NeonRed
import com.example.ui.theme.TextMuted
import com.example.ui.theme.TextPrimary
import com.example.ui.theme.TextSecondary

@Composable
fun QuizScreen(
    initialCourseType: CourseType? = null,
    modifier: Modifier = Modifier
) {
    var selectedFilter by remember { mutableStateOf(initialCourseType) }
    var questionList by remember(selectedFilter) {
        mutableStateOf(QuizData.getQuestionsForCourse(selectedFilter))
    }

    var currentQuestionIndex by remember(selectedFilter) { mutableIntStateOf(0) }
    var userScore by remember(selectedFilter) { mutableIntStateOf(0) }
    var selectedOptionIndex by remember { mutableStateOf<Int?>(null) }
    var isAnswerSubmitted by remember { mutableStateOf(false) }
    var isQuizFinished by remember { mutableStateOf(false) }

    val scrollState = rememberScrollState()

    val currentQuestion = questionList.getOrNull(currentQuestionIndex)

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(DarkCanvas)
            .verticalScroll(scrollState)
            .padding(18.dp)
    ) {
        // Quiz Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(36.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFFFBBF24).copy(alpha = 0.15f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Quiz,
                        contentDescription = null,
                        tint = Color(0xFFFBBF24),
                        modifier = Modifier.size(20.dp)
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(
                        text = "Beginner Quizzes",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary
                    )
                    Text(
                        text = "Test your coding knowledge",
                        fontSize = 12.sp,
                        color = TextSecondary
                    )
                }
            }

            // Score Pill
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(DarkSurfaceElevated)
                    .border(1.dp, DarkBorder, CircleShape)
                    .padding(horizontal = 12.dp, vertical = 6.dp)
            ) {
                Text(
                    text = "Score: $userScore",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = NeonGreen
                )
            }
        }

        Spacer(modifier = Modifier.height(14.dp))

        // Category Filter Tabs (All, HTML, CSS, JavaScript)
        ScrollableTabRow(
            selectedTabIndex = when (selectedFilter) {
                null -> 0
                CourseType.HTML -> 1
                CourseType.CSS -> 2
                CourseType.JAVASCRIPT -> 3
            },
            containerColor = DarkSurface,
            contentColor = TextPrimary,
            edgePadding = 0.dp,
            indicator = { tabPositions ->
                val tabIdx = when (selectedFilter) {
                    null -> 0
                    CourseType.HTML -> 1
                    CourseType.CSS -> 2
                    CourseType.JAVASCRIPT -> 3
                }
                if (tabIdx < tabPositions.size) {
                    TabRowDefaults.SecondaryIndicator(
                        Modifier.tabIndicatorOffset(tabPositions[tabIdx]),
                        color = selectedFilter?.accentColor ?: NeonGreen,
                        height = 3.dp
                    )
                }
            }
        ) {
            val tabs = listOf<Pair<String, CourseType?>>(
                "All Tracks" to null,
                "🟠 HTML" to CourseType.HTML,
                "🔵 CSS" to CourseType.CSS,
                "🟡 JavaScript" to CourseType.JAVASCRIPT
            )
            tabs.forEach { (label, course) ->
                val isSelected = selectedFilter == course
                Tab(
                    selected = isSelected,
                    onClick = {
                        selectedFilter = course
                        currentQuestionIndex = 0
                        userScore = 0
                        selectedOptionIndex = null
                        isAnswerSubmitted = false
                        isQuizFinished = false
                    },
                    text = {
                        Text(
                            text = label,
                            fontSize = 12.sp,
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                            color = if (isSelected) TextPrimary else TextSecondary
                        )
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (isQuizFinished) {
            // FINAL SCORE RESULTS SCREEN
            val totalQuestions = questionList.size
            val percentage = if (totalQuestions > 0) ((userScore.toFloat() / totalQuestions) * 100).toInt() else 0

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp))
                    .background(DarkSurface)
                    .border(1.dp, DarkBorder, RoundedCornerShape(20.dp))
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = if (percentage >= 80) "🏆 Outstanding Work!"
                    else if (percentage >= 50) "🎉 Well Done!"
                    else "Keep Learning!",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextPrimary
                )

                Spacer(modifier = Modifier.height(16.dp))

                Box(
                    modifier = Modifier
                        .size(110.dp)
                        .clip(CircleShape)
                        .background(
                            if (percentage >= 70) NeonGreen.copy(alpha = 0.15f)
                            else Color(0xFFFBBF24).copy(alpha = 0.15f)
                        )
                        .border(
                            2.dp,
                            if (percentage >= 70) NeonGreen else Color(0xFFFBBF24),
                            CircleShape
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "$percentage%",
                            fontSize = 28.sp,
                            fontWeight = FontWeight.Black,
                            color = if (percentage >= 70) NeonGreen else Color(0xFFFBBF24)
                        )
                        Text(
                            text = "$userScore / $totalQuestions",
                            fontSize = 12.sp,
                            color = TextSecondary
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = if (percentage >= 80) "You have a solid beginner grasp of core web concepts! Ready to build real web pages in the playground."
                    else "Review the lessons in the course and try the quiz again to get a 100% score.",
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    color = TextSecondary,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(24.dp))

                ElevatedButton(
                    onClick = {
                        currentQuestionIndex = 0
                        userScore = 0
                        selectedOptionIndex = null
                        isAnswerSubmitted = false
                        isQuizFinished = false
                    },
                    colors = ButtonDefaults.elevatedButtonColors(
                        containerColor = NeonGreen,
                        contentColor = Color.Black
                    ),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .testTag("retake_quiz_button")
                ) {
                    Icon(
                        imageVector = Icons.Default.Refresh,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "Retake Quiz",
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    )
                }
            }
        } else if (currentQuestion != null) {
            // ACTIVE QUESTION CARD
            val progress = ((currentQuestionIndex + 1).toFloat() / questionList.size).coerceIn(0f, 1f)

            // Question Progress Bar
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Question ${currentQuestionIndex + 1} of ${questionList.size}",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = currentQuestion.courseType.accentColor,
                    fontFamily = FontFamily.Monospace
                )
                Text(
                    text = "${(progress * 100).toInt()}%",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = TextMuted
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            LinearProgressIndicator(
                progress = { progress },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(6.dp)
                    .clip(CircleShape),
                color = currentQuestion.courseType.accentColor,
                trackColor = DarkBorder
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Question Text Card
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(DarkSurface)
                    .border(1.dp, DarkBorder, RoundedCornerShape(16.dp))
                    .padding(18.dp)
            ) {
                Column {
                    Text(
                        text = currentQuestion.question,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary,
                        lineHeight = 24.sp
                    )

                    // Optional Code snippet inside question
                    if (currentQuestion.codeSnippet != null) {
                        Spacer(modifier = Modifier.height(12.dp))
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(8.dp))
                                .background(CodeBackground)
                                .border(1.dp, DarkBorder, RoundedCornerShape(8.dp))
                                .padding(12.dp)
                        ) {
                            Text(
                                text = currentQuestion.codeSnippet,
                                fontFamily = FontFamily.Monospace,
                                fontSize = 13.sp,
                                color = TextPrimary
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // 4 MULTIPLE-CHOICE OPTIONS
            currentQuestion.options.forEachIndexed { index, optionText ->
                val isSelected = selectedOptionIndex == index
                val isCorrect = index == currentQuestion.correctOptionIndex

                val borderColor = when {
                    !isAnswerSubmitted && isSelected -> currentQuestion.courseType.accentColor
                    isAnswerSubmitted && isCorrect -> NeonGreen
                    isAnswerSubmitted && isSelected && !isCorrect -> NeonRed
                    else -> DarkBorder
                }

                val backgroundColor = when {
                    !isAnswerSubmitted && isSelected -> DarkSurfaceElevated
                    isAnswerSubmitted && isCorrect -> NeonGreen.copy(alpha = 0.15f)
                    isAnswerSubmitted && isSelected && !isCorrect -> NeonRed.copy(alpha = 0.15f)
                    else -> DarkSurface
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 5.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(backgroundColor)
                        .border(1.dp, borderColor, RoundedCornerShape(12.dp))
                        .clickable(enabled = !isAnswerSubmitted) {
                            selectedOptionIndex = index
                            isAnswerSubmitted = true
                            if (isCorrect) {
                                userScore++
                            }
                        }
                        .padding(14.dp)
                        .testTag("quiz_option_$index")
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.weight(1f)
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(28.dp)
                                    .clip(CircleShape)
                                    .background(DarkSurfaceVariant),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = ('A' + index).toString(),
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = TextSecondary
                                )
                            }
                            Spacer(modifier = Modifier.width(12.dp))
                            Text(
                                text = optionText,
                                fontSize = 14.sp,
                                fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                color = TextPrimary
                            )
                        }

                        // Feedback Icon
                        if (isAnswerSubmitted) {
                            if (isCorrect) {
                                Icon(
                                    imageVector = Icons.Default.CheckCircle,
                                    contentDescription = "Correct",
                                    tint = NeonGreen,
                                    modifier = Modifier.size(20.dp)
                                )
                            } else if (isSelected) {
                                Icon(
                                    imageVector = Icons.Default.Close,
                                    contentDescription = "Incorrect",
                                    tint = NeonRed,
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        }
                    }
                }
            }

            // FEEDBACK & EXPLANATION CARD (revealed after selection)
            AnimatedVisibility(
                visible = isAnswerSubmitted,
                enter = fadeIn() + slideInVertically()
            ) {
                Column {
                    Spacer(modifier = Modifier.height(14.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(12.dp))
                            .background(DarkSurfaceVariant)
                            .border(1.dp, DarkBorder, RoundedCornerShape(12.dp))
                            .padding(14.dp)
                    ) {
                        Column {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Text(
                                    text = if (selectedOptionIndex == currentQuestion.correctOptionIndex) "Correct! 🎉" else "Incorrect 🤔",
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 14.sp,
                                    color = if (selectedOptionIndex == currentQuestion.correctOptionIndex) NeonGreen else NeonRed
                                )
                            }
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = currentQuestion.explanation,
                                fontSize = 13.5.sp,
                                lineHeight = 19.sp,
                                color = TextSecondary
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    // NEXT QUESTION / FINISH BUTTON
                    ElevatedButton(
                        onClick = {
                            if (currentQuestionIndex < questionList.size - 1) {
                                currentQuestionIndex++
                                selectedOptionIndex = null
                                isAnswerSubmitted = false
                            } else {
                                isQuizFinished = true
                            }
                        },
                        colors = ButtonDefaults.elevatedButtonColors(
                            containerColor = currentQuestion.courseType.accentColor,
                            contentColor = Color.Black
                        ),
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp)
                            .testTag("quiz_next_button")
                    ) {
                        Text(
                            text = if (currentQuestionIndex < questionList.size - 1) "Next Question" else "View Final Score",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(30.dp))
        }
    }
}
