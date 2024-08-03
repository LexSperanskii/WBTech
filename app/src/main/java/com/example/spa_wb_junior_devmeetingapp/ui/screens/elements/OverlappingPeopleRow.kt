package com.example.spa_wb_junior_devmeetingapp.ui.screens.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.spa_wb_junior_devmeetingapp.R
import com.example.spa_wb_junior_devmeetingapp.models.RegisteredPersonModelUI
import com.example.spa_wb_junior_devmeetingapp.ui.theme.DevMeetingAppTheme
import com.example.spa_wb_junior_devmeetingapp.ui.utils.UiUtils.DEFAULT_DIVIDER
import com.example.spa_wb_junior_devmeetingapp.ui.utils.UiUtils.DEFAULT_OVERLAPPING_PEOPLE_COUNT
import com.example.spa_wb_junior_devmeetingapp.ui.utils.UiUtils.DEFAULT_OVERLAPPING_PERCENTAGE

@Composable
internal fun OverlappingPeopleRow(
    participantsList: List<RegisteredPersonModelUI>,
    modifier: Modifier = Modifier,
    reverse: Boolean = false,
    overlappingPercentage: Float = DEFAULT_OVERLAPPING_PERCENTAGE,
    accountsInOverlappingRow: Int = DEFAULT_OVERLAPPING_PEOPLE_COUNT
){
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = modifier
    ) {
        when {
            participantsList.size < accountsInOverlappingRow -> {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(2.dp),
                    modifier = Modifier.padding(4.dp)
                ) {
                    participantsList.forEach { participant ->
                        ParticipantIcon(
                            size = 48.dp,
                            participant = participant
                        )
                    }
                }
            }
            else -> {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(4.dp)
                ) {
                    OverlappingRow(
                        reverse = reverse,
                        overlappingPercentage = overlappingPercentage
                    ) {
                        participantsList.take(accountsInOverlappingRow).forEach { participant ->
                            ParticipantIcon(
                                size = 48.dp,
                                participant = participant
                            )
                        }
                    }
                    Text(
                        text = stringResource(id = R.string.number_of_people, participantsList.size-accountsInOverlappingRow ),
                        style = DevMeetingAppTheme.typography.bodyText1,
                        modifier = Modifier.padding(start = 10.dp)
                    )
                }
            }
        }
    }
}

@Composable
internal fun ParticipantIcon(
    size: Dp,
    participant: RegisteredPersonModelUI
) {
    val iconScale = size.value / DEFAULT_DIVIDER
    participant.iconURL?.let { avatarURL ->
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(avatarURL)
                .crossfade(true)
                .build(),
            contentScale = ContentScale.Crop,
            error = painterResource(R.drawable.ic_broken_image),
            placeholder = painterResource(R.drawable.loading_img),
            contentDescription = stringResource(R.string.profile_icon_in_row),
            modifier = Modifier
                .size(size)
                .clip(RoundedCornerShape(16.dp))
                .border(
                    2.dp,
                    DevMeetingAppTheme.colors.purpleForGroupedPeople,
                    RoundedCornerShape(16.dp)
                ),
        )
    } ?: Box(
        modifier = Modifier
            .size(size)
            .clip(RoundedCornerShape(16.dp))
            .border(
                2.dp,
                DevMeetingAppTheme.colors.purpleForGroupedPeople,
                RoundedCornerShape(16.dp)
            )
            .background(DevMeetingAppTheme.colors.extraLightGray)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.icon_avatar_person),
            contentDescription = stringResource(R.string.profile_icon_in_row),
            modifier = Modifier
                .align(Alignment.Center)
                .scale(iconScale)
        )
    }
}

@Composable
internal fun OverlappingRow(
    overlappingPercentage: Float,
    reverse: Boolean,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    // Фактор перекрытия элементов
    val factor = (1 - overlappingPercentage)

    // Layout для размещения дочерних элементов с заданной стратегией перекрытия
    Layout(
        modifier = modifier,
        content = content,
        measurePolicy = { measurables, constraints ->
            // Измеряем каждый дочерний элемент в соответствии с ограничениями
            val placeables = measurables.map { it.measure(constraints) }
            // Суммируем ширины всех элементов, кроме первого (тот, который отображается полностью без перекрытия)
            val widthsExceptFirst = placeables.subList(1, placeables.size).sumOf { it.width }
            // Ширина первого элемента
            val firstWidth = placeables.getOrNull(0)?.width ?: 0
            // Общая ширина контейнера с учетом перекрытия
            val width = (widthsExceptFirst * factor + firstWidth).toInt()
            // Высота контейнера равна высоте самого высокого элемента
            val height = placeables.maxOf { it.height }
            // Размещаем элементы в контейнере
            if(!reverse){
                layout(width, height) {
                    // Начальная позиция x для размещения элементов, начиная с правой стороны
                    var x = width - firstWidth
                    // Размещаем элементы в обратном порядке чтобы оригинальной порядок списка сохранился
                    for (placeable in placeables.asReversed()) {
                        // Размещаем текущий элемент по координатам (x, 0)
                        placeable.placeRelative(x, 0, 0f)
                        // Обновляем x для следующего элемента
                        x -= (placeable.width * factor).toInt()
                    }
                }
            } else {
                layout(width, height) {
                    var x = 0
                    for (placeable in placeables) {
                        placeable.placeRelative(x, 0, 0f)
                        x += (placeable.width * factor).toInt()
                    }
                }
            }
        }
    )
}