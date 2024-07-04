package com.example.spa_wb_junior_devmeetingapp.ui.screens.elements

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.spa_wb_junior_devmeetingapp.ui.theme.ExtraLightGray
import com.example.spa_wb_junior_devmeetingapp.ui.theme.Gray

@Composable
fun MySearchBar(modifier: Modifier = Modifier) {

    var text by rememberSaveable { mutableStateOf("") }

    TextField(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(4.dp),
        value = text,
        onValueChange = { text = it },
        placeholder = {
            Text(
                text = "Поиск",
                color = Gray,
                fontWeight = FontWeight.SemiBold
            )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Outlined.Search,
                contentDescription = "Search",
                tint = Gray
            )
        },
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            focusedContainerColor = ExtraLightGray,
            unfocusedContainerColor = ExtraLightGray
        ),
    )
}
