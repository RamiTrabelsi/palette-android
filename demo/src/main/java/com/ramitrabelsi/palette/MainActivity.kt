package com.ramitrabelsi.palette

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.ramitrabelsi.palette.demo.PaletteShowcaseApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val systemIsDark = isSystemInDarkTheme()
            var isDark by rememberSaveable { mutableStateOf(systemIsDark) }
            PaletteTheme(isDarkMode = isDark) {
                PaletteShowcaseApp(
                    isDarkTheme = isDark,
                    onToggleTheme = { isDark = !isDark }
                )
            }
        }
    }
}

@Preview(name = "Light theme", showBackground = true)
@Composable
fun PaletteShowcaseLightPreview() {
    PaletteTheme(isDarkMode = false) {
        PaletteShowcaseApp(
            isDarkTheme = false,
            onToggleTheme = {}
        )
    }
}

@Preview(
    name = "Dark theme",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun PaletteShowcaseDarkPreview() {
    PaletteTheme(isDarkMode = true) {
        PaletteShowcaseApp(
            isDarkTheme = true,
            onToggleTheme = {}
        )
    }
}
