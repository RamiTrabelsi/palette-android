package com.ramitrabelsi.palette.designsystem.components.icon

import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.ramitrabelsi.palette.designsystem.designtokens.icon.PaletteIconAsset
import com.ramitrabelsi.palette.designsystem.tokens.dimensions.PaletteDimension

/**
 * PaletteIconButton is a clickable icon component following the Palette Design System.
 *
 * It wraps a PaletteIcon in an IconButton, providing proper click handling, ripple effect,
 * and accessibility semantics.
 *
 * @param onClick Callback invoked when the button is clicked.
 * @param icon The icon asset to display.
 * @param modifier Modifier for layout adjustments.
 * @param iconSize The size at which to render the icon (restricted to PaletteDimension.IconSize values).
 *                 Defaults to [PaletteDimension.IconSize.Size16].
 * @param tint Optional tint color; defaults to [LocalContentColor.current].
 * @param accessibilityLabel Optional contextual label. When omitted, Palette uses the icon's
 * localized default label.
 * @param isEnabled Whether the button accepts user interaction.
 */
@Composable
fun PaletteIconButton(
    onClick: () -> Unit,
    icon: PaletteIconAsset,
    modifier: Modifier = Modifier,
    iconSize: PaletteDimension.IconSize = PaletteDimension.IconSize.Size16,
    tint: Color = LocalContentColor.current,
    accessibilityLabel: String? = null,
    isEnabled: Boolean = true,
) {
    val resolvedAccessibilityLabel = accessibilityLabel
        ?: stringResource(icon.accessibilityLabelRes)

    IconButton(
        onClick = onClick,
        enabled = isEnabled,
        modifier = modifier
    ) {
        PaletteIcon(
            icon = icon,
            size = iconSize,
            tint = tint,
            contentDescription = resolvedAccessibilityLabel
        )
    }
}
