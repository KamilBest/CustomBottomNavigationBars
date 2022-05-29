package com.best.navigationbars.lightpanel

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.best.navigationbars.lightpanel.builder.LightRayViewSetup

@Composable
fun LightPanelView(lightRayViewSetupConfig: LightRayViewSetup,
                   offsetAnimation: Dp,
) {
    Box(
        modifier = Modifier
            .wrapContentSize()
            .offset(x = offsetAnimation), contentAlignment = Alignment.Center
    ) {
        LightPanelCanvas(lightRayViewSetupConfig)
    }
}

@Composable
fun LightPanelCanvas(lightRayViewSetupConfig: LightRayViewSetup) {
    val lightGradient = getLightGradient(lightRayViewSetupConfig.lightColor)
    val panelCornerRadius = 20.dp
    Canvas(
        modifier = Modifier
            .width(lightRayViewSetupConfig.width)
            .height(lightRayViewSetupConfig.height), onDraw =
        {

            val width = lightRayViewSetupConfig.width.toPx()
            val height = lightRayViewSetupConfig.height.toPx()
            val trapezoidPath = Path().apply {
                moveTo(0f, 0f)
                lineTo(0f, 0f)
                lineTo(width, 0f)
                lineTo(width - (width / lightRayViewSetupConfig.itemWidthRatio), height)
                lineTo((width / lightRayViewSetupConfig.itemWidthRatio), height)
                close()
            }

            drawPath(path = trapezoidPath, brush = lightGradient)
            drawRoundRect(
                lightRayViewSetupConfig.panelColor, size = Size(
                    width = (width / (lightRayViewSetupConfig.itemWidthRatio / 2)),
                    height = lightRayViewSetupConfig.panelHeight.toPx()
                ), topLeft = Offset(
                    x = (width / lightRayViewSetupConfig.itemWidthRatio),
                    y = height
                ), cornerRadius = CornerRadius(
                    x = panelCornerRadius.toPx(),
                    y = panelCornerRadius.toPx()
                )
            )
        })
}

const val ALMOST_TRANSPARENT_ALPHA = 0.1F
const val ONE_THIRD_ALPHA = 0.3F
const val MAX_Y_OF_GRADIENT = 135.0F

private fun getLightGradient(lightColor: Color) = Brush.verticalGradient(
    listOf(
        Color.Transparent,
        lightColor.copy(alpha = ALMOST_TRANSPARENT_ALPHA),
        lightColor.copy(alpha = ONE_THIRD_ALPHA),
        lightColor
    ),
    startY = 0F,
    endY = MAX_Y_OF_GRADIENT
)
