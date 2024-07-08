package com.example.spa_wb_junior_devmeetingapp.ui.screens.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.spa_wb_junior_devmeetingapp.ui.theme.ExtraDarkPurpleForBottomBar
import com.example.spa_wb_junior_devmeetingapp.ui.theme.Heading1
import com.example.spa_wb_junior_devmeetingapp.ui.theme.LightGray
import com.example.spa_wb_junior_devmeetingapp.ui.theme.SFProDisplay



@Composable
fun PinCodeInput(
    value: String,
    onValueChange :  (String) -> Unit = {},
    valueLength : Int = 4,
    modifier : Modifier = Modifier
){
    val focusManager = LocalFocusManager.current

    BasicTextField(
        value = value,
        onValueChange = {
            onValueChange(it.take(valueLength))
        },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Number
        ),
        keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
        maxLines = 1,
        decorationBox = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(40.dp),
                modifier = Modifier.heightIn(40.dp)
            ) {
                repeat(valueLength) { index ->
                    when (index in value.indices) {
                        true -> Text(
                            text = value[index].toString(),
                            color = ExtraDarkPurpleForBottomBar,
                            fontSize = MaterialTheme.typography.Heading1.fontSize,
                            fontWeight = FontWeight.Bold,
                            fontFamily = SFProDisplay,
                            modifier = Modifier.width(32.dp)
                        )
                        else -> Box(
                            modifier = Modifier
                                .padding(horizontal = 4.dp)
                                .size(24.dp)
                                .clip(CircleShape)
                                .background(LightGray)
                        )
                    }
                }
            }
        },
        modifier = modifier
    )
}