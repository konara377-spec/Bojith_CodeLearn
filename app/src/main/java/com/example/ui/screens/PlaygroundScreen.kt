package com.example.ui.screens

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.RestartAlt
import androidx.compose.material.icons.filled.Terminal
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.components.CodeEditorView
import com.example.ui.components.LivePreviewView
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

enum class PlaygroundTab {
    HTML, CSS, JS
}

data class PlaygroundPreset(
    val title: String,
    val description: String,
    val html: String,
    val css: String,
    val js: String
)

val PRESET_SIMPLE_WEBPAGE = PlaygroundPreset(
    title = "Simple Webpage",
    description = "Clean modern profile card",
    html = """
        <div class="card">
          <h1>Hello, CodeLearner! 👋</h1>
          <p>Welcome to your personal live web development playground.</p>
          <div class="badge">Beginner Friendly</div>
        </div>
    """.trimIndent(),
    css = """
        body {
          margin: 0;
          padding: 16px;
          background: #0f172a;
          color: white;
          font-family: sans-serif;
          display: flex;
          justify-content: center;
        }
        .card {
          background: #1e293b;
          border: 1px solid #334155;
          padding: 20px;
          border-radius: 12px;
          text-align: center;
          max-width: 320px;
        }
        h1 {
          font-size: 20px;
          color: #38bdf8;
          margin-top: 0;
        }
        p {
          color: #94a3b8;
          font-size: 14px;
        }
        .badge {
          display: inline-block;
          background: #10b981;
          color: black;
          font-weight: bold;
          padding: 4px 12px;
          border-radius: 20px;
          font-size: 12px;
        }
    """.trimIndent(),
    js = """
        console.log("Simple Webpage loaded successfully!");
    """.trimIndent()
)

val PRESET_BUTTON_COUNTER = PlaygroundPreset(
    title = "Button Counter",
    description = "Interactive click tracker",
    html = """
        <div class="counter-box">
          <h2>Click Counter</h2>
          <div id="count-number">0</div>
          <div class="btn-group">
            <button id="inc-btn" onclick="increment()">+ Count</button>
            <button id="reset-btn" onclick="reset()">Reset</button>
          </div>
        </div>
    """.trimIndent(),
    css = """
        body {
          background: #0b0f19;
          font-family: sans-serif;
          display: flex;
          justify-content: center;
          align-items: center;
          height: 100vh;
          margin: 0;
        }
        .counter-box {
          text-align: center;
          background: #1e293b;
          padding: 24px;
          border-radius: 16px;
          border: 2px solid #ffd600;
          color: white;
        }
        #count-number {
          font-size: 48px;
          font-weight: bold;
          color: #ffd600;
          margin: 12px 0;
        }
        button {
          padding: 10px 18px;
          margin: 4px;
          border: none;
          border-radius: 8px;
          font-weight: bold;
          cursor: pointer;
        }
        #inc-btn { background: #10b981; color: white; }
        #reset-btn { background: #ef4444; color: white; }
    """.trimIndent(),
    js = """
        let count = 0;
        function increment() {
          count++;
          document.getElementById('count-number').textContent = count;
          console.log('Count incremented to:', count);
        }
        function reset() {
          count = 0;
          document.getElementById('count-number').textContent = count;
          console.log('Count reset to 0');
        }
    """.trimIndent()
)

val PRESET_ANIMATED_CARD = PlaygroundPreset(
    title = "Animated Card",
    description = "Hover & glowing button",
    html = """
        <div class="neon-card">
          <h3>⚡ Neon Pulsing Box</h3>
          <p>This box demonstrates smooth CSS transitions and JavaScript interactions.</p>
          <button onclick="pulse()">Trigger Pulse</button>
        </div>
    """.trimIndent(),
    css = """
        body {
          background: #020617;
          display: flex;
          justify-content: center;
          padding: 20px;
          font-family: sans-serif;
        }
        .neon-card {
          background: #0f172a;
          border: 2px solid #00d2ff;
          box-shadow: 0 0 15px rgba(0, 210, 255, 0.4);
          padding: 20px;
          border-radius: 16px;
          color: white;
          text-align: center;
          transition: transform 0.3s;
        }
        .neon-card:hover {
          transform: translateY(-4px);
        }
        h3 {
          color: #00d2ff;
          margin-top: 0;
        }
        p {
          color: #94a3b8;
          font-size: 13px;
        }
        button {
          background: #00d2ff;
          color: black;
          font-weight: bold;
          border: none;
          padding: 10px 20px;
          border-radius: 8px;
          cursor: pointer;
        }
    """.trimIndent(),
    js = """
        function pulse() {
          const card = document.querySelector('.neon-card');
          card.style.transform = 'scale(1.08)';
          setTimeout(() => {
            card.style.transform = 'scale(1)';
          }, 200);
        }
    """.trimIndent()
)

