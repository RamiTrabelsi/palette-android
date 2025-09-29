package com.ramitrabelsi.palette.designsystem.patterns.analytics

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.ramitrabelsi.palette.PaletteTheme
import com.ramitrabelsi.palette.designsystem.components.badge.PaletteBadge
import com.ramitrabelsi.palette.designsystem.components.badge.PaletteBadgeType
import com.ramitrabelsi.palette.designsystem.components.icon.PaletteIcon
import com.ramitrabelsi.palette.designsystem.components.text.PaletteText
import com.ramitrabelsi.palette.designsystem.designtokens.icon.PaletteIconAsset
import com.ramitrabelsi.palette.designsystem.tokens.dimensions.PaletteDimension

/**
 * PaletteStatisticCard is a compact data visualization helper designed for community dashboards.
 *
 * It bundles together typography tokens, color semantics and spatial rhythm so teams can quickly
 * surface metrics, growth rates or highlight numbers without reimplementing a pattern from scratch.
 */
@Composable
fun PaletteStatisticCard(
    title: String,
    primaryValue: String,
    modifier: Modifier = Modifier,
    icon: PaletteIconAsset? = null,
    supportingText: String? = null,
    trendLabel: String? = null,
    trendType: PaletteStatisticTrend = PaletteStatisticTrend.Neutral,
    onClick: (() -> Unit)? = null,
) {
    val containerColor = MaterialTheme.colorScheme.surfaceVariant
    val contentColor = MaterialTheme.colorScheme.onSurfaceVariant

    val cardColors = CardDefaults.cardColors(
        containerColor = containerColor,
        contentColor = contentColor
    )
    val elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)

    val cardContent: @Composable () -> Unit = {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(PaletteDimension.Spacing16),
            verticalArrangement = Arrangement.spacedBy(PaletteDimension.Spacing12)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(PaletteDimension.Spacing12)
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    PaletteText(
                        text = title,
                        style = PaletteTheme.typographySystem.subtitle,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    supportingText?.let {
                        PaletteText(
                            text = it,
                            style = PaletteTheme.typographySystem.bodySmall,
                            color = contentColor.copy(alpha = 0.8f),
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }
                if (icon != null) {
                    PaletteIcon(
                        icon = icon,
                        size = PaletteDimension.IconSize.Size32,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }

            PaletteText(
                text = primaryValue,
                style = PaletteTheme.typographySystem.hero,
                color = MaterialTheme.colorScheme.primary
            )

            if (trendLabel != null) {
                val badgeType = when (trendType) {
                    PaletteStatisticTrend.Positive -> PaletteBadgeType.Success
                    PaletteStatisticTrend.Negative -> PaletteBadgeType.Danger
                    PaletteStatisticTrend.Neutral -> PaletteBadgeType.Neutral
                }
                PaletteBadge(
                    text = trendLabel,
                    type = badgeType
                )
            }
        }
    }

    if (onClick != null) {
        Card(
            onClick = onClick,
            modifier = modifier,
            shape = PaletteTheme.shapeSystem.card,
            colors = cardColors,
            elevation = elevation,
        ) { cardContent() }
    } else {
        Card(
            modifier = modifier,
            shape = PaletteTheme.shapeSystem.card,
            colors = cardColors,
            elevation = elevation,
        ) { cardContent() }
    }
}

/**
 * Represents how the [PaletteStatisticCard] should color the change badge.
 */
enum class PaletteStatisticTrend {
    Positive,
    Negative,
    Neutral,
}
