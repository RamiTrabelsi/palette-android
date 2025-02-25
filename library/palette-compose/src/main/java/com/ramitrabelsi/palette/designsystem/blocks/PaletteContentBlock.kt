package com.ramitrabelsi.palette.designsystem.blocks

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ramitrabelsi.palette.PaletteTheme
import com.ramitrabelsi.palette.designsystem.components.button.PaletteButton
import com.ramitrabelsi.palette.designsystem.components.button.PaletteButtonSize
import com.ramitrabelsi.palette.designsystem.components.button.PaletteButtonType
import com.ramitrabelsi.palette.designsystem.components.image.PaletteImage
import com.ramitrabelsi.palette.designsystem.components.text.PaletteText
import com.ramitrabelsi.palette.designsystem.patterns.card.PaletteCard
import com.ramitrabelsi.palette.designsystem.tokens.dimensions.PaletteDimension

/**
 * PaletteContentBlock displays a content card with an image, a title, and a description.
 *
 * This block demonstrates how to combine design tokens (colors, typography, spacing, and shapes)
 * with components ([PaletteImage] and [PaletteText]) and pattern like [PaletteCard] to form a
 * reusable UI block.
 *
 * @param title The header text to display (rendered by PaletteCard).
 * @param description The body text or summary to display.
 * @param imageRes Optional drawable resource ID for the header image.
 * @param imageUrl Optional URL for the header image. If both are provided, the URL takes precedence.
 * @param onActionClick Optional callback when the action button is clicked.
 * @param actionText The label for the action button; defaults to "Read More".
 * @param modifier Modifier for layout adjustments.
 */
@Composable
fun PaletteContentBlock(
    title: String,
    description: String,
    @DrawableRes imageRes: Int? = null,
    imageUrl: String? = null,
    onActionClick: (() -> Unit)? = null,
    actionText: String = "Read More",
    modifier: Modifier = Modifier,
) {
    PaletteCard(
        title = title,
        modifier = modifier,
        onClick = null,
        content = {
            when {
                !imageUrl.isNullOrEmpty() -> {
                    PaletteImage(
                        imageUrl = imageUrl,
                        contentDescription = title
                    )
                }

                imageRes != null -> {
                    PaletteImage(
                        imageRes = imageRes,
                        contentDescription = title
                    )
                }
            }
            Spacer(modifier = Modifier.height(PaletteDimension.Spacing12))
            PaletteText(
                text = description,
                style = PaletteTheme.typographySystem.bodyMedium
            )
            if (onActionClick != null) {
                Spacer(modifier = Modifier.height(PaletteDimension.Spacing16))
                PaletteButton(
                    onClick = onActionClick,
                    text = actionText,
                    size = PaletteButtonSize.Small,
                    type = PaletteButtonType.Primary
                )
            }
        }
    )
}
