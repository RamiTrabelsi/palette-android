package com.ramitrabelsi.palette.designsystem.components.image

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ramitrabelsi.palette.PaletteTheme

/**
 * PaletteImage displays an image styled according to the Palette Design System.
 *
 * This overload loads an image from a drawable resource.
 *
 * @param imageRes The drawable resource ID for the image.
 * @param modifier Modifier for layout adjustments.
 * @param contentDescription Optional description for accessibility.
 * @param contentScale How to scale the image; defaults to [ContentScale.Crop].
 * @param shape The shape to clip the image; defaults to [PaletteTheme.shapeSystem.card].
 * @param borderWidth Optional border width. Defaults to 0.dp (no border).
 * @param borderColor Optional border color. Defaults to [Color.Transparent].
 */
@Composable
fun PaletteImage(
    @DrawableRes imageRes: Int,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    contentScale: ContentScale = ContentScale.Crop,
    shape: Shape = PaletteTheme.shapeSystem.card,
    borderWidth: Dp = 0.dp,
    borderColor: Color = Color.Transparent,
) {
    Image(
        painter = painterResource(id = imageRes),
        contentDescription = contentDescription,
        contentScale = contentScale,
        modifier = modifier
            .fillMaxWidth()
            .clip(shape)
            .then(
                if (borderWidth > 0.dp) Modifier.border(
                    width = borderWidth,
                    color = borderColor,
                    shape = shape
                ) else Modifier
            )
    )
}

/**
 * PaletteImage loads an image from a URL and displays it with Palette styling.
 *
 * This overload uses Coil's AsyncImage to load the image.
 *
 * @param imageUrl The URL of the image to display.
 * @param modifier Modifier for layout adjustments.
 * @param contentDescription Optional description for accessibility.
 * @param contentScale How to scale the image; defaults to [ContentScale.Crop].
 * @param shape The shape to clip the image; defaults to [PaletteTheme.shapeSystem.card].
 * @param borderWidth Optional border width. Defaults to 0.dp (no border).
 * @param borderColor Optional border color. Defaults to [Color.Transparent].
 */
@Composable
fun PaletteImage(
    imageUrl: String,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    contentScale: ContentScale = ContentScale.Crop,
    shape: Shape = PaletteTheme.shapeSystem.card,
    borderWidth: Dp = 0.dp,
    borderColor: Color = Color.Transparent,
) {
    AsyncImage(
        model = imageUrl,
        contentDescription = contentDescription,
        contentScale = contentScale,
        modifier = modifier
            .fillMaxWidth()
            .clip(shape)
            .then(
                if (borderWidth > 0.dp) Modifier.border(
                    width = borderWidth,
                    color = borderColor,
                    shape = shape
                ) else Modifier
            )
    )
}
