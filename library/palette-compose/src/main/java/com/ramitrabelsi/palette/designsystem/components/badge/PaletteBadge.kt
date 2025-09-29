package com.ramitrabelsi.palette.designsystem.components.badge

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.compositeOver
import androidx.compose.ui.unit.dp
import com.ramitrabelsi.palette.PaletteTheme
import com.ramitrabelsi.palette.designsystem.components.icon.PaletteIcon
import com.ramitrabelsi.palette.designsystem.designtokens.icon.PaletteIconAsset
import com.ramitrabelsi.palette.designsystem.designtokens.typography.PaletteTextStyle
import com.ramitrabelsi.palette.designsystem.tokens.dimensions.PaletteDimension
import com.ramitrabelsi.palette.designsystem.components.text.PaletteText

/**
 * PaletteBadge is a compact status indicator built on top of Palette tokens.
 *
 * It is designed to be flexible enough for community-driven use-cases such as tagging content,
 * highlighting states, or displaying metadata alongside list items.
 *
 * The badge automatically picks meaningful foreground/background colors for every [PaletteBadgeType]
 * and optionally supports leading icons.
 */
@Composable
fun PaletteBadge(
    text: String,
    modifier: Modifier = Modifier,
    type: PaletteBadgeType = PaletteBadgeType.Neutral,
    icon: PaletteIconAsset? = null,
    iconTint: Color? = null,
    textStyle: PaletteTextStyle = PaletteTheme.typographySystem.labelMedium,
) {
    val colorSystem = PaletteTheme.colorSystem
    val materialColors = colorSystem.toMaterialColors()
    val (containerColor, contentColor) = when (type) {
        PaletteBadgeType.Primary -> materialColors.primaryContainer to materialColors.onPrimaryContainer
        PaletteBadgeType.Success -> colorSystem.successContainer to colorSystem.onSuccessContainer
        PaletteBadgeType.Warning -> colorSystem.warningContainer to colorSystem.onWarningContainer
        PaletteBadgeType.Danger -> materialColors.errorContainer to materialColors.onErrorContainer
        PaletteBadgeType.Info -> colorSystem.infoContainer to colorSystem.onInfoContainer
        PaletteBadgeType.Neutral -> {
            val base = colorSystem.grayscaleG20
            // Add a subtle overlay to ensure contrast on both dark/light modes.
            val overlay = colorSystem.accentPrimary.copy(alpha = PaletteDimension.AlphaVeryLight)
            (overlay.compositeOver(base)) to colorSystem.grayscaleG100
        }
    }

    Row(
        modifier = modifier
            .clip(PaletteTheme.shapeSystem.dialog)
            .background(containerColor)
            .padding(
                horizontal = PaletteDimension.Spacing12,
                vertical = PaletteDimension.Spacing4
            )
            .sizeIn(minHeight = 24.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(PaletteDimension.Spacing4)
    ) {
        if (icon != null) {
            PaletteIcon(
                icon = icon,
                size = PaletteDimension.IconSize.Size16,
                tint = iconTint ?: contentColor
            )
        }
        PaletteText(
            text = text,
            style = textStyle,
            color = contentColor
        )
    }
}

/**
 * Available visual treatments for [PaletteBadge].
 */
enum class PaletteBadgeType {
    Primary,
    Success,
    Warning,
    Danger,
    Info,
    Neutral,
}
