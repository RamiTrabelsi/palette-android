package com.ramitrabelsi.palette.designsystem.designtokens.typography

import androidx.compose.material3.Typography
import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

/**
 * PaletteTypographySystem defines a complete set of text styles for an app.
 *
 * It includes both Material standard tokens and extended tokens for extra typographic control.
 * All values are customizable by the consuming app.
 */
@Immutable
data class PaletteTypographySystem(
    // Material Typography Tokens
    val displayLarge: TextStyle = TextStyle(
        fontSize = 57.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamily.SansSerif,
        lineHeight = 64.sp
    ),
    val displayMedium: TextStyle = TextStyle(
        fontSize = 45.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamily.SansSerif,
        lineHeight = 52.sp
    ),
    val displaySmall: TextStyle = TextStyle(
        fontSize = 36.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamily.SansSerif,
        lineHeight = 44.sp
    ),
    val headlineLarge: TextStyle = TextStyle(
        fontSize = 32.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamily.SansSerif,
        lineHeight = 40.sp
    ),
    val headlineMedium: TextStyle = TextStyle(
        fontSize = 28.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamily.SansSerif,
        lineHeight = 36.sp
    ),
    val headlineSmall: TextStyle = TextStyle(
        fontSize = 24.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamily.SansSerif,
        lineHeight = 32.sp
    ),
    val titleLarge: TextStyle = TextStyle(
        fontSize = 22.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = FontFamily.SansSerif,
        lineHeight = 28.sp
    ),
    val titleMedium: TextStyle = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = FontFamily.SansSerif,
        lineHeight = 24.sp
    ),
    val titleSmall: TextStyle = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = FontFamily.SansSerif,
        lineHeight = 20.sp
    ),
    val bodyLarge: TextStyle = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamily.SansSerif,
        lineHeight = 24.sp
    ),
    val bodyMedium: TextStyle = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamily.SansSerif,
        lineHeight = 20.sp
    ),
    val bodySmall: TextStyle = TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamily.SansSerif,
        lineHeight = 16.sp
    ),
    val labelLarge: TextStyle = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = FontFamily.SansSerif,
        lineHeight = 20.sp
    ),
    val labelMedium: TextStyle = TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = FontFamily.SansSerif,
        lineHeight = 16.sp
    ),
    val labelSmall: TextStyle = TextStyle(
        fontSize = 11.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = FontFamily.SansSerif,
        lineHeight = 16.sp
    ),

    // Extended Typography Tokens (additional styles)
    val hero: TextStyle = TextStyle(
        fontSize = 64.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily.SansSerif,
        lineHeight = 72.sp
    ),
    val sectionTitle: TextStyle = TextStyle(
        fontSize = 26.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = FontFamily.SansSerif,
        lineHeight = 32.sp
    ),
    val subtitle: TextStyle = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = FontFamily.SansSerif,
        lineHeight = 24.sp
    ),
    val button: TextStyle = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = FontFamily.SansSerif,
        letterSpacing = 1.25.sp
    ),
    val caption: TextStyle = TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight.Light,
        fontFamily = FontFamily.SansSerif,
        lineHeight = 16.sp
    ),
    val overline: TextStyle = TextStyle(
        fontSize = 10.sp,
        fontWeight = FontWeight.Medium,
        fontFamily = FontFamily.SansSerif,
        letterSpacing = 1.5.sp
    ),
)

/**
 * Converts PaletteTypographySystem to a Material Typography object.
 *
 * All Material tokens are mapped directly.
 */
internal fun PaletteTypographySystem.toMaterialTypography(): Typography = Typography(
    displayLarge = displayLarge,
    displayMedium = displayMedium,
    displaySmall = displaySmall,
    headlineLarge = headlineLarge,
    headlineMedium = headlineMedium,
    headlineSmall = headlineSmall,
    titleLarge = titleLarge,
    titleMedium = titleMedium,
    titleSmall = titleSmall,
    bodyLarge = bodyLarge,
    bodyMedium = bodyMedium,
    bodySmall = bodySmall,
    labelLarge = labelLarge,
    labelMedium = labelMedium,
    labelSmall = labelSmall
)
