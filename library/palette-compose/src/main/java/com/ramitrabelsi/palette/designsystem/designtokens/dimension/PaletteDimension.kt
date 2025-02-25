package com.ramitrabelsi.palette.designsystem.tokens.dimensions

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * PaletteDimension defines all the dimension tokens used in the Palette Design System.
 *
 * It includes spacing tokens and type-safe enumerations for icon sizes and corner radii.
 * All values are centralized here to ensure consistency across the design system.
 */
@Immutable
object PaletteDimension {

    // Commons
    const val AlphaVeryLight: Float = 0.05f       // Very light overlay alpha
    const val AlphaOverlay: Float = 0.2f          // Standard overlay alpha

    @Stable
    val CircularLoadingStrokeWidth: Dp = 2.dp

    // Spacing tokens (in dp)
    @Stable
    val Spacing0: Dp = 0.dp

    @Stable
    val Spacing4: Dp = 4.dp

    @Stable
    val Spacing8: Dp = 8.dp

    @Stable
    val Spacing12: Dp = 12.dp

    @Stable
    val Spacing16: Dp = 16.dp

    @Stable
    val Spacing24: Dp = 24.dp

    @Stable
    val Spacing32: Dp = 32.dp

    @Stable
    val Spacing48: Dp = 48.dp

    /**
     * IconSize defines the allowed icon sizes in the design system.
     */
    @Stable
    enum class IconSize(val dp: Dp) {
        Size16(16.dp),
        Size24(24.dp),
        Size32(32.dp),
        Size48(48.dp)
    }

    /**
     * CornerRadius defines the allowed corner radii for shaping components.
     */
    @Stable
    enum class CornerRadius(val dp: Dp) {
        Radius0(0.dp),
        Radius2(2.dp),
        Radius4(4.dp),
        Radius8(8.dp),
        Radius16(16.dp)
    }
}
