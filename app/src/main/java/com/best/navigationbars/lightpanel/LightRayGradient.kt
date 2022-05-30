package com.best.navigationbars.lightpanel

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

object LightRayGradient {
    private const val GRADIENT_MAX_RANGE = 140.0F

    fun getLightGradient(lightColor: Color) = Brush.verticalGradient(
        listOf(
            Color.Transparent,
            lightColor.copy(alpha = 0.1F),
            lightColor.copy(alpha = 0.3F),
            lightColor
        ),
        startY = 0F,
        endY = GRADIENT_MAX_RANGE
    )
}