package com.ramitrabelsi.palette.designsystem.designtokens.typography

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

/**
 * PaletteTextStyle restricts typography to the allowed text styles in the Palette Design System.
 *
 * Use only these predefined styles (e.g. DisplayLarge, BodyMedium, Caption) to ensure consistent
 * typography.
 */
@Immutable
sealed class PaletteTextStyle(@Stable val style: TextStyle) {

    @Stable
    data object DisplayLarge : PaletteTextStyle(
        TextStyle(
            fontSize = 57.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.SansSerif,
            lineHeight = 64.sp
        )
    )

    @Stable
    data object DisplayMedium : PaletteTextStyle(
        TextStyle(
            fontSize = 45.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.SansSerif,
            lineHeight = 52.sp
        )
    )

    @Stable
    data object DisplaySmall : PaletteTextStyle(
        TextStyle(
            fontSize = 36.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.SansSerif,
            lineHeight = 44.sp
        )
    )

    @Stable
    data object HeadlineLarge : PaletteTextStyle(
        TextStyle(
            fontSize = 32.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.SansSerif,
            lineHeight = 40.sp
        )
    )

    @Stable
    data object HeadlineMedium : PaletteTextStyle(
        TextStyle(
            fontSize = 28.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.SansSerif,
            lineHeight = 36.sp
        )
    )

    @Stable
    data object HeadlineSmall : PaletteTextStyle(
        TextStyle(
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.SansSerif,
            lineHeight = 32.sp
        )
    )

    @Stable
    data object TitleLarge : PaletteTextStyle(
        TextStyle(
            fontSize = 22.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily.SansSerif,
            lineHeight = 28.sp
        )
    )

    @Stable
    data object TitleMedium : PaletteTextStyle(
        TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily.SansSerif,
            lineHeight = 24.sp
        )
    )

    @Stable
    data object TitleSmall : PaletteTextStyle(
        TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily.SansSerif,
            lineHeight = 20.sp
        )
    )

    @Stable
    data object BodyLarge : PaletteTextStyle(
        TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.SansSerif,
            lineHeight = 24.sp
        )
    )

    @Stable
    data object BodyMedium : PaletteTextStyle(
        TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.SansSerif,
            lineHeight = 20.sp
        )
    )

    @Stable
    data object BodySmall : PaletteTextStyle(
        TextStyle(
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.SansSerif,
            lineHeight = 16.sp
        )
    )

    @Stable
    data object LabelLarge : PaletteTextStyle(
        TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily.SansSerif,
            lineHeight = 20.sp
        )
    )

    @Stable
    data object LabelMedium : PaletteTextStyle(
        TextStyle(
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily.SansSerif,
            lineHeight = 16.sp
        )
    )

    @Stable
    data object LabelSmall : PaletteTextStyle(
        TextStyle(
            fontSize = 11.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily.SansSerif,
            lineHeight = 16.sp
        )
    )

    // Extended Typography Tokens
    @Stable
    data object Hero : PaletteTextStyle(
        TextStyle(
            fontSize = 64.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif,
            lineHeight = 72.sp
        )
    )

    @Stable
    data object SectionTitle : PaletteTextStyle(
        TextStyle(
            fontSize = 26.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily.SansSerif,
            lineHeight = 32.sp
        )
    )

    @Stable
    data object Subtitle : PaletteTextStyle(
        TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.SansSerif,
            lineHeight = 24.sp
        )
    )

    @Stable
    data object Button : PaletteTextStyle(
        TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily.SansSerif,
            letterSpacing = 1.25.sp
        )
    )

    @Stable
    data object Caption : PaletteTextStyle(
        TextStyle(
            fontSize = 12.sp,
            fontWeight = FontWeight.Light,
            fontFamily = FontFamily.SansSerif,
            lineHeight = 16.sp
        )
    )

    @Stable
    data object Overline : PaletteTextStyle(
        TextStyle(
            fontSize = 10.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily.SansSerif,
            letterSpacing = 1.5.sp
        )
    )
}
