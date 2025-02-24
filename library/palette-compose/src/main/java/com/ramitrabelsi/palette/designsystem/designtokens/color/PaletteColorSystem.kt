package com.ramitrabelsi.palette.designsystem.designtokens.color

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import com.ramitrabelsi.palette.designsystem.designtokens.color.PaletteColor.AccentPrimaryDark
import com.ramitrabelsi.palette.designsystem.designtokens.color.PaletteColor.AccentPrimaryLight
import com.ramitrabelsi.palette.designsystem.designtokens.color.PaletteColor.AccentSecondaryDark
import com.ramitrabelsi.palette.designsystem.designtokens.color.PaletteColor.AccentSecondaryLight
import com.ramitrabelsi.palette.designsystem.designtokens.color.PaletteColor.AccentTertiaryDark
import com.ramitrabelsi.palette.designsystem.designtokens.color.PaletteColor.AccentTertiaryLight
import com.ramitrabelsi.palette.designsystem.designtokens.color.PaletteColor.ErrorContainerDark
import com.ramitrabelsi.palette.designsystem.designtokens.color.PaletteColor.ErrorContainerLight
import com.ramitrabelsi.palette.designsystem.designtokens.color.PaletteColor.ErrorDark
import com.ramitrabelsi.palette.designsystem.designtokens.color.PaletteColor.ErrorLight
import com.ramitrabelsi.palette.designsystem.designtokens.color.PaletteColor.G0
import com.ramitrabelsi.palette.designsystem.designtokens.color.PaletteColor.G100
import com.ramitrabelsi.palette.designsystem.designtokens.color.PaletteColor.G20
import com.ramitrabelsi.palette.designsystem.designtokens.color.PaletteColor.G40
import com.ramitrabelsi.palette.designsystem.designtokens.color.PaletteColor.G60
import com.ramitrabelsi.palette.designsystem.designtokens.color.PaletteColor.G80
import com.ramitrabelsi.palette.designsystem.designtokens.color.PaletteColor.InfoContainerDark
import com.ramitrabelsi.palette.designsystem.designtokens.color.PaletteColor.InfoContainerLight
import com.ramitrabelsi.palette.designsystem.designtokens.color.PaletteColor.InfoDark
import com.ramitrabelsi.palette.designsystem.designtokens.color.PaletteColor.InfoLight
import com.ramitrabelsi.palette.designsystem.designtokens.color.PaletteColor.OnErrorContainerDark
import com.ramitrabelsi.palette.designsystem.designtokens.color.PaletteColor.OnErrorContainerLight
import com.ramitrabelsi.palette.designsystem.designtokens.color.PaletteColor.OnErrorDark
import com.ramitrabelsi.palette.designsystem.designtokens.color.PaletteColor.OnErrorLight
import com.ramitrabelsi.palette.designsystem.designtokens.color.PaletteColor.OnInfoContainerDark
import com.ramitrabelsi.palette.designsystem.designtokens.color.PaletteColor.OnInfoContainerLight
import com.ramitrabelsi.palette.designsystem.designtokens.color.PaletteColor.OnInfoDark
import com.ramitrabelsi.palette.designsystem.designtokens.color.PaletteColor.OnInfoLight
import com.ramitrabelsi.palette.designsystem.designtokens.color.PaletteColor.OnSuccessContainerDark
import com.ramitrabelsi.palette.designsystem.designtokens.color.PaletteColor.OnSuccessContainerLight
import com.ramitrabelsi.palette.designsystem.designtokens.color.PaletteColor.OnSuccessDark
import com.ramitrabelsi.palette.designsystem.designtokens.color.PaletteColor.OnSuccessLight
import com.ramitrabelsi.palette.designsystem.designtokens.color.PaletteColor.OnWarningContainerDark
import com.ramitrabelsi.palette.designsystem.designtokens.color.PaletteColor.OnWarningContainerLight
import com.ramitrabelsi.palette.designsystem.designtokens.color.PaletteColor.OnWarningDark
import com.ramitrabelsi.palette.designsystem.designtokens.color.PaletteColor.OnWarningLight
import com.ramitrabelsi.palette.designsystem.designtokens.color.PaletteColor.SuccessContainerDark
import com.ramitrabelsi.palette.designsystem.designtokens.color.PaletteColor.SuccessContainerLight
import com.ramitrabelsi.palette.designsystem.designtokens.color.PaletteColor.SuccessDark
import com.ramitrabelsi.palette.designsystem.designtokens.color.PaletteColor.SuccessLight
import com.ramitrabelsi.palette.designsystem.designtokens.color.PaletteColor.WarningContainerDark
import com.ramitrabelsi.palette.designsystem.designtokens.color.PaletteColor.WarningContainerLight
import com.ramitrabelsi.palette.designsystem.designtokens.color.PaletteColor.WarningDark
import com.ramitrabelsi.palette.designsystem.designtokens.color.PaletteColor.WarningLight

