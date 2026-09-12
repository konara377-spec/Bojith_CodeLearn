package com.example.data

import com.example.model.CourseType
import com.example.model.QuizQuestion

object QuizData {
    val allQuestions: List<QuizQuestion> = listOf(
        // HTML Questions
        QuizQuestion(
            id = 1,
            courseType = CourseType.HTML,
            question = "What does HTML stand for?",
            options = listOf(
                "HyperText Markup Language",
                "High Tech Modern Language",
                "Hyperlink and Text Management Language",
                "Home Tool Markup Language"
            ),
            correctOptionIndex = 0,
            explanation = "HTML stands for HyperText Markup Language, the standard markup language used to build websites."
        ),
        QuizQuestion(
            id = 2,
            courseType = CourseType.HTML,
            question = "Which HTML tag is used for the most important, highest-level heading?",
            codeSnippet = "<...>Main Title</...>",
            options = listOf("<head>", "<h6>", "<h1>", "<heading>"),
            correctOptionIndex = 2,
            explanation = "<h1> defines the top-level heading on the page and carries the highest SEO weight."
        ),
        QuizQuestion(
            id = 3,
            courseType = CourseType.HTML,
            question = "Which attribute specifies the destination URL of a hyperlink <a>?",
            codeSnippet = "<a ...=\"https://example.com\">Visit</a>",
            options = listOf("src", "href", "link", "url"),
            correctOptionIndex = 1,
            explanation = "The 'href' (Hypertext REFerence) attribute specifies the destination web address for <a> links."
        ),
        QuizQuestion(
            id = 4,
            courseType = CourseType.HTML,
            question = "Which tag is required to display an image with fallback text?",
            options = listOf(
                "<img src=\"pic.jpg\" alt=\"Description\">",
                "<image src=\"pic.jpg\">",
                "<picture href=\"pic.jpg\">",
                "<photo file=\"pic.jpg\">"
            ),
            correctOptionIndex = 0,
            explanation = "<img> is the standard self-closing tag and 'alt' provides accessibility description."
        ),
        QuizQuestion(
            id = 5,
            courseType = CourseType.HTML,
            question = "Which tag creates an unordered, bulleted list?",
            options = listOf("<ol>", "<list>", "<ul>", "<dl>"),
            correctOptionIndex = 2,
            explanation = "<ul> creates an unordered bulleted list, whereas <ol> creates an ordered numbered list."
        ),

        // CSS Questions
        QuizQuestion(
            id = 6,
            courseType = CourseType.CSS,
            question = "What does CSS stand for?",
            options = listOf(
                "Cascading Style Sheets",
                "Creative Styling Software",
                "Computer Style Syntax",
                "Colorful Screen Sheets"
            ),
            correctOptionIndex = 0,
            explanation = "CSS stands for Cascading Style Sheets, used to format the layout and design of web pages."
        ),
        QuizQuestion(
            id = 7,
            courseType = CourseType.CSS,
            question = "How do you select an element with class=\"btn\" in CSS?",
            options = listOf(".btn", "#btn", "btn", "*btn"),
            correctOptionIndex = 0,
            explanation = "Class selectors in CSS are prefixed with a dot (.) like .btn."
        ),
        QuizQuestion(
            id = 8,
            courseType = CourseType.CSS,
            question = "Which CSS property controls the space INSIDE the border of an element?",
            options = listOf("margin", "padding", "border-spacing", "outline"),
            correctOptionIndex = 1,
            explanation = "Padding creates space INSIDE the border, while margin creates space OUTSIDE the border."
        ),
        QuizQuestion(
            id = 9,
            courseType = CourseType.CSS,
            question = "What CSS layout property makes centering horizontally and vertically super easy?",
            codeSnippet = ".container {\n  display: flex;\n  justify-content: center;\n  align-items: center;\n}",
            options = listOf("display: inline", "display: flex", "display: block", "float: left"),
            correctOptionIndex = 1,
            explanation = "Flexbox (display: flex) provides flexible 1D alignment and effortless vertical centering."
        ),
        QuizQuestion(
            id = 10,
            courseType = CourseType.CSS,
            question = "Which property makes corners rounded on cards or buttons?",
            options = listOf("corner-style", "border-radius", "box-curve", "round-edge"),
            correctOptionIndex = 1,
            explanation = "border-radius curves the corners of an element (e.g. border-radius: 12px; or 50% for circles)."
        ),

        // JavaScript Questions
        QuizQuestion(
            id = 11,
            courseType = CourseType.JAVASCRIPT,
            question = "Which keyword declares a variable whose value cannot be reassigned?",
            options = listOf("var", "let", "const", "static"),
            correctOptionIndex = 2,
            explanation = "const declares an immutable block-scoped constant variable in modern JavaScript."
        ),
        QuizQuestion(
            id = 12,
            courseType = CourseType.JAVASCRIPT,
            question = "How do you log a message to the browser developer console?",
            options = listOf(
                "console.log('Hello');",
                "print('Hello');",
                "System.out.println('Hello');",
                "log.message('Hello');"
            ),
            correctOptionIndex = 0,
            explanation = "console.log() prints messages to the browser's developer console for inspection."
        ),
        QuizQuestion(
            id = 13,
            courseType = CourseType.JAVASCRIPT,
            question = "Which operator tests for strict equality (matching both value AND type)?",
            options = listOf("==", "=", "===", "!="),
            correctOptionIndex = 2,
            explanation = "=== is strict equality. 5 === '5' returns false because one is a number and one is a string."
        ),
        QuizQuestion(
            id = 14,
            courseType = CourseType.JAVASCRIPT,
            question = "How do you select an element by its ID in JavaScript?",
            options = listOf(
                "document.getElementById('myId')",
                "document.selectId('myId')",
                "window.find('myId')",
                "document.getElementByName('myId')"
            ),
            correctOptionIndex = 0,
            explanation = "document.getElementById('myId') or document.querySelector('#myId') are standard ways to find elements by ID."
        ),
        QuizQuestion(
            id = 15,
            courseType = CourseType.JAVASCRIPT,
            question = "Which method attaches an event listener (like a click) to an element?",
            codeSnippet = "button.addEventListener('click', () => { ... });",
            options = listOf(
                "addEventListener()",
                "attachEvent()",
                "onClick()",
                "listen()"
            ),
            correctOptionIndex = 0,
            explanation = "addEventListener() is the standard modern approach to handle user interactions."
        )
    )

    fun getQuestionsForCourse(courseType: CourseType?): List<QuizQuestion> {
        return if (courseType == null) {
            allQuestions
        } else {
            allQuestions.filter { it.courseType == courseType }
        }
    }
}
