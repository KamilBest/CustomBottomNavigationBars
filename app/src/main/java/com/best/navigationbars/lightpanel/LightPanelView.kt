package com.best.navigationbars.lightpanel

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.best.navigationbars.lightpanel.builder.LightRayViewSetup

@Composable
fun LightPanelView(
    lightRayViewSetupConfig: LightRayViewSetup,
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
    val lightGradient = LightRayGradient.getLightGradient(lightRayViewSetupConfig.lightColor)
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