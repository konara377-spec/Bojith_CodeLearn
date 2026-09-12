package com.example.data

import android.content.Context
import android.content.SharedPreferences
import com.example.model.CourseType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProgressRepository(context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("codelearn_progress_prefs", Context.MODE_PRIVATE)

    private val _completedLessons = MutableStateFlow<Set<String>>(emptySet())
    val completedLessons: StateFlow<Set<String>> = _completedLessons.asStateFlow()

    init {
        loadCompletedLessons()
    }

    private fun loadCompletedLessons() {
        val savedSet = prefs.getStringSet(KEY_COMPLETED_LESSONS, emptySet()) ?: emptySet()
        _completedLessons.value = savedSet
    }

    fun isCompleted(lessonId: String): Boolean {
        return _completedLessons.value.contains(lessonId)
    }

    fun toggleCompleted(lessonId: String): Boolean {
        val current = _completedLessons.value.toMutableSet()
        val willBeCompleted = !current.contains(lessonId)
        if (willBeCompleted) {
            current.add(lessonId)
        } else {
            current.remove(lessonId)
        }
        _completedLessons.value = current
        prefs.edit().putStringSet(KEY_COMPLETED_LESSONS, current).apply()
        return willBeCompleted
    }

    fun markCompleted(lessonId: String, completed: Boolean) {
        val current = _completedLessons.value.toMutableSet()
        if (completed) {
            current.add(lessonId)
        } else {
            current.remove(lessonId)
        }
        _completedLessons.value = current
        prefs.edit().putStringSet(KEY_COMPLETED_LESSONS, current).apply()
    }

    fun getCompletedCount(courseType: CourseType): Int {
        val prefix = when (courseType) {
            CourseType.HTML -> "html_"
            CourseType.CSS -> "css_"
            CourseType.JAVASCRIPT -> "js_"
        }
        return _completedLessons.value.count { it.startsWith(prefix) }
    }

    fun resetProgress() {
        _completedLessons.value = emptySet()
        prefs.edit().remove(KEY_COMPLETED_LESSONS).apply()
    }

    // Save Playground Code
    fun savePlaygroundCode(html: String, css: String, js: String) {
        prefs.edit()
            .putString("playground_html", html)
            .putString("playground_css", css)
            .putString("playground_js", js)
            .apply()
    }

    fun getPlaygroundHtml(): String? = prefs.getString("playground_html", null)
    fun getPlaygroundCss(): String? = prefs.getString("playground_css", null)
    fun getPlaygroundJs(): String? = prefs.getString("playground_js", null)

    companion object {
        private const val KEY_COMPLETED_LESSONS = "completed_lessons"

        @Volatile
        private var INSTANCE: ProgressRepository? = null

        fun getInstance(context: Context): ProgressRepository {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: ProgressRepository(context.applicationContext).also { INSTANCE = it }
            }
        }
    }
}
