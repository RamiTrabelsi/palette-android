package com.ramitrabelsi.palette

import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import com.ramitrabelsi.palette.designsystem.components.button.PaletteButton
import com.ramitrabelsi.palette.designsystem.components.icon.PaletteIcon
import com.ramitrabelsi.palette.designsystem.components.icon.PaletteIconButton
import com.ramitrabelsi.palette.designsystem.designtokens.icon.PaletteIconAsset
import com.ramitrabelsi.palette.designsystem.patterns.card.PaletteCard
import org.junit.Rule
import org.junit.Test

class PaletteAccessibilityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<PaletteTestActivity>()

    @Test
    fun iconButton_exposesContextualAccessibleNameAndAction() {
        composeTestRule.setContent {
            PaletteTheme {
                PaletteIconButton(
                    onClick = {},
                    icon = PaletteIconAsset.Settings,
                    accessibilityLabel = "Open payment settings"
                )
            }
        }

        composeTestRule
            .onNodeWithContentDescription("Open payment settings")
            .assertHasClickAction()
    }

    @Test
    fun standaloneIcon_isDecorativeByDefault() {
        composeTestRule.setContent {
            PaletteTheme {
                PaletteIcon(icon = PaletteIconAsset.Favorite)
            }
        }

        composeTestRule
            .onNodeWithContentDescription("Favorite")
            .assertDoesNotExist()
    }

    @Test
    fun loadingButton_keepsItsNameAndAnnouncesItsState() {
        composeTestRule.setContent {
            PaletteTheme {
                PaletteButton(
                    onClick = {},
                    text = "Confirm payment",
                    isLoading = true
                )
            }
        }

        composeTestRule
            .onNodeWithContentDescription("Confirm payment")
            .assertIsNotEnabled()
            .assert(
                SemanticsMatcher.expectValue(
                    SemanticsProperties.StateDescription,
                    "Loading"
                )
            )
    }

    @Test
    fun cardTitle_isExposedAsHeading() {
        composeTestRule.setContent {
            PaletteTheme {
                PaletteCard(title = "Recent payments")
            }
        }

        composeTestRule
            .onNodeWithText("Recent payments")
            .assert(SemanticsMatcher.keyIsDefined(SemanticsProperties.Heading))
    }
}
