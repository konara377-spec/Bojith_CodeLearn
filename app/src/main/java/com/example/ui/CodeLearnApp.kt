package com.example.ui

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Code
import androidx.compose.material.icons.filled.EmojiEvents
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayCircle
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material.icons.filled.Terminal
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.CssLessons
import com.example.data.HtmlLessons
import com.example.data.JsLessons
import com.example.data.ProgressRepository
import com.example.model.CourseType
import com.example.ui.screens.CourseLessonScreen
import com.example.ui.screens.HomeScreen
import com.example.ui.screens.PlaygroundScreen
import com.example.ui.screens.ProgressScreen
import com.example.ui.screens.QuizScreen
import com.example.ui.theme.DarkBorder
import com.example.ui.theme.DarkCanvas
import com.example.ui.theme.DarkSurface
import com.example.ui.theme.NeonCssBlue
import com.example.ui.theme.NeonGreen
import com.example.ui.theme.NeonHtmlOrange
import com.example.ui.theme.NeonJsYellow
import com.example.ui.theme.TextMuted
import com.example.ui.theme.TextPrimary
import com.example.ui.theme.TextSecondary

sealed class NavDestination(val route: String) {
    data object Home : NavDestination("home")
    data class Course(val courseType: CourseType, val lessonIndex: Int = 0) : NavDestination("course/${courseType.name}")
    data object Playground : NavDestination("playground")
    data object Quizzes : NavDestination("quizzes")
    data object Progress : NavDestination("progress")
}

