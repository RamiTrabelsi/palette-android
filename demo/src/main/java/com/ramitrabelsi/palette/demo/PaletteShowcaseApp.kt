package com.ramitrabelsi.palette.demo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.coerceAtLeast
import com.ramitrabelsi.palette.PaletteTheme
import com.ramitrabelsi.palette.designsystem.blocks.PaletteContentBlock
import com.ramitrabelsi.palette.designsystem.components.badge.PaletteBadge
import com.ramitrabelsi.palette.designsystem.components.badge.PaletteBadgeType
import com.ramitrabelsi.palette.designsystem.components.button.PaletteButton
import com.ramitrabelsi.palette.designsystem.components.button.PaletteButtonSize
import com.ramitrabelsi.palette.designsystem.components.button.PaletteButtonType
import com.ramitrabelsi.palette.designsystem.components.icon.PaletteIcon
import com.ramitrabelsi.palette.designsystem.components.icon.PaletteIconButton
import com.ramitrabelsi.palette.designsystem.components.image.PaletteImage
import com.ramitrabelsi.palette.designsystem.components.text.PaletteText
import com.ramitrabelsi.palette.designsystem.components.text.PaletteUrlText
import com.ramitrabelsi.palette.designsystem.designtokens.icon.PaletteIconAsset
import com.ramitrabelsi.palette.designsystem.designtokens.typography.PaletteTextStyle
import com.ramitrabelsi.palette.designsystem.patterns.analytics.PaletteStatisticCard
import com.ramitrabelsi.palette.designsystem.patterns.analytics.PaletteStatisticTrend
import com.ramitrabelsi.palette.designsystem.patterns.card.PaletteCard
import com.ramitrabelsi.palette.designsystem.patterns.topappbar.PaletteTopAppBar
import com.ramitrabelsi.palette.designsystem.patterns.templates.PaletteErrorScreenTemplate
import com.ramitrabelsi.palette.designsystem.tokens.dimensions.PaletteDimension
import kotlin.math.roundToInt

/**
 * The main entry point for the demo application, showcasing Palette's design tokens and components.
 */
@Composable
fun PaletteShowcaseApp(
    isDarkTheme: Boolean,
    onToggleTheme: () -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedSection by rememberSaveable { mutableStateOf(PaletteDemoSection.Tokens) }
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            PaletteTopAppBar(
                title = "Palette Showcase",
                actions = {
                    PaletteBadge(
                        text = if (isDarkTheme) "Dark mode" else "Light mode",
                        type = PaletteBadgeType.Primary
                    )
                    PaletteIconButton(
                        onClick = onToggleTheme,
                        icon = PaletteIconAsset.Settings
                    )
                }
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)) {
            TabRow(
                selectedTabIndex = selectedSection.ordinal,
                containerColor = MaterialTheme.colorScheme.surface
            ) {
                PaletteDemoSection.values().forEach { section ->
                    Tab(
                        selected = selectedSection == section,
                        onClick = { selectedSection = section },
                        text = {
                            PaletteText(
                                text = section.title,
                                style = PaletteTheme.typographySystem.labelLarge,
                                color = if (selectedSection == section) {
                                    MaterialTheme.colorScheme.primary
                                } else {
                                    MaterialTheme.colorScheme.onSurface
                                }
                            )
                        }
                    )
                }
            }

            when (selectedSection) {
                PaletteDemoSection.Tokens -> TokensShowcase()
                PaletteDemoSection.Components -> ComponentsShowcase()
                PaletteDemoSection.Patterns -> PatternsShowcase()
                PaletteDemoSection.Community -> CommunityShowcase()
            }
        }
    }
}

enum class PaletteDemoSection(val title: String) {
    Tokens("Tokens"),
    Components("Components"),
    Patterns("Patterns"),
    Community("Community Lab")
}

