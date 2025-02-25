@file:OptIn(ExperimentalMaterial3Api::class)

package com.ramitrabelsi.palette.designsystem.patterns.templates

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.ramitrabelsi.palette.designsystem.blocks.PaletteContentBlock
import com.ramitrabelsi.palette.designsystem.patterns.topappbar.PaletteTopAppBar
import com.ramitrabelsi.palette_compose.R

/**
 * PaletteErrorScreenTemplate composes multiple Palette components and a design system block to
 * form a full-page error screen.
 *
 * It integrates:
 * - A PaletteTopAppBar for the header.
 * - A PaletteContentBlock for error content (image, title, description, and a retry action).
 *
 * @param errorMessage The error message to display in the content block.
 * @param onRetry Callback triggered when the user taps the "Retry" button.
 * @param modifier Modifier for layout adjustments.
 * @param errorImageRes Optional drawable resource ID for an error image.
 * @param errorImageUrl Optional URL for an error image; takes precedence over [errorImageRes] if
 *        provided.
 * @param onNavigationClick Optional callback for the navigation (back) icon.
 */
@Composable
fun PaletteErrorScreenTemplate(
    errorMessage: String,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier,
    @DrawableRes errorImageRes: Int? = null,
    errorImageUrl: String? = null,
    onNavigationClick: (() -> Unit)? = null,
) {
    Column(modifier = modifier.fillMaxSize()) {
        // Header using the PaletteTopAppBar pattern
        PaletteTopAppBar(
            title = stringResource(R.string.palette_error_screen_title),
            onNavigationClick = onNavigationClick
        )
        // Content block for error message and retry action
        PaletteContentBlock(
            title = stringResource(R.string.palette_error_screen_content_header),
            description = errorMessage,
            imageRes = errorImageRes,
            imageUrl = errorImageUrl,
            onActionClick = onRetry,
            actionText = stringResource(R.string.palette_error_screen_cta),
            modifier = Modifier.weight(1f)
        )
    }
}