@Composable
fun PlaygroundScreen(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val scrollState = rememberScrollState()

    var activePreset by remember { mutableStateOf(PRESET_SIMPLE_WEBPAGE) }

    var htmlCode by remember { mutableStateOf(PRESET_SIMPLE_WEBPAGE.html) }
    var cssCode by remember { mutableStateOf(PRESET_SIMPLE_WEBPAGE.css) }
    var jsCode by remember { mutableStateOf(PRESET_SIMPLE_WEBPAGE.js) }

    var selectedTab by remember { mutableStateOf(PlaygroundTab.HTML) }

    // Generates compiled HTML document
    fun buildFullDocument(): String {
        return """
            <!DOCTYPE html>
            <html>
            <head>
              <meta charset="utf-8">
              <meta name="viewport" content="width=device-width, initial-scale=1.0">
              <style>
                $cssCode
              </style>
            </head>
            <body>
              $htmlCode
              <script>
                $jsCode
              </script>
            </body>
            </html>
        """.trimIndent()
    }

    var renderedHtml by remember { mutableStateOf(buildFullDocument()) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(DarkCanvas)
            .verticalScroll(scrollState)
            .padding(16.dp)
    ) {
        // Playground Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier
                            .size(32.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(NeonGreen.copy(alpha = 0.15f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.Terminal,
                            contentDescription = null,
                            tint = NeonGreen,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "Code Playground",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextPrimary
                    )
                }
                Text(
                    text = "HTML, CSS & JavaScript Sandbox",
                    fontSize = 12.sp,
                    color = TextSecondary,
                    modifier = Modifier.padding(start = 42.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Preset Chips
        Text(
            text = "Starter Presets:",
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = TextMuted,
            fontFamily = FontFamily.Monospace
        )
        Spacer(modifier = Modifier.height(6.dp))

        val presetScroll = rememberScrollState()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(presetScroll),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val presets = listOf(PRESET_SIMPLE_WEBPAGE, PRESET_BUTTON_COUNTER, PRESET_ANIMATED_CARD)
            presets.forEach { p ->
                val isSelected = activePreset.title == p.title
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(if (isSelected) DarkSurfaceElevated else DarkSurface)
                        .border(
                            1.dp,
                            if (isSelected) NeonGreen else DarkBorder,
                            RoundedCornerShape(8.dp)
                        )
                        .clickable {
                            activePreset = p
                            htmlCode = p.html
                            cssCode = p.css
                            jsCode = p.js
                            renderedHtml = """
                                <!DOCTYPE html>
                                <html>
                                <head><style>${p.css}</style></head>
                                <body>${p.html}<script>${p.js}</script></body>
                                </html>
                            """.trimIndent()
                            Toast.makeText(context, "Loaded preset: ${p.title}", Toast.LENGTH_SHORT).show()
                        }
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                ) {
                    Text(
                        text = p.title,
                        fontSize = 12.sp,
                        fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                        color = if (isSelected) NeonGreen else TextSecondary
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Language Tabs: HTML, CSS, JS
        TabRow(
            selectedTabIndex = selectedTab.ordinal,
            containerColor = DarkSurface,
            contentColor = TextPrimary,
            indicator = { tabPositions ->
                TabRowDefaults.SecondaryIndicator(
                    Modifier.tabIndicatorOffset(tabPositions[selectedTab.ordinal]),
                    color = when (selectedTab) {
                        PlaygroundTab.HTML -> NeonHtmlOrange
                        PlaygroundTab.CSS -> NeonCssBlue
                        PlaygroundTab.JS -> NeonJsYellow
                    },
                    height = 3.dp
                )
            }
        ) {
            Tab(
                selected = selectedTab == PlaygroundTab.HTML,
                onClick = { selectedTab = PlaygroundTab.HTML },
                text = {
                    Text(
                        text = "🟠 HTML",
                        fontSize = 13.sp,
                        fontWeight = if (selectedTab == PlaygroundTab.HTML) FontWeight.Bold else FontWeight.Normal,
                        color = if (selectedTab == PlaygroundTab.HTML) NeonHtmlOrange else TextSecondary
                    )
                }
            )
            Tab(
                selected = selectedTab == PlaygroundTab.CSS,
                onClick = { selectedTab = PlaygroundTab.CSS },
                text = {
                    Text(
                        text = "🔵 CSS",
                        fontSize = 13.sp,
                        fontWeight = if (selectedTab == PlaygroundTab.CSS) FontWeight.Bold else FontWeight.Normal,
                        color = if (selectedTab == PlaygroundTab.CSS) NeonCssBlue else TextSecondary
                    )
                }
            )
            Tab(
                selected = selectedTab == PlaygroundTab.JS,
                onClick = { selectedTab = PlaygroundTab.JS },
                text = {
                    Text(
                        text = "🟡 JavaScript",
                        fontSize = 13.sp,
                        fontWeight = if (selectedTab == PlaygroundTab.JS) FontWeight.Bold else FontWeight.Normal,
                        color = if (selectedTab == PlaygroundTab.JS) NeonJsYellow else TextSecondary
                    )
                }
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Active Editor
        when (selectedTab) {
            PlaygroundTab.HTML -> {
                CodeEditorView(
                    code = htmlCode,
                    language = "HTML",
                    onCodeChange = { htmlCode = it },
                    onRunCode = {
                        renderedHtml = buildFullDocument()
                        Toast.makeText(context, "Running updated code...", Toast.LENGTH_SHORT).show()
                    },
                    onReset = {
                        htmlCode = activePreset.html
                    },
                    onClear = {
                        htmlCode = ""
                    }
                )
            }
            PlaygroundTab.CSS -> {
                CodeEditorView(
                    code = cssCode,
                    language = "CSS",
                    onCodeChange = { cssCode = it },
                    onRunCode = {
                        renderedHtml = buildFullDocument()
                        Toast.makeText(context, "Running updated code...", Toast.LENGTH_SHORT).show()
                    },
                    onReset = {
                        cssCode = activePreset.css
                    },
                    onClear = {
                        cssCode = ""
                    }
                )
            }
            PlaygroundTab.JS -> {
                CodeEditorView(
                    code = jsCode,
                    language = "JavaScript",
                    onCodeChange = { jsCode = it },
                    onRunCode = {
                        renderedHtml = buildFullDocument()
                        Toast.makeText(context, "Running updated code...", Toast.LENGTH_SHORT).show()
                    },
                    onReset = {
                        jsCode = activePreset.js
                    },
                    onClear = {
                        jsCode = ""
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Global Action Bar: Run Code, Copy Full Code, Reset All, Clear All
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Live Output",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = TextPrimary
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                // Copy Full Webpage HTML button
                IconButton(
                    onClick = {
                        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
                        val clip = ClipData.newPlainText("Full Code", buildFullDocument())
                        clipboard.setPrimaryClip(clip)
                        Toast.makeText(context, "Full HTML+CSS+JS copied!", Toast.LENGTH_SHORT).show()
                    },
                    modifier = Modifier.size(32.dp).testTag("copy_full_playground_button")
                ) {
                    Icon(
                        imageVector = Icons.Default.ContentCopy,
                        contentDescription = "Copy Full HTML Document",
                        tint = TextSecondary,
                        modifier = Modifier.size(16.dp)
                    )
                }

                // Reset All button
                IconButton(
                    onClick = {
                        htmlCode = activePreset.html
                        cssCode = activePreset.css
                        jsCode = activePreset.js
                        renderedHtml = buildFullDocument()
                        Toast.makeText(context, "Reset all files to preset!", Toast.LENGTH_SHORT).show()
                    },
                    modifier = Modifier.size(32.dp).testTag("reset_all_playground_button")
                ) {
                    Icon(
                        imageVector = Icons.Default.RestartAlt,
                        contentDescription = "Reset All",
                        tint = TextSecondary,
                        modifier = Modifier.size(16.dp)
                    )
                }

                Spacer(modifier = Modifier.width(6.dp))

                ElevatedButton(
                    onClick = {
                        renderedHtml = buildFullDocument()
                        Toast.makeText(context, "Live output reloaded!", Toast.LENGTH_SHORT).show()
                    },
                    colors = ButtonDefaults.elevatedButtonColors(
                        containerColor = NeonGreen,
                        contentColor = Color.Black
                    ),
                    shape = RoundedCornerShape(8.dp),
                    modifier = Modifier.testTag("run_full_code_button")
                ) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text("Run All", fontWeight = FontWeight.Bold, fontSize = 12.5.sp)
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Live Preview Window
        LivePreviewView(
            codeHtml = renderedHtml,
            heightDp = 240,
            showConsole = true
        )

        Spacer(modifier = Modifier.height(30.dp))
    }
}
