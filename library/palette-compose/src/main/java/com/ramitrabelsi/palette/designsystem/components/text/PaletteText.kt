package com.ramitrabelsi.palette.designsystem.components.text

import androidx.annotation.StringRes
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.ramitrabelsi.palette.designsystem.designtokens.typography.PaletteTextStyle

/**
 * PaletteText displays text styled according to the Palette Design System.
 *
 * The text style is restricted to the allowed values defined in [PaletteTextStyle].
 *
 * @param text The text content to display.
 * @param modifier Modifier for layout adjustments.
 * @param style The [PaletteTextStyle] to apply. Defaults to [PaletteTextStyle.BodyMedium].
 * @param color The text color. Defaults to [LocalContentColor.current].
 * @param textAlign Optional text alignment.
 * @param maxLines Maximum number of lines to display.
 * @param overflow How to handle text overflow.
 * @param contentDescription Optional content description for accessibility.
 */
@Composable
fun PaletteText(
    text: String,
    modifier: Modifier = Modifier,
    style: PaletteTextStyle = PaletteTextStyle.BodyMedium,
    color: Color = LocalContentColor.current,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip,
    contentDescription: String? = null,
) {
    val finalModifier = if (contentDescription != null) {
        modifier.semantics { this.contentDescription = contentDescription }
    } else modifier

    Text(
        text = text,
        style = style.style,
        color = color,
        modifier = finalModifier,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = overflow
    )
}

/**
 * PaletteText displays text from a string resource, styled according to the Palette Design System.
 *
 * @param textRes The string resource ID to display.
 * @param modifier Modifier for layout adjustments.
 * @param style The [PaletteTextStyle] to apply. Defaults to [PaletteTextStyle.BodyMedium].
 * @param color The text color. Defaults to [LocalContentColor.current].
 * @param textAlign Optional text alignment.
 * @param maxLines Maximum number of lines to display.
 * @param overflow How to handle text overflow.
 * @param contentDescription Optional content description for accessibility.
 */
@Composable
fun PaletteText(
    @StringRes textRes: Int,
    modifier: Modifier = Modifier,
    style: PaletteTextStyle = PaletteTextStyle.BodyMedium,
    color: Color = LocalContentColor.current,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip,
    contentDescription: String? = null,
) {
    PaletteText(
        text = stringResource(id = textRes),
        modifier = modifier,
        style = style,
        color = color,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = overflow,
        contentDescription = contentDescription
    )
}
