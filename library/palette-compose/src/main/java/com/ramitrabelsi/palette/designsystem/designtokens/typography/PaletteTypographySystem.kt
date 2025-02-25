package com.ramitrabelsi.palette.designsystem.designtokens.typography

import androidx.compose.material3.Typography
import androidx.compose.runtime.Immutable

/**
 * PaletteTypographySystem defines a complete set of text styles for the Palette Design System.
 *
 * All allowed text styles are restricted to the predefined values of [PaletteTextStyle].
 * These tokens are fully customizable by the consuming app.
 */
@Immutable
data class PaletteTypographySystem(
    val displayLarge: PaletteTextStyle = PaletteTextStyle.DisplayLarge,
    val displayMedium: PaletteTextStyle = PaletteTextStyle.DisplayMedium,
    val displaySmall: PaletteTextStyle = PaletteTextStyle.DisplaySmall,
    val headlineLarge: PaletteTextStyle = PaletteTextStyle.HeadlineLarge,
    val headlineMedium: PaletteTextStyle = PaletteTextStyle.HeadlineMedium,
    val headlineSmall: PaletteTextStyle = PaletteTextStyle.HeadlineSmall,
    val titleLarge: PaletteTextStyle = PaletteTextStyle.TitleLarge,
    val titleMedium: PaletteTextStyle = PaletteTextStyle.TitleMedium,
    val titleSmall: PaletteTextStyle = PaletteTextStyle.TitleSmall,
    val bodyLarge: PaletteTextStyle = PaletteTextStyle.BodyLarge,
    val bodyMedium: PaletteTextStyle = PaletteTextStyle.BodyMedium,
    val bodySmall: PaletteTextStyle = PaletteTextStyle.BodySmall,
    val labelLarge: PaletteTextStyle = PaletteTextStyle.LabelLarge,
    val labelMedium: PaletteTextStyle = PaletteTextStyle.LabelMedium,
    val labelSmall: PaletteTextStyle = PaletteTextStyle.LabelSmall,
    // Extended tokens:
    val hero: PaletteTextStyle = PaletteTextStyle.Hero,
    val sectionTitle: PaletteTextStyle = PaletteTextStyle.SectionTitle,
    val subtitle: PaletteTextStyle = PaletteTextStyle.Subtitle,
    val button: PaletteTextStyle = PaletteTextStyle.Button,
    val caption: PaletteTextStyle = PaletteTextStyle.Caption,
    val overline: PaletteTextStyle = PaletteTextStyle.Overline
)

/**
 * Converts [PaletteTypographySystem] to a Material 3 [Typography] object.
 *
 * Each token is mapped directly by extracting the underlying [TextStyle] from [PaletteTextStyle].
 */
internal fun PaletteTypographySystem.toMaterialTypography(): Typography = Typography(
    displayLarge = displayLarge.style,
    displayMedium = displayMedium.style,
    displaySmall = displaySmall.style,
    headlineLarge = headlineLarge.style,
    headlineMedium = headlineMedium.style,
    headlineSmall = headlineSmall.style,
    titleLarge = titleLarge.style,
    titleMedium = titleMedium.style,
    titleSmall = titleSmall.style,
    bodyLarge = bodyLarge.style,
    bodyMedium = bodyMedium.style,
    bodySmall = bodySmall.style,
    labelLarge = labelLarge.style,
    labelMedium = labelMedium.style,
    labelSmall = labelSmall.style
)
