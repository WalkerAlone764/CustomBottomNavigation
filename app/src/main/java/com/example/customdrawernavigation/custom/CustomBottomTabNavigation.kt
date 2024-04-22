package com.example.customdrawernavigation.custom

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CustomBottomTabNavigation(
    list: List<CustomNavigationItem>
) {

    var selectedIndex by remember {
        mutableIntStateOf(0)
    }

    val scaleValue by animateFloatAsState(targetValue = 3f)

    Row(
        modifier = Modifier
            .navigationBarsPadding()
            .fillMaxWidth()
            .height(80.dp)
            .background(MaterialTheme.colorScheme.onBackground),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {

        list.forEachIndexed { index, customNavigationItem ->
            Column(
                modifier = Modifier
                    .weight(1f)
                    .clickable {
                        selectedIndex = index
                    }, horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if (selectedIndex == index) {
                    Column(
                        modifier = Modifier, horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Column(
                            modifier = Modifier
                                .scale(scaleValue)
                                .clip(RoundedCornerShape(50))
                                .background(Color.LightGray)
                                .padding(0.7.dp)
                        ) {
                            Column(
                                modifier = Modifier
//                                    .scale(4f)
//                                    .padding(6.dp)
                                    .clip(RoundedCornerShape(50))
                                    .background(Color.Blue.copy(0.9f))
                                    .padding(2.dp)

                            ) {

                                Icon(
                                    imageVector = customNavigationItem.icon,
                                    contentDescription = "",
                                    tint = Color.White,
                                    modifier = Modifier


                                )

                            }
                        }
                        Spacer(modifier = Modifier.height(28.dp))
                        Text(text = customNavigationItem.title, color = Color.White)
                    }
                } else {

                    Icon(
                        imageVector = customNavigationItem.icon,
                        contentDescription = "",
                        tint = Color.White
                    )

                }
            }
        }
    }

}


@Composable
@Preview
fun CustomPreview() {
    val list = listOf<CustomNavigationItem>(
        CustomNavigationItem(title = "Home", icon = Icons.Outlined.Home),
        CustomNavigationItem(title = "Setting", icon = Icons.Outlined.Settings)
    )
    CustomBottomTabNavigation(list = list)
}