@Composable
private fun TokensShowcase() {
    val colorSystem = PaletteTheme.colorSystem
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(PaletteDimension.Spacing16),
        verticalArrangement = Arrangement.spacedBy(PaletteDimension.Spacing16)
    ) {
        item {
            PaletteCard(title = "Brand & Accent Colors") {
                ColorTokenGrid(
                    colors = listOf(
                        TokenColor(
                            "Accent Primary",
                            colorSystem.accentPrimary,
                            onColor = if (colorSystem.isDark) colorSystem.grayscaleG0 else colorSystem.grayscaleG100
                        ),
                        TokenColor(
                            "Accent Secondary",
                            colorSystem.accentSecondary,
                            onColor = if (colorSystem.isDark) colorSystem.grayscaleG0 else colorSystem.grayscaleG100
                        ),
                        TokenColor(
                            "Accent Tertiary",
                            colorSystem.accentTertiary,
                            onColor = if (colorSystem.isDark) colorSystem.grayscaleG0 else colorSystem.grayscaleG100
                        ),
                    )
                )
            }
        }

        item {
            PaletteCard(title = "Semantic Colors") {
                ColorTokenGrid(
                    colors = listOf(
                        TokenColor("Error", colorSystem.error, onColor = colorSystem.onError),
                        TokenColor("Error Container", colorSystem.errorContainer, onColor = colorSystem.onErrorContainer),
                        TokenColor("Success", colorSystem.success, onColor = colorSystem.onSuccess),
                        TokenColor("Success Container", colorSystem.successContainer, onColor = colorSystem.onSuccessContainer),
                        TokenColor("Warning", colorSystem.warning, onColor = colorSystem.onWarning),
                        TokenColor("Warning Container", colorSystem.warningContainer, onColor = colorSystem.onWarningContainer),
                        TokenColor("Info", colorSystem.info, onColor = colorSystem.onInfo),
                        TokenColor("Info Container", colorSystem.infoContainer, onColor = colorSystem.onInfoContainer),
                    )
                )
            }
        }

        item {
            PaletteCard(title = "Grayscale Tokens") {
                ColorTokenGrid(
                    colors = listOf(
                        TokenColor("G0", colorSystem.grayscaleG0, onColor = colorSystem.grayscaleG100),
                        TokenColor("G20", colorSystem.grayscaleG20, onColor = colorSystem.grayscaleG100),
                        TokenColor("G40", colorSystem.grayscaleG40, onColor = colorSystem.grayscaleG100),
                        TokenColor("G60", colorSystem.grayscaleG60, onColor = colorSystem.grayscaleG0),
                        TokenColor("G80", colorSystem.grayscaleG80, onColor = colorSystem.grayscaleG0),
                        TokenColor("G100", colorSystem.grayscaleG100, onColor = colorSystem.grayscaleG0),
                    )
                )
            }
        }

        item {
            PaletteCard(title = "Typography System") {
                TypographyTokenList()
            }
        }

        item {
            PaletteCard(title = "Spacing Tokens") {
                DimensionTokenColumn(
                    tokens = listOf(
                        "Spacing 0" to PaletteDimension.Spacing0,
                        "Spacing 4" to PaletteDimension.Spacing4,
                        "Spacing 8" to PaletteDimension.Spacing8,
                        "Spacing 12" to PaletteDimension.Spacing12,
                        "Spacing 16" to PaletteDimension.Spacing16,
                        "Spacing 24" to PaletteDimension.Spacing24,
                        "Spacing 32" to PaletteDimension.Spacing32,
                        "Spacing 48" to PaletteDimension.Spacing48,
                    )
                )
            }
        }

        item {
            PaletteCard(title = "Icon Sizes & Corner Radii") {
                IconSizeShowcase()
                Spacer(modifier = Modifier.height(PaletteDimension.Spacing16))
                CornerRadiusShowcase()
            }
        }

        item {
            PaletteCard(title = "Shape System") {
                ShapeShowcase()
            }
        }

        item {
            PaletteCard(title = "Icon Library") {
                IconLibrary()
            }
        }
    }
}

