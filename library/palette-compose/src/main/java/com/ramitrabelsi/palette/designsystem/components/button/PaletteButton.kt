package com.ramitrabelsi.palette.designsystem.components.button

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ramitrabelsi.palette.PaletteTheme
import com.ramitrabelsi.palette.designsystem.components.icon.PaletteIcon
import com.ramitrabelsi.palette.designsystem.components.text.PaletteText
import com.ramitrabelsi.palette.designsystem.designtokens.icon.PaletteIconAsset
import com.ramitrabelsi.palette.designsystem.designtokens.typography.PaletteTextStyle
import com.ramitrabelsi.palette.designsystem.tokens.dimensions.PaletteDimension

/**
 * PaletteButton is a customizable, theme-aware button component following the Palette Design System.
 *
 * It supports multiple sizes and visual types, an optional icon with a restricted size,
 * and a loading state. All styling is driven by design tokens ensuring a consistent look.
 *
 * @param onClick Callback invoked when the button is clicked.
 * @param text The label text displayed on the button.
 * @param modifier Modifier for layout adjustments.
 * @param icon Optional icon asset to display alongside the text.
 * @param iconSize The size to render the icon. Defaults to [PaletteDimension.IconSize.Size16].
 * @param size The size of the button. Defaults to Large.
 * @param type The visual type of the button. Defaults to Primary.
 * @param isFillContainer If true, the button fills the available width.
 * @param isEnabled Whether the button is enabled. Defaults to true.
 * @param isLoading If true, a loading indicator is shown instead of the text/icon.
 * @param textColor Optional override for the button text color.
 * @param backgroundColor Optional override for the button background color.
 * @param textStyle Optional override for the button text style.
 * @param interactionSource Stream of interaction events.
 */
@Composable
fun PaletteButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    icon: PaletteIconAsset? = null,
    iconSize: PaletteDimension.IconSize = PaletteDimension.IconSize.Size16,
    size: PaletteButtonSize = PaletteButtonSize.Large,
    type: PaletteButtonType = PaletteButtonType.Primary,
    isFillContainer: Boolean = false,
    isEnabled: Boolean = true,
    isLoading: Boolean = false,
    textColor: Color? = null,
    textStyle: PaletteTextStyle = PaletteTheme.typographySystem.button,
    backgroundColor: Color? = null,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    // Apply fillMaxWidth if requested.
    val finalModifier = if (isFillContainer) modifier.fillMaxWidth() else modifier

    // Determine default colors based on the button type.
    val finalBackgroundColor = backgroundColor ?: when (type) {
        PaletteButtonType.Primary -> MaterialTheme.colorScheme.primaryContainer
        PaletteButtonType.Secondary -> MaterialTheme.colorScheme.secondaryContainer
        PaletteButtonType.Ghost -> Color.Transparent
        PaletteButtonType.Destructive -> MaterialTheme.colorScheme.errorContainer
    }
    val finalTextColor = textColor ?: when (type) {
        PaletteButtonType.Primary -> MaterialTheme.colorScheme.onPrimaryContainer
        PaletteButtonType.Secondary -> MaterialTheme.colorScheme.onSecondaryContainer
        PaletteButtonType.Ghost -> MaterialTheme.colorScheme.primary
        PaletteButtonType.Destructive -> MaterialTheme.colorScheme.onErrorContainer
    }

    // Define content padding based on the button size.
    val horizontalPadding = when (size) {
        PaletteButtonSize.Large -> PaletteDimension.Spacing16
        PaletteButtonSize.Medium -> PaletteDimension.Spacing12
        PaletteButtonSize.Small -> PaletteDimension.Spacing8
    }
    val verticalPadding = when (size) {
        PaletteButtonSize.Large -> PaletteDimension.Spacing12
        PaletteButtonSize.Medium -> PaletteDimension.Spacing8
        PaletteButtonSize.Small -> PaletteDimension.Spacing4
    }

    Button(
        onClick = onClick,
        enabled = isEnabled && !isLoading,
        interactionSource = interactionSource,
        shape = PaletteTheme.shapeSystem.button,
        colors = ButtonDefaults.buttonColors(
            containerColor = finalBackgroundColor,
            contentColor = finalTextColor
        ),
        contentPadding = PaddingValues(
            horizontal = horizontalPadding,
            vertical = verticalPadding
        ),
        modifier = finalModifier
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.requiredSize(PaletteDimension.IconSize.Size16.dp),
                color = finalTextColor,
                strokeWidth = 2.dp
            )
        } else {
            if (icon != null) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(PaletteDimension.Spacing4)
                ) {
                    // Render the icon with the restricted size.
                    PaletteIcon(
                        icon = icon,
                        size = iconSize
                    )
                    PaletteText(
                        text = text,
                        style = textStyle,
                        color = finalTextColor,
                        textAlign = TextAlign.Center
                    )
                }
            } else {
                PaletteText(
                    text = text,
                    style = textStyle,
                    color = finalTextColor,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

/**
 * Enum representing the available sizes for PaletteButton.
 */
enum class PaletteButtonSize {
    Large, Medium, Small
}

/**
 * Enum representing the visual types for PaletteButton.
 */
enum class PaletteButtonType {
    Primary, Secondary, Ghost, Destructive
}
