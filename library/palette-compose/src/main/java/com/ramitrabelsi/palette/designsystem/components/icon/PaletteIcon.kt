package com.ramitrabelsi.palette.designsystem.components.icon

import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.ramitrabelsi.palette.designsystem.designtokens.icon.PaletteIconAsset
import com.ramitrabelsi.palette.designsystem.tokens.dimensions.PaletteDimension

/**
 * PaletteIcon renders an icon asset from the Palette Design System.
 *
 * This composable ensures that only the approved icon assets (managed via PaletteIconAsset)
 * are used across the app, and it applies an optional size and tint.
 *
 * @param icon The icon asset to display. This includes the drawable resource and accessibility
 *             description.
 * @param modifier Modifier for layout adjustments.
 * @param size Optional size (restricted to values defined in [PaletteDimension.IconSize]).
 *             If provided, the icon will be resized accordingly.
 * @param tint Optional tint color; if not specified, it defaults to [LocalContentColor.current].
 */
@Composable
fun PaletteIcon(
    icon: PaletteIconAsset,
    modifier: Modifier = Modifier,
    size: PaletteDimension.IconSize? = null,
    tint: Color = LocalContentColor.current,
) {
    val finalModifier = size?.let { modifier.requiredSize(it.dp) } ?: modifier
    Icon(
        painter = painterResource(id = icon.resourceId),
        contentDescription = icon.nameForAccessibility,
        tint = tint,
        modifier = finalModifier
    )
}
