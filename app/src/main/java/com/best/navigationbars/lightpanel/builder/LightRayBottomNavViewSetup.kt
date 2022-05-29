package com.best.navigationbars.lightpanel.builder

import androidx.compose.ui.graphics.Color

class LightRayBottomNavViewSetup private constructor(
    val iconColor: Color,
    val selectedIconColor: Color,
    val lightRayViewSetup: LightRayViewSetup,
) {

    data class Builder(
        var iconColor: Color = Color.Gray,
        var selectedIconColor: Color = Color.White,
        var lightRayViewSetup: LightRayViewSetup = LightRayViewSetup.Builder()
            .build()
    ) {
        fun iconColor(iconColor: Color) =
            apply { this.iconColor = iconColor }

        fun selectedIconColor(selectedIconColor: Color) =
            apply { this.selectedIconColor = selectedIconColor }

        fun lightRayViewSetup(lightRayViewSetup: LightRayViewSetup) =
            apply { this.lightRayViewSetup = lightRayViewSetup }

        fun build() = LightRayBottomNavViewSetup(
            iconColor = iconColor,
            selectedIconColor = selectedIconColor,
            lightRayViewSetup = lightRayViewSetup
        )
    }
}