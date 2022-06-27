package com.best.navigationbars.lightpanel

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.best.navigationbars.lightpanel.builder.LightRayBottomNavViewSetup
import com.best.navigationbars.model.NavigationBarItem
import com.best.navigationbars.model.NavigationBarItems


@Composable
fun LightRayBottomNavView(
    lightRayBottomNavViewSetup: LightRayBottomNavViewSetup = LightRayBottomNavViewSetup.Builder().build(),
    currentItemId: String,
    onItemSelected: (NavigationBarItem) -> Unit
) {
    val items = NavigationBarItems.getItems()

    var itemIndex by remember { mutableStateOf(0) }

    val offsetAnimation: Dp by animateDpAsState(
        calculateOffsetForItem(index = itemIndex)
    )

    Box( modifier = Modifier
        .height(54.dp)
        .background(Color.Black)
        .fillMaxWidth()) {
        Row( modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEachIndexed { index, item ->
                LampLightBottomNavItem(
                    lightRayBottomNavViewSetup = lightRayBottomNavViewSetup,
                    item = item,
                    isSelected = item.id == currentItemId
                ) {
                    onItemSelected(item)
                    itemIndex = index
                }
            }

        }

        LightPanelView(lightRayBottomNavViewSetup.lightRayViewSetup, offsetAnimation)
    }
}

@Composable
private fun calculateOffsetForItem(index: Int): Dp {
    val items = NavigationBarItems.getItems()
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val oneItemWidth = screenWidth / items.size
    val itemStartPositionDp = oneItemWidth * index
    val halfOfItemWidth = oneItemWidth / 2
    val halfOfPanelWidth = 48.dp / 2

    return itemStartPositionDp + halfOfItemWidth - halfOfPanelWidth

}

@Composable
fun LampLightBottomNavItem(
    lightRayBottomNavViewSetup: LightRayBottomNavViewSetup,
    item: NavigationBarItem, isSelected: Boolean, onClick: () -> Unit
) {
    val animatedColor = animateColorAsState(
        if (isSelected) lightRayBottomNavViewSetup.selectedIconColor else lightRayBottomNavViewSetup.iconColor,
        tween(lightRayBottomNavViewSetup.moveLightRayAnimationTweenDuration)
    )

    val scale = animateFloatAsState(if (isSelected) lightRayBottomNavViewSetup.selectedIconScale else lightRayBottomNavViewSetup.iconScale)

    Box(
        modifier = Modifier
            .defaultMinSize(48.dp)
            .clickable(onClick = onClick), contentAlignment = Alignment.Center
    )
    {

        Column(
            modifier = Modifier
                .wrapContentSize()
                .clickable(onClick = onClick),
            verticalArrangement = Arrangement.Center
        ) {

            Icon(
                painter = painterResource(item.iconResId),
                modifier = Modifier
                    .size(20.dp)
                    .scale(scale.value),
                contentDescription = item.title,
                tint = animatedColor.value
            )
        }
    }
}