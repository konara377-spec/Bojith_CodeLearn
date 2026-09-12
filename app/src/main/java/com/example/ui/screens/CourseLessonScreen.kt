package com.example.ui.screens

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.RestartAlt
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.model.CourseType
import com.example.model.Lesson
import com.example.ui.components.AnimatedProgressBar
import com.example.ui.components.CodeEditorView
import com.example.ui.components.ImportantPointsCard
import com.example.ui.components.LineExplanationList
import com.example.ui.components.LivePreviewView
import com.example.ui.components.SampleCodeTabsView
import com.example.ui.theme.DarkBorder
import com.example.ui.theme.DarkCanvas
import com.example.ui.theme.DarkSurface
import com.example.ui.theme.DarkSurfaceElevated
import com.example.ui.theme.DarkSurfaceVariant
import com.example.ui.theme.NeonGreen
import com.example.ui.theme.TextMuted
import com.example.ui.theme.TextPrimary
import com.example.ui.theme.TextSecondary
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CourseLessonScreen(
    courseType: CourseType,
    lessons: List<Lesson>,
    initialLessonIndex: Int = 0,
    isCompleted: (String) -> Unit, // Callback or check
    onToggleCompleted: (String) -> Unit,
    checkCompleted: (String) -> Boolean,
    onBackToHome: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var currentLessonIndex by remember { mutableIntStateOf(initialLessonIndex.coerceIn(0, lessons.size - 1)) }
    val currentLesson = lessons.getOrNull(currentLessonIndex) ?: lessons.first()

    var activeRunnableCode by remember(currentLesson) {
        mutableStateOf(currentLesson.defaultRunnableCode)
    }

    var previewCodeTrigger by remember(currentLesson) {
        mutableStateOf(currentLesson.defaultRunnableCode)
    }

    val scrollState = rememberScrollState()
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showLessonListSheet by remember { mutableStateOf(false) }

    // Scroll to top when changing lesson
    LaunchedEffect(currentLessonIndex) {
        scrollState.animateScrollTo(0)
    }

    val isCurrentLessonCompleted = checkCompleted(currentLesson.id)

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(DarkCanvas)
    ) {
        // TOP NAVIGATION BAR
        Surface(
            color = DarkSurface,
            shadowElevation = 4.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(
                        onClick = onBackToHome,
                        modifier = Modifier.testTag("lesson_back_button")
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back to Courses",
                            tint = TextPrimary
                        )
                    }

                    Spacer(modifier = Modifier.width(6.dp))

                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(
                                text = "${courseType.shortName} • Lesson ${currentLesson.lessonNumber}/20",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = courseType.accentColor,
                                fontFamily = FontFamily.Monospace
                            )
                            if (isCurrentLessonCompleted) {
                                Spacer(modifier = Modifier.width(6.dp))
                                Icon(
                                    imageVector = Icons.Default.CheckCircle,
                                    contentDescription = "Completed",
                                    tint = NeonGreen,
                                    modifier = Modifier.size(14.dp)
                                )
                            }
                        }
                        Text(
                            text = currentLesson.title,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextPrimary,
                            maxLines = 1
                        )
                    }
                }

                // Lesson List button
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(DarkSurfaceVariant)
                        .clickable { showLessonListSheet = true }
                        .padding(horizontal = 10.dp, vertical = 6.dp)
                        .testTag("open_lesson_list_button")
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.List,
                            contentDescription = "Lesson List",
                            tint = courseType.accentColor,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Lessons",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextPrimary
                        )
                    }
                }
            }
        }

        // LESSON CONTENT BODY
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(scrollState)
                .padding(horizontal = 18.dp, vertical = 16.dp)
        ) {
            // Lesson Header Badge & Title
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(courseType.accentColor.copy(alpha = 0.15f))
                        .border(1.dp, courseType.accentColor.copy(alpha = 0.4f), CircleShape)
                        .padding(horizontal = 10.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = "Lesson ${currentLesson.lessonNumber}",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Bold,
                        color = courseType.accentColor,
                        fontFamily = FontFamily.Monospace
                    )
                }

                // Mark as completed toggle button
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(if (isCurrentLessonCompleted) NeonGreen.copy(alpha = 0.2f) else DarkSurfaceVariant)
                        .border(
                            1.dp,
                            if (isCurrentLessonCompleted) NeonGreen else DarkBorder,
                            RoundedCornerShape(8.dp)
                        )
                        .clickable { onToggleCompleted(currentLesson.id) }
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                        .testTag("mark_completed_header_button")
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = if (isCurrentLessonCompleted) Icons.Default.Check else Icons.Default.CheckCircle,
                            contentDescription = null,
                            tint = if (isCurrentLessonCompleted) NeonGreen else TextMuted,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = if (isCurrentLessonCompleted) "Completed" else "Mark Completed",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = if (isCurrentLessonCompleted) NeonGreen else TextPrimary
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = currentLesson.title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = TextPrimary
            )

            Spacer(modifier = Modifier.height(14.dp))

            // 1. SIMPLE EXPLANATION
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(14.dp))
                    .background(DarkSurface)
                    .border(1.dp, DarkBorder, RoundedCornerShape(14.dp))
                    .padding(16.dp)
            ) {
                Column {
                    Text(
                        text = "Explanation",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = courseType.accentColor,
                        fontFamily = FontFamily.Monospace
                    )
                    Spacer(modifier = Modifier.height(6.dp))
                    Text(
                        text = currentLesson.explanation,
                        fontSize = 14.5.sp,
                        lineHeight = 22.sp,
                        color = TextSecondary
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // 2. IMPORTANT POINTS
            ImportantPointsCard(
                points = currentLesson.importantPoints,
                accentColor = courseType.accentColor
            )

            Spacer(modifier = Modifier.height(20.dp))

            // 3. SAMPLE CODES (2-3 code samples with Copy Code and tabs)
            Text(
                text = "Sample Code Examples",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = TextPrimary
            )
            Spacer(modifier = Modifier.height(8.dp))

            SampleCodeTabsView(
                codeExamples = currentLesson.codeExamples,
                accentColor = courseType.accentColor,
                onLoadIntoEditor = { code ->
                    activeRunnableCode = code
                    previewCodeTrigger = code
                    Toast.makeText(context, "Loaded into Code Editor below!", Toast.LENGTH_SHORT).show()
                }
            )

            Spacer(modifier = Modifier.height(20.dp))

            // 4. LINE-BY-LINE EXPLANATION
            LineExplanationList(
                explanations = currentLesson.lineExplanations,
                accentColor = courseType.accentColor
            )

            Spacer(modifier = Modifier.height(20.dp))

            // 5. EDITABLE CODE EDITOR
            Text(
                text = "Interactive Code Editor",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = TextPrimary
            )
            Text(
                text = "Modify this code and press Run Code to see live changes:",
                fontSize = 12.5.sp,
                color = TextSecondary,
                modifier = Modifier.padding(top = 2.dp, bottom = 8.dp)
            )

            CodeEditorView(
                code = activeRunnableCode,
                language = courseType.shortName,
                onCodeChange = { activeRunnableCode = it },
                onRunCode = {
                    previewCodeTrigger = activeRunnableCode
                    Toast.makeText(context, "Code executed!", Toast.LENGTH_SHORT).show()
                },
                onReset = {
                    activeRunnableCode = currentLesson.defaultRunnableCode
                    previewCodeTrigger = currentLesson.defaultRunnableCode
                    Toast.makeText(context, "Code reset to default!", Toast.LENGTH_SHORT).show()
                },
                onClear = {
                    activeRunnableCode = ""
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // 6. LIVE RESULT PREVIEW
            Text(
                text = "Live Result Preview",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = TextPrimary
            )
            Spacer(modifier = Modifier.height(8.dp))

            LivePreviewView(
                codeHtml = previewCodeTrigger,
                heightDp = 200,
                showConsole = courseType == CourseType.JAVASCRIPT
            )

            Spacer(modifier = Modifier.height(16.dp))

            // 7. NOTES SECTION
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(DarkSurfaceVariant)
                    .border(1.dp, courseType.accentColor.copy(alpha = 0.3f), RoundedCornerShape(12.dp))
                    .padding(14.dp)
            ) {
                Row(verticalAlignment = Alignment.Top) {
                    Text("💡", fontSize = 16.sp, modifier = Modifier.padding(end = 8.dp))
                    Column {
                        Text(
                            text = "Lesson Notes",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = courseType.accentColor
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = currentLesson.notes,
                            fontSize = 13.5.sp,
                            lineHeight = 19.sp,
                            color = TextSecondary
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // MARK AS COMPLETED BUTTON
            ElevatedButton(
                onClick = { onToggleCompleted(currentLesson.id) },
                colors = ButtonDefaults.elevatedButtonColors(
                    containerColor = if (isCurrentLessonCompleted) NeonGreen else courseType.accentColor,
                    contentColor = Color.Black
                ),
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .testTag("mark_completed_button")
            ) {
                Icon(
                    imageVector = if (isCurrentLessonCompleted) Icons.Default.Check else Icons.Default.CheckCircle,
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = if (isCurrentLessonCompleted) "Lesson Completed ✓" else "Mark as Completed",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // PREVIOUS & NEXT LESSON NAVIGATION BUTTONS
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Previous Lesson
                OutlinedButton(
                    onClick = {
                        if (currentLessonIndex > 0) {
                            currentLessonIndex--
                        }
                    },
                    enabled = currentLessonIndex > 0,
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        contentColor = TextPrimary
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .testTag("previous_lesson_button")
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(text = "Previous", fontSize = 13.sp, fontWeight = FontWeight.Bold)
                }

                Spacer(modifier = Modifier.width(12.dp))

                // Next Lesson
                ElevatedButton(
                    onClick = {
                        if (currentLessonIndex < lessons.size - 1) {
                            currentLessonIndex++
                        }
                    },
                    enabled = currentLessonIndex < lessons.size - 1,
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.elevatedButtonColors(
                        containerColor = DarkSurfaceElevated,
                        contentColor = courseType.accentColor
                    ),
                    modifier = Modifier
                        .weight(1f)
                        .testTag("next_lesson_button")
                ) {
                    Text(text = "Next", fontSize = 13.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.width(6.dp))
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(36.dp))
        }
    }

    // MODAL BOTTOM SHEET: 20 LESSONS BROWSER
    if (showLessonListSheet) {
        ModalBottomSheet(
            onDismissRequest = { showLessonListSheet = false },
            sheetState = sheetState,
            containerColor = DarkSurface
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 12.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "${courseType.title} Curriculum",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextPrimary
                        )
                        Text(
                            text = "Select any lesson to jump directly",
                            fontSize = 13.sp,
                            color = TextSecondary
                        )
                    }
                    Text(
                        text = "20 Lessons",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = courseType.accentColor
                    )
                }

                Spacer(modifier = Modifier.height(14.dp))
                HorizontalDivider(color = DarkBorder)
                Spacer(modifier = Modifier.height(8.dp))

                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(380.dp)
                ) {
                    itemsIndexed(lessons) { index, lesson ->
                        val isDone = checkCompleted(lesson.id)
                        val isSelected = index == currentLessonIndex

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 4.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .background(if (isSelected) DarkSurfaceElevated else Color.Transparent)
                                .border(
                                    1.dp,
                                    if (isSelected) courseType.accentColor else Color.Transparent,
                                    RoundedCornerShape(8.dp)
                                )
                                .clickable {
                                    currentLessonIndex = index
                                    scope.launch {
                                        sheetState.hide()
                                        showLessonListSheet = false
                                    }
                                }
                                .padding(horizontal = 12.dp, vertical = 10.dp),
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
                                        .background(if (isSelected) courseType.accentColor else DarkSurfaceVariant),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Text(
                                        text = "${lesson.lessonNumber}",
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = if (isSelected) Color.Black else TextSecondary
                                    )
                                }
                                Spacer(modifier = Modifier.width(12.dp))
                                Text(
                                    text = lesson.title,
                                    fontSize = 14.sp,
                                    fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
                                    color = if (isSelected) TextPrimary else TextSecondary,
                                    maxLines = 1
                                )
                            }

                            if (isDone) {
                                Icon(
                                    imageVector = Icons.Default.CheckCircle,
                                    contentDescription = "Completed",
                                    tint = NeonGreen,
                                    modifier = Modifier.size(18.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
