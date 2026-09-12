package com.example.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkCodingColorScheme = darkColorScheme(
    primary = NeonCssBlue,
    onPrimary = Color.Black,
    primaryContainer = DarkSurfaceVariant,
    onPrimaryContainer = NeonCssBlueLight,
    secondary = NeonHtmlOrange,
    onSecondary = Color.Black,
    secondaryContainer = DarkSurfaceVariant,
    onSecondaryContainer = NeonHtmlOrangeLight,
    tertiary = NeonJsYellow,
    onTertiary = Color.Black,
    tertiaryContainer = DarkSurfaceVariant,
    onTertiaryContainer = NeonJsYellowLight,
    background = DarkCanvas,
    onBackground = TextPrimary,
    surface = DarkSurface,
    onSurface = TextPrimary,
    surfaceVariant = DarkSurfaceVariant,
    onSurfaceVariant = TextSecondary,
    outline = DarkBorder,
    outlineVariant = DarkBorderHighlight
)

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = true,
    dynamicColor: Boolean = false, // Dark coding theme is primary
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = DarkCodingColorScheme,
        typography = Typography,
        content = content
    )
}
