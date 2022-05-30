package com.best.navigationbars.lightpanel.builder

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

class LightRayViewSetup private constructor(
    val width: Dp,
    val height: Dp,
    val panelHeight: Dp,
    val panelColor: Color,
    val lightColor: Color,
    val itemWidthRatio: Float
) {

    data class Builder(
        var width: Dp = DEFAULT_WIDTH.dp,
        var height: Dp = DEFAULT_HEIGHT.dp,
        var panelHeight: Dp = DEFAULT_PANEL_HEIGHT.dp,
        var lightColor: Color = Color(DEFAULT_COLOR),
        var lightPanelColor: Color = Color(DEFAULT_PANEL_COLOR),
        var itemWidthRatio: Float = DEFAULT_ITEM_WIDTH_RATIO
    ) {
        fun lightPanelColor(lightPanelColor: Color) =
            apply { this.lightPanelColor = lightPanelColor }

        fun lightColor(lightColor: Color) =
            apply { this.lightColor = lightColor }

        fun build() = LightRayViewSetup(width = width, height = height, panelHeight = panelHeight, panelColor = lightPanelColor, lightColor = lightColor, itemWidthRatio = itemWidthRatio)

        companion object {
            const val DEFAULT_WIDTH = 48
            const val DEFAULT_HEIGHT = 50
            const val DEFAULT_PANEL_HEIGHT = 2
            const val DEFAULT_COLOR = 0xFFE6E6E6
            const val DEFAULT_PANEL_COLOR = 0xFFFFFFFF
            const val DEFAULT_ITEM_WIDTH_RATIO = 4.0F

        }
    }
}