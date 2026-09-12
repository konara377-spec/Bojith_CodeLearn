package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.data.CssLessons
import com.example.data.HtmlLessons
import com.example.data.JsLessons
import com.example.data.ProgressRepository
import com.example.data.QuizData
import com.example.model.CourseType
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [36])
class ExampleRobolectricTest {

  @Test
  fun `read string from context`() {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val appName = context.getString(R.string.app_name)
    assertEquals("CodeLearn", appName)
  }

  @Test
  fun `verify full 20 lessons for HTML, CSS, and JavaScript`() {
    assertEquals(20, HtmlLessons.lessons.size)
    assertEquals(20, CssLessons.lessons.size)
    assertEquals(20, JsLessons.lessons.size)
  }

  @Test
  fun `verify quiz questions available for each course type`() {
    val htmlQuestions = QuizData.getQuestionsForCourse(CourseType.HTML)
    val cssQuestions = QuizData.getQuestionsForCourse(CourseType.CSS)
    val jsQuestions = QuizData.getQuestionsForCourse(CourseType.JAVASCRIPT)

    assertTrue(htmlQuestions.isNotEmpty())
    assertTrue(cssQuestions.isNotEmpty())
    assertTrue(jsQuestions.isNotEmpty())
  }

  @Test
  fun `verify progress repository completion tracking`() {
    val context = ApplicationProvider.getApplicationContext<Context>()
    val repo = ProgressRepository(context)

    repo.resetProgress()
    assertFalse(repo.isCompleted("html_1"))

    val newlyCompleted = repo.toggleCompleted("html_1")
    assertTrue(newlyCompleted)
    assertTrue(repo.isCompleted("html_1"))
    assertEquals(1, repo.getCompletedCount(CourseType.HTML))

    repo.resetProgress()
    assertFalse(repo.isCompleted("html_1"))
    assertEquals(0, repo.getCompletedCount(CourseType.HTML))
  }
}
