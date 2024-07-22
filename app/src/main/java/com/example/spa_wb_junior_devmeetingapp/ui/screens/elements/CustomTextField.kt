package com.example.spa_wb_junior_devmeetingapp.ui.screens.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spa_wb_junior_devmeetingapp.ui.utils.UiUtils.replaceFirstCharToCapitalCase
import com.example.spa_wb_junior_devmeetingapp.ui.theme.DevMeetingAppTheme

@Composable
fun CustomTextField(
    value: String,
    placeholder: String,
    onValueChange : (String) -> Unit,
    modifier: Modifier = Modifier
){
    val focusManager = LocalFocusManager.current
    var focusState by remember { mutableStateOf(false) }

    BasicTextField(
        modifier = modifier
            .fillMaxWidth()
            .height(36.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(color = DevMeetingAppTheme.colors.extraLightGray)
            .onFocusChanged { focusState = it.isFocused }
            .padding(horizontal = 8.dp, vertical = 6.dp),
        value = value,
        onValueChange = {
            onValueChange(replaceFirstCharToCapitalCase(it))
        },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
        ),
        keyboardActions = KeyboardActions(onDone = {
            focusManager.clearFocus()
        }),
        textStyle= TextStyle(
            color = DevMeetingAppTheme.colors.extraDarkPurpleForBottomBar,
            fontSize = DevMeetingAppTheme.typography.bodyText1.fontSize,
            fontWeight = DevMeetingAppTheme.typography.bodyText1.fontWeight,
            fontFamily = DevMeetingAppTheme.typography.bodyText1.fontFamily,
            lineHeight = 24.sp
        ),
        decorationBox = { innerTextField ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
            ) {
                when {
                    !focusState && value.isEmpty() -> {
                        Text(
                            text = placeholder,
                            color = DevMeetingAppTheme.colors.grayForCommunityCard,
                            style = DevMeetingAppTheme.typography.bodyText1,
                            lineHeight = 24.sp
                        )
                    }

                    else -> {
                        innerTextField()
                    }
                }
            }
        },
        maxLines = 1
    )
}
