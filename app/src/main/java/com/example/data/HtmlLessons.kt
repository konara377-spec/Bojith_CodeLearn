package com.example.data

import com.example.model.CodeExample
import com.example.model.CourseType
import com.example.model.Lesson
import com.example.model.LineExplanation

object HtmlLessons {
    val lessons: List<Lesson> = listOf(
        Lesson(
            id = "html_1",
            courseType = CourseType.HTML,
            lessonNumber = 1,
            title = "What is HTML?",
            explanation = "HTML stands for HyperText Markup Language. It is the standard code used to create and structure pages on the World Wide Web. HTML describes the structure of a web page using a series of elements represented by tags like <h1>, <p>, and <a>.",
            importantPoints = listOf(
                "HTML is the skeleton/blueprint of every webpage.",
                "Tags are surrounded by angle brackets, like <tagname>.",
                "Most tags come in pairs: an opening tag <p> and a closing tag </p>.",
                "HTML files have an extension of .html or .htm."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "First Web Element",
                    code = "<h1>Hello, World!</h1>\n<p>Welcome to HTML programming.</p>"
                ),
                CodeExample(
                    title = "Tag Pairing",
                    code = "<!-- Opening tag, content, and closing tag -->\n<h2>This is a Subheading</h2>\n<p>HTML is super easy to learn!</p>"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("<h1>Hello, World!</h1>", "<h1> defines the most important heading on the page."),
                LineExplanation("<p>Welcome to HTML...</p>", "<p> defines a paragraph of regular text."),
                LineExplanation("</h1> and </p>", "The forward slash / indicates the end (closing) of the tag.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; text-align: center; padding: 20px; background: #1e293b; color: #f8fafc; border-radius: 12px;">
                  <h1 style="color: #ff6b35;">Hello, World!</h1>
                  <p style="font-size: 16px; color: #94a3b8;">Welcome to your first HTML document.</p>
                  <span style="background: #334155; padding: 6px 12px; border-radius: 6px; font-size: 13px;">HTML Skeleton Ready</span>
                </div>
            """.trimIndent(),
            notes = "Remember: HTML does not handle visual styling or logic on its own. It only sets up the structure and content!"
        ),

        Lesson(
            id = "html_2",
            courseType = CourseType.HTML,
            lessonNumber = 2,
            title = "Creating an HTML file",
            explanation = "To build a webpage on your computer, you create a plain text file named index.html. The name 'index.html' is special because web servers look for it by default when visitors open a website.",
            importantPoints = listOf(
                "HTML files are saved with the .html extension (e.g. index.html).",
                "You can use text editors like VS Code, Sublime, or Notepad to write them.",
                "Double-clicking an .html file opens it in any browser like Chrome or Safari.",
                "No compiler is required—browsers read and display HTML natively."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Basic index.html",
                    code = "<!DOCTYPE html>\n<html>\n  <body>\n    <h1>My First Page</h1>\n  </body>\n</html>"
                ),
                CodeExample(
                    title = "Adding a Title",
                    code = "<!DOCTYPE html>\n<html>\n<head>\n  <title>My Portfolio</title>\n</head>\n<body>\n  <p>Coming Soon!</p>\n</body>\n</html>"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("<!DOCTYPE html>", "Tells browser this document is written in modern HTML5."),
                LineExplanation("<html>", "The root element that wraps all page content."),
                LineExplanation("<body>", "Contains all visible contents shown on the screen.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; padding: 16px; background: #0f172a; color: #e2e8f0; border-radius: 8px;">
                  <h2 style="color: #38bdf8;">File: index.html</h2>
                  <p>This file is read and rendered by web browsers instantly.</p>
                  <div style="background: #1e293b; padding: 10px; border-radius: 6px; border-left: 4px solid #ff6b35;">
                    💡 Tip: The homepage of websites is always named index.html
                  </div>
                </div>
            """.trimIndent(),
            notes = "Always ensure file extensions are visible in your operating system so you don't accidentally save as 'index.html.txt'."
        ),

        Lesson(
            id = "html_3",
            courseType = CourseType.HTML,
            lessonNumber = 3,
            title = "Basic HTML structure",
            explanation = "Every standard HTML5 document follows a strict nested structure: <!DOCTYPE html>, <html>, <head>, and <body>. The <head> contains metadata (like the page title), while the <body> contains all user-visible text, images, and links.",
            importantPoints = listOf(
                "<!DOCTYPE html> must be the very first line.",
                "<head> holds information ABOUT the page (metadata, title, stylesheet links).",
                "<title> inside <head> sets the browser tab title.",
                "<body> holds all visible elements users interact with."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Standard HTML5 Boilerplate",
                    code = "<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n  <meta charset=\"UTF-8\">\n  <title>Web Page Title</title>\n</head>\n<body>\n  <h1>Welcome!</h1>\n  <p>Everything in body is visible.</p>\n</body>\n</html>"
                ),
                CodeExample(
                    title = "With Viewport Meta Tag",
                    code = "<head>\n  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n  <title>Mobile Friendly Page</title>\n</head>"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("<html lang=\"en\">", "Specifies the primary language (English) for search engines and accessibility."),
                LineExplanation("<meta charset=\"UTF-8\">", "Ensures text characters, symbols, and emojis display accurately."),
                LineExplanation("<title>", "Sets the title in the browser tab and search results.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; padding: 20px; background: #111827; border-radius: 12px; color: #f3f4f6;">
                  <span style="color: #a855f7; font-size: 12px; font-weight: bold;">HTML5 DOCUMENT</span>
                  <h1 style="color: #ff6b35; margin-top: 8px;">Structure in Action</h1>
                  <p style="color: #9ca3af;">Notice how the header and body organize information neatly.</p>
                  <button style="background: #ff6b35; color: white; border: none; padding: 8px 16px; border-radius: 6px; cursor: pointer;">Awesome!</button>
                </div>
            """.trimIndent(),
            notes = "Think of <head> as the brain of the webpage and <body> as the physical body that everyone can see."
        ),

        Lesson(
            id = "html_4",
            courseType = CourseType.HTML,
            lessonNumber = 4,
            title = "HTML headings",
            explanation = "HTML has six levels of headings, ranging from <h1> to <h6>. <h1> is the highest and most important heading (usually one per page), while <h6> is the smallest subheading.",
            importantPoints = listOf(
                "<h1> is the largest and most critical for Search Engine Optimization (SEO).",
                "Headings decrease in size and importance from <h1> down to <h6>.",
                "Do not skip heading levels (e.g. going from <h1> directly to <h4>).",
                "Use headings for content hierarchy, not purely for text sizing."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Heading Hierarchy",
                    code = "<h1>Main Heading (h1)</h1>\n<h2>Section Title (h2)</h2>\n<h3>Sub-section (h3)</h3>\n<h4>Minor Heading (h4)</h4>"
                ),
                CodeExample(
                    title = "Headings 5 and 6",
                    code = "<h5>Small Heading (h5)</h5>\n<h6>Smallest Heading (h6)</h6>"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("<h1>Main Heading</h1>", "The primary topic title for the page."),
                LineExplanation("<h2>Section Title</h2>", "Separates major sections underneath the main heading."),
                LineExplanation("<h3>Sub-section</h3>", "Breaks down an h2 section into sub-topics.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; padding: 16px; background: #1e293b; color: #f8fafc; border-radius: 10px;">
                  <h1 style="color: #ff6b35; margin: 6px 0; font-size: 26px;">Heading 1 (h1)</h1>
                  <h2 style="color: #38bdf8; margin: 6px 0; font-size: 20px;">Heading 2 (h2)</h2>
                  <h3 style="color: #facc15; margin: 6px 0; font-size: 17px;">Heading 3 (h3)</h3>
                  <h4 style="color: #a78bfa; margin: 6px 0; font-size: 14px;">Heading 4 (h4)</h4>
                </div>
            """.trimIndent(),
            notes = "Search engines like Google index your page primarily based on keywords inside your <h1> and <h2> tags."
        ),

        Lesson(
            id = "html_5",
            courseType = CourseType.HTML,
            lessonNumber = 5,
            title = "Paragraphs",
            explanation = "The <p> tag defines a paragraph of text. Browsers automatically add a small amount of whitespace (margin) before and after each paragraph to make reading comfortable.",
            importantPoints = listOf(
                "Paragraphs are block-level elements (they always start on a new line).",
                "Extra spaces and line breaks in HTML source code are collapsed into a single space.",
                "To force a simple line break without starting a new paragraph, use the <br> tag."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Two Separate Paragraphs",
                    code = "<p>This is the first paragraph. It introduces the main idea.</p>\n<p>This is the second paragraph. It continues the story.</p>"
                ),
                CodeExample(
                    title = "Line Break Inside Paragraph",
                    code = "<p>First line of poem<br>Second line of poem<br>Third line of poem</p>"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("<p>...</p>", "Defines a distinct text block with top and bottom spacing."),
                LineExplanation("<br>", "Self-closing tag that causes an instant line break inside a paragraph.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; padding: 16px; background: #0f172a; color: #cbd5e1; border-radius: 8px; line-height: 1.6;">
                  <p style="margin-bottom: 12px; color: #f8fafc;">Coding is a superpower that lets you build software used by millions across the globe.</p>
                  <p style="color: #94a3b8;">HTML is where every web engineer starts their journey.<br>Take it one step at a time!</p>
                </div>
            """.trimIndent(),
            notes = "Never use multiple <br> tags just to create space between paragraphs. Use CSS margins instead!"
        ),

        Lesson(
            id = "html_6",
            courseType = CourseType.HTML,
            lessonNumber = 6,
            title = "Text formatting",
            explanation = "HTML has special formatting tags to give text visual weight and semantic importance. Tags like <strong> indicate critical importance (bold), <em> marks emphasis (italics), and <mark> highlights text.",
            importantPoints = listOf(
                "<strong> makes text bold and signals importance to screen readers.",
                "<em> creates italics and denotes linguistic emphasis.",
                "<mark> highlights text with a yellow background.",
                "<del> strikes through text, and <ins> underlines inserted text."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Bold, Italic, and Highlight",
                    code = "<p>This is <strong>very important</strong>.</p>\n<p>This is <em>emphasized</em> text.</p>\n<p>Don't forget to <mark>save your work</mark>!</p>"
                ),
                CodeExample(
                    title = "Subscript and Strikethrough",
                    code = "<p>Original price: <del>$100</del> Now: <strong>$75</strong></p>\n<p>Water chemical formula: H<sub>2</sub>O</p>"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("<strong>", "Renders text bold and adds semantic urgency."),
                LineExplanation("<em>", "Italicizes text with verbal stress emphasis."),
                LineExplanation("<mark>", "Applies a fluorescent highlighter effect."),
                LineExplanation("<del>", "Shows deleted or outdated information with a line through it.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; padding: 16px; background: #1e293b; color: #e2e8f0; border-radius: 8px; line-height: 1.8;">
                  <p>Learning code is <strong>exciting</strong> and <em>transformative</em>!</p>
                  <p>Special deal: <del>$99.99</del> <ins style="color: #34d399; font-weight: bold;">FREE Today</ins></p>
                  <p>Remember this rule: <mark style="background: #fef08a; padding: 2px 6px; border-radius: 4px;">Practice every day</mark></p>
                </div>
            """.trimIndent(),
            notes = "Prefer <strong> and <em> over older <b> and <i> tags because they provide accessibility meaning to assistive software."
        ),

        Lesson(
            id = "html_7",
            courseType = CourseType.HTML,
            lessonNumber = 7,
            title = "Links",
            explanation = "Links are created using the anchor tag <a>. They allow users to navigate between pages on the same website, jump to external websites, or jump to a specific section on the current page.",
            importantPoints = listOf(
                "The href attribute specifies the destination URL.",
                "The text between <a> and </a> is what the user clicks.",
                "target=\"_blank\" opens the link in a brand new browser tab.",
                "You can link to email addresses using href=\"mailto:example@domain.com\"."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Standard Web Link",
                    code = "<a href=\"https://www.google.com\">Search on Google</a>"
                ),
                CodeExample(
                    title = "Open in New Tab",
                    code = "<a href=\"https://github.com\" target=\"_blank\" rel=\"noopener noreferrer\">Visit GitHub</a>"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("<a ...>", "Anchor tag that defines a hyperlink."),
                LineExplanation("href=\"https://...\"", "Hypertext reference: the address the link goes to."),
                LineExplanation("target=\"_blank\"", "Instructs the browser to open the URL in a new tab.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; padding: 18px; background: #111827; border-radius: 10px; color: #f9fafb;">
                  <h3 style="color: #ff6b35; margin-top: 0;">Resource Links</h3>
                  <p>Click the link below to visit an educational website:</p>
                  <a href="https://developer.mozilla.org" target="_blank" style="display: inline-block; background: #00d2ff; color: #000; padding: 10px 18px; border-radius: 6px; text-decoration: none; font-weight: bold;">MDN Web Docs ↗</a>
                </div>
            """.trimIndent(),
            notes = "Always include rel=\"noopener noreferrer\" when using target=\"_blank\" for security and performance protection."
        ),

        Lesson(
            id = "html_8",
            courseType = CourseType.HTML,
            lessonNumber = 8,
            title = "Images",
            explanation = "Images are added to webpages using the <img> tag. The <img> tag is self-closing (it has no closing </img> tag) and requires two essential attributes: src (source) and alt (alternative text).",
            importantPoints = listOf(
                "<img> is a void/self-closing element.",
                "src provides the file path or web URL of the image.",
                "alt describes the image for screen readers and displays if the file fails to load.",
                "Supports formats like JPEG, PNG, SVG, WebP, and GIF."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Basic Image",
                    code = "<img src=\"https://picsum.photos/300/180\" alt=\"A scenic mountain view\">"
                ),
                CodeExample(
                    title = "Image with Dimensions",
                    code = "<img src=\"logo.png\" alt=\"Company Logo\" width=\"120\" height=\"40\">"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("<img ...>", "Initiates an image element."),
                LineExplanation("src=\"...\"", "Location of the image file."),
                LineExplanation("alt=\"...\"", "Text description required for accessibility and fallback.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; padding: 16px; background: #1e293b; color: white; border-radius: 12px; text-align: center;">
                  <h3 style="margin-top: 0; color: #38bdf8;">Image Display</h3>
                  <img src="https://images.unsplash.com/photo-1517694712202-14dd9538aa97?w=400&q=80" alt="Laptop with Code" style="width: 100%; max-width: 320px; border-radius: 8px; border: 2px solid #334155; display: block; margin: 0 auto;">
                  <p style="font-size: 13px; color: #94a3b8; margin-top: 8px;">Coding workstation illustration</p>
                </div>
            """.trimIndent(),
            notes = "Never leave the alt attribute empty! If an image is purely decorative, use alt=\"\" so screen readers skip it gracefully."
        ),

        Lesson(
            id = "html_9",
            courseType = CourseType.HTML,
            lessonNumber = 9,
            title = "Image attributes",
            explanation = "HTML allows fine-tuned control over images using attributes like width, height, title, loading=\"lazy\", and srcset for responsive display on high-resolution screens.",
            importantPoints = listOf(
                "width and height reserve layout space before the image downloads.",
                "loading=\"lazy\" improves page speed by only downloading when scrolled into view.",
                "title attribute displays a tooltip when hovering with a mouse.",
                "Specifying aspect ratios prevents annoying layout shifts (CLS)."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Lazy Loading & Dimensions",
                    code = "<img src=\"banner.jpg\" alt=\"Tech conference banner\" width=\"600\" height=\"300\" loading=\"lazy\">"
                ),
                CodeExample(
                    title = "Hover Title Tooltip",
                    code = "<img src=\"avatar.png\" alt=\"User Avatar\" title=\"Click to view user profile\">"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("width=\"600\"", "Sets intrinsic display width in pixels."),
                LineExplanation("loading=\"lazy\"", "Defers image download until user scrolls near it."),
                LineExplanation("title=\"...\"", "Hover tooltip visible on desktop browsers.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; padding: 16px; background: #0f172a; border-radius: 10px; color: #f1f5f9;">
                  <h4 style="color: #facc15; margin: 0 0 10px;">Attributes Example</h4>
                  <div style="display: flex; gap: 12px; align-items: center;">
                    <img src="https://images.unsplash.com/photo-1534972195531-a756b1126f24?w=160&q=80" alt="Programmer avatar" width="80" height="80" style="border-radius: 50%; border: 3px solid #ff6b35; object-fit: cover;">
                    <div>
                      <strong style="font-size: 16px;">Alex Rivera</strong>
                      <p style="margin: 4px 0 0; color: #94a3b8; font-size: 13px;">Full Stack Engineer • width: 80, height: 80</p>
                    </div>
                  </div>
                </div>
            """.trimIndent(),
            notes = "Modern web design uses CSS for responsive scaling (max-width: 100%), but HTML width and height remain crucial for preventing layout shift."
        ),

        Lesson(
            id = "html_10",
            courseType = CourseType.HTML,
            lessonNumber = 10,
            title = "Lists",
            explanation = "HTML offers two main types of lists: Unordered lists (<ul>) with bullet points, and Ordered lists (<ol>) with sequential numbers. Each item inside a list is placed in an <li> (list item) tag.",
            importantPoints = listOf(
                "<ul> creates a bulleted list.",
                "<ol> creates a numbered list (1, 2, 3...).",
                "<li> stands for 'list item' and is placed inside <ul> or <ol>.",
                "Lists can be nested inside one another to create multi-level menus."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Unordered List (Bullets)",
                    code = "<ul>\n  <li>HTML5</li>\n  <li>CSS3</li>\n  <li>JavaScript</li>\n</ul>"
                ),
                CodeExample(
                    title = "Ordered List (Numbered)",
                    code = "<ol>\n  <li>Write Code</li>\n  <li>Test in Browser</li>\n  <li>Deploy to Web</li>\n</ol>"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("<ul>...</ul>", "Unordered list wrapper."),
                LineExplanation("<ol>...</ol>", "Ordered list wrapper showing numbers automatically."),
                LineExplanation("<li>...</li>", "Individual item within the parent list container.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; padding: 18px; background: #1e293b; border-radius: 12px; color: #f8fafc;">
                  <h3 style="color: #38bdf8; margin-top: 0;">Frontend Roadmap</h3>
                  <ol style="padding-left: 20px; line-height: 1.8; color: #facc15;">
                    <li><span style="color: #e2e8f0;">Master HTML5 Structure</span></li>
                    <li><span style="color: #e2e8f0;">Style with CSS & Flexbox</span></li>
                    <li><span style="color: #e2e8f0;">Add Logic with JavaScript</span></li>
                  </ol>
                </div>
            """.trimIndent(),
            notes = "Navigation bars in modern web apps are almost always built with a <ul> list and styled with CSS!"
        ),

        Lesson(
            id = "html_11",
            courseType = CourseType.HTML,
            lessonNumber = 11,
            title = "Tables",
            explanation = "HTML tables organize information into rows and columns. A table uses <table>, <tr> for table rows, <th> for table header cells, and <td> for table data cells.",
            importantPoints = listOf(
                "<table> is the main container element.",
                "<tr> defines a horizontal row of cells.",
                "<th> defines a header cell (bold and centered by default).",
                "<td> defines a standard data cell holding values.",
                "<thead> and <tbody> help structure complex tabular data."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Basic 2x2 Table",
                    code = "<table border=\"1\">\n  <tr>\n    <th>Language</th>\n    <th>Role</th>\n  </tr>\n  <tr>\n    <td>HTML</td>\n    <td>Structure</td>\n  </tr>\n</table>"
                ),
                CodeExample(
                    title = "Table with 3 Columns",
                    code = "<table>\n  <tr>\n    <th>Tech</th>\n    <th>Year</th>\n    <th>Creator</th>\n  </tr>\n  <tr>\n    <td>JavaScript</td>\n    <td>1995</td>\n    <td>Brendan Eich</td>\n  </tr>\n</table>"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("<table>", "Starts the tabular grid."),
                LineExplanation("<tr>", "Creates a table row."),
                LineExplanation("<th>", "Header cell defining what the column represents."),
                LineExplanation("<td>", "Data cell containing specific information.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; padding: 14px; background: #0f172a; border-radius: 10px;">
                  <table style="width: 100%; border-collapse: collapse; color: #f8fafc; text-align: left;">
                    <thead>
                      <tr style="background: #334155; color: #ff6b35;">
                        <th style="padding: 10px; border-bottom: 2px solid #475569;">Track</th>
                        <th style="padding: 10px; border-bottom: 2px solid #475569;">Level</th>
                        <th style="padding: 10px; border-bottom: 2px solid #475569;">Lessons</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr style="border-bottom: 1px solid #1e293b;">
                        <td style="padding: 8px 10px;">HTML</td>
                        <td style="padding: 8px 10px; color: #34d399;">Beginner</td>
                        <td style="padding: 8px 10px;">20</td>
                      </tr>
                      <tr>
                        <td style="padding: 8px 10px;">CSS</td>
                        <td style="padding: 8px 10px; color: #38bdf8;">Beginner</td>
                        <td style="padding: 8px 10px;">20</td>
                      </tr>
                    </tbody>
                  </table>
                </div>
            """.trimIndent(),
            notes = "Do not use tables for page layout! Tables should only be used for displaying actual tabular data (like spreadsheets or schedules)."
        ),

        Lesson(
            id = "html_12",
            courseType = CourseType.HTML,
            lessonNumber = 12,
            title = "Buttons",
            explanation = "The <button> element represents a clickable button. Buttons trigger actions such as submitting forms, toggling views, playing audio, or launching JavaScript functions.",
            importantPoints = listOf(
                "<button> can contain text, emojis, and even images.",
                "type=\"button\" defines a standard clickable button.",
                "type=\"submit\" submits the enclosing form data.",
                "disabled attribute prevents the user from clicking the button."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Basic Clickable Button",
                    code = "<button type=\"button\">Click Me!</button>"
                ),
                CodeExample(
                    title = "Button with Alert Action",
                    code = "<button type=\"button\" onclick=\"alert('You clicked the button!')\">Tap Here</button>"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("<button type=\"button\">", "Specifies a generic interactive button."),
                LineExplanation("onclick=\"...\"", "Runs a snippet of JavaScript code when the user taps or clicks."),
                LineExplanation("disabled", "Disables user interaction until a certain condition is met.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; padding: 20px; background: #1e293b; border-radius: 12px; text-align: center;">
                  <h3 style="color: #facc15; margin-top: 0;">Interactive Buttons</h3>
                  <button onclick="alert('Hello from HTML button!')" style="background: #ff6b35; color: white; border: none; padding: 12px 24px; border-radius: 8px; font-weight: bold; font-size: 15px; cursor: pointer; margin-right: 8px;">
                    Click Me 🚀
                  </button>
                  <button disabled style="background: #475569; color: #94a3b8; border: none; padding: 12px 24px; border-radius: 8px; font-size: 15px;">
                    Disabled 🔒
                  </button>
                </div>
            """.trimIndent(),
            notes = "Always provide descriptive button text so users and screen readers understand what clicking it will do."
        ),

        Lesson(
            id = "html_13",
            courseType = CourseType.HTML,
            lessonNumber = 13,
            title = "Forms",
            explanation = "HTML forms (<form>) collect user inputs such as login credentials, search queries, feedback messages, and survey responses to send to a web server for processing.",
            importantPoints = listOf(
                "<form> acts as a container for input fields, checkboxes, and buttons.",
                "action specifies the URL where form data is sent.",
                "method specifies the HTTP method, typically 'GET' (for searches) or 'POST' (for logins).",
                "<label> improves accessibility by associating text with inputs."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Simple Login Form",
                    code = "<form action=\"/submit\" method=\"POST\">\n  <label for=\"uname\">Username:</label>\n  <input id=\"uname\" type=\"text\" name=\"username\">\n  <button type=\"submit\">Login</button>\n</form>"
                ),
                CodeExample(
                    title = "Search Form",
                    code = "<form action=\"/search\" method=\"GET\">\n  <input type=\"search\" name=\"q\" placeholder=\"Search articles...\">\n  <input type=\"submit\" value=\"Search\">\n</form>"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("<form ...>", "Container for data collection controls."),
                LineExplanation("action=\"/submit\"", "The destination server endpoint that processes the data."),
                LineExplanation("method=\"POST\"", "Sends sensitive user data securely in the request body.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; padding: 18px; background: #0f172a; border-radius: 12px; color: #f8fafc;">
                  <h3 style="color: #00d2ff; margin-top: 0;">Sign Up Form</h3>
                  <form onsubmit="alert('Form submitted!'); return false;" style="display: flex; flex-direction: column; gap: 10px;">
                    <label style="font-size: 13px; color: #94a3b8;">Email Address</label>
                    <input type="email" placeholder="coder@example.com" required style="padding: 10px; border-radius: 6px; border: 1px solid #334155; background: #1e293b; color: white;">
                    <button type="submit" style="background: #00d2ff; color: black; border: none; padding: 10px; border-radius: 6px; font-weight: bold; cursor: pointer; margin-top: 4px;">Join Community</button>
                  </form>
                </div>
            """.trimIndent(),
            notes = "Always include <label> elements with 'for' attributes linking to the input's 'id' to help screen reader users."
        ),

        Lesson(
            id = "html_14",
            courseType = CourseType.HTML,
            lessonNumber = 14,
            title = "Input fields",
            explanation = "The <input> element is one of the most powerful and flexible tags in HTML. Depending on the type attribute, it can appear as a text box, password field, checkbox, radio button, or date picker.",
            importantPoints = listOf(
                "type=\"text\" is a single-line text input.",
                "type=\"password\" masks entered characters for security.",
                "type=\"checkbox\" allows multiple choices.",
                "type=\"radio\" allows choosing one option from a group.",
                "placeholder shows helpful preview text before typing."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Text and Password Inputs",
                    code = "<input type=\"text\" placeholder=\"Enter your name\">\n<input type=\"password\" placeholder=\"Enter secret password\">"
                ),
                CodeExample(
                    title = "Checkboxes and Radios",
                    code = "<label><input type=\"checkbox\" checked> Subscribe to newsletter</label><br>\n<label><input type=\"radio\" name=\"role\" value=\"dev\"> Developer</label>\n<label><input type=\"radio\" name=\"role\" value=\"des\"> Designer</label>"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("type=\"password\"", "Hides characters as dots for privacy."),
                LineExplanation("placeholder=\"...\"", "Faint prompt text inside the empty field."),
                LineExplanation("required", "Browser enforces input before submitting.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; padding: 18px; background: #1e293b; border-radius: 12px; color: #f8fafc;">
                  <h4 style="color: #ff6b35; margin-top: 0;">Input Controls</h4>
                  <div style="display: flex; flex-direction: column; gap: 10px;">
                    <input type="text" placeholder="Your username" style="padding: 8px 12px; border-radius: 6px; border: 1px solid #475569; background: #0f172a; color: white;">
                    <input type="password" placeholder="Your password" style="padding: 8px 12px; border-radius: 6px; border: 1px solid #475569; background: #0f172a; color: white;">
                    <label style="font-size: 13px; color: #94a3b8; display: flex; align-items: center; gap: 8px;">
                      <input type="checkbox" checked style="accent-color: #ff6b35;"> Remember my login
                    </label>
                  </div>
                </div>
            """.trimIndent(),
            notes = "HTML5 added modern input types like 'email', 'tel', 'number', and 'color' with built-in validation."
        ),

        Lesson(
            id = "html_15",
            courseType = CourseType.HTML,
            lessonNumber = 15,
            title = "Audio",
            explanation = "HTML5 introduced the native <audio> tag, allowing websites to play music, podcasts, and sound effects directly in the browser without any third-party plugins.",
            importantPoints = listOf(
                "The controls attribute adds playback controls (play, pause, volume).",
                "Common supported audio formats: MP3, WAV, and OGG.",
                "Use the <source> tag inside <audio> to supply multiple audio file formats for browser compatibility.",
                "autoplay and loop attributes control automatic playback and repetition."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Basic Audio Player",
                    code = "<audio controls>\n  <source src=\"podcast.mp3\" type=\"audio/mpeg\">\n  Your browser does not support audio.\n</audio>"
                ),
                CodeExample(
                    title = "Audio with Loop & Autoplay",
                    code = "<audio controls loop>\n  <source src=\"ambient-sound.ogg\" type=\"audio/ogg\">\n  <source src=\"ambient-sound.mp3\" type=\"audio/mpeg\">\n</audio>"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("<audio controls>", "Displays the native browser audio player interface."),
                LineExplanation("<source src=\"...\" type=\"...\">", "Specifies audio file location and MIME type."),
                LineExplanation("loop", "Automatically restarts playback once the audio finishes.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; padding: 20px; background: #111827; border-radius: 12px; color: white; text-align: center;">
                  <h3 style="color: #38bdf8; margin-top: 0;">HTML5 Audio Player</h3>
                  <p style="color: #94a3b8; font-size: 14px;">Listen to sample chime sound effect:</p>
                  <audio controls style="width: 100%; max-width: 320px; outline: none;">
                    <source src="https://actions.google.com/sounds/v1/alarms/digital_watch_alarm_long.ogg" type="audio/ogg">
                    <source src="https://actions.google.com/sounds/v1/alarms/alarm_clock.ogg" type="audio/ogg">
                    Your browser does not support audio.
                  </audio>
                </div>
            """.trimIndent(),
            notes = "Modern browsers block audio autoplay unless the user has first interacted with the webpage to avoid annoying visitors."
        ),

        Lesson(
            id = "html_16",
            courseType = CourseType.HTML,
            lessonNumber = 16,
            title = "Video",
            explanation = "The <video> tag allows embedding video clips directly into web pages. It features built-in controls for play, pause, fullscreen, and volume, along with poster image support.",
            importantPoints = listOf(
                "controls adds standard play/pause, scrub bar, and fullscreen buttons.",
                "poster displays an image while the video is downloading or before playing.",
                "Common supported formats: MP4 (H.264), WebM, and Ogg.",
                "muted attribute is required if you want a video to autoplay silently."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Basic Video Player",
                    code = "<video width=\"320\" height=\"240\" controls poster=\"thumbnail.jpg\">\n  <source src=\"movie.mp4\" type=\"video/mp4\">\n  Your browser does not support the video tag.\n</video>"
                ),
                CodeExample(
                    title = "Silent Background Loop",
                    code = "<video autoplay muted loop playsinline width=\"100%\">\n  <source src=\"ambient.webm\" type=\"video/webm\">\n</video>"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("<video controls>", "Embeds video element with native playback controls."),
                LineExplanation("poster=\"...\"", "Thumbnail image shown before play is pressed."),
                LineExplanation("muted", "Silences audio so browsers permit autoplay.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; padding: 16px; background: #0f172a; border-radius: 12px; color: #f8fafc; text-align: center;">
                  <h3 style="color: #ff6b35; margin-top: 0;">HTML5 Video Example</h3>
                  <video controls width="100%" style="max-width: 360px; border-radius: 8px; background: #000;" poster="https://images.unsplash.com/photo-1518770660439-4636190af475?w=400">
                    <source src="https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4" type="video/mp4">
                    Your browser does not support video.
                  </video>
                  <p style="font-size: 13px; color: #94a3b8; margin-top: 8px;">Playable MP4 video streaming demo</p>
                </div>
            """.trimIndent(),
            notes = "Always include width and height to maintain aspect ratio and prevent layout shifting while the video streams."
        ),

        Lesson(
            id = "html_17",
            courseType = CourseType.HTML,
            lessonNumber = 17,
            title = "Embedding videos",
            explanation = "Rather than hosting large video files on your own server, you can embed videos hosted on platforms like YouTube, Vimeo, or DailyMotion using an <iframe> (inline frame).",
            importantPoints = listOf(
                "<iframe> embeds another web document inside the current page.",
                "Use the 'Share > Embed' URL provided by video platforms.",
                "allowfullscreen allows viewers to enlarge the video to their full display.",
                "frameborder=\"0\" removes obsolete frame borders."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "YouTube Embed",
                    code = "<iframe width=\"560\" height=\"315\" src=\"https://www.youtube.com/embed/dQw4w9WgXcQ\" title=\"Video Player\" frameborder=\"0\" allowfullscreen></iframe>"
                ),
                CodeExample(
                    title = "Responsive Aspect Ratio Container",
                    code = "<div style=\"position: relative; padding-bottom: 56.25%; height: 0;\">\n  <iframe src=\"https://www.youtube.com/embed/dQw4w9WgXcQ\" style=\"position: absolute; top: 0; left: 0; width: 100%; height: 100%;\" allowfullscreen></iframe>\n</div>"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("<iframe ...>", "Creates an inline window to display external content."),
                LineExplanation("src=\"https://www.youtube.com/embed/...\"", "The specialized embed URL of the video."),
                LineExplanation("allowfullscreen", "Enables browser fullscreen mode on the iframe.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; padding: 16px; background: #1e293b; border-radius: 12px; color: white;">
                  <h3 style="color: #38bdf8; margin-top: 0;">Embedded Online Video</h3>
                  <div style="position: relative; padding-bottom: 56.25%; height: 0; overflow: hidden; border-radius: 8px;">
                    <iframe src="https://www.youtube.com/embed/dQw4w9WgXcQ" style="position: absolute; top:0; left: 0; width: 100%; height: 100%; border: none;" allowfullscreen></iframe>
                  </div>
                  <p style="font-size: 13px; color: #94a3b8; margin-top: 8px; text-align: center;">Hosted external video streaming via iframe</p>
                </div>
            """.trimIndent(),
            notes = "Make sure you use the /embed/ link from YouTube rather than the standard /watch?v= link, as watch links block iframe embedding."
        ),

        Lesson(
            id = "html_18",
            courseType = CourseType.HTML,
            lessonNumber = 18,
            title = "div and span",
            explanation = "<div> and <span> are general-purpose container elements. <div> is a block-level container used to group sections of content, while <span> is an inline container used to style words or phrases inside a text line.",
            importantPoints = listOf(
                "<div> creates a block container that starts on a new line and takes 100% width.",
                "<span> is inline and only takes as much width as its content.",
                "Neither element has inherent visual styling until you apply CSS classes or styles.",
                "They are foundational for CSS layout engines like Flexbox and Grid."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "div Card Container",
                    code = "<div class=\"card\">\n  <h2>Card Title</h2>\n  <p>Card description text inside a div.</p>\n</div>"
                ),
                CodeExample(
                    title = "span Inline Highlighting",
                    code = "<p>Prices start at <span style=\"color: #10b981; font-weight: bold;\">$9.99</span> per month.</p>"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("<div>...</div>", "Block container grouping related HTML tags together."),
                LineExplanation("<span>...</span>", "Inline container targeting a specific segment of text within a line.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; padding: 16px; background: #111827; border-radius: 10px;">
                  <div style="background: #1e293b; padding: 14px; border-radius: 8px; border: 1px solid #334155;">
                    <h3 style="color: #ff6b35; margin: 0 0 6px;">Profile Card (div)</h3>
                    <p style="color: #cbd5e1; margin: 0;">Status: <span style="color: #10b981; font-weight: bold;">● Online (span)</span></p>
                  </div>
                </div>
            """.trimIndent(),
            notes = "While <div> is extremely useful, always check if a semantic tag like <article>, <section>, or <header> is more descriptive."
        ),

        Lesson(
            id = "html_19",
            courseType = CourseType.HTML,
            lessonNumber = 19,
            title = "Semantic HTML",
            explanation = "Semantic HTML tags clearly describe their meaning to both the browser and the developer. Instead of using generic <div> elements everywhere, semantic tags like <header>, <nav>, <main>, <article>, <aside>, and <footer> explain the structure of the document.",
            importantPoints = listOf(
                "<header> represents introductory content or navigation.",
                "<nav> defines major navigation links.",
                "<main> holds the unique central content of the document.",
                "<article> contains self-contained, distributable content (e.g. blog post).",
                "<footer> contains copyright notices and secondary links."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Semantic Page Layout",
                    code = "<header>\n  <h1>CodeLearn</h1>\n  <nav><a href=\"#\">Home</a></nav>\n</header>\n<main>\n  <article>\n    <h2>Semantic Benefits</h2>\n    <p>Better SEO and accessibility.</p>\n  </article>\n</main>\n<footer>\n  <p>© 2026 CodeLearn</p>\n</footer>"
                ),
                CodeExample(
                    title = "Aside Sidebar",
                    code = "<aside>\n  <h3>Related Articles</h3>\n  <ul><li>CSS Tips</li></ul>\n</aside>"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("<header>", "Top section containing logo and site title."),
                LineExplanation("<nav>", "Semantic wrapper indicating navigation menu."),
                LineExplanation("<main>", "Dominant primary content area of the document."),
                LineExplanation("<footer>", "Bottom bar with author and copyright info.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; background: #0f172a; padding: 14px; border-radius: 10px; color: #f8fafc;">
                  <header style="background: #1e293b; padding: 8px 12px; border-radius: 6px; display: flex; justify-content: space-between; align-items: center;">
                    <strong style="color: #ff6b35;">CodeLearn</strong>
                    <nav><span style="color: #38bdf8; font-size: 13px;">Home • Docs</span></nav>
                  </header>
                  <main style="background: #182234; padding: 12px; border-radius: 6px; margin: 8px 0;">
                    <h4 style="margin: 0 0 4px; color: #facc15;">Semantic Article</h4>
                    <p style="margin: 0; font-size: 13px; color: #94a3b8;">Clear layout structure for web crawlers.</p>
                  </main>
                  <footer style="text-align: center; font-size: 11px; color: #64748b;">
                    © 2026 CodeLearn Inc.
                  </footer>
                </div>
            """.trimIndent(),
            notes = "Using semantic tags significantly boosts your search engine ranking and enables visually impaired users to navigate easily using screen readers."
        ),

        Lesson(
            id = "html_20",
            courseType = CourseType.HTML,
            lessonNumber = 20,
            title = "Beginner HTML project",
            explanation = "Congratulations on reaching Lesson 20! In this capstone project, you combine everything you have learned: doctype, headings, paragraphs, lists, links, images, tables, and buttons into a complete personal profile portfolio webpage.",
            importantPoints = listOf(
                "Combines all 19 previous HTML lessons into one unified project.",
                "Structure includes a header, biography, skills list, project table, and contact button.",
                "Demonstrates mastery of modern HTML5 markup.",
                "Ready to be styled in the upcoming CSS course!"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Personal Portfolio Page",
                    code = "<header>\n  <h1>Sarah Doe</h1>\n  <p>Aspiring Web Developer</p>\n</header>\n<section>\n  <h2>Skills</h2>\n  <ul>\n    <li>HTML5 Structure</li>\n    <li>Semantic Markup</li>\n  </ul>\n</section>"
                ),
                CodeExample(
                    title = "Contact Section",
                    code = "<section>\n  <h2>Contact Me</h2>\n  <button onclick=\"alert('Email: sarah@example.com')\">Send Message</button>\n</section>"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("<header>...</header>", "Identifies the site owner and headline."),
                LineExplanation("<ul>...</ul>", "Lists web development proficiencies."),
                LineExplanation("<button ...>", "Interactive contact call-to-action.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; background: #0f172a; padding: 20px; border-radius: 12px; color: #f8fafc; border: 1px solid #334155;">
                  <div style="text-align: center; border-bottom: 1px solid #334155; padding-bottom: 16px;">
                    <img src="https://images.unsplash.com/photo-1534528741775-53994a69daeb?w=160" alt="Sarah Developer" style="width: 72px; height: 72px; border-radius: 50%; border: 2px solid #ff6b35;">
                    <h2 style="color: #ff6b35; margin: 8px 0 2px;">Sarah Jenkins</h2>
                    <p style="color: #94a3b8; margin: 0; font-size: 14px;">Web Developer • HTML Graduate</p>
                  </div>
                  
                  <h3 style="color: #38bdf8; margin: 14px 0 6px; font-size: 16px;">My Coding Skills</h3>
                  <ul style="padding-left: 20px; color: #cbd5e1; font-size: 14px; margin: 0;">
                    <li>HTML5 & Semantic Structure</li>
                    <li>Forms, Tables, and Accessibility</li>
                    <li>Audio, Video & Media Integration</li>
                  </ul>
                  
                  <div style="margin-top: 16px; text-align: center;">
                    <button onclick="alert('Thanks for viewing my portfolio project!')" style="background: #10b981; color: white; border: none; padding: 10px 20px; border-radius: 6px; font-weight: bold; cursor: pointer;">Hire Me 🚀</button>
                  </div>
                </div>
            """.trimIndent(),
            notes = "You are now fully ready to dive into CSS and make your HTML websites look beautiful and modern!"
        )
    )
}
