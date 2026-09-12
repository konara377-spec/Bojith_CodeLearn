package com.example.data

import com.example.model.CodeExample
import com.example.model.CourseType
import com.example.model.Lesson
import com.example.model.LineExplanation

object CssLessons {
    val lessons: List<Lesson> = listOf(
        Lesson(
            id = "css_1",
            courseType = CourseType.CSS,
            lessonNumber = 1,
            title = "What is CSS?",
            explanation = "CSS stands for Cascading Style Sheets. While HTML builds the skeleton of a website, CSS is the design language that gives it beauty, layout, colors, typography, and responsive animations. CSS determines how HTML elements should be presented on screen.",
            importantPoints = listOf(
                "CSS describes the presentation and design of HTML documents.",
                "Consists of a selector and a declaration block: selector { property: value; }",
                "Separates website content (HTML) from visual design (CSS).",
                "Saves enormous development time by allowing one stylesheet to style thousands of pages."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Basic CSS Rule",
                    code = "h1 {\n  color: #00d2ff;\n  font-size: 32px;\n  text-align: center;\n}"
                ),
                CodeExample(
                    title = "Multiple Selectors",
                    code = "p, span {\n  color: #e2e8f0;\n  line-height: 1.6;\n}"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("h1 { ... }", "The selector targeting all <h1> elements on the page."),
                LineExplanation("color: #00d2ff;", "Property 'color' changes text color to cyan neon."),
                LineExplanation("font-size: 32px;", "Sets font dimensions in pixels."),
                LineExplanation("text-align: center;", "Centers the text horizontally.")
            ),
            defaultRunnableCode = """
                <style>
                  .css-intro {
                    font-family: sans-serif;
                    background: #111827;
                    border: 2px solid #00d2ff;
                    border-radius: 12px;
                    padding: 24px;
                    text-align: center;
                  }
                  .css-intro h1 {
                    color: #00d2ff;
                    margin: 0 0 10px;
                  }
                  .css-intro p {
                    color: #94a3b8;
                    margin: 0;
                  }
                </style>
                <div class="css-intro">
                  <h1>CSS is Magic ✨</h1>
                  <p>Turn raw HTML into a visual masterpiece!</p>
                </div>
            """.trimIndent(),
            notes = "Without CSS, the entire web would look like a plain black-and-white 1990s research paper!"
        ),

        Lesson(
            id = "css_2",
            courseType = CourseType.CSS,
            lessonNumber = 2,
            title = "Adding CSS to HTML",
            explanation = "There are three primary ways to add CSS to an HTML document: Inline styles (using style=\"\" attribute), Internal styles (using <style> tags inside <head>), and External stylesheets (linking a separate .css file with <link>).",
            importantPoints = listOf(
                "External CSS (<link rel=\"stylesheet\" href=\"style.css\">) is best practice for production.",
                "Internal CSS (<style> in <head>) is useful for single-page applications and quick demos.",
                "Inline CSS (style=\"...\") applies only to that specific element and has the highest specificity.",
                "External stylesheets keep code clean, reusable, and cacheable by browsers."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "External CSS Link",
                    code = "<head>\n  <link rel=\"stylesheet\" href=\"styles.css\">\n</head>"
                ),
                CodeExample(
                    title = "Internal <style> Tag",
                    code = "<style>\n  body { background-color: #0f172a; }\n  .title { color: #38bdf8; }\n</style>"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("<link rel=\"stylesheet\" ...>", "Connects external styles.css to your HTML document."),
                LineExplanation("<style>...</style>", "Defines internal styles directly in the document."),
                LineExplanation("style=\"color: red;\"", "Inline attribute styling a single tag.")
            ),
            defaultRunnableCode = """
                <style>
                  .styled-box {
                    background: linear-gradient(135deg, #1e293b, #0f172a);
                    color: #f8fafc;
                    padding: 20px;
                    border-radius: 12px;
                    border-left: 5px solid #00d2ff;
                    font-family: sans-serif;
                  }
                </style>
                <div class="styled-box">
                  <h3 style="color: #00d2ff; margin: 0 0 8px;">Internal Style In Action</h3>
                  <p style="margin: 0; color: #cbd5e1;">The <style> block above defined these colors and border styles.</p>
                </div>
            """.trimIndent(),
            notes = "Avoid inline styles on real projects because they make code messy and impossible to update in bulk."
        ),

        Lesson(
            id = "css_3",
            courseType = CourseType.CSS,
            lessonNumber = 3,
            title = "CSS selectors",
            explanation = "CSS selectors target specific HTML elements so you can style them. The main selectors are element selectors (e.g. p), class selectors (prefixed with a dot .card), and ID selectors (prefixed with a hash #header).",
            importantPoints = listOf(
                "Element selector (p) styles all <p> tags on the entire page.",
                "Class selector (.highlight) styles elements having class=\"highlight\". Reusable!",
                "ID selector (#main-logo) styles the single unique element with id=\"main-logo\".",
                "Classes are intended to be used multiple times; IDs must be unique per page."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Class and ID Selectors",
                    code = "/* Class selector */\n.btn {\n  padding: 10px 20px;\n  border-radius: 6px;\n}\n\n/* ID selector */\n#hero-banner {\n  background: #1e1e2e;\n}"
                ),
                CodeExample(
                    title = "Universal & Grouped Selectors",
                    code = "/* Universal reset */\n* {\n  box-sizing: border-box;\n}\n\n/* Grouped */\nh1, h2, h3 {\n  font-family: 'Inter', sans-serif;\n}"
                )
            ),
            lineExplanations = listOf(
                LineExplanation(".btn { ... }", "Period (.) denotes a class selector. Applies to class=\"btn\"."),
                LineExplanation("#hero-banner { ... }", "Hash (#) denotes an ID selector. Applies to id=\"hero-banner\"."),
                LineExplanation("* { ... }", "Asterisk targets every single element on the page.")
            ),
            defaultRunnableCode = """
                <style>
                  .badge {
                    display: inline-block;
                    padding: 6px 14px;
                    border-radius: 20px;
                    font-size: 12px;
                    font-weight: bold;
                    margin-right: 8px;
                    font-family: sans-serif;
                  }
                  .badge-primary { background: #00d2ff; color: #000; }
                  .badge-warning { background: #facc15; color: #000; }
                  #unique-tag { border: 2px dashed #ff6b35; }
                </style>
                <div style="padding: 16px; background: #0f172a; border-radius: 10px;">
                  <span class="badge badge-primary">Class 1 (.badge-primary)</span>
                  <span class="badge badge-warning">Class 2 (.badge-warning)</span>
                  <span id="unique-tag" class="badge" style="color: #ff6b35;">Unique ID (#unique-tag)</span>
                </div>
            """.trimIndent(),
            notes = "Always prefer classes over IDs for styling because classes are flexible and easy to maintain."
        ),