@Composable
fun CodeLearnApp(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val progressRepo = remember { ProgressRepository(context) }
    val completedLessonIds by progressRepo.completedLessons.collectAsState()

    var currentDestination by remember { mutableStateOf<NavDestination>(NavDestination.Home) }

    val htmlCompleted = HtmlLessons.lessons.count { it.id in completedLessonIds }
    val cssCompleted = CssLessons.lessons.count { it.id in completedLessonIds }
    val jsCompleted = JsLessons.lessons.count { it.id in completedLessonIds }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = DarkCanvas,
        bottomBar = {
            NavigationBar(
                containerColor = DarkSurface,
                tonalElevation = 8.dp,
                modifier = Modifier
                    .border(width = 1.dp, color = DarkBorder)
                    .testTag("bottom_navigation_bar")
            ) {
                // 1. Home
                NavigationBarItem(
                    selected = currentDestination is NavDestination.Home,
                    onClick = { currentDestination = NavDestination.Home },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Home",
                            modifier = Modifier.size(22.dp)
                        )
                    },
                    label = { Text("Home", fontSize = 11.sp, fontWeight = FontWeight.SemiBold) },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = NeonGreen,
                        selectedTextColor = NeonGreen,
                        unselectedIconColor = TextSecondary,
                        unselectedTextColor = TextSecondary,
                        indicatorColor = NeonGreen.copy(alpha = 0.15f)
                    ),
                    modifier = Modifier.testTag("nav_item_home")
                )

                // 2. HTML
                NavigationBarItem(
                    selected = (currentDestination as? NavDestination.Course)?.courseType == CourseType.HTML,
                    onClick = { currentDestination = NavDestination.Course(CourseType.HTML, 0) },
                    icon = {
                        Text("🟠", fontSize = 16.sp)
                    },
                    label = { Text("HTML", fontSize = 11.sp, fontWeight = FontWeight.SemiBold) },
                    colors = NavigationBarItemDefaults.colors(
                        selectedTextColor = NeonHtmlOrange,
                        unselectedTextColor = TextSecondary,
                        indicatorColor = NeonHtmlOrange.copy(alpha = 0.15f)
                    ),
                    modifier = Modifier.testTag("nav_item_html")
                )

                // 3. CSS
                NavigationBarItem(
                    selected = (currentDestination as? NavDestination.Course)?.courseType == CourseType.CSS,
                    onClick = { currentDestination = NavDestination.Course(CourseType.CSS, 0) },
                    icon = {
                        Text("🔵", fontSize = 16.sp)
                    },
                    label = { Text("CSS", fontSize = 11.sp, fontWeight = FontWeight.SemiBold) },
                    colors = NavigationBarItemDefaults.colors(
                        selectedTextColor = NeonCssBlue,
                        unselectedTextColor = TextSecondary,
                        indicatorColor = NeonCssBlue.copy(alpha = 0.15f)
                    ),
                    modifier = Modifier.testTag("nav_item_css")
                )

                // 4. JS
                NavigationBarItem(
                    selected = (currentDestination as? NavDestination.Course)?.courseType == CourseType.JAVASCRIPT,
                    onClick = { currentDestination = NavDestination.Course(CourseType.JAVASCRIPT, 0) },
                    icon = {
                        Text("🟡", fontSize = 16.sp)
                    },
                    label = { Text("JS", fontSize = 11.sp, fontWeight = FontWeight.SemiBold) },
                    colors = NavigationBarItemDefaults.colors(
                        selectedTextColor = NeonJsYellow,
                        unselectedTextColor = TextSecondary,
                        indicatorColor = NeonJsYellow.copy(alpha = 0.15f)
                    ),
                    modifier = Modifier.testTag("nav_item_js")
                )

                // 5. Playground
                NavigationBarItem(
                    selected = currentDestination is NavDestination.Playground,
                    onClick = { currentDestination = NavDestination.Playground },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Terminal,
                            contentDescription = "Playground",
                            modifier = Modifier.size(22.dp)
                        )
                    },
                    label = { Text("Sandbox", fontSize = 11.sp, fontWeight = FontWeight.SemiBold) },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = NeonGreen,
                        selectedTextColor = NeonGreen,
                        unselectedIconColor = TextSecondary,
                        unselectedTextColor = TextSecondary,
                        indicatorColor = NeonGreen.copy(alpha = 0.15f)
                    ),
                    modifier = Modifier.testTag("nav_item_playground")
                )

                // 6. Progress
                NavigationBarItem(
                    selected = currentDestination is NavDestination.Progress,
                    onClick = { currentDestination = NavDestination.Progress },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.EmojiEvents,
                            contentDescription = "Progress",
                            modifier = Modifier.size(22.dp)
                        )
                    },
                    label = { Text("Stats", fontSize = 11.sp, fontWeight = FontWeight.SemiBold) },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = NeonGreen,
                        selectedTextColor = NeonGreen,
                        unselectedIconColor = TextSecondary,
                        unselectedTextColor = TextSecondary,
                        indicatorColor = NeonGreen.copy(alpha = 0.15f)
                    ),
                    modifier = Modifier.testTag("nav_item_progress")
                )
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            AnimatedContent(
                targetState = currentDestination,
                transitionSpec = { fadeIn() togetherWith fadeOut() },
                label = "screen_transition"
            ) { destination ->
                when (destination) {
                    is NavDestination.Home -> {
                        HomeScreen(
                            htmlCompleted = htmlCompleted,
                            cssCompleted = cssCompleted,
                            jsCompleted = jsCompleted,
                            onOpenCourse = { course ->
                                currentDestination = NavDestination.Course(course, 0)
                            },
                            onOpenPlayground = {
                                currentDestination = NavDestination.Playground
                            },
                            onOpenQuiz = {
                                currentDestination = NavDestination.Quizzes
                            }
                        )
                    }

                    is NavDestination.Course -> {
                        val (courseLessons, courseType) = when (destination.courseType) {
                            CourseType.HTML -> HtmlLessons.lessons to CourseType.HTML
                            CourseType.CSS -> CssLessons.lessons to CourseType.CSS
                            CourseType.JAVASCRIPT -> JsLessons.lessons to CourseType.JAVASCRIPT
                        }

                        CourseLessonScreen(
                            courseType = courseType,
                            lessons = courseLessons,
                            initialLessonIndex = destination.lessonIndex,
                            isCompleted = { id -> progressRepo.toggleCompleted(id) },
                            onToggleCompleted = { id -> progressRepo.toggleCompleted(id) },
                            checkCompleted = { id -> progressRepo.isCompleted(id) },
                            onBackToHome = { currentDestination = NavDestination.Home }
                        )
                    }

                    is NavDestination.Playground -> {
                        PlaygroundScreen()
                    }

                    is NavDestination.Quizzes -> {
                        QuizScreen()
                    }

                    is NavDestination.Progress -> {
                        ProgressScreen(
                            htmlCompleted = htmlCompleted,
                            cssCompleted = cssCompleted,
                            jsCompleted = jsCompleted,
                            checkCompleted = { id -> progressRepo.isCompleted(id) },
                            onToggleCompleted = { id -> progressRepo.toggleCompleted(id) },
                            onNavigateToLesson = { course, idx ->
                                currentDestination = NavDestination.Course(course, idx)
                            },
                            onResetAllProgress = {
                                progressRepo.resetProgress()
                            }
                        )
                    }
                }
            }
        }
    }
}
