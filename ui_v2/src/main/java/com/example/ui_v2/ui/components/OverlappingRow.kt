package com.example.ui_v2.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.ui_v2.models.UserModelUI
import com.example.ui_v2.ui.utils.UiUtils.DEFAULT_OVERLAPPING_PEOPLE_COUNT
import com.example.ui_v2.ui.utils.UiUtils.DEFAULT_OVERLAPPING_PERCENTAGE

@Composable
internal fun OverlappingPeopleRow(
    participantsList: List<UserModelUI>,
    onOverlappingRowClick: () -> Unit,
    modifier: Modifier = Modifier,
    reverse: Boolean = false,
    overlappingPercentage: Float = DEFAULT_OVERLAPPING_PERCENTAGE,
    accountsInOverlappingRow: Int = DEFAULT_OVERLAPPING_PEOPLE_COUNT,
    size: Dp = 48.dp,
) {
    Card(
        onClick = onOverlappingRowClick,
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
                        PersonAvatar(
                            size = size,
                            imageURL = participant.imageURL
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
                            PersonAvatar(
                                size = size,
                                imageURL = participant.imageURL
                            )
                        }
                    }
                    MorePeople(
                        quantity = participantsList.size - accountsInOverlappingRow,
                        size = size,
                        modifier = Modifier
                            .offset(x = (-size.value * overlappingPercentage).dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun OverlappingRow(
    overlappingPercentage: Float,
    reverse: Boolean,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
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
            if (!reverse) {
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