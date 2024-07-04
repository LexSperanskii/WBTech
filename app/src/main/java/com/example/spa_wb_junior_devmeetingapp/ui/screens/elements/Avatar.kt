package com.example.spa_wb_junior_devmeetingapp.ui.screens.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.spa_wb_junior_devmeetingapp.R
import com.example.spa_wb_junior_devmeetingapp.ui.theme.ExtraLightGray

@Composable
fun AvatarColumn(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        PersonAvatar(
            size = 200.dp,
            isEdit = false
        )
        Image(
            painter = painterResource(id = R.drawable.avatar_meeting),
            contentDescription = "avatar meeting",
            modifier = Modifier.size(48.dp),
            contentScale = ContentScale.Fit
        )
    }
}

@Composable
fun PersonAvatar(
    size: Dp,
    isEdit: Boolean,
    backgroundColor: Color = ExtraLightGray,
    painter: Painter = painterResource(id = R.drawable.icon_avatar_person),
    modifier: Modifier = Modifier
) {

    val iconScale = size.value / 100 // Коэффициент масштабирования

    Box(modifier = Modifier) {
        Box(
            modifier = modifier
                .size(size)
                .clip(CircleShape)
                .background(backgroundColor)
        ) {
            Icon(
                painter = painter,
                contentDescription = "avatar person",
                modifier = Modifier
                    .align(Alignment.Center)
                    .scale(iconScale)
            )
        }
        if (isEdit) {
            Icon(
                painter = painterResource(id = R.drawable.icon_avatar_plus_sign),
                contentDescription = "plus sign",
                modifier = Modifier
                    .size(20.dp)
                    .align(Alignment.BottomEnd)
                    .offset((-5).dp,(-1).dp)
            )
        }
    }
}

