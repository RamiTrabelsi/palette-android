@file:OptIn(ExperimentalMaterial3Api::class)

package com.ramitrabelsi.palette.designsystem.patterns.topappbar

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramitrabelsi.palette.PaletteTheme
import com.ramitrabelsi.palette.PaletteTheme.colorSystem
import com.ramitrabelsi.palette.designsystem.components.icon.PaletteIconButton
import com.ramitrabelsi.palette.designsystem.components.text.PaletteText
import com.ramitrabelsi.palette.designsystem.designtokens.icon.PaletteIconAsset
import com.ramitrabelsi.palette.designsystem.tokens.dimensions.PaletteDimension

/**
 * PaletteTopAppBar displays a top app bar consistent with the Palette Design System.
 *
 * It shows a title, an optional navigation icon (back button), and optional action items.
 *
 * @param title The title to display.
 * @param modifier Modifier for layout adjustments.
 * @param onNavigationClick Optional callback for the navigation (back) icon.
 * @param actions Optional composable lambda to render additional action icons.
 */
@Composable
fun PaletteTopAppBar(
    title: String,
    modifier: Modifier = Modifier,
    onNavigationClick: (() -> Unit)? = null,
    actions: @Composable (() -> Unit)? = null,
) {
    TopAppBar(
        title = {
            PaletteText(
                text = title,
                style = PaletteTheme.typographySystem.titleMedium
            )
        },
        navigationIcon = {
            onNavigationClick?.let { click ->
                PaletteIconButton(
                    onClick = click,
                    icon = PaletteIconAsset.BackArrow,
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(PaletteDimension.Spacing8)
                )
            }
        },
        actions = { actions?.invoke() },
        colors = TopAppBarColors(
            containerColor = if (colorSystem.isDark) {
                colorSystem.grayscaleG100
            } else {
                colorSystem.grayscaleG0
            },
            scrolledContainerColor = if (colorSystem.isDark) {
                colorSystem.accentPrimary
            } else {
                colorSystem.accentSecondary
            },
            navigationIconContentColor = if (colorSystem.isDark) {
                colorSystem.grayscaleG0
            } else {
                colorSystem.grayscaleG100
            },
            titleContentColor = if (colorSystem.isDark) {
                colorSystem.grayscaleG0
            } else {
                colorSystem.grayscaleG100
            },
            actionIconContentColor = if (colorSystem.isDark) {
                colorSystem.grayscaleG0
            } else {
                colorSystem.grayscaleG100
            }
        ),
        modifier = modifier
    )
}