/**
 * PaletteColorSystem is the complete library of color tokens available for an
 * application consuming the Palette design system.
 *
 * Developers access colors via `PaletteTheme.colorSystem.FOO`—never directly through
 *  This data class provides default values (which are customizable) for:
 *
 * - **Grayscale tokens:** Fixed values (G0, G20, …, G100).
 * - **Accent tokens:** Core branding/emphasis colors, selected based on the theme (dark/light).
 * - **Semantic tokens:** Colors for states such as error, success, warning, and info.
 *
 * This class is marked as immutable to ensure stability throughout recompositions.
 *
 * **Customization Note:**
 * The default values provided here can be overridden by an app integrating the SDK,
 * allowing you to adapt the design system to your brand.
 *
 * @property isDark Determines if the palette should use dark-mode accent and semantic values.
 */
@Immutable
data class PaletteColorSystem(
    val isDark: Boolean,
    // Grayscale tokens (fixed)
    val grayscaleG0: Color = G0,
    val grayscaleG20: Color = G20,
    val grayscaleG40: Color = G40,
    val grayscaleG60: Color = G60,
    val grayscaleG80: Color = G80,
    val grayscaleG100: Color = G100,
    // Accent tokens (vary by theme)
    val accentPrimary: Color = if (isDark) AccentPrimaryDark else AccentPrimaryLight,
    val accentSecondary: Color = if (isDark) AccentSecondaryDark else AccentSecondaryLight,
    val accentTertiary: Color = if (isDark) AccentTertiaryDark else AccentTertiaryLight,
    // Semantic tokens – Error
    val error: Color = if (isDark) ErrorDark else ErrorLight,
    val onError: Color = if (isDark) OnErrorDark else OnErrorLight,
    val errorContainer: Color = if (isDark) ErrorContainerDark else ErrorContainerLight,
    val onErrorContainer: Color = if (isDark) OnErrorContainerDark else OnErrorContainerLight,
    // Semantic tokens – Success
    val success: Color = if (isDark) SuccessDark else SuccessLight,
    val onSuccess: Color = if (isDark) OnSuccessDark else OnSuccessLight,
    val successContainer: Color = if (isDark) SuccessContainerDark else SuccessContainerLight,
    val onSuccessContainer: Color = if (isDark) OnSuccessContainerDark else OnSuccessContainerLight,
    // Semantic tokens – Warning
    val warning: Color = if (isDark) WarningDark else WarningLight,
    val onWarning: Color = if (isDark) OnWarningDark else OnWarningLight,
    val warningContainer: Color = if (isDark) WarningContainerDark else WarningContainerLight,
    val onWarningContainer: Color = if (isDark) OnWarningContainerDark else OnWarningContainerLight,
    // Semantic tokens – Info
    val info: Color = if (isDark) InfoDark else InfoLight,
    val onInfo: Color = if (isDark) OnInfoDark else OnInfoLight,
    val infoContainer: Color = if (isDark) InfoContainerDark else InfoContainerLight,
    val onInfoContainer: Color = if (isDark) OnInfoContainerDark else OnInfoContainerLight,
) {
    /**
     * Maps the PaletteColorSystem to a Material 3 [ColorScheme].
     *
     * This extension function integrates your custom tokens with MaterialTheme.
     */
    fun toMaterialColors(): ColorScheme =
        if (isDark) {
            darkColorScheme(
                primary = accentPrimary,
                onPrimary = grayscaleG0,
                primaryContainer = accentPrimary,
                onPrimaryContainer = grayscaleG20,
                secondary = accentSecondary,
                onSecondary = grayscaleG0,
                secondaryContainer = accentSecondary,
                onSecondaryContainer = grayscaleG20,
                tertiary = accentTertiary,
                onTertiary = grayscaleG0,
                tertiaryContainer = accentTertiary,
                onTertiaryContainer = grayscaleG20,
                background = grayscaleG100,
                onBackground = grayscaleG0,
                surface = grayscaleG80,
                onSurface = grayscaleG0,
                error = error,
                onError = onError,
                errorContainer = errorContainer,
                onErrorContainer = onErrorContainer,
                outline = grayscaleG60,
                inverseSurface = grayscaleG0,
                inverseOnSurface = grayscaleG100,
                inversePrimary = accentPrimary
            )
        } else {
            lightColorScheme(
                primary = accentPrimary,
                onPrimary = grayscaleG100,
                primaryContainer = accentPrimary,
                onPrimaryContainer = grayscaleG20,
                secondary = accentSecondary,
                onSecondary = grayscaleG100,
                secondaryContainer = accentSecondary,
                onSecondaryContainer = grayscaleG20,
                tertiary = accentTertiary,
                onTertiary = grayscaleG100,
                tertiaryContainer = accentTertiary,
                onTertiaryContainer = grayscaleG20,
                background = grayscaleG0,
                onBackground = grayscaleG100,
                surface = grayscaleG20,
                onSurface = grayscaleG100,
                error = error,
                onError = onError,
                errorContainer = errorContainer,
                onErrorContainer = onErrorContainer,
                outline = grayscaleG60,
                inverseSurface = grayscaleG100,
                inverseOnSurface = grayscaleG0,
                inversePrimary = accentPrimary
            )
        }
}
