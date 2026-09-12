package com.example.data

import com.example.model.CodeExample
import com.example.model.CourseType
import com.example.model.Lesson
import com.example.model.LineExplanation

object JsLessons {
    val lessons: List<Lesson> = listOf(
        Lesson(
            id = "js_1",
            courseType = CourseType.JAVASCRIPT,
            lessonNumber = 1,
            title = "What is JavaScript?",
            explanation = "JavaScript (JS) is the programming language of the Web. While HTML provides the structure and CSS adds styling, JavaScript provides the brain and muscles: it enables interactivity, dynamic data handling, user input validation, and animations.",
            importantPoints = listOf(
                "JavaScript is executed directly by the browser on the client side.",
                "It can update and change both HTML content and CSS styles on the fly.",
                "console.log() prints messages to the browser developer console.",
                "JavaScript is completely different from the Java programming language."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Console Greeting",
                    code = "console.log('Hello, CodeLearn developer!');\nalert('Welcome to JavaScript!');"
                ),
                CodeExample(
                    title = "Interactive Document Write",
                    code = "document.write('JavaScript wrote this text!');"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("console.log('...');", "Outputs diagnostic text to browser developer tools."),
                LineExplanation("alert('...');", "Pops up a native browser modal alert dialog.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; padding: 20px; background: #111827; border-radius: 12px; text-align: center; color: white;">
                  <h2 style="color: #ffd600; margin-top: 0;">JavaScript in Action ⚡</h2>
                  <p id="js-demo" style="color: #94a3b8;">Click the button to test JavaScript execution.</p>
                  <button onclick="document.getElementById('js-demo').innerHTML = '🔥 JavaScript successfully modified this text!';" style="background: #ffd600; color: black; border: none; padding: 10px 20px; border-radius: 8px; font-weight: bold; cursor: pointer;">
                    Run JS Magic
                  </button>
                </div>
            """.trimIndent(),
            notes = "Open Developer Tools in any browser with F12 or Right Click > Inspect to view your JavaScript console messages."
        ),

        Lesson(
            id = "js_2",
            courseType = CourseType.JAVASCRIPT,
            lessonNumber = 2,
            title = "Adding JavaScript to HTML",
            explanation = "You can add JavaScript into HTML using the <script> tag. It can be placed inline inside HTML, or linked as an external file using <script src=\"app.js\"></script>. Placing scripts before </body> ensures the HTML elements load before scripts run.",
            importantPoints = listOf(
                "<script> tag holds JavaScript code.",
                "External script: <script src=\"script.js\"></script> keeps code clean and modular.",
                "Place scripts at the bottom of <body> or use the 'defer' attribute in <head>.",
                "Browsers parse HTML from top to bottom."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "External Script with Defer",
                    code = "<head>\n  <script src=\"app.js\" defer></script>\n</head>"
                ),
                CodeExample(
                    title = "Inline <script> in Body",
                    code = "<body>\n  <h1>My Site</h1>\n  <script>\n    console.log('Page ready!');\n  </script>\n</body>"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("<script src=\"...\">", "Loads external JavaScript file from server."),
                LineExplanation("defer", "Delays script execution until the full HTML document is parsed.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; padding: 18px; background: #0f172a; border-radius: 12px; color: #f8fafc;">
                  <h3 style="color: #ffd600; margin-top: 0;">Script Tag Demonstration</h3>
                  <div id="status-box" style="padding: 10px; background: #1e293b; border-radius: 6px; color: #38bdf8;">
                    Loading script...
                  </div>
                  <script>
                    setTimeout(() => {
                      document.getElementById('status-box').innerHTML = '✅ Script executed after DOM ready!';
                    }, 400);
                  </script>
                </div>
            """.trimIndent(),
            notes = "Using the 'defer' attribute prevents JavaScript from blocking page rendering."
        ),

        Lesson(
            id = "js_3",
            courseType = CourseType.JAVASCRIPT,
            lessonNumber = 3,
            title = "Variables",
            explanation = "Variables are containers for storing data values. Modern JavaScript uses 'let' (for values that can change) and 'const' (for constants that never change). Avoid the older 'var' keyword.",
            importantPoints = listOf(
                "const declares a constant value that cannot be reassigned.",
                "let declares a variable that can be updated later.",
                "Always use const by default; switch to let only if you need to reassign.",
                "Variable names are case-sensitive and camelCase by convention (e.g. userName)."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "let vs const",
                    code = "const appName = 'CodeLearn';\nlet userScore = 0;\n\nuserScore = userScore + 10; // score is now 10\nconsole.log(appName, userScore);"
                ),
                CodeExample(
                    title = "Declaring Multiple Variables",
                    code = "const firstName = 'John';\nconst lastName = 'Smith';\nlet age = 21;"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("const appName = '...';", "Declares an immutable constant variable."),
                LineExplanation("let userScore = 0;", "Declares a mutable variable initialized to zero."),
                LineExplanation("userScore = ...;", "Reassigns a new value to the let variable.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; padding: 18px; background: #1e293b; border-radius: 12px; color: white;">
                  <h3 style="color: #ffd600; margin-top: 0;">Variable Counter</h3>
                  <p>Current Score: <strong id="score-text" style="color: #10b981; font-size: 20px;">0</strong></p>
                  <button onclick="incrementScore()" style="background: #ffd600; color: black; border: none; padding: 8px 16px; border-radius: 6px; font-weight: bold; cursor: pointer;">
                    + 10 Points (let score)
                  </button>
                  <script>
                    let score = 0;
                    function incrementScore() {
                      score += 10;
                      document.getElementById('score-text').textContent = score;
                    }
                  </script>
                </div>
            """.trimIndent(),
            notes = "Attempting to reassign a const variable causes a TypeError: Assignment to constant variable."
        ),

        Lesson(
            id = "js_4",
            courseType = CourseType.JAVASCRIPT,
            lessonNumber = 4,
            title = "Data types",
            explanation = "JavaScript is dynamically typed and has primitive data types: String (text), Number (integers and decimals), Boolean (true or false), Null (intentional absence of value), Undefined (declared but unassigned), and Object.",
            importantPoints = listOf(
                "String: 'hello' or \"world\" (text).",
                "Number: 42 or 3.14 (numeric values).",
                "Boolean: true or false (logical flags).",
                "typeof operator tells you the type of any variable."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Primitive Types",
                    code = "const title = 'HTML5';     // String\nconst lessons = 20;         // Number\nconst isComplete = false;   // Boolean\nlet certificate;            // undefined"
                ),
                CodeExample(
                    title = "Checking Types with typeof",
                    code = "console.log(typeof 'hello'); // 'string'\nconsole.log(typeof 100);     // 'number'\nconsole.log(typeof true);    // 'boolean'"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("typeof ...", "Operator returning string name of data type."),
                LineExplanation("isComplete = false;", "Boolean boolean flag representing binary state.")
            ),
            defaultRunnableCode = """
                <div style="font-family: monospace; padding: 16px; background: #0b0f19; border-radius: 10px; color: #f8fafc;">
                  <div style="color: #ffd600; font-weight: bold; margin-bottom: 8px;">// JavaScript Types Output:</div>
                  <div style="color: #60a5fa;">const name = "CodeLearn"; <span style="color: #6b7280;">// string</span></div>
                  <div style="color: #34d399;">const score = 95.5; <span style="color: #6b7280;">// number</span></div>
                  <div style="color: #f87171;">const isGraduated = true; <span style="color: #6b7280;">// boolean</span></div>
                  <div style="color: #c084fc; margin-top: 8px;">typeof score: <span id="type-result">number</span></div>
                </div>
            """.trimIndent(),
            notes = "Notice that JavaScript does not separate integers from floating point decimals—all numbers are just 'Number'."
        ),

        Lesson(
            id = "js_5",
            courseType = CourseType.JAVASCRIPT,
            lessonNumber = 5,
            title = "Operators",
            explanation = "Operators perform operations on variables and values: Arithmetic (+, -, *, /, %, **), Assignment (=, +=, -=), Comparison (===, !==, >, <), and Logical (&&, ||, !).",
            importantPoints = listOf(
                "+ adds numbers or concatenates strings.",
                "% is the modulo operator (returns division remainder).",
                "=== checks strict equality (both value AND type match).",
                "Always prefer === over == to avoid bizarre type coercion bugs."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Arithmetic and Modulo",
                    code = "const sum = 10 + 5;   // 15\nconst product = 4 * 3; // 12\nconst remainder = 10 % 3; // 1"
                ),
                CodeExample(
                    title = "Strict Equality vs Loose",
                    code = "5 === 5;   // true\n5 === '5'; // false (number vs string!)\n5 == '5';  // true (loose check, avoid!)"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("10 % 3", "Modulo operator calculates 10 divided by 3 has remainder 1."),
                LineExplanation("5 === '5'", "Strict triple-equals compares type and value; returns false.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; padding: 16px; background: #1e293b; border-radius: 12px; color: white;">
                  <h3 style="color: #ffd600; margin-top: 0;">Math Calculator</h3>
                  <div id="calc-output" style="background: #0f172a; padding: 12px; border-radius: 6px; font-family: monospace; color: #38bdf8;">
                    10 + 5 * 2 = 20
                  </div>
                  <button onclick="document.getElementById('calc-output').innerHTML = 'Remainder of 17 % 5 is: ' + (17 % 5);" style="margin-top: 10px; background: #ffd600; color: black; border: none; padding: 8px 16px; border-radius: 6px; font-weight: bold; cursor: pointer;">
                    Compute Modulo (17 % 5)
                  </button>
                </div>
            """.trimIndent(),
            notes = "In JavaScript, 10 + '5' equals '105' (string), but 10 - '5' equals 5 (number). That's why === is your best friend!"
        ),

        Lesson(
            id = "js_6",
            courseType = CourseType.JAVASCRIPT,
            lessonNumber = 6,
            title = "Strings",
            explanation = "Strings hold textual data. You can define strings using single quotes ('...'), double quotes (\"...\"), or modern template literals (`...`). Template literals allow multiline strings and variable interpolation using \${variable}.",
            importantPoints = listOf(
                "Backticks `...` define template literals.",
                "\${variable} inserts variables directly into a string.",
                "str.length returns the number of characters in the string.",
                "Methods like toUpperCase(), toLowerCase(), and includes() make text manipulation easy."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Template Literals Interpolation",
                    code = "const user = 'Alex';\nconst track = 'JavaScript';\nconst message = `Hello \${user}, welcome to \${track}!`;\nconsole.log(message);"
                ),
                CodeExample(
                    title = "Useful String Methods",
                    code = "const text = 'Web Development';\nconsole.log(text.length); // 15\nconsole.log(text.toUpperCase()); // 'WEB DEVELOPMENT'"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("`Hello \${user}`", "Template literal injecting the value of user into string."),
                LineExplanation("text.toUpperCase()", "Transforms all lowercase letters into uppercase."),
                LineExplanation("text.length", "Property returning character count.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; padding: 16px; background: #111827; border-radius: 12px; color: white;">
                  <h3 style="color: #38bdf8; margin-top: 0;">String Transformer</h3>
                  <input id="input-str" value="Learn to code" style="padding: 8px; border-radius: 6px; border: 1px solid #334155; background: #1e293b; color: white; width: 80%;">
                  <div style="margin-top: 10px;">
                    <button onclick="const s = document.getElementById('input-str').value; document.getElementById('str-preview').textContent = s.toUpperCase() + ' (' + s.length + ' chars)';" style="background: #ffd600; color: black; border: none; padding: 8px 14px; border-radius: 6px; font-weight: bold; cursor: pointer;">
                      Transform
                    </button>
                  </div>
                  <p id="str-preview" style="color: #10b981; font-family: monospace; margin-top: 10px; font-size: 15px;">
                    LEARN TO CODE (13 chars)
                  </p>
                </div>
            """.trimIndent(),
            notes = "Template literals work across multiple lines without needing \\n escape characters."
        ),

        Lesson(
            id = "js_7",
            courseType = CourseType.JAVASCRIPT,
            lessonNumber = 7,
            title = "Numbers",
            explanation = "JavaScript numbers can be written with or without decimals, and scientific exponential notation. The built-in Math object provides powerful mathematical functions like Math.round(), Math.floor(), Math.random(), and Math.max().",
            importantPoints = listOf(
                "Math.random() generates a pseudo-random decimal between 0 and 1.",
                "Math.floor(x) rounds down to nearest integer.",
                "Number('42') converts a text string into an actual number.",
                "NaN stands for 'Not a Number' (occurs when math fails on invalid input)."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Random Number Generator (1 to 6)",
                    code = "const diceRoll = Math.floor(Math.random() * 6) + 1;\nconsole.log('Dice rolled:', diceRoll);"
                ),
                CodeExample(
                    title = "Parsing Numbers from Inputs",
                    code = "const priceStr = '19.99';\nconst price = parseFloat(priceStr);\nconst total = price * 1.1; // adding 10% tax"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("Math.random() * 6", "Generates decimal between 0.0 and 5.999..."),
                LineExplanation("Math.floor(...)", "Rounds downward to integer 0, 1, 2, 3, 4, or 5."),
                LineExplanation("parseFloat('19.99')", "Parses float value from text string.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; padding: 18px; background: #0f172a; border-radius: 12px; text-align: center; color: white;">
                  <h3 style="color: #ffd600; margin-top: 0;">Dice Roll Simulator 🎲</h3>
                  <div id="dice-display" style="font-size: 40px; font-weight: bold; color: #00d2ff; margin: 10px 0;">4</div>
                  <button onclick="document.getElementById('dice-display').textContent = Math.floor(Math.random() * 6) + 1;" style="background: #ff6b35; color: white; border: none; padding: 10px 22px; border-radius: 8px; font-weight: bold; cursor: pointer;">
                    Roll Dice!
                  </button>
                </div>
            """.trimIndent(),
            notes = "To format numbers as currency with 2 decimal places, use num.toFixed(2)."
        ),

        Lesson(
            id = "js_8",
            courseType = CourseType.JAVASCRIPT,
            lessonNumber = 8,
            title = "Arrays",
            explanation = "An array is an ordered collection of items. In JavaScript, arrays can hold any mix of data types. Arrays are zero-indexed, meaning the first element is at index 0.",
            importantPoints = listOf(
                "Arrays use square brackets: const fruits = ['Apple', 'Banana'];",
                "Zero-indexed: fruits[0] is 'Apple'.",
                "push() adds an element to the end; pop() removes the last element.",
                "arr.length returns total count of elements."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Creating & Accessing Arrays",
                    code = "const languages = ['HTML', 'CSS', 'JavaScript'];\nconsole.log(languages[0]); // 'HTML'\nconsole.log(languages.length); // 3"
                ),
                CodeExample(
                    title = "Modifying Arrays",
                    code = "const stack = ['HTML'];\nstack.push('CSS'); // ['HTML', 'CSS']\nstack.push('JS');  // ['HTML', 'CSS', 'JS']"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("const languages = [...]", "Initializes array containing 3 string items."),
                LineExplanation("languages[0]", "Accesses the first item using index zero."),
                LineExplanation("stack.push('JS')", "Appends 'JS' to the end of the array.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; padding: 18px; background: #1e293b; border-radius: 12px; color: white;">
                  <h3 style="color: #ffd600; margin-top: 0;">Dynamic Tech Stack (Array)</h3>
                  <div id="array-items" style="color: #38bdf8; font-family: monospace; font-size: 15px; margin-bottom: 12px;">['HTML', 'CSS']</div>
                  <button onclick="addTech()" style="background: #10b981; color: white; border: none; padding: 8px 16px; border-radius: 6px; font-weight: bold; cursor: pointer;">
                    push('JavaScript')
                  </button>
                  <script>
                    const tech = ['HTML', 'CSS'];
                    function addTech() {
                      if (!tech.includes('JavaScript')) tech.push('JavaScript');
                      document.getElementById('array-items').textContent = JSON.stringify(tech);
                    }
                  </script>
                </div>
            """.trimIndent(),
            notes = "Modern JavaScript also offers high-performance array methods like .map(), .filter(), and .reduce()."
        ),

        Lesson(
            id = "js_9",
            courseType = CourseType.JAVASCRIPT,
            lessonNumber = 9,
            title = "Objects",
            explanation = "Objects store data in key-value pairs (properties). They represent real-world entities like a user, a product, or a lesson. Access values with dot notation (user.name) or bracket notation (user['name']).",
            importantPoints = listOf(
                "Created with curly braces: const course = { name: 'HTML', lessons: 20 };",
                "Properties can hold strings, numbers, booleans, arrays, or other objects.",
                "Methods are functions stored inside objects.",
                "Dot notation user.email is standard for property access."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "User Profile Object",
                    code = "const coder = {\n  username: 'SarahDev',\n  rank: 'Master',\n  lessonsCompleted: 18,\n  isActive: true\n};\nconsole.log(coder.username);"
                ),
                CodeExample(
                    title = "Object with a Method",
                    code = "const car = {\n  brand: 'Tesla',\n  start: function() {\n    return 'Engine started silently!';\n  }\n};"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("const coder = { ... }", "Declares an object literal with key-value properties."),
                LineExplanation("coder.username", "Dot notation retrieves the 'username' value.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; padding: 18px; background: #111827; border-radius: 12px; color: white;">
                  <h3 style="color: #ffd600; margin-top: 0;">User Object</h3>
                  <div style="background: #1e293b; padding: 12px; border-radius: 8px;">
                    <p style="margin: 4px 0; color: #f8fafc;">Name: <span style="color: #38bdf8;">Alex Turner</span></p>
                    <p style="margin: 4px 0; color: #f8fafc;">Role: <span style="color: #ff6b35;">Frontend Engineer</span></p>
                    <p style="margin: 4px 0; color: #f8fafc;">Level: <span style="color: #10b981;">Level 5 Coder</span></p>
                  </div>
                </div>
            """.trimIndent(),
            notes = "JSON (JavaScript Object Notation) is based directly on JavaScript object syntax and is the universal data format for web APIs."
        ),

        Lesson(
            id = "js_10",
            courseType = CourseType.JAVASCRIPT,
            lessonNumber = 10,
            title = "Functions",
            explanation = "A function is a reusable block of code designed to perform a specific task. You define it once, and can invoke (call) it anywhere with arguments, and return calculated results.",
            importantPoints = listOf(
                "Declared using the function keyword or arrow function syntax: () => {}",
                "Parameters are inputs passed into the function; arguments are the actual values.",
                "The return keyword sends a computed value back to where it was called.",
                "Arrow functions offer concise syntax: const add = (a, b) => a + b;"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Standard Function",
                    code = "function greetUser(name) {\n  return 'Hello, ' + name + '!';\n}\nconst greeting = greetUser('Alex');"
                ),
                CodeExample(
                    title = "Arrow Function",
                    code = "const calculateArea = (width, height) => {\n  return width * height;\n};\nconsole.log(calculateArea(5, 4)); // 20"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("function greetUser(name)", "Defines function named greetUser accepting 'name' parameter."),
                LineExplanation("return ...", "Outputs the final result and exits the function."),
                LineExplanation("greetUser('Alex')", "Executes the function with argument 'Alex'.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; padding: 18px; background: #0f172a; border-radius: 12px; color: white;">
                  <h3 style="color: #ffd600; margin-top: 0;">Function Execution</h3>
                  <p id="fn-result" style="color: #38bdf8; font-size: 16px;">Result: 0</p>
                  <button onclick="multiplyNumbers(7, 8)" style="background: #00d2ff; color: black; border: none; padding: 8px 18px; border-radius: 6px; font-weight: bold; cursor: pointer;">
                    Call multiplyNumbers(7, 8)
                  </button>
                  <script>
                    function multiplyNumbers(a, b) {
                      const res = a * b;
                      document.getElementById('fn-result').textContent = 'Result of ' + a + ' × ' + b + ' = ' + res;
                    }
                  </script>
                </div>
            """.trimIndent(),
            notes = "Arrow functions do not bind their own 'this', making them popular for event listeners and timers."
        ),

        Lesson(
            id = "js_11",
            courseType = CourseType.JAVASCRIPT,
            lessonNumber = 11,
            title = "If and Else",
            explanation = "Conditional statements (if, else if, else) control decision-making logic. They allow code to execute different actions based on whether conditions evaluate to true or false.",
            importantPoints = listOf(
                "if (condition) { ... } runs code only when condition is true.",
                "else if provides additional conditions to test.",
                "else runs when none of the above conditions were met.",
                "Ternary operator offers one-line conditions: condition ? valueIfTrue : valueIfFalse."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Grade Calculator Condition",
                    code = "const score = 85;\nif (score >= 90) {\n  console.log('Grade: A');\n} else if (score >= 80) {\n  console.log('Grade: B');\n} else {\n  console.log('Grade: C');\n}"
                ),
                CodeExample(
                    title = "Ternary Operator",
                    code = "const age = 20;\nconst canDrive = age >= 18 ? 'Yes' : 'No';"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("if (score >= 90)", "Evaluates if score is at least 90."),
                LineExplanation("else if ...", "Alternative condition checked if first was false."),
                LineExplanation("else { ... }", "Catch-all fallback branch.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; padding: 18px; background: #1e293b; border-radius: 12px; color: white;">
                  <h3 style="color: #ffd600; margin-top: 0;">Pass / Fail Checker</h3>
                  <input id="score-input" type="number" value="75" placeholder="Enter score" style="padding: 8px; border-radius: 6px; border: 1px solid #475569; background: #0f172a; color: white; width: 100px;">
                  <button onclick="checkPass()" style="background: #ffd600; color: black; border: none; padding: 8px 14px; border-radius: 6px; font-weight: bold; cursor: pointer; margin-left: 8px;">Check</button>
                  <p id="grade-badge" style="margin-top: 10px; font-weight: bold; color: #10b981;">PASSED (Score: 75)</p>
                  <script>
                    function checkPass() {
                      const val = parseInt(document.getElementById('score-input').value);
                      const el = document.getElementById('grade-badge');
                      if (val >= 60) {
                        el.textContent = 'PASSED (Score: ' + val + ') 🎉';
                        el.style.color = '#10b981';
                      } else {
                        el.textContent = 'NEEDS WORK (Score: ' + val + ') ✍️';
                        el.style.color = '#ef4444';
                      }
                    }
                  </script>
                </div>
            """.trimIndent(),
            notes = "In JavaScript, values like 0, '', null, undefined, and NaN are considered 'falsy' in if conditions."
        ),

        Lesson(
            id = "js_12",
            courseType = CourseType.JAVASCRIPT,
            lessonNumber = 12,
            title = "Loops",
            explanation = "Loops repeat a block of code multiple times until a condition is met. The most common loops are the 'for' loop, the 'while' loop, and modern array iterators like for...of.",
            importantPoints = listOf(
                "for (let i = 0; i < 5; i++) runs code exactly 5 times.",
                "while (condition) repeats while the condition remains true.",
                "for...of iterates through arrays with clean syntax.",
                "Remember to increment the counter to avoid an infinite loop that crashes the browser!"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Classic for Loop",
                    code = "for (let i = 1; i <= 5; i++) {\n  console.log('Step number:', i);\n}"
                ),
                CodeExample(
                    title = "for...of Array Loop",
                    code = "const colors = ['red', 'blue', 'green'];\nfor (const color of colors) {\n  console.log('Color:', color);\n}"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("let i = 0;", "Initializes loop counter variable."),
                LineExplanation("i < 5;", "Loop continues running as long as this condition is true."),
                LineExplanation("i++", "Increments counter by 1 after each loop cycle.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; padding: 18px; background: #0b0f19; border-radius: 12px; color: white;">
                  <h3 style="color: #ffd600; margin-top: 0;">for Loop Generator</h3>
                  <button onclick="runLoop()" style="background: #38bdf8; color: black; border: none; padding: 8px 16px; border-radius: 6px; font-weight: bold; cursor: pointer;">Generate 5 Badges</button>
                  <div id="loop-badges" style="margin-top: 12px; display: flex; gap: 8px; flex-wrap: wrap;"></div>
                  <script>
                    function runLoop() {
                      let html = '';
                      for (let i = 1; i <= 5; i++) {
                        html += '<span style=\"background: #ff6b35; color: white; padding: 4px 10px; border-radius: 12px; font-size: 12px;\">Item #' + i + '</span>';
                      }
                      document.getElementById('loop-badges').innerHTML = html;
                    }
                    runLoop();
                  </script>
                </div>
            """.trimIndent(),
            notes = "Array.forEach() is also widely used when you want to execute a callback function for every element."
        ),

        Lesson(
            id = "js_13",
            courseType = CourseType.JAVASCRIPT,
            lessonNumber = 13,
            title = "Events",
            explanation = "Events are things that happen to HTML elements when users interact with the page—such as mouse clicks, keyboard presses, page scrolling, and form inputs. JavaScript listens for events with addEventListener().",
            importantPoints = listOf(
                "addEventListener('click', handlerFunction) registers an event listener.",
                "Common events: click, mouseenter, mouseleave, keydown, change, submit.",
                "addEventListener allows attaching multiple event handlers to the same element.",
                "event.target gives reference to the exact element that triggered the event."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Click Event Listener",
                    code = "const button = document.querySelector('#myBtn');\nbutton.addEventListener('click', () => {\n  console.log('Button was clicked!');\n});"
                ),
                CodeExample(
                    title = "Keyboard Enter Listener",
                    code = "window.addEventListener('keydown', (e) => {\n  if (e.key === 'Enter') {\n    console.log('Enter key pressed!');\n  }\n});"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("addEventListener('click', ...)", "Subscribes to user mouse or tap clicks."),
                LineExplanation("e.key === 'Enter'", "Checks which keyboard key was pressed.")
            ),
            defaultRunnableCode = """
                <div id="interactive-area" style="font-family: sans-serif; padding: 24px; background: #1e293b; border-radius: 12px; text-align: center; border: 2px dashed #475569; transition: background 0.3s; color: white;">
                  <h3 id="event-title" style="margin: 0 0 6px; color: #ffd600;">Hover or Tap Over This Box</h3>
                  <p id="event-desc" style="color: #94a3b8; margin: 0; font-size: 13px;">Event listener waiting...</p>
                  <script>
                    const box = document.getElementById('interactive-area');
                    box.addEventListener('mouseenter', () => {
                      box.style.background = '#0f172a';
                      box.style.borderColor = '#00d2ff';
                      document.getElementById('event-desc').textContent = '🎯 mouseenter event detected!';
                    });
                    box.addEventListener('mouseleave', () => {
                      box.style.background = '#1e293b';
                      box.style.borderColor = '#475569';
                      document.getElementById('event-desc').textContent = '👋 mouseleave event triggered!';
                    });
                  </script>
                </div>
            """.trimIndent(),
            notes = "Always prefer addEventListener() over older HTML inline attributes like onclick=\"...\" for clean code architecture."
        ),

        Lesson(
            id = "js_14",
            courseType = CourseType.JAVASCRIPT,
            lessonNumber = 14,
            title = "Button events",
            explanation = "Buttons are the primary vehicle for user actions on websites. Pairing button clicks with JavaScript functions lets you create toggles, counters, modals, and dynamic shopping carts.",
            importantPoints = listOf(
                "Buttons can be styled with active/pressed states.",
                "You can disable buttons during asynchronous loading states.",
                "Double-click prevention is common when submitting financial transactions.",
                "Buttons can trigger audio playback or CSS animations."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Toggle Light/Dark Theme",
                    code = "btn.addEventListener('click', () => {\n  document.body.classList.toggle('light-mode');\n});"
                ),
                CodeExample(
                    title = "Loading State Button",
                    code = "btn.addEventListener('click', () => {\n  btn.disabled = true;\n  btn.textContent = 'Saving...';\n});"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("classList.toggle('light-mode')", "Adds class if missing; removes it if present."),
                LineExplanation("btn.disabled = true", "Prevents repeat accidental clicks.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; padding: 20px; background: #111827; border-radius: 12px; text-align: center; color: white;">
                  <h3 id="mode-text" style="color: #ffd600; margin-top: 0;">State: Inactive 💤</h3>
                  <button id="state-btn" onclick="toggleActive()" style="background: #00d2ff; color: black; border: none; padding: 10px 20px; border-radius: 8px; font-weight: bold; cursor: pointer; transition: 0.2s;">
                    Activate System
                  </button>
                  <script>
                    let isActive = false;
                    function toggleActive() {
                      isActive = !isActive;
                      const text = document.getElementById('mode-text');
                      const btn = document.getElementById('state-btn');
                      if (isActive) {
                        text.textContent = 'State: Active & Online ⚡';
                        text.style.color = '#10b981';
                        btn.textContent = 'Deactivate';
                        btn.style.background = '#ef4444';
                        btn.style.color = 'white';
                      } else {
                        text.textContent = 'State: Inactive 💤';
                        text.style.color = '#ffd600';
                        btn.textContent = 'Activate System';
                        btn.style.background = '#00d2ff';
                        btn.style.color = 'black';
                      }
                    }
                  </script>
                </div>
            """.trimIndent(),
            notes = "State toggles are the foundational design pattern behind tabs, dark mode switches, and accordion drawers."
        ),

        Lesson(
            id = "js_15",
            courseType = CourseType.JAVASCRIPT,
            lessonNumber = 15,
            title = "Getting input values",
            explanation = "Web applications thrive on user input. In JavaScript, you read values from input fields, checkboxes, and dropdown selects using the '.value' property of the input element.",
            importantPoints = listOf(
                "inputElement.value reads text typed by user.",
                "For checkboxes, use checkboxElement.checked (returns true or false).",
                "Trim whitespace using input.value.trim() before validating.",
                "Listen to 'input' event for real-time live typing updates."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Reading Text Input",
                    code = "const input = document.querySelector('#nameInput');\nconst name = input.value.trim();\nconsole.log('Entered name:', name);"
                ),
                CodeExample(
                    title = "Realtime Input Mirroring",
                    code = "input.addEventListener('input', (e) => {\n  outputHeading.textContent = e.target.value;\n});"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("input.value", "Retrieves currently typed string in input field."),
                LineExplanation(".trim()", "Strips accidental leading/trailing spaces.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; padding: 18px; background: #0f172a; border-radius: 12px; color: white;">
                  <h3 style="color: #ffd600; margin-top: 0;">Live Greeting Generator</h3>
                  <input id="guest-name" type="text" placeholder="Type your name here..." oninput="updateGreeting()" style="padding: 10px; border-radius: 8px; border: 1px solid #334155; background: #1e293b; color: white; width: 85%;">
                  <p style="margin-top: 12px; font-size: 16px; color: #cbd5e1;">
                    Greeting: <strong id="greeting-target" style="color: #00d2ff;">Welcome, Guest!</strong>
                  </p>
                  <script>
                    function updateGreeting() {
                      const val = document.getElementById('guest-name').value.trim();
                      document.getElementById('greeting-target').textContent = val ? 'Welcome, ' + val + '!' : 'Welcome, Guest!';
                    }
                  </script>
                </div>
            """.trimIndent(),
            notes = "Always validate user input on both the client side (JavaScript) and the backend server for security."
        ),

        Lesson(
            id = "js_16",
            courseType = CourseType.JAVASCRIPT,
            lessonNumber = 16,
            title = "DOM basics",
            explanation = "The DOM (Document Object Model) is a tree representation of the webpage created by the browser. JavaScript uses the DOM to find, read, add, and remove HTML elements.",
            importantPoints = listOf(
                "document.getElementById('id') selects element with specific ID.",
                "document.querySelector('.class') selects first element matching CSS selector.",
                "document.querySelectorAll('tag') selects all matching elements.",
                "document.createElement('div') constructs new elements programmatically."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Selecting Elements",
                    code = "const title = document.querySelector('#main-title');\nconst allCards = document.querySelectorAll('.card');"
                ),
                CodeExample(
                    title = "Appending New Child",
                    code = "const newParagraph = document.createElement('p');\nnewParagraph.textContent = 'Created dynamically!';\ndocument.body.appendChild(newParagraph);"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("document.querySelector('#main-title')", "Uses modern CSS selector to locate unique element."),
                LineExplanation("document.createElement('p')", "Creates a new paragraph in memory before attaching to page.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; padding: 18px; background: #1e293b; border-radius: 12px; color: white;">
                  <h3 style="color: #ffd600; margin-top: 0;">DOM Element Spawner</h3>
                  <button onclick="spawnItem()" style="background: #10b981; color: white; border: none; padding: 8px 16px; border-radius: 6px; font-weight: bold; cursor: pointer;">
                    + Add New Item to DOM
                  </button>
                  <ul id="dom-list" style="padding-left: 20px; color: #38bdf8; margin-top: 12px; line-height: 1.6;">
                    <li>Default Item 1</li>
                  </ul>
                  <script>
                    let count = 1;
                    function spawnItem() {
                      count++;
                      const li = document.createElement('li');
                      li.textContent = 'Spawned Item #' + count + ' via createElement()';
                      li.style.color = '#facc15';
                      document.getElementById('dom-list').appendChild(li);
                    }
                  </script>
                </div>
            """.trimIndent(),
            notes = "The DOM connects programming languages to the web page."
        ),

        Lesson(
            id = "js_17",
            courseType = CourseType.JAVASCRIPT,
            lessonNumber = 17,
            title = "Changing HTML",
            explanation = "JavaScript can alter page content in two ways: element.textContent (safely modifies plain text) and element.innerHTML (modifies HTML tags inside the element).",
            importantPoints = listOf(
                "textContent updates plain text only and prevents XSS security attacks.",
                "innerHTML parses tags like <strong> and <span> into real DOM elements.",
                "element.setAttribute('src', 'new.png') updates HTML attributes.",
                "element.remove() removes an element from the page."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "textContent vs innerHTML",
                    code = "box.textContent = 'Plain safe text';\nbox.innerHTML = '<span style=\"color: gold;\">Rich HTML</span>';"
                ),
                CodeExample(
                    title = "Changing Image Source",
                    code = "const img = document.querySelector('#avatar');\nimg.src = 'https://example.com/new-photo.jpg';"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("box.textContent = ...", "Replaces text content without parsing HTML."),
                LineExplanation("box.innerHTML = ...", "Renders new HTML markup dynamically.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; padding: 18px; background: #0f172a; border-radius: 12px; color: white;">
                  <h3 id="target-header" style="color: #38bdf8; margin-top: 0;">Original HTML Header</h3>
                  <div style="display: flex; gap: 8px;">
                    <button onclick="document.getElementById('target-header').textContent = 'Text changed by textContent!';" style="background: #ff6b35; color: white; border: none; padding: 8px 12px; border-radius: 6px; cursor: pointer; font-size: 13px;">Change Text</button>
                    <button onclick="document.getElementById('target-header').innerHTML = '<span>Rich <mark style=\"background: #facc15;\">innerHTML</mark> Tag!</span>';" style="background: #00d2ff; color: black; border: none; padding: 8px 12px; border-radius: 6px; cursor: pointer; font-size: 13px;">Change HTML</button>
                  </div>
                </div>
            """.trimIndent(),
            notes = "Never use innerHTML with untrusted user input to prevent malicious Cross-Site Scripting (XSS) injection!"
        ),

        Lesson(
            id = "js_18",
            courseType = CourseType.JAVASCRIPT,
            lessonNumber = 18,
            title = "Changing CSS with JavaScript",
            explanation = "JavaScript can manipulate CSS styles dynamically using element.style (for inline styles) or by adding and removing CSS classes using element.classList.add(), remove(), and toggle().",
            importantPoints = listOf(
                "element.style.property sets inline CSS (e.g. el.style.backgroundColor = 'red').",
                "CSS properties with hyphens become camelCase in JS (background-color -> backgroundColor).",
                "classList.add('active') is preferred over inline styles for clean architecture.",
                "classList.toggle('dark') easily flips a state on and off."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Modifying Inline Styles",
                    code = "const card = document.querySelector('.card');\ncard.style.backgroundColor = '#0f172a';\ncard.style.borderRadius = '16px';"
                ),
                CodeExample(
                    title = "ClassList Manipulation",
                    code = "button.classList.add('glowing');\nbutton.classList.remove('disabled');\nbutton.classList.toggle('selected');"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("el.style.backgroundColor = '#...'", "Hyphenated CSS names convert to camelCase in JavaScript."),
                LineExplanation("el.classList.toggle('dark')", "Toggles a predefined CSS class.")
            ),
            defaultRunnableCode = """
                <div id="style-canvas" style="font-family: sans-serif; padding: 20px; background: #1e293b; border-radius: 12px; text-align: center; color: white; transition: all 0.3s;">
                  <h4 style="margin: 0 0 10px;">Dynamic Style Canvas</h4>
                  <div style="display: flex; gap: 8px; justify-content: center;">
                    <button onclick="changeColor('#ff6b35')" style="background: #ff6b35; color: white; border: none; padding: 6px 12px; border-radius: 6px; cursor: pointer;">Orange</button>
                    <button onclick="changeColor('#00d2ff')" style="background: #00d2ff; color: black; border: none; padding: 6px 12px; border-radius: 6px; cursor: pointer;">Cyan</button>
                    <button onclick="changeColor('#10b981')" style="background: #10b981; color: white; border: none; padding: 6px 12px; border-radius: 6px; cursor: pointer;">Green</button>
                  </div>
                  <script>
                    function changeColor(c) {
                      document.getElementById('style-canvas').style.borderColor = c;
                      document.getElementById('style-canvas').style.border = '2px solid ' + c;
                      document.getElementById('style-canvas').style.boxShadow = '0 0 15px ' + c;
                    }
                  </script>
                </div>
            """.trimIndent(),
            notes = "Always keep styling definitions in CSS classes, and use JavaScript primarily to add or remove those classes."
        ),

        Lesson(
            id = "js_19",
            courseType = CourseType.JAVASCRIPT,
            lessonNumber = 19,
            title = "Interactive animations",
            explanation = "JavaScript orchestrates interactive animations that react to user gestures, timers (setTimeout, setInterval), and requestAnimationFrame for buttery smooth 60fps movement.",
            importantPoints = listOf(
                "setTimeout(fn, ms) runs code once after a delay.",
                "setInterval(fn, ms) repeats code continuously every X milliseconds.",
                "clearInterval(timerId) stops a running interval.",
                "requestAnimationFrame() synchronizes animations with the browser refresh rate."
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Countdown Timer with setInterval",
                    code = "let seconds = 10;\nconst timer = setInterval(() => {\n  seconds--;\n  console.log('Seconds remaining:', seconds);\n  if (seconds === 0) clearInterval(timer);\n}, 1000);"
                ),
                CodeExample(
                    title = "Delayed Action with setTimeout",
                    code = "setTimeout(() => {\n  notification.style.display = 'none';\n}, 3000);"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("setInterval(..., 1000)", "Runs the callback function every 1000 milliseconds (1 second)."),
                LineExplanation("clearInterval(timer)", "Cancels the active interval loop.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; padding: 20px; background: #0b0f19; border-radius: 12px; text-align: center; color: white;">
                  <h3 style="color: #ffd600; margin-top: 0;">Interactive Stopwatch</h3>
                  <div id="timer-number" style="font-size: 36px; font-weight: bold; color: #00d2ff; font-family: monospace; margin: 10px 0;">0.0s</div>
                  <div style="display: flex; gap: 8px; justify-content: center;">
                    <button onclick="startTimer()" style="background: #10b981; color: white; border: none; padding: 8px 16px; border-radius: 6px; font-weight: bold; cursor: pointer;">Start</button>
                    <button onclick="stopTimer()" style="background: #ef4444; color: white; border: none; padding: 8px 16px; border-radius: 6px; font-weight: bold; cursor: pointer;">Stop</button>
                    <button onclick="resetTimer()" style="background: #64748b; color: white; border: none; padding: 8px 16px; border-radius: 6px; cursor: pointer;">Reset</button>
                  </div>
                  <script>
                    let time = 0;
                    let intervalId = null;
                    function startTimer() {
                      if (!intervalId) {
                        intervalId = setInterval(() => {
                          time += 0.1;
                          document.getElementById('timer-number').textContent = time.toFixed(1) + 's';
                        }, 100);
                      }
                    }
                    function stopTimer() {
                      clearInterval(intervalId);
                      intervalId = null;
                    }
                    function resetTimer() {
                      stopTimer();
                      time = 0;
                      document.getElementById('timer-number').textContent = '0.0s';
                    }
                  </script>
                </div>
            """.trimIndent(),
            notes = "Always store the return value of setInterval in a variable so you can clear it when the component unmounts!"
        ),

        Lesson(
            id = "js_20",
            courseType = CourseType.JAVASCRIPT,
            lessonNumber = 20,
            title = "Beginner JavaScript project",
            explanation = "Congratulations! You have reached Lesson 20. In this final capstone project, you build an interactive Todo List application that combines DOM selection, event listeners, input extraction, array manipulation, and dynamic HTML rendering!",
            importantPoints = listOf(
                "Full interactive web application built with HTML, CSS, and JavaScript.",
                "Adds tasks, checks off completed items, and deletes tasks.",
                "Demonstrates complete frontend engineering capability.",
                "You now know all three foundational pillars of the World Wide Web!"
            ),
            codeExamples = listOf(
                CodeExample(
                    title = "Todo App Logic",
                    code = "const todos = [];\nfunction addTodo(text) {\n  todos.push({ text: text, done: false });\n  renderTodos();\n}"
                ),
                CodeExample(
                    title = "Toggling Task Status",
                    code = "function toggleTodo(index) {\n  todos[index].done = !todos[index].done;\n  renderTodos();\n}"
                )
            ),
            lineExplanations = listOf(
                LineExplanation("todos.push({ ... })", "Stores task object in memory array."),
                LineExplanation("renderTodos()", "Refreshes user interface with updated list.")
            ),
            defaultRunnableCode = """
                <div style="font-family: sans-serif; padding: 18px; background: #111827; border-radius: 12px; color: white;">
                  <h3 style="color: #ffd600; margin: 0 0 10px;">Interactive Todo App</h3>
                  <div style="display: flex; gap: 8px; margin-bottom: 12px;">
                    <input id="todo-text" placeholder="Add a new task..." style="flex: 1; padding: 8px; border-radius: 6px; border: 1px solid #334155; background: #1e293b; color: white;">
                    <button onclick="addTodoItem()" style="background: #ffd600; color: black; border: none; padding: 8px 14px; border-radius: 6px; font-weight: bold; cursor: pointer;">Add</button>
                  </div>
                  <div id="todo-container" style="display: flex; flex-direction: column; gap: 6px;"></div>
                  <script>
                    const tasks = ['Complete HTML course', 'Master CSS Flexbox', 'Code in JavaScript'];
                    function render() {
                      const c = document.getElementById('todo-container');
                      c.innerHTML = '';
                      tasks.forEach((t, i) => {
                        const row = document.createElement('div');
                        row.style = 'display: flex; justify-content: space-between; align-items: center; background: #1e293b; padding: 8px 12px; border-radius: 6px; font-size: 13px;';
                        row.innerHTML = '<span>✓ ' + t + '</span><button onclick=\"removeTask(' + i + ')\" style=\"background: #ef4444; color: white; border: none; padding: 2px 6px; border-radius: 4px; cursor: pointer; font-size: 11px;\">Delete</button>';
                        c.appendChild(row);
                      });
                    }
                    function addTodoItem() {
                      const inp = document.getElementById('todo-text');
                      if (inp.value.trim()) {
                        tasks.push(inp.value.trim());
                        inp.value = '';
                        render();
                      }
                    }
                    function removeTask(idx) {
                      tasks.splice(idx, 1);
                      render();
                    }
                    render();
                  </script>
                </div>
            """.trimIndent(),
            notes = "You have graduated the core triumvirate of Web Development: HTML (Structure), CSS (Style), and JavaScript (Logic)!"
        )
    )
}
