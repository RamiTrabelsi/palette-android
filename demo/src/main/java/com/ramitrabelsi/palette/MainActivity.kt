package com.ramitrabelsi.palette

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
            var isDark by rememberSaveable { mutableStateOf(false) }
            PaletteTheme(isDarkMode = isDark) {
                PaletteShowcaseApp(
                    isDarkTheme = isDark,
                    onToggleTheme = { isDark = !isDark }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PaletteTheme {
        PaletteShowcaseApp(
            isDarkTheme = false,
            onToggleTheme = {}
        )
    }
}