@Composable
private fun ComponentsShowcase() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(PaletteDimension.Spacing16),
        verticalArrangement = Arrangement.spacedBy(PaletteDimension.Spacing16)
    ) {
        item {
            PaletteCard(title = "Buttons") {
                Column(
                    verticalArrangement = Arrangement.spacedBy(PaletteDimension.Spacing12)
                ) {
                    PaletteButton(
                        onClick = {},
                        text = "Primary CTA",
                        type = PaletteButtonType.Primary,
                        isFillContainer = true
                    )
                    PaletteButton(
                        onClick = {},
                        text = "Secondary CTA",
                        type = PaletteButtonType.Secondary,
                        icon = PaletteIconAsset.Favorite,
                        isFillContainer = true
                    )
                    PaletteButton(
                        onClick = {},
                        text = "Ghost Action",
                        type = PaletteButtonType.Ghost,
                        size = PaletteButtonSize.Medium
                    )
                    PaletteButton(
                        onClick = {},
                        text = "Delete",
                        type = PaletteButtonType.Destructive,
                        size = PaletteButtonSize.Small
                    )
                    PaletteButton(
                        onClick = {},
                        text = "Loading...",
                        isLoading = true,
                        isFillContainer = true
                    )
                }
            }
        }

        item {
            PaletteCard(title = "Iconography") {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(PaletteDimension.Spacing12),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    PaletteIconButton(onClick = {}, icon = PaletteIconAsset.Home)
                    PaletteIconButton(onClick = {}, icon = PaletteIconAsset.Search,
                        iconSize = PaletteDimension.IconSize.Size24)
                    PaletteIcon(
                        icon = PaletteIconAsset.Favorite,
                        size = PaletteDimension.IconSize.Size32,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }

        item {
            PaletteCard(title = "Text Components") {
                Column(verticalArrangement = Arrangement.spacedBy(PaletteDimension.Spacing8)) {
                    PaletteText(
                        text = "PaletteText keeps typography in sync with the design tokens.",
                        style = PaletteTheme.typographySystem.bodyLarge
                    )
                    PaletteText(
                        text = "Labels use dedicated styles for metadata.",
                        style = PaletteTheme.typographySystem.labelMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                    PaletteUrlText(
                        url = "https://github.com/ramitrabelsi/palette", 
                        displayText = "Open Palette on GitHub"
                    )
                }
            }
        }

        item {
            PaletteCard(title = "Media") {
                Column(verticalArrangement = Arrangement.spacedBy(PaletteDimension.Spacing12)) {
                    PaletteImage(
                        imageRes = com.ramitrabelsi.palette.demo.R.drawable.ic_launcher_foreground,
                        contentDescription = "Palette mascot"
                    )
                    PaletteImage(
                        imageUrl = "https://images.unsplash.com/photo-1526481280695-3c4691d133d8?auto=format&fit=crop&w=800&q=60",
                        contentDescription = "Remote inspiration",
                        borderWidth = 2.dp,
                        borderColor = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}

@Composable
private fun PatternsShowcase() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(PaletteDimension.Spacing16),
        verticalArrangement = Arrangement.spacedBy(PaletteDimension.Spacing16)
    ) {
        item {
            PaletteCard(title = "Content Block") {
                PaletteContentBlock(
                    title = "Composable content",
                    description = "Blocks are perfect for editorial or marketing layouts. Use them to stitch imagery, typography and CTAs together.",
                    imageUrl = "https://images.unsplash.com/photo-1498050108023-c5249f4df085?auto=format&fit=crop&w=800&q=60",
                    onActionClick = {},
                    actionText = "Read story"
                )
            }
        }

        item {
            PaletteCard(title = "Elevated Card") {
                PaletteCard(
                    title = "PaletteCard inside a PaletteCard",
                    content = {
                        PaletteText(
                            text = "Patterns can be composed together to create sophisticated layouts.",
                            style = PaletteTheme.typographySystem.bodyMedium
                        )
                    }
                )
            }
        }

        item {
            PaletteCard(title = "Error Template") {
                PaletteErrorScreenTemplate(
                    errorMessage = "We couldn't load your projects. Check your connection and try again.",
                    onRetry = {},
                    errorImageUrl = "https://images.unsplash.com/photo-1521737604893-d14cc237f11d?auto=format&fit=crop&w=800&q=60",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(320.dp)
                )
            }
        }
    }
}

@Composable
private fun CommunityShowcase() {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(PaletteDimension.Spacing16),
        verticalArrangement = Arrangement.spacedBy(PaletteDimension.Spacing16)
    ) {
        item {
            PaletteCard(title = "Badges") {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(PaletteDimension.Spacing8),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    PaletteBadge(text = "Featured", type = PaletteBadgeType.Primary)
                    PaletteBadge(text = "Trending", type = PaletteBadgeType.Success)
                    PaletteBadge(text = "Beta", type = PaletteBadgeType.Info)
                    PaletteBadge(text = "Deprecated", type = PaletteBadgeType.Danger)
                }
            }
        }

        item {
            PaletteCard(title = "Analytics Tile") {
                Column(verticalArrangement = Arrangement.spacedBy(PaletteDimension.Spacing16)) {
                    PaletteStatisticCard(
                        title = "Weekly signups",
                        primaryValue = "1,248",
                        supportingText = "A healthy mix of organic and referral traffic.",
                        trendLabel = "▲ 12.4% vs last week",
                        trendType = PaletteStatisticTrend.Positive,
                        icon = PaletteIconAsset.Search
                    )
                    PaletteStatisticCard(
                        title = "Churn rate",
                        primaryValue = "3.1%",
                        supportingText = "Stay below 4% to keep momentum.",
                        trendLabel = "▼ 0.6% vs last month (good)",
                        trendType = PaletteStatisticTrend.Positive,
                        icon = PaletteIconAsset.Favorite
                    )
                    PaletteStatisticCard(
                        title = "Downtime incidents",
                        primaryValue = "3",
                        supportingText = "Track operational debt across squads.",
                        trendLabel = "▲ 2 vs target",
                        trendType = PaletteStatisticTrend.Negative,
                        icon = PaletteIconAsset.Settings
                    )
                }
            }
        }
    }
}

data class TokenColor(
    val name: String,
    val color: Color,
    val onColor: Color
)

@Composable
private fun ColorTokenGrid(colors: List<TokenColor>) {
    Column(verticalArrangement = Arrangement.spacedBy(PaletteDimension.Spacing12)) {
        colors.chunked(3).forEach { rowColors ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(PaletteDimension.Spacing12),
                modifier = Modifier.fillMaxWidth()
            ) {
                rowColors.forEach { token ->
                    ColorTokenItem(token, modifier = Modifier.weight(1f))
                }
                repeat(3 - rowColors.size) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}

@Composable
private fun ColorTokenItem(token: TokenColor, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(PaletteDimension.Spacing4)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .clip(PaletteTheme.shapeSystem.medium)
                .background(token.color),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = token.name,
                color = token.onColor,
                fontWeight = FontWeight.Bold
            )
        }
        PaletteText(
            text = "${token.name} - ${token.color.toHex()}",
            style = PaletteTheme.typographySystem.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Composable
private fun TypographyTokenList() {
    val typography = PaletteTheme.typographySystem
    val typographyMap = listOf(
        "Hero" to typography.hero,
        "Display Large" to typography.displayLarge,
        "Display Medium" to typography.displayMedium,
        "Display Small" to typography.displaySmall,
        "Headline Large" to typography.headlineLarge,
        "Headline Medium" to typography.headlineMedium,
        "Headline Small" to typography.headlineSmall,
        "Title Large" to typography.titleLarge,
        "Title Medium" to typography.titleMedium,
        "Title Small" to typography.titleSmall,
        "Body Large" to typography.bodyLarge,
        "Body Medium" to typography.bodyMedium,
        "Body Small" to typography.bodySmall,
        "Label Large" to typography.labelLarge,
        "Label Medium" to typography.labelMedium,
        "Label Small" to typography.labelSmall,
        "Section Title" to typography.sectionTitle,
        "Subtitle" to typography.subtitle,
        "Button" to typography.button,
        "Caption" to typography.caption,
        "Overline" to typography.overline,
    )

    Column(verticalArrangement = Arrangement.spacedBy(PaletteDimension.Spacing12)) {
        typographyMap.forEach { (label, style) ->
            TypographyTokenRow(label = label, style = style)
        }
    }
}

@Composable
private fun TypographyTokenRow(label: String, style: PaletteTextStyle) {
    Column(verticalArrangement = Arrangement.spacedBy(PaletteDimension.Spacing4)) {
        PaletteText(
            text = label,
            style = PaletteTheme.typographySystem.labelSmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        PaletteText(
            text = "Grumpy wizards make toxic brew for the evil Queen and Jack.",
            style = style
        )
    }
}

@Composable
private fun DimensionTokenColumn(tokens: List<Pair<String, Dp>>) {
    Column(verticalArrangement = Arrangement.spacedBy(PaletteDimension.Spacing12)) {
        tokens.forEach { (label, value) ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(PaletteDimension.Spacing12)
            ) {
                Box(
                    modifier = Modifier
                        .height(12.dp)
                        .width(value.coerceAtLeast(1.dp))
                        .clip(PaletteTheme.shapeSystem.small)
                        .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.4f))
                )
                PaletteText(
                    text = "$label = ${value.value.roundToInt()}dp",
                    style = PaletteTheme.typographySystem.bodyMedium
                )
            }
        }
    }
}

@Composable
private fun IconSizeShowcase() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(PaletteDimension.Spacing16),
        verticalAlignment = Alignment.CenterVertically
    ) {
        PaletteDimension.IconSize.values().forEach { iconSize ->
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                PaletteIcon(
                    icon = PaletteIconAsset.Home,
                    size = iconSize,
                    tint = MaterialTheme.colorScheme.primary
                )
                PaletteText(
                    text = "${iconSize.name.replace("Size", "")} dp",
                    style = PaletteTheme.typographySystem.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
private fun CornerRadiusShowcase() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(PaletteDimension.Spacing12),
        verticalAlignment = Alignment.CenterVertically
    ) {
        PaletteDimension.CornerRadius.values().forEach { radius ->
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(
                    modifier = Modifier
                        .size(56.dp)
                        .clip(androidx.compose.foundation.shape.RoundedCornerShape(radius.dp))
                        .background(MaterialTheme.colorScheme.secondaryContainer)
                )
                PaletteText(
                    text = "${radius.name.replace("Radius", "")}",
                    style = PaletteTheme.typographySystem.labelSmall,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
private fun ShapeShowcase() {
    val shapes = listOf(
        "Small" to PaletteTheme.shapeSystem.small,
        "Medium" to PaletteTheme.shapeSystem.medium,
        "Large" to PaletteTheme.shapeSystem.large,
        "Card" to PaletteTheme.shapeSystem.card,
        "Dialog" to PaletteTheme.shapeSystem.dialog,
        "Button" to PaletteTheme.shapeSystem.button,
    )

    Column(verticalArrangement = Arrangement.spacedBy(PaletteDimension.Spacing12)) {
        shapes.forEach { (label, shape) ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(PaletteDimension.Spacing12)
            ) {
                Box(
                    modifier = Modifier
                        .size(width = 96.dp, height = 56.dp)
                        .clip(shape)
                        .background(MaterialTheme.colorScheme.surfaceVariant)
                )
                PaletteText(
                    text = label,
                    style = PaletteTheme.typographySystem.bodyMedium
                )
            }
        }
    }
}

@Composable
private fun IconLibrary() {
    val icons = listOf(
        PaletteIconAsset.Home,
        PaletteIconAsset.Favorite,
        PaletteIconAsset.Search,
        PaletteIconAsset.Settings,
        PaletteIconAsset.BackArrow
    )

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(PaletteDimension.Spacing24)
    ) {
        icons.forEach { icon ->
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                PaletteIcon(
                    icon = icon,
                    size = PaletteDimension.IconSize.Size32,
                    tint = MaterialTheme.colorScheme.onSurface
                )
                PaletteText(
                    text = icon.nameForAccessibility,
                    style = PaletteTheme.typographySystem.labelSmall,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

private fun Color.toHex(): String {
    val intColor = this.toArgb()
    return "#%02X%02X%02X".format(
        (intColor shr 16) and 0xFF,
        (intColor shr 8) and 0xFF,
        intColor and 0xFF
    )
}
