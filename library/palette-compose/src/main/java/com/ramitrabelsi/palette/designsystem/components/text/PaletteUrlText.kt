package com.ramitrabelsi.palette.designsystem.components.text

import android.content.Intent
import android.net.Uri
import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import com.ramitrabelsi.palette.PaletteTheme
import com.ramitrabelsi.palette.designsystem.designtokens.typography.PaletteTextStyle

private const val TAG_URL = "URL"
private const val DEFAULT_CONTENT_DESCRIPTION = "Clickable URL Text"

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
 * @param contentDescription Optional content description for accessibility.
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
    contentDescription: String? = DEFAULT_CONTENT_DESCRIPTION,
) {
    val context = LocalContext.current
    val annotatedText = buildAnnotatedString {
        append(displayText)
        addStyle(
            style = SpanStyle(color = color, textDecoration = TextDecoration.Underline),
            start = 0,
            end = displayText.length
        )
        addStringAnnotation(
            tag = TAG_URL,
            annotation = url,
            start = 0,
            end = displayText.length
        )
    }
    Text(
        text = annotatedText,
        modifier = modifier
            .clickable {
                annotatedText.getStringAnnotations(TAG_URL, 0, annotatedText.length)
                    .firstOrNull()?.let { annotation ->
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(annotation.item))
                        context.startActivity(intent)
                    }
            }.let { finalModifier ->
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
    contentDescription: String? = DEFAULT_CONTENT_DESCRIPTION,
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
