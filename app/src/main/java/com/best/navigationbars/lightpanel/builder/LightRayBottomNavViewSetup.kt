package com.best.navigationbars.lightpanel.builder

import androidx.compose.ui.graphics.Color

class LightRayBottomNavViewSetup private constructor(
    val iconColor: Color,
    val selectedIconColor: Color,
    val lightRayViewSetup: LightRayViewSetup,
    val iconScale: Float,
    val selectedIconScale: Float,
    val moveLightRayAnimationTweenDuration: Int
) {
    data class Builder(
        var iconColor: Color = Color.Gray,
        var selectedIconColor: Color = Color.White,
        var iconScale: Float = DEFAULT_ICON_SCALE,
        var selectedIconScale: Float = DEFAULT_SELECTED_ICON_SCALE,
        var moveLightRayAnimationTweenDuration: Int = DEFAULT_MOVE_LIGHT_RAY_ANIMATION_TWEEN_DURATION,
        var lightRayViewSetup: LightRayViewSetup = LightRayViewSetup.Builder().build()
    ) {
        fun iconColor(iconColor: Color) =
            apply { this.iconColor = iconColor }

        fun selectedIconColor(selectedIconColor: Color) =
            apply { this.selectedIconColor = selectedIconColor }

        fun lightRayViewSetup(lightRayViewSetup: LightRayViewSetup) =
            apply { this.lightRayViewSetup = lightRayViewSetup }

        fun iconScale(iconScale: Float) = apply { this.iconScale = iconScale }

        fun selectedIconScale(selectedIconScale: Float) =
            apply { this.selectedIconScale = selectedIconScale }

        fun moveLightRayAnimationTweenDuration(moveLightRayAnimationTweenDuration: Int) =
            apply { this.moveLightRayAnimationTweenDuration = moveLightRayAnimationTweenDuration }


        fun build() = LightRayBottomNavViewSetup(
            iconColor = iconColor,
            selectedIconColor = selectedIconColor,
            lightRayViewSetup = lightRayViewSetup,
            iconScale = iconScale,
            selectedIconScale = selectedIconScale,
            moveLightRayAnimationTweenDuration = moveLightRayAnimationTweenDuration
        )

        companion object {
            const val DEFAULT_ICON_SCALE = 1F
            const val DEFAULT_SELECTED_ICON_SCALE = 1.1F
            const val DEFAULT_MOVE_LIGHT_RAY_ANIMATION_TWEEN_DURATION = 600
        }
    }
}