package com.ramitrabelsi.palette.designsystem.components.text

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.ramitrabelsi.palette.PaletteTheme
import com.ramitrabelsi.palette.designsystem.designtokens.typography.PaletteTextStyle

/**
 * PaletteUrlText displays clickable text styled according to the Palette Design System.
 *
 * When clicked, it opens the provided URL in a browser.
 *
 * @param url The URL to open when the text is clicked.
 * @param displayText The text to display.
 * @param modifier Modifier for layout adjustments.
 * @param style The text style to apply, restricted to [PaletteTextStyle]. Defaults to [PaletteTheme.typography.bodyMedium].
 * @param color The text color. Defaults to MaterialTheme.colorScheme.primary.
 * @param textAlign Optional text alignment.
 * @param maxLines Maximum number of lines to display. Defaults to Int.MAX_VALUE.
 * @param overflow How to handle text overflow. Defaults to [TextOverflow.Clip].
 * @param contentDescription Optional label override. Prefer the visible [displayText] whenever it
 * already describes the destination clearly.
 */
@Composable
fun PaletteUrlText(
    url: String,
    displayText: String,
    modifier: Modifier = Modifier,
    style: PaletteTextStyle = PaletteTheme.typographySystem.bodyMedium,
    color: Color = MaterialTheme.colorScheme.primary,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip,
    contentDescription: String? = null,
) {
    val annotatedText = buildAnnotatedString {
        val start = length
        append(displayText)
        addLink(
            url = LinkAnnotation.Url(
                url = url,
                styles = TextLinkStyles(
                    style = SpanStyle(
                        color = color,
                        textDecoration = TextDecoration.Underline
                    )
                )
            ),
            start = start,
            end = length
        )
    }
    Text(
        text = annotatedText,
        modifier = modifier
            .sizeIn(minWidth = 48.dp, minHeight = 48.dp)
            .let { finalModifier ->
                if (contentDescription != null) {
                    finalModifier.semantics { this.contentDescription = contentDescription }
                } else {
                    finalModifier
                }
            },
        style = style.style,
        color = color,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = overflow
    )
}

/**
 * Overload of PaletteUrlText that accepts a string resource.
 *
 * @param textRes The string resource ID to display.
 * @param modifier Modifier for layout adjustments.
 * @param style The text style to apply. Defaults to [PaletteTheme.typography.bodyMedium].
 * @param color The text color. Defaults to MaterialTheme.colorScheme.primary.
 * @param textAlign Optional text alignment.
 * @param maxLines Maximum number of lines to display.
 * @param overflow How to handle text overflow.
 * @param contentDescription Optional content description for accessibility.
 */
@Composable
fun PaletteUrlText(
    @StringRes textRes: Int,
    url: String,
    modifier: Modifier = Modifier,
    style: PaletteTextStyle = PaletteTheme.typographySystem.bodyMedium,
    color: Color = MaterialTheme.colorScheme.primary,
    textAlign: TextAlign? = null,
    maxLines: Int = Int.MAX_VALUE,
    overflow: TextOverflow = TextOverflow.Clip,
    contentDescription: String? = null,
) {
    PaletteUrlText(
        url = url,
        displayText = stringResource(id = textRes),
        modifier = modifier,
        style = style,
        color = color,
        textAlign = textAlign,
        maxLines = maxLines,
        overflow = overflow,
        contentDescription = contentDescription
    )
}
