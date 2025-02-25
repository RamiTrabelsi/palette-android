package com.ramitrabelsi.palette.designsystem.patterns.card

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ramitrabelsi.palette.PaletteTheme
import com.ramitrabelsi.palette.designsystem.components.text.PaletteText
import com.ramitrabelsi.palette.designsystem.tokens.dimensions.PaletteDimension

/**
 * PaletteCard is a reusable card pattern that combines design tokens (colors, shapes, and spacing)
 * with components to form a cohesive UI element.
 *
 * @param title The title text displayed on the card.
 * @param content Optional content composable for additional details.
 * @param onClick Optional click action for the card.
 * @param modifier Modifier for layout adjustments.
 */
@Composable
fun PaletteCard(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable (() -> Unit)? = null,
    onClick: (() -> Unit)? = null,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable(enabled = onClick != null) { onClick?.invoke() },
        shape = PaletteTheme.shapeSystem.card,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(PaletteDimension.Spacing16)
        ) {
            PaletteText(
                text = title,
                style = PaletteTheme.typographySystem.titleMedium
            )
            content?.invoke()
        }
    }
}
