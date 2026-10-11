package com.example.e3_listacomida.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = BlueGrey80,
    onPrimary = BlueGreyOn80,
    secondary = BlueGreySecondary80,
    tertiary = OfertaAzulClaro,
    background = BlueGreyBackgroundDark,
    surface = BlueGreyBackgroundDark,
    onBackground = BlueGreyOnSurfaceDark,
    onSurface = BlueGreyOnSurfaceDark,
    surfaceVariant = BlueGreyCardDark,
    onSurfaceVariant = BlueGreyOnCardDark
)

private val LightColorScheme = lightColorScheme(
    primary = BlueGrey40,
    onPrimary = BlueGreyOn40,
    secondary = BlueGreySecondary40,
    tertiary = OfertaAzul,
    background = BlueGreyBackground,
    surface = BlueGreyBackground,
    onBackground = BlueGreyOnSurface,
    onSurface = BlueGreyOnSurface,
    surfaceVariant = BlueGreyCard,
    onSurfaceVariant = BlueGreyOnCard
)

@Composable
fun E3_listacomidaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}