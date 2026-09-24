package com.ramitrabelsi.palette.designsystem.designtokens.icon

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
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
 * @property accessibilityLabelRes Localized default label used by actionable icon components.
 * @property resourceId Drawable resource id for the icon image.
 */
@Immutable
class PaletteIconAsset private constructor(
    @StringRes val accessibilityLabelRes: Int,
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
            accessibilityLabelRes = R.string.palette_a11y_icon_home,
            resourceId = R.drawable.palette_ic_home
        )

        @Stable
        val Favorite = PaletteIconAsset(
            accessibilityLabelRes = R.string.palette_a11y_icon_favorite,
            resourceId = R.drawable.palette_ic_favorites
        )

        @Stable
        val Search = PaletteIconAsset(
            accessibilityLabelRes = R.string.palette_a11y_icon_search,
            resourceId = R.drawable.palette_ic_search
        )

        @Stable
        val Settings = PaletteIconAsset(
            accessibilityLabelRes = R.string.palette_a11y_icon_settings,
            resourceId = R.drawable.palette_ic_settings
        )

        @Stable
        val BackArrow = PaletteIconAsset(
            accessibilityLabelRes = R.string.palette_a11y_icon_back,
            resourceId = R.drawable.palette_ic_back_arrow
        )

        @Stable
        val DarkMode = PaletteIconAsset(
            accessibilityLabelRes = R.string.palette_a11y_icon_dark_mode,
            resourceId = R.drawable.palette_ic_dark_mode
        )

        @Stable
        val LightMode = PaletteIconAsset(
            accessibilityLabelRes = R.string.palette_a11y_icon_light_mode,
            resourceId = R.drawable.palette_ic_light_mode
        )
    }
}
