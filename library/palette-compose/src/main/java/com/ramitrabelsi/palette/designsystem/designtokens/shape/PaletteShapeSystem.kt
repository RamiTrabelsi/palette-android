package com.ramitrabelsi.palette.designsystem.designtokens.shape

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Immutable
import com.ramitrabelsi.palette.designsystem.tokens.dimensions.PaletteDimension

/**
 * PaletteShapesSystem defines a set of shape tokens for the design system.
 *
 * It includes both the standard Material shape tokens and extended tokens for specific use cases.
 * The tokens are based on the dimension values defined in PaletteDimension.
 */
@Immutable
data class PaletteShapeSystem(
    // Standard Material shape tokens
    val small: CornerBasedShape = RoundedCornerShape(PaletteDimension.CornerRadius.Radius4.dp),
    val medium: CornerBasedShape = RoundedCornerShape(PaletteDimension.CornerRadius.Radius8.dp),
    val large: CornerBasedShape = RoundedCornerShape(PaletteDimension.CornerRadius.Radius0.dp),
    // Extended shape tokens
    val card: CornerBasedShape = RoundedCornerShape(PaletteDimension.Spacing12),
    val dialog: CornerBasedShape = RoundedCornerShape(PaletteDimension.Spacing16),
    val button: CornerBasedShape = CircleShape,
)

/**
 * Converts PaletteShapesSystem to a Material3 Shapes object.
 *
 * Only the standard tokens (small, medium, large) are mapped for seamless integration with MaterialTheme.
 */
internal fun PaletteShapeSystem.toMaterialShapes(): Shapes = Shapes(
    small = small,
    medium = medium,
    large = large
)
