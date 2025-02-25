package com.ramitrabelsi.palette

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import com.ramitrabelsi.palette.designsystem.designtokens.color.PaletteColorSystem
import com.ramitrabelsi.palette.designsystem.designtokens.shape.PaletteShapeSystem
import com.ramitrabelsi.palette.designsystem.designtokens.shape.toMaterialShapes
import com.ramitrabelsi.palette.designsystem.designtokens.typography.PaletteTypographySystem
import com.ramitrabelsi.palette.designsystem.designtokens.typography.toMaterialTypography

private val LocalPaletteColorSystem = staticCompositionLocalOf<PaletteColorSystem> {
    error("No PaletteColorSystem provided! Ensure you wrap your UI in PaletteTheme.")
}

private val LocalPaletteTypographySystem = staticCompositionLocalOf<PaletteTypographySystem> {
    error("No PaletteTypographySystem provided! Ensure you wrap your UI in PaletteTheme.")
}

private val LocalPaletteShapeSystem = staticCompositionLocalOf<PaletteShapeSystem> {
    error("No PaletteShapesSystem provided! Ensure you wrap your UI in PaletteTheme.")
}

/**
 * PaletteTheme is a reusable Jetpack Compose design system theme,
 * implementing Material Design 3 principles.
 *
 * @see [Material Theming](https://developer.android.com/develop/ui/compose/designsystems/custom)
 */
@Composable
fun PaletteTheme(
    isDarkMode: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorSystem = PaletteColorSystem(isDark = isDarkMode)
    val typographySystem = PaletteTypographySystem()
    val shapesSystem = PaletteShapeSystem()

    CompositionLocalProvider(
        LocalPaletteColorSystem provides colorSystem,
        LocalPaletteTypographySystem provides typographySystem,
        LocalPaletteShapeSystem provides shapesSystem,
        LocalContentColor provides colorSystem.toMaterialColors().onSurface,
    ) {
        MaterialTheme(
            colorScheme = colorSystem.toMaterialColors(),
            typography = typographySystem.toMaterialTypography(),
            shapes = shapesSystem.toMaterialShapes(),
            content = content
        )
    }
}

/**
 * Provides access to the current theme's color, typography, and shape systems.
 */
object PaletteTheme {

    val colorSystem: PaletteColorSystem
        @Composable
        get() = LocalPaletteColorSystem.current

    val shapeSystem: PaletteShapeSystem
        @Composable
        get() = LocalPaletteShapeSystem.current

    val typographySystem: PaletteTypographySystem
        @Composable
        get() = LocalPaletteTypographySystem.current
}
