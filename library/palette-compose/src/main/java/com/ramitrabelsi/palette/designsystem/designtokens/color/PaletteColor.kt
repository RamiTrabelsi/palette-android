package com.ramitrabelsi.palette.designsystem.designtokens.color

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

/**
 * **PaletteColor: Core base color tokens for the Palette Design System.**
 *
 * This internal object defines the default color values used throughout the design system.
 * These values serve as a foundation for consistent UI styling and theming.
 *
 * **Customization Note:**
 * These default values can be customized by an app integrating the SDK. By overriding these
 * tokens in your implementation, you can tailor the design system to your brand's identity.
 */
@Immutable
internal object PaletteColor {
    // Grayscale tokens
    val G0 = Color(0xFFFFFFFF)    // White
    val G20 = Color(0xFFCCCCCC)   // Light gray
    val G40 = Color(0xFF999999)   // Medium gray
    val G60 = Color(0xFF666666)   // Dark gray
    val G80 = Color(0xFF333333)   // Very dark gray
    val G100 = Color(0xFF000000)  // Black

    // Accent tokens for Light Mode
    val AccentPrimaryLight = Color(0xFF6200EE)    // Vibrant purple
    val AccentSecondaryLight = Color(0xFF018786)  // Teal
    val AccentTertiaryLight = Color(0xFFB00020)   // Deep red

    // Accent tokens for Dark Mode
    val AccentPrimaryDark = Color(0xFFBB86FC)     // Soft purple
    val AccentSecondaryDark = Color(0xFF03DAC6)   // Light teal
    val AccentTertiaryDark = Color(0xFFCF6679)    // Pinkish red

    // Semantic tokens – Light Mode
    val ErrorLight = Color(0xFFB00020)            // Red
    val OnErrorLight = Color(0xFFFFFFFF)          // White
    val ErrorContainerLight = Color(0xFFFFDAD6)   // Pale red
    val OnErrorContainerLight = Color(0xFF000000) // Black

    val SuccessLight = Color(0xFF388E3C)            // Green
    val OnSuccessLight = Color(0xFFFFFFFF)          // White
    val SuccessContainerLight = Color(0xFF81C784)   // Green (success)
    val OnSuccessContainerLight = Color(0xFF000000) // Black

    val WarningLight = Color(0xFFF57C00)             // Orange
    val OnWarningLight = Color(0xFFFFFFFF)           // White
    val WarningContainerLight = Color(0xFFFFCC80)    // Light orange
    val OnWarningContainerLight = Color(0xFF000000)  // Black

    val InfoLight = Color(0xFF1976D2)              // Blue
    val OnInfoLight = Color(0xFFFFFFFF)            // White
    val InfoContainerLight = Color(0xFF64B5F6)     // Light blue
    val OnInfoContainerLight = Color(0xFF000000)   // Black

    // Semantic tokens – Dark Mode
    val ErrorDark = Color(0xFFCF6679)              // Pinkish red
    val OnErrorDark = Color(0xFF000000)            // Black
    val ErrorContainerDark = Color(0xFFB13849)     // Muted red
    val OnErrorContainerDark = Color(0xFFFFFFFF)   // White

    val SuccessDark = Color(0xFF81C784)            // Green (success)
    val OnSuccessDark = Color(0xFF000000)          // Black
    val SuccessContainerDark = Color(0xFF388E3C)   // Green
    val OnSuccessContainerDark = Color(0xFFFFFFFF) // White

    val WarningDark = Color(0xFFFFCC80)            // Light orange
    val OnWarningDark = Color(0xFF000000)          // Black
    val WarningContainerDark = Color(0xFFF57C00)   // Orange
    val OnWarningContainerDark = Color(0xFFFFFFFF) // White

    val InfoDark = Color(0xFF64B5F6)               // Light blue
    val OnInfoDark = Color(0xFF000000)             // Black
    val InfoContainerDark = Color(0xFF1976D2)      // Blue
    val OnInfoContainerDark = Color(0xFFFFFFFF)    // White
}
