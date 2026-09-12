package com.example.ui.components

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.ViewGroup
import android.webkit.ConsoleMessage
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.ui.theme.DarkBorder
import com.example.ui.theme.DarkSurface
import com.example.ui.theme.DarkSurfaceVariant
import com.example.ui.theme.NeonGreen
import com.example.ui.theme.TextMuted
import com.example.ui.theme.TextPrimary
import com.example.ui.theme.TextSecondary

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun LivePreviewView(
    codeHtml: String,
    modifier: Modifier = Modifier,
    heightDp: Int = 220,
    showConsole: Boolean = true
) {
    val context = LocalContext.current
    val consoleLogs = remember { mutableStateListOf<String>() }
    var webViewRef by remember { mutableStateOf<WebView?>(null) }
    var refreshTrigger by remember { mutableStateOf(0) }

    val fullHtmlDocument = remember(codeHtml, refreshTrigger) {
        val hasHtmlTags = codeHtml.contains("<!DOCTYPE", ignoreCase = true) ||
                codeHtml.contains("<html", ignoreCase = true)

        if (hasHtmlTags) {
            codeHtml
        } else {
            """
            <!DOCTYPE html>
            <html>
            <head>
              <meta charset="utf-8">
              <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
              <style>
                * { box-sizing: border-box; }
                body {
                  margin: 0;
                  padding: 12px;
                  background-color: #0f172a;
                  color: #f8fafc;
                  font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, sans-serif;
                }
              </style>
            </head>
            <body>
              $codeHtml
            </body>
            </html>
            """.trimIndent()
        }
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .border(1.dp, DarkBorder, RoundedCornerShape(12.dp))
            .background(DarkSurface)
    ) {
        // Browser Window Header Bar
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(DarkSurfaceVariant)
                .padding(horizontal = 12.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Window control dots
            Box(modifier = Modifier.size(10.dp).background(androidx.compose.ui.graphics.Color(0xFFEF4444), CircleShape))
            Spacer(modifier = Modifier.width(6.dp))
            Box(modifier = Modifier.size(10.dp).background(androidx.compose.ui.graphics.Color(0xFFFBBF24), CircleShape))
            Spacer(modifier = Modifier.width(6.dp))
            Box(modifier = Modifier.size(10.dp).background(NeonGreen, CircleShape))
            Spacer(modifier = Modifier.width(12.dp))

            // Address bar label
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(6.dp))
                    .background(DarkSurface)
                    .padding(horizontal = 10.dp, vertical = 4.dp)
            ) {
                Text(
                    text = "Live Output Preview",
                    fontSize = 11.sp,
                    color = TextMuted,
                    fontFamily = FontFamily.Monospace
                )
            }

            IconButton(
                onClick = {
                    consoleLogs.clear()
                    refreshTrigger++
                    webViewRef?.reload()
                },
                modifier = Modifier.size(28.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = "Reload Preview",
                    tint = TextSecondary,
                    modifier = Modifier.size(16.dp)
                )
            }
        }

        // Live WebView Container
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(heightDp.dp)
                .background(androidx.compose.ui.graphics.Color(0xFF0F172A))
        ) {
            AndroidView(
                factory = { ctx ->
                    WebView(ctx).apply {
                        layoutParams = ViewGroup.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT
                        )
                        setBackgroundColor(Color.parseColor("#0f172a"))
                        settings.apply {
                            javaScriptEnabled = true
                            domStorageEnabled = true
                            allowFileAccess = true
                            mediaPlaybackRequiresUserGesture = false
                            loadWithOverviewMode = true
                            useWideViewPort = true
                            cacheMode = WebSettings.LOAD_NO_CACHE
                        }
                        webViewClient = object : WebViewClient() {}
                        webChromeClient = object : WebChromeClient() {
                            override fun onConsoleMessage(message: ConsoleMessage?): Boolean {
                                message?.message()?.let { msg ->
                                    if (!consoleLogs.contains(msg)) {
                                        consoleLogs.add(msg)
                                    }
                                }
                                return super.onConsoleMessage(message)
                            }
                        }
                        webViewRef = this
                        loadDataWithBaseURL(null, fullHtmlDocument, "text/html", "UTF-8", null)
                    }
                },
                update = { webView ->
                    webView.loadDataWithBaseURL(null, fullHtmlDocument, "text/html", "UTF-8", null)
                },
                modifier = Modifier.fillMaxSize()
            )
        }

        // Console Logs Output Bar (if JavaScript outputs messages)
        if (showConsole && consoleLogs.isNotEmpty()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(androidx.compose.ui.graphics.Color(0xFF070B12))
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            ) {
                Text(
                    text = "Console Output:",
                    fontSize = 11.sp,
                    color = NeonGreen,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.Bold
                )
                consoleLogs.takeLast(3).forEach { log ->
                    Text(
                        text = "> $log",
                        fontSize = 11.sp,
                        color = TextPrimary,
                        fontFamily = FontFamily.Monospace,
                        modifier = Modifier.padding(top = 2.dp)
                    )
                }
            }
        }
    }
}
