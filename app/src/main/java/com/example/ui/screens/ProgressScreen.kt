package com.example.ui.screens

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.RadioButtonUnchecked
import androidx.compose.material.icons.filled.RestartAlt
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.CssLessons
import com.example.data.HtmlLessons
import com.example.data.JsLessons
import com.example.model.CourseType
import com.example.model.Lesson
import com.example.ui.components.AnimatedProgressBar
import com.example.ui.theme.DarkBorder
import com.example.ui.theme.DarkCanvas
import com.example.ui.theme.DarkSurface
import com.example.ui.theme.DarkSurfaceElevated
import com.example.ui.theme.DarkSurfaceVariant
import com.example.ui.theme.NeonCssBlue
import com.example.ui.theme.NeonGreen
import com.example.ui.theme.NeonHtmlOrange
import com.example.ui.theme.NeonJsYellow
import com.example.ui.theme.TextMuted
import com.example.ui.theme.TextPrimary
import com.example.ui.theme.TextSecondary

@Composable
fun ProgressScreen(
    htmlCompleted: Int,
    cssCompleted: Int,
    jsCompleted: Int,
    checkCompleted: (String) -> Boolean,
    onToggleCompleted: (String) -> Unit,
    onNavigateToLesson: (CourseType, Int) -> Unit,
    onResetAllProgress: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()

    var selectedCourseFilter by remember { mutableStateOf<CourseType?>(null) }
    var showResetDialog by remember { mutableStateOf(false) }

    val totalCompleted = htmlCompleted + cssCompleted + jsCompleted
    val totalLessons = 60
    val overallPercentage = ((totalCompleted.toFloat() / totalLessons) * 100).toInt()

    val allLessonsList: List<Lesson> = remember {
        HtmlLessons.lessons + CssLessons.lessons + JsLessons.lessons
    }

    val filteredLessons = remember(selectedCourseFilter) {
        if (selectedCourseFilter == null) allLessonsList
        else allLessonsList.filter { it.courseType == selectedCourseFilter }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(DarkCanvas)
            .verticalScroll(scrollState)
            .padding(18.dp)
    ) {
        // Header Row
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
                        .background(NeonGreen.copy(alpha = 0.15f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.EmojiEvents,
                        contentDescription = null,
                        tint = NeonGreen,
                        modifier = Modifier.size(20.dp)
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(
                        text = "Your Progress",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary
                    )
                    Text(
                        text = "Curriculum completion tracking",
                        fontSize = 12.sp,
                        color = TextSecondary
                    )
                }
            }

            IconButton(
                onClick = { showResetDialog = true },
                modifier = Modifier.testTag("reset_progress_icon_button")
            ) {
                Icon(
                    imageVector = Icons.Default.RestartAlt,
                    contentDescription = "Reset Progress",
                    tint = TextMuted
                )
            }
        }

        Spacer(modifier = Modifier.height(18.dp))

        // OVERALL SUMMARY CARD
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(18.dp))
                .background(
                    Brush.verticalGradient(
                        listOf(DarkSurfaceElevated, DarkSurface)
                    )
                )
                .border(1.dp, NeonGreen.copy(alpha = 0.3f), RoundedCornerShape(18.dp))
                .padding(20.dp)
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "TOTAL COMPLETED",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = NeonGreen,
                            letterSpacing = 1.sp
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                        Text(
                            text = "$totalCompleted / $totalLessons Lessons",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextPrimary
                        )
                    }

                    Box(
                        modifier = Modifier
                            .size(54.dp)
                            .clip(CircleShape)
                            .background(NeonGreen.copy(alpha = 0.15f))
                            .border(2.dp, NeonGreen, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "$overallPercentage%",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = NeonGreen
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                AnimatedProgressBar(
                    completed = totalCompleted,
                    total = totalLessons,
                    accentColor = NeonGreen
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // 3 TRACK PROGRESS BARS
        Text(
            text = "Course Milestones",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = TextPrimary
        )

        Spacer(modifier = Modifier.height(10.dp))

        // HTML Progress Card
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(14.dp))
                .background(DarkSurface)
                .border(1.dp, DarkBorder, RoundedCornerShape(14.dp))
                .padding(16.dp)
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "🟠", fontSize = 16.sp)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "HTML Course",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextPrimary
                        )
                    }
                    Text(
                        text = "$htmlCompleted / 20",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = NeonHtmlOrange,
                        fontFamily = FontFamily.Monospace
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                AnimatedProgressBar(
                    completed = htmlCompleted,
                    total = 20,
                    accentColor = NeonHtmlOrange
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        // CSS Progress Card
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(14.dp))
                .background(DarkSurface)
                .border(1.dp, DarkBorder, RoundedCornerShape(14.dp))
                .padding(16.dp)
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "🔵", fontSize = 16.sp)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "CSS Course",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextPrimary
                        )
                    }
                    Text(
                        text = "$cssCompleted / 20",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = NeonCssBlue,
                        fontFamily = FontFamily.Monospace
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                AnimatedProgressBar(
                    completed = cssCompleted,
                    total = 20,
                    accentColor = NeonCssBlue
                )
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        // JavaScript Progress Card
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(14.dp))
                .background(DarkSurface)
                .border(1.dp, DarkBorder, RoundedCornerShape(14.dp))
                .padding(16.dp)
        ) {
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(text = "🟡", fontSize = 16.sp)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "JavaScript Course",
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold,
                            color = TextPrimary
                        )
                    }
                    Text(
                        text = "$jsCompleted / 20",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Bold,
                        color = NeonJsYellow,
                        fontFamily = FontFamily.Monospace
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                AnimatedProgressBar(
                    completed = jsCompleted,
                    total = 20,
                    accentColor = NeonJsYellow
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // COMPLETED LESSONS CHECKLIST SECTION
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Lessons Checklist",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = TextPrimary
            )
            Text(
                text = "Tap to toggle or open",
                fontSize = 11.5.sp,
                color = TextMuted
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Filter tabs
        ScrollableTabRow(
            selectedTabIndex = when (selectedCourseFilter) {
                null -> 0
                CourseType.HTML -> 1
                CourseType.CSS -> 2
                CourseType.JAVASCRIPT -> 3
            },
            containerColor = DarkSurface,
            contentColor = TextPrimary,
            edgePadding = 0.dp,
            indicator = { tabPositions ->
                val tabIdx = when (selectedCourseFilter) {
                    null -> 0
                    CourseType.HTML -> 1
                    CourseType.CSS -> 2
                    CourseType.JAVASCRIPT -> 3
                }
                if (tabIdx < tabPositions.size) {
                    TabRowDefaults.SecondaryIndicator(
                        Modifier.tabIndicatorOffset(tabPositions[tabIdx]),
                        color = selectedCourseFilter?.accentColor ?: NeonGreen,
                        height = 3.dp
                    )
                }
            }
        ) {
            val tabs = listOf<Pair<String, CourseType?>>(
                "All (60)" to null,
                "HTML (20)" to CourseType.HTML,
                "CSS (20)" to CourseType.CSS,
                "JS (20)" to CourseType.JAVASCRIPT
            )
            tabs.forEach { (label, type) ->
                val isSelected = selectedCourseFilter == type
                Tab(
                    selected = isSelected,
                    onClick = { selectedCourseFilter = type },
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

        Spacer(modifier = Modifier.height(12.dp))

        // Lessons Checklist Column
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            filteredLessons.forEach { lesson ->
                val isDone = checkCompleted(lesson.id)
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                        .background(DarkSurface)
                        .border(
                            1.dp,
                            if (isDone) NeonGreen.copy(alpha = 0.4f) else DarkBorder,
                            RoundedCornerShape(10.dp)
                        )
                        .padding(horizontal = 12.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Checkbox toggle + Title
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .weight(1f)
                            .clickable { onToggleCompleted(lesson.id) }
                    ) {
                        Icon(
                            imageVector = if (isDone) Icons.Default.CheckCircle else Icons.Default.RadioButtonUnchecked,
                            contentDescription = if (isDone) "Completed" else "Not Completed",
                            tint = if (isDone) NeonGreen else TextMuted,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Column {
                            Text(
                                text = "${lesson.courseType.shortName} #${lesson.lessonNumber}: ${lesson.title}",
                                fontSize = 13.5.sp,
                                fontWeight = if (isDone) FontWeight.SemiBold else FontWeight.Normal,
                                color = if (isDone) TextPrimary else TextSecondary
                            )
                        }
                    }

                    // Jump to lesson link
                    IconButton(
                        onClick = {
                            onNavigateToLesson(lesson.courseType, lesson.lessonNumber - 1)
                        },
                        modifier = Modifier.size(28.dp)
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                            contentDescription = "Open Lesson",
                            tint = lesson.courseType.accentColor,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(36.dp))
    }

    // Confirmation dialog for Reset All Progress
    if (showResetDialog) {
        AlertDialog(
            onDismissRequest = { showResetDialog = false },
            title = {
                Text(text = "Reset Progress?", color = TextPrimary, fontWeight = FontWeight.Bold)
            },
            text = {
                Text(
                    text = "This will reset all completed lesson markers back to 0 so you can retake the courses from the beginning.",
                    color = TextSecondary,
                    fontSize = 14.sp
                )
            },
            confirmButton = {
                ElevatedButton(
                    onClick = {
                        onResetAllProgress()
                        showResetDialog = false
                        Toast.makeText(context, "All progress has been reset.", Toast.LENGTH_SHORT).show()
                    },
                    colors = ButtonDefaults.elevatedButtonColors(
                        containerColor = Color(0xFFEF4444),
                        contentColor = Color.White
                    )
                ) {
                    Text("Reset Everything")
                }
            },
            dismissButton = {
                TextButton(onClick = { showResetDialog = false }) {
                    Text("Cancel", color = TextSecondary)
                }
            },
            containerColor = DarkSurface
        )
    }
}
