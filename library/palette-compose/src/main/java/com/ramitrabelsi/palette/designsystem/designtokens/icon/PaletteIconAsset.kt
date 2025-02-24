package com.ramitrabelsi.palette.designsystem.designtokens.icon

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.ramitrabelsi.palette_compose.R

/**
 * PaletteIconAsset represents a single icon asset in the Palette Design System.
 *
 * This class serves as the single source of truth for all icons. New icons should be added here
 * to ensure consistency and avoid duplication. Each icon is provided in separate dark and light
 * variants to capture design nuances that tinting alone may not achieve.
 *
 * Note: While you can apply tint programmatically to monochromatic icons (using Compose's Icon tint
 * parameter), dedicated dark/light assets provide more precise control over details (gradients,
 * shadows, outlines) and ensure optimized appearance across themes.
 *
 * @property nameForAccessibility Text used by accessibility services to describe the icon.
 * @property resourceId Drawable resource id for the icon image.
 */
@Immutable
class PaletteIconAsset private constructor(
    val nameForAccessibility: String,
    @DrawableRes internal val resourceId: Int,
) {

    /**
     * The companion object contains all the default icons provided by the design system.
     * New icons should be added here in alphabetical order to keep the library organized.
     */
    @Immutable
    companion object {

        @Stable
        val Home = PaletteIconAsset(
            nameForAccessibility = "Home",
            resourceId = R.drawable.palette_ic_home
        )

        @Stable
        val Favorite = PaletteIconAsset(
            nameForAccessibility = "Favorite",
            resourceId = R.drawable.palette_ic_favorites
        )

        @Stable
        val Search = PaletteIconAsset(
            nameForAccessibility = "Search",
            resourceId = R.drawable.palette_ic_search
        )

        @Stable
        val Settings = PaletteIconAsset(
            nameForAccessibility = "Settings",
            resourceId = R.drawable.palette_ic_settings
        )
    }
}