        Lesson(
            id = "css_4",
            courseType = CourseType.CSS,
            lessonNumber = 4,
            title = "Colors",
            explanation = "CSS supports multiple ways to define colors: color names (red, cyan), Hex codes (#00d2ff), RGB/RGBA (rgba(0, 210, 255, 0.8)), and HSL (hue, saturation, lightness). The color property sets text color.",
            importantPoints = listOf(
                "Hex codes (#rrggbb) use hexadecimal values from 00 to FF.",
                "RGBA allows an alpha transparency channel from 0.0 (invisible) to 1.0 (opaque).",
                "HSL (hsl(hue, sat%, light%)) is intuitive for picking tints and shades.",
                "Use high contrast between text and background colors for accessibility."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Color Notations",
                    code = "/* Hex color */\ncolor: #ff6b35;\n\n/* RGBA with 50% transparency */\nbackground-color: rgba(0, 210, 255, 0.5);\n\n/* HSL */\nborder-color: hsl(210, 100%, 50%);"
                ),
                CodeExample(
                    title = "Opacity and Accents",
                    code = ".card {\n  color: #f8fafc;\n  background: rgba(30, 41, 59, 0.85);\n}"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("#ff6b35", "Hex notation for vibrant neon orange."),
                LineExplanation("rgba(0, 210, 255, 0.5)", "Red 0, Green 210, Blue 255, and 0.5 (50%) transparency.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; padding: 18px; background: #0b0f19; border-radius: 12px; display: flex; gap: 12px; flex-wrap: wrap;">
                  <div style="flex: 1; min-width: 100px; padding: 12px; background: #ff6b35; color: white; border-radius: 8px; text-align: center; font-weight: bold;">
                    #ff6b35<br><span style="font-size: 11px;">Hex Orange</span>
                  </div>
                  <div style="flex: 1; min-width: 100px; padding: 12px; background: #00d2ff; color: black; border-radius: 8px; text-align: center; font-weight: bold;">
                    #00d2ff<br><span style="font-size: 11px;">Hex Cyan</span>
                  </div>
                  <div style="flex: 1; min-width: 100px; padding: 12px; background: rgba(16, 185, 129, 0.8); color: white; border-radius: 8px; text-align: center; font-weight: bold;">
                    RGBA<br><span style="font-size: 11px;">80% Alpha</span>
                  </div>
                </div>
            """.trimIndent(),
            notes = "Modern web apps store color palettes inside CSS variables (:root { --brand-color: #00d2ff; }) for easy dark mode toggling."
        ),

        Lesson(
            id = "css_5",
            courseType = CourseType.CSS,
            lessonNumber = 5,
            title = "Backgrounds",
            explanation = "The background properties in CSS control the backdrop of elements. You can set solid background-color, high-resolution background-image, gradients, and configure how backgrounds repeat, scale, and align.",
            importantPoints = listOf(
                "background-color sets a solid or translucent backdrop.",
                "background-image: url('...') sets an image as the background.",
                "linear-gradient(...) creates modern multi-color fade gradients.",
                "background-size: cover scales the image to fully cover the element without stretching."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Linear Gradient Background",
                    code = ".hero {\n  background: linear-gradient(135deg, #1e1e38, #0f172a);\n  color: #ffffff;\n}"
                ),
                CodeExample(
                    title = "Cover Image Background",
                    code = ".cover {\n  background-image: url('wallpaper.jpg');\n  background-size: cover;\n  background-position: center;\n  background-repeat: no-repeat;\n}"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("linear-gradient(135deg, ...)", "Creates a diagonal color transition from top-left to bottom-right."),
                LineExplanation("background-size: cover", "Resizes image proportionally to cover entire element boundaries.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; padding: 24px; border-radius: 14px; background: linear-gradient(135deg, #ff6b35, #a855f7, #00d2ff); color: white; text-align: center; box-shadow: 0 8px 24px rgba(0,0,0,0.3);">
                  <h2 style="margin: 0 0 6px; text-shadow: 0 2px 4px rgba(0,0,0,0.4);">Lush Gradient</h2>
                  <p style="margin: 0; font-size: 14px; opacity: 0.95;">linear-gradient(135deg, #ff6b35, #a855f7, #00d2ff)</p>
                </div>
            """.trimIndent(),
            notes = "CSS gradients are computed digitally by the browser and load instantly with zero download file size!"
        ),

        Lesson(
            id = "css_6",
            courseType = CourseType.CSS,
            lessonNumber = 6,
            title = "Fonts",
            explanation = "Typography is one of the most critical aspects of web design. CSS lets you choose font-family, import Google Fonts, adjust font-size, and control font-weight (from thin 100 to bold 900).",
            importantPoints = listOf(
                "font-family provides a prioritized list of fallback fonts (e.g. Arial, sans-serif).",
                "Web fonts from Google Fonts can be linked via @import or <link>.",
                "font-weight controls thickness (400 is normal, 700 is bold).",
                "Use 'rem' units for font sizes to support user accessibility font scaling."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Font Family Stack",
                    code = "body {\n  font-family: 'Segoe UI', -apple-system, Roboto, sans-serif;\n  font-size: 16px;\n  font-weight: 400;\n}"
                ),
                CodeExample(
                    title = "Monospace Code Font",
                    code = "code, pre {\n  font-family: 'Fira Code', 'Courier New', monospace;\n  font-size: 14px;\n}"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("font-family: 'Segoe UI', sans-serif;", "Tries 'Segoe UI' first, then falls back to default sans-serif."),
                LineExplanation("font-weight: 700;", "Renders characters in bold weight.")
            ),
            defaultRunnableCode = """
                <div style="padding: 16px; background: #111827; border-radius: 10px; color: #f8fafc;">
                  <p style="font-family: sans-serif; font-size: 18px; font-weight: 700; color: #38bdf8; margin: 0 0 8px;">
                    Sans-Serif Bold (Modern & Clean)
                  </p>
                  <p style="font-family: serif; font-size: 16px; font-style: italic; color: #cbd5e1; margin: 0 0 8px;">
                    Serif Italic (Classic & Editorial)
                  </p>
                  <p style="font-family: monospace; font-size: 14px; color: #facc15; background: #1e293b; padding: 6px 10px; border-radius: 4px; margin: 0;">
                    Monospace (Great for Code & Tech)
                  </p>
                </div>
            """.trimIndent(),
            notes = "Always end your font-family list with a generic family keyword like sans-serif, serif, or monospace."
        ),

        Lesson(
            id = "css_7",
            courseType = CourseType.CSS,
            lessonNumber = 7,
            title = "Text styling",
            explanation = "CSS offers numerous properties to polish text readability: text-align (left, center, right, justify), text-decoration (underline, line-through, none), line-height (vertical line spacing), letter-spacing, and text-transform.",
            importantPoints = listOf(
                "line-height: 1.6 provides optimal readability for paragraphs.",
                "text-transform: uppercase makes text ALL CAPS without modifying HTML.",
                "text-decoration: none removes default blue underlines from links.",
                "letter-spacing adds breathing room between individual characters."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Link Clean Reset",
                    code = "a {\n  text-decoration: none;\n  color: #00d2ff;\n  font-weight: bold;\n}"
                ),
                CodeExample(
                    title = "Badge Text Uppercase",
                    code = ".tag {\n  text-transform: uppercase;\n  letter-spacing: 1.5px;\n  font-size: 11px;\n}"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("text-decoration: none;", "Removes default underlines from anchor links."),
                LineExplanation("text-transform: uppercase;", "Converts text characters to capital letters."),
                LineExplanation("letter-spacing: 1px;", "Adds 1 pixel of space between every letter.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; padding: 18px; background: #1e293b; border-radius: 12px;">
                  <span style="font-size: 11px; font-weight: bold; letter-spacing: 2px; text-transform: uppercase; color: #00d2ff; background: rgba(0, 210, 255, 0.15); padding: 4px 10px; border-radius: 4px;">Featured Post</span>
                  <h3 style="color: #f8fafc; margin: 8px 0; line-height: 1.3;">Styling Text for Maximum Readability</h3>
                  <p style="color: #94a3b8; line-height: 1.6; margin: 0;">Notice how generous line-height and letter-spacing make text pleasurable to read on any device.</p>
                </div>
            """.trimIndent(),
            notes = "A line-height of 1.5 to 1.7 is considered the golden standard for comfortable digital reading."
        ),

        Lesson(
            id = "css_8",
            courseType = CourseType.CSS,
            lessonNumber = 8,
            title = "Borders",
            explanation = "Borders frame HTML elements. You can configure border-width, border-style (solid, dashed, dotted), border-color, and border-radius to curve sharp square edges into smooth rounded rectangles or circles.",
            importantPoints = listOf(
                "Shorthand syntax: border: 2px solid #00d2ff;",
                "border-radius rounds corners (e.g. border-radius: 12px;).",
                "border-radius: 50% turns a square into a perfect circle.",
                "You can style individual sides: border-left, border-bottom, etc."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Border Shorthand & Radius",
                    code = ".card {\n  border: 1px solid #334155;\n  border-radius: 12px;\n}"
                ),
                CodeExample(
                    title = "Circular Avatar Border",
                    code = ".avatar {\n  width: 80px;\n  height: 80px;\n  border: 3px solid #ff6b35;\n  border-radius: 50%;\n}"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("border: 2px solid #00d2ff;", "Width is 2px, style is solid, color is neon cyan."),
                LineExplanation("border-radius: 12px;", "Curves the 4 corners by 12 pixels.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; padding: 18px; background: #0f172a; border-radius: 12px; display: flex; gap: 14px; align-items: center;">
                  <div style="padding: 14px; border: 2px dashed #00d2ff; border-radius: 10px; color: #00d2ff; font-weight: bold; font-size: 13px;">
                    Dashed Border
                  </div>
                  <div style="padding: 14px; border-left: 5px solid #ff6b35; background: #1e293b; border-radius: 6px; color: #f8fafc; font-size: 13px;">
                    Left Accent Border
                  </div>
                </div>
            """.trimIndent(),
            notes = "border-radius: 9999px is commonly used by Tailwind and modern UI kits to create capsule / pill buttons."
        ),

        Lesson(
            id = "css_9",
            courseType = CourseType.CSS,
            lessonNumber = 9,
            title = "Width and height",
            explanation = "The width and height properties define the dimensions of an element. CSS supports absolute units (px) and responsive relative units like percentages (%), viewport width (vw), and viewport height (vh).",
            importantPoints = listOf(
                "max-width prevents elements from overflowing on narrow phone screens.",
                "min-height guarantees a component will never shrink smaller than a threshold.",
                "width: 100% takes the full width of the parent container.",
                "height: auto lets height adapt automatically based on inner text content."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Responsive Max Width",
                    code = ".container {\n  width: 100%;\n  max-width: 600px;\n  margin: 0 auto;\n}"
                ),
                CodeExample(
                    title = "Full Viewport Hero",
                    code = ".hero {\n  width: 100vw;\n  min-height: 80vh;\n}"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("max-width: 600px;", "Element will never expand wider than 600px, but will shrink on phones."),
                LineExplanation("min-height: 200px;", "Guarantees a minimum vertical height even if empty.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; padding: 16px; background: #1e293b; border-radius: 12px;">
                  <div style="width: 100%; background: #0f172a; border-radius: 8px; padding: 10px; box-sizing: border-box; color: #cbd5e1; font-size: 13px; margin-bottom: 10px;">
                    width: 100% (Adapts to phone screen)
                  </div>
                  <div style="width: 65%; background: #00d2ff; color: #000; border-radius: 8px; padding: 10px; font-weight: bold; font-size: 13px;">
                    width: 65%
                  </div>
                </div>
            """.trimIndent(),
            notes = "Avoid setting rigid pixel heights on containers containing text; text will overflow if font size changes or screen wraps."
        ),

        Lesson(
            id = "css_10",
            courseType = CourseType.CSS,
            lessonNumber = 10,
            title = "Margin",
            explanation = "Margin creates space OUTSIDE of an element's border. It pushes neighboring elements away so elements don't collide or look cramped together.",
            importantPoints = listOf(
                "Margin is completely transparent outside whitespace.",
                "Shorthand: margin: 10px 20px; (top/bottom 10px, left/right 20px).",
                "margin: 0 auto; centers a block element horizontally inside its parent.",
                "Individual sides: margin-top, margin-right, margin-bottom, margin-left."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Centering with Auto Margin",
                    code = ".center-card {\n  width: 300px;\n  margin: 0 auto;\n}"
                ),
                CodeExample(
                    title = "Margin Shorthand",
                    code = "/* top right bottom left (clockwise) */\n.box {\n  margin: 10px 15px 20px 5px;\n}"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("margin: 0 auto;", "0 top/bottom, auto calculates equal left/right space to center."),
                LineExplanation("margin-bottom: 24px;", "Adds 24px gap before the next element below.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; padding: 16px; background: #0f172a; border-radius: 12px;">
                  <div style="background: #334155; color: white; padding: 10px; border-radius: 6px; text-align: center; margin-bottom: 16px;">
                    Box 1 (margin-bottom: 16px)
                  </div>
                  <div style="background: #ff6b35; color: white; padding: 10px; border-radius: 6px; text-align: center;">
                    Box 2 pushed downward cleanly!
                  </div>
                </div>
            """.trimIndent(),
            notes = "Vertical margins between adjacent blocks can collapse into a single margin equal to the larger of the two values."
        ),

        Lesson(
            id = "css_11",
            courseType = CourseType.CSS,
            lessonNumber = 11,
            title = "Padding",
            explanation = "Padding creates space INSIDE an element's border, between the border and the actual content (like text or an image). Padding gives text breathing room inside cards and buttons.",
            importantPoints = listOf(
                "Padding is inside the element and takes the element's background color.",
                "Shorthand: padding: 12px 24px; (vertical 12px, horizontal 24px).",
                "Essential for making clickable buttons feel comfortable and thumb-friendly.",
                "Increasing padding enlarges the clickable touch area of an element."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Button Padding",
                    code = ".btn {\n  padding: 12px 24px;\n  background: #00d2ff;\n  border-radius: 8px;\n}"
                ),
                CodeExample(
                    title = "Card Padding",
                    code = ".card {\n  padding: 24px;\n  background: #1e293b;\n}"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("padding: 12px 24px;", "12px breathing room on top/bottom, 24px on left/right sides."),
                LineExplanation("padding-left: 16px;", "Targets only the left inner spacing.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; padding: 16px; background: #1e293b; border-radius: 12px; display: flex; gap: 12px; align-items: center;">
                  <button style="background: #ef4444; color: white; border: none; padding: 2px; border-radius: 4px; font-size: 13px;">
                    No Padding ❌
                  </button>
                  <button style="background: #10b981; color: white; border: none; padding: 12px 20px; border-radius: 8px; font-size: 14px; font-weight: bold; cursor: pointer;">
                    Generous Padding (12px 20px) ✅
                  </button>
                </div>
            """.trimIndent(),
            notes = "Always remember: Margin is OUTSIDE the border, Padding is INSIDE the border."
        ),

        Lesson(
            id = "css_12",
            courseType = CourseType.CSS,
            lessonNumber = 12,
            title = "Box model",
            explanation = "Every HTML element is considered a rectangular box in CSS. The CSS Box Model consists of 4 layers from inside out: Content, Padding, Border, and Margin. Understanding the Box Model is essential for accurate layouts.",
            importantPoints = listOf(
                "1. Content: where text and images appear.",
                "2. Padding: clear space around content, inside the border.",
                "3. Border: line enclosing the padding and content.",
                "4. Margin: clear space outside the border separating elements.",
                "box-sizing: border-box includes padding and border inside the declared width."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Universal Box-Sizing Reset",
                    code = "*, *::before, *::after {\n  box-sizing: border-box;\n}"
                ),
                CodeExample(
                    title = "Box Model in Action",
                    code = ".box {\n  width: 200px;\n  padding: 20px;\n  border: 4px solid #38bdf8;\n  margin: 20px;\n}"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("box-sizing: border-box;", "Tells the browser: width = content + padding + border."),
                LineExplanation("Content -> Padding -> Border -> Margin", "The four concentric rectangles forming every web component.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; background: #0f172a; padding: 16px; border-radius: 12px; text-align: center;">
                  <div style="background: rgba(255, 107, 53, 0.2); border: 2px dashed #ff6b35; padding: 12px; border-radius: 8px;">
                    <span style="color: #ff6b35; font-size: 12px; font-weight: bold;">MARGIN (Outer)</span>
                    <div style="background: rgba(0, 210, 255, 0.2); border: 2px solid #00d2ff; padding: 12px; margin: 8px 0; border-radius: 6px;">
                      <span style="color: #00d2ff; font-size: 12px; font-weight: bold;">BORDER & PADDING</span>
                      <div style="background: #10b981; color: white; padding: 8px; border-radius: 4px; font-weight: bold; margin-top: 6px;">
                        CONTENT
                      </div>
                    </div>
                  </div>
                </div>
            """.trimIndent(),
            notes = "Always set 'box-sizing: border-box' at the start of your CSS to avoid calculation headaches!"
        ),

        Lesson(
            id = "css_13",
            courseType = CourseType.CSS,
            lessonNumber = 13,
            title = "Display",
            explanation = "The display property defines how an element is rendered in document flow. Common display values include block, inline, inline-block, flex, grid, and none (hides element completely).",
            importantPoints = listOf(
                "block takes 100% width and starts on a new line (e.g. <div>, <p>).",
                "inline takes only content width and flows in text (e.g. <span>, <a>).",
                "inline-block allows setting custom width and height while flowing horizontally.",
                "display: none removes the element from display and layout calculation entirely."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Inline-Block Navigation",
                    code = "nav a {\n  display: inline-block;\n  padding: 8px 16px;\n}"
                ),
                CodeExample(
                    title = "Hiding Elements",
                    code = ".hidden {\n  display: none;\n}"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("display: inline-block;", "Allows side-by-side elements to take width, height, and padding."),
                LineExplanation("display: none;", "Completely hides the element and collapses its space.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; padding: 16px; background: #1e293b; border-radius: 12px;">
                  <span style="display: inline-block; background: #00d2ff; color: black; padding: 8px 16px; border-radius: 6px; font-weight: bold; margin-right: 8px;">Inline-Block 1</span>
                  <span style="display: inline-block; background: #ff6b35; color: white; padding: 8px 16px; border-radius: 6px; font-weight: bold;">Inline-Block 2</span>
                  <p style="color: #94a3b8; font-size: 13px; margin: 10px 0 0;">Notice how both badges sit side-by-side on the same line!</p>
                </div>
            """.trimIndent(),
            notes = "Unlike display: none, 'visibility: hidden' hides the element visually but preserves its empty space in the layout."
        ),

        Lesson(
            id = "css_14",
            courseType = CourseType.CSS,
            lessonNumber = 14,
            title = "Position",
            explanation = "The position property specifies how an element is positioned on the page: static (default), relative (offset from normal position), absolute (positioned relative to nearest positioned ancestor), fixed (locked to screen viewport), or sticky.",
            importantPoints = listOf(
                "relative allows nudging using top, right, bottom, left while retaining its original space.",
                "absolute removes element from normal flow and places it relative to its parent.",
                "fixed sticks an element to the screen even when the user scrolls.",
                "sticky behaves normally until a scroll threshold is met, then locks in place."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Relative Parent with Absolute Badge",
                    code = ".card {\n  position: relative;\n}\n.badge {\n  position: absolute;\n  top: 10px;\n  right: 10px;\n}"
                ),
                CodeExample(
                    title = "Sticky Header",
                    code = ".navbar {\n  position: sticky;\n  top: 0;\n  z-index: 100;\n}"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("position: relative;", "Establishes a coordinate anchor for absolute children."),
                LineExplanation("position: absolute; top: 10px;", "Pins element precisely 10px from top inside container."),
                LineExplanation("z-index: 10;", "Controls 3D layering order (higher sits on top).")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; position: relative; padding: 24px 16px 16px; background: #0f172a; border-radius: 12px; border: 1px solid #334155;">
                  <span style="position: absolute; top: -10px; right: 14px; background: #ff6b35; color: white; font-size: 11px; font-weight: bold; padding: 4px 10px; border-radius: 20px; box-shadow: 0 4px 10px rgba(255,107,53,0.4);">
                    NEW FEATURE
                  </span>
                  <h3 style="color: #f8fafc; margin: 0 0 6px;">Card with Absolute Badge</h3>
                  <p style="color: #94a3b8; font-size: 13px; margin: 0;">Position: relative on card, position: absolute on badge!</p>
                </div>
            """.trimIndent(),
            notes = "Always remember to set position: relative on the container when using position: absolute on a child!"
        ),

        Lesson(
            id = "css_15",
            courseType = CourseType.CSS,
            lessonNumber = 15,
            title = "Flexbox",
            explanation = "Flexbox (Flexible Box Layout) is the premier 1-dimensional CSS layout model. Setting display: flex aligns child items in rows or columns, distributes space evenly, and makes vertical centering effortless.",
            importantPoints = listOf(
                "display: flex turns a container into a flex parent.",
                "justify-content aligns items along the main axis (center, space-between, space-around).",
                "align-items aligns items along the cross axis (center, stretch, flex-start).",
                "gap adds space between flex items without tricky margin hacks."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Perfect Centering",
                    code = ".center-container {\n  display: flex;\n  justify-content: center;\n  align-items: center;\n  min-height: 200px;\n}"
                ),
                CodeExample(
                    title = "Flex Row with Gap",
                    code = ".nav-row {\n  display: flex;\n  gap: 16px;\n  align-items: center;\n}"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("display: flex;", "Activates flexbox layout for all direct children."),
                LineExplanation("justify-content: space-between;", "Pushes items to opposite sides with equal middle space."),
                LineExplanation("gap: 12px;", "Uniform 12px spacing between all items.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; display: flex; justify-content: space-between; align-items: center; background: #1e293b; padding: 14px 18px; border-radius: 12px;">
                  <div style="font-weight: bold; color: #00d2ff; font-size: 16px;">Logo</div>
                  <div style="display: flex; gap: 10px;">
                    <button style="background: #334155; color: white; border: none; padding: 6px 12px; border-radius: 6px; font-size: 13px;">Login</button>
                    <button style="background: #00d2ff; color: black; border: none; padding: 6px 12px; border-radius: 6px; font-weight: bold; font-size: 13px;">Sign Up</button>
                  </div>
                </div>
            """.trimIndent(),
            notes = "Flexbox solved the 20-year-old CSS nightmare of vertically centering a div in just 3 lines of code!"
        ),

        Lesson(
            id = "css_16",
            courseType = CourseType.CSS,
            lessonNumber = 16,
            title = "CSS Grid",
            explanation = "CSS Grid is a 2-dimensional layout system that handles both columns AND rows simultaneously. It allows you to build complex magazine-style website layouts with clean, semantic markup.",
            importantPoints = listOf(
                "display: grid activates grid layout.",
                "grid-template-columns defines column widths (e.g. repeat(3, 1fr)).",
                "The 'fr' (fractional) unit divides available space proportionally.",
                "grid-gap or gap sets the gutter spacing between grid cells."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "3-Column Responsive Grid",
                    code = ".gallery {\n  display: grid;\n  grid-template-columns: repeat(3, 1fr);\n  gap: 16px;\n}"
                ),
                CodeExample(
                    title = "Auto-fit Responsive Grid",
                    code = ".cards {\n  display: grid;\n  grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));\n  gap: 20px;\n}"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("grid-template-columns: repeat(3, 1fr);", "Creates 3 equally wide flexible columns."),
                LineExplanation("gap: 12px;", "Sets spacing between both columns and rows.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; display: grid; grid-template-columns: repeat(3, 1fr); gap: 10px; padding: 14px; background: #0f172a; border-radius: 12px;">
                  <div style="background: #1e293b; padding: 16px 8px; border-radius: 8px; text-align: center; color: #ff6b35; font-weight: bold; font-size: 13px;">Col 1</div>
                  <div style="background: #1e293b; padding: 16px 8px; border-radius: 8px; text-align: center; color: #00d2ff; font-weight: bold; font-size: 13px;">Col 2</div>
                  <div style="background: #1e293b; padding: 16px 8px; border-radius: 8px; text-align: center; color: #facc15; font-weight: bold; font-size: 13px;">Col 3</div>
                </div>
            """.trimIndent(),
            notes = "Use Flexbox for 1D layouts (single rows or navigation bars) and CSS Grid for 2D whole-page structures."
        ),

        Lesson(
            id = "css_17",
            courseType = CourseType.CSS,
            lessonNumber = 17,
            title = "Buttons",
            explanation = "Modern buttons demand visual polish: smooth hover states, active click feedback, crisp shadows, and responsive sizing. Pseudo-classes like :hover and :active let you create interactive button transitions.",
            importantPoints = listOf(
                ":hover applies styling when mouse or pointer hovers over button.",
                ":active applies styling when the button is actively pressed down.",
                "transition: all 0.2s ease makes state changes smooth instead of sudden.",
                "cursor: pointer gives visual clue that an element is clickable."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Modern Glowing Button",
                    code = ".glow-btn {\n  background: #00d2ff;\n  color: #000;\n  padding: 12px 24px;\n  border: none;\n  border-radius: 8px;\n  cursor: pointer;\n  transition: 0.3s;\n}\n.glow-btn:hover {\n  box-shadow: 0 0 15px #00d2ff;\n  transform: translateY(-2px);\n}"
                ),
                CodeExample(
                    title = "Button Active Press Effect",
                    code = ".glow-btn:active {\n  transform: scale(0.96);\n}"
                )
            ),
            lineExplanations = listOf(
                LineExplanation(":hover", "Triggered when cursor hovers over element."),
                LineExplanation("transition: 0.3s ease;", "Interpolates property changes smoothly over 300 milliseconds."),
                LineExplanation("transform: translateY(-2px);", "Lifts the button slightly upward.")
            ),
            defaultRunnableCode = """
                <style>
                  .btn-magic {
                    background: linear-gradient(90deg, #ff6b35, #facc15);
                    color: #000;
                    font-weight: bold;
                    border: none;
                    padding: 12px 28px;
                    border-radius: 25px;
                    cursor: pointer;
                    font-size: 15px;
                    transition: transform 0.2s, box-shadow 0.2s;
                    box-shadow: 0 4px 14px rgba(255, 107, 53, 0.4);
                  }
                  .btn-magic:hover {
                    transform: scale(1.05);
                    box-shadow: 0 6px 20px rgba(255, 107, 53, 0.6);
                  }
                </style>
                <div style="font-family: sans-serif; padding: 24px; background: #111827; border-radius: 12px; text-align: center;">
                  <button class="btn-magic">Hover & Click Me!</button>
                </div>
            """.trimIndent(),
            notes = "Always include a visible :focus style on buttons so keyboard-only users can navigate with Tab."
        ),

        Lesson(
            id = "css_18",
            courseType = CourseType.CSS,
            lessonNumber = 18,
            title = "Images",
            explanation = "CSS ensures images scale responsively across all phone and desktop sizes without distortion. Properties like max-width: 100%, object-fit: cover, and filter let you crop, scale, and adjust graphics effortlessly.",
            importantPoints = listOf(
                "img { max-width: 100%; height: auto; } prevents images from overflowing screens.",
                "object-fit: cover fills a set container while preserving aspect ratio.",
                "filter: grayscale(100%) or blur(4px) applies instant visual effects.",
                "box-shadow adds realistic depth underneath photos."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Responsive Image Reset",
                    code = "img {\n  max-width: 100%;\n  height: auto;\n  display: block;\n}"
                ),
                CodeExample(
                    title = "Object-Fit Cover with Filters",
                    code = ".photo {\n  width: 200px;\n  height: 200px;\n  object-fit: cover;\n  border-radius: 12px;\n  filter: contrast(110%);\n}"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("max-width: 100%;", "Prevents image from ever exceeding parent boundaries."),
                LineExplanation("object-fit: cover;", "Clips image neatly like background-size: cover."),
                LineExplanation("filter: grayscale(...);", "Applies dynamic image processing in real time.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; padding: 16px; background: #0f172a; border-radius: 12px; text-align: center;">
                  <img src="https://images.unsplash.com/photo-1555066931-4365d14bab8c?w=400" alt="Code Editor" style="width: 100%; max-width: 280px; height: 160px; object-fit: cover; border-radius: 10px; border: 2px solid #00d2ff; box-shadow: 0 4px 16px rgba(0,210,255,0.25);">
                  <p style="font-size: 13px; color: #94a3b8; margin: 8px 0 0;">object-fit: cover + neon border</p>
                </div>
            """.trimIndent(),
            notes = "Using object-fit is the cleanest way to create uniform photo grids when user uploads have different aspect ratios."
        ),

        Lesson(
            id = "css_19",
            courseType = CourseType.CSS,
            lessonNumber = 19,
            title = "CSS animations",
            explanation = "CSS animations bring websites alive without needing JavaScript. Using @keyframes and the animation property, you can create smooth breathing pulses, rotating spinners, and subtle fade-in reveals.",
            importantPoints = listOf(
                "@keyframes defines the stages of the animation (0% to 100% or from / to).",
                "animation-duration specifies how long one cycle lasts (e.g. 2s).",
                "animation-iteration-count: infinite repeats forever.",
                "animation-timing-function: ease-in-out makes movement organic and natural."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Pulse Keyframe Animation",
                    code = "@keyframes pulse {\n  0% { transform: scale(1); }\n  50% { transform: scale(1.1); }\n  100% { transform: scale(1); }\n}\n.heart {\n  animation: pulse 1.5s infinite;\n}"
                ),
                CodeExample(
                    title = "Rotation Spinner",
                    code = "@keyframes spin {\n  to { transform: rotate(360deg); }\n}\n.spinner {\n  animation: spin 1s linear infinite;\n}"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("@keyframes pulse { ... }", "Defines the custom animation sequence and transform states."),
                LineExplanation("animation: pulse 1.5s infinite;", "Applies keyframe 'pulse', duration 1.5s, repeats continuously.")
            ),
            defaultRunnableCode = """
                <style>
                  @keyframes neon-glow {
                    0% { box-shadow: 0 0 5px #00d2ff; }
                    50% { box-shadow: 0 0 25px #00d2ff, 0 0 45px #38bdf8; }
                    100% { box-shadow: 0 0 5px #00d2ff; }
                  }
                  .pulsing-box {
                    width: 90px;
                    height: 90px;
                    background: #111827;
                    border: 2px solid #00d2ff;
                    border-radius: 50%;
                    display: flex;
                    align-items: center;
                    justify-content: center;
                    margin: 0 auto;
                    color: #00d2ff;
                    font-weight: bold;
                    animation: neon-glow 2s infinite ease-in-out;
                  }
                </style>
                <div style="font-family: sans-serif; padding: 24px; background: #070b12; border-radius: 12px; text-align: center;">
                  <div class="pulsing-box">CSS</div>
                  <p style="color: #94a3b8; font-size: 13px; margin: 12px 0 0;">Smooth @keyframes Neon Glow</p>
                </div>
            """.trimIndent(),
            notes = "Always use CSS animations for visual styling rather than JS setInterval loops—CSS runs on the GPU with 60fps smoothness!"
        ),

        Lesson(
            id = "css_20",
            courseType = CourseType.CSS,
            lessonNumber = 20,
            title = "Beginner CSS project",
            explanation = "Congratulations on finishing CSS! In this milestone project, you build a modern dark-mode Pricing / Product Feature Card incorporating gradients, flexbox alignment, badges, rounded borders, and glowing hover states.",
            importantPoints = listOf(
                "Integrates Flexbox, custom typography, and CSS borders.",
                "Includes gradient hero header and feature list.",
                "Demonstrates hover micro-interactions and call-to-action button.",
                "Fully prepared to connect with JavaScript logic in Course 3!"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Modern Pricing Card",
                    code = ".card {\n  background: #1e293b;\n  border-radius: 16px;\n  padding: 24px;\n  border: 1px solid #334155;\n  transition: transform 0.2s;\n}\n.card:hover {\n  transform: translateY(-4px);\n}"
                ),
                CodeExample(
                    title = "Accent CTA Button",
                    code = ".cta {\n  width: 100%;\n  background: #00d2ff;\n  color: #000;\n  padding: 12px;\n  font-weight: bold;\n  border-radius: 8px;\n}"
                )
            ),
            lineExplanations = listOf(
                LineExplanation(".card { ... }", "Main container with rounded corners and subtle border."),
                LineExplanation(".card:hover", "Lifts the card upward slightly when hovered."),
                LineExplanation(".cta { ... }", "Full-width call to action button.")
            ),
            defaultRunnableCode = """
                <style>
                  .pro-card {
                    font-family: sans-serif;
                    background: #111827;
                    border: 1px solid #334155;
                    border-radius: 16px;
                    padding: 20px;
                    color: #f8fafc;
                    box-shadow: 0 10px 30px rgba(0,0,0,0.5);
                    position: relative;
                  }
                  .badge-pro {
                    position: absolute;
                    top: 14px;
                    right: 14px;
                    background: #00d2ff;
                    color: black;
                    font-size: 11px;
                    font-weight: bold;
                    padding: 3px 8px;
                    border-radius: 10px;
                  }
                  .feature-item {
                    display: flex;
                    align-items: center;
                    gap: 8px;
                    color: #cbd5e1;
                    font-size: 13px;
                    margin-bottom: 8px;
                  }
                </style>
                <div class="pro-card">
                  <span class="badge-pro">POPULAR</span>
                  <h3 style="margin: 0; color: #f8fafc;">Developer Pro</h3>
                  <div style="font-size: 28px; font-weight: bold; color: #00d2ff; margin: 8px 0;">
                    $19 <span style="font-size: 14px; color: #94a3b8; font-weight: normal;">/ month</span>
                  </div>
                  <div class="feature-item">✓ Unlimited Coding Sandboxes</div>
                  <div class="feature-item">✓ HTML, CSS & JavaScript Bundles</div>
                  <div class="feature-item">✓ 24/7 Certificate Verification</div>
                  <button onclick="alert('Congratulations! CSS Course Completed!')" style="width: 100%; background: #00d2ff; color: #000; border: none; padding: 12px; border-radius: 8px; font-weight: bold; cursor: pointer; margin-top: 10px;">
                    Get Started 🚀
                  </button>
                </div>
            """.trimIndent(),
            notes = "You have mastered CSS styling! Next, learn JavaScript to make your designs interactive and dynamic."
        )
    )
}
