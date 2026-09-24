package com.ramitrabelsi.palette.designsystem.designtokens.color

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import org.junit.Assert.assertTrue
import org.junit.Test

class PaletteColorSystemTest {

    @Test
    fun `all semantic color pairs meet WCAG AA contrast for normal text`() {
        listOf(false, true).forEach { isDark ->
            val colors = PaletteColorSystem(isDark = isDark)
            val pairs = listOf(
                "error" to (colors.error to colors.onError),
                "errorContainer" to (colors.errorContainer to colors.onErrorContainer),
                "success" to (colors.success to colors.onSuccess),
                "successContainer" to (colors.successContainer to colors.onSuccessContainer),
                "warning" to (colors.warning to colors.onWarning),
                "warningContainer" to (colors.warningContainer to colors.onWarningContainer),
                "info" to (colors.info to colors.onInfo),
                "infoContainer" to (colors.infoContainer to colors.onInfoContainer),
            )

            pairs.forEach { (name, pair) ->
                val ratio = contrastRatio(pair.first, pair.second)
                assertTrue(
                    "$name (${if (isDark) "dark" else "light"}) has only $ratio:1 contrast",
                    ratio >= WCAG_AA_NORMAL_TEXT_CONTRAST
                )
            }
        }
    }

    @Test
    fun `Material accent content pairs meet WCAG AA contrast for normal text`() {
        listOf(false, true).forEach { isDark ->
            val colors = PaletteColorSystem(isDark = isDark).toMaterialColors()
            val pairs = listOf(
                "primary" to (colors.primary to colors.onPrimary),
                "primaryContainer" to (colors.primaryContainer to colors.onPrimaryContainer),
                "secondary" to (colors.secondary to colors.onSecondary),
                "secondaryContainer" to (colors.secondaryContainer to colors.onSecondaryContainer),
                "tertiary" to (colors.tertiary to colors.onTertiary),
                "tertiaryContainer" to (colors.tertiaryContainer to colors.onTertiaryContainer),
            )

            pairs.forEach { (name, pair) ->
                val ratio = contrastRatio(pair.first, pair.second)
                assertTrue(
                    "$name (${if (isDark) "dark" else "light"}) has only $ratio:1 contrast",
                    ratio >= WCAG_AA_NORMAL_TEXT_CONTRAST
                )
            }
        }
    }

    private fun contrastRatio(first: Color, second: Color): Float {
        val lighter = maxOf(first.luminance(), second.luminance())
        val darker = minOf(first.luminance(), second.luminance())
        return (lighter + 0.05f) / (darker + 0.05f)
    }

    private companion object {
        const val WCAG_AA_NORMAL_TEXT_CONTRAST = 4.5f
    }
}
