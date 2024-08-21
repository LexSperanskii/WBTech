package com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.newUi

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spa_wb_junior_devmeetingapp.R
import com.example.spa_wb_junior_devmeetingapp.ui.theme.DevMeetingAppTheme
import com.example.spa_wb_junior_devmeetingapp.ui.utils.UiUtils.replaceFirstCharToCapitalCase

internal val textFieldGradientNormal = Brush.horizontalGradient(
    listOf(
        Color(0xFFFFFFFF), Color(0xFFF6F6FA)
    )
)
internal val textFieldGradientError = Brush.horizontalGradient(
    listOf(
        Color(0xFFFFEEF4), Color(0xFFFFFFFF), Color(0x1AF0114C)
    )
)

@Composable
internal fun NameSurnameTextField(
    value: String,
    isValid: Boolean,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = stringResource(id = R.string.placeholder_name_surname),
) {
    val focusManager = LocalFocusManager.current
    var focusState by remember { mutableStateOf(false) }

    BasicTextField(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(56.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(
                brush = when (isValid) {
                    true -> {
                        textFieldGradientNormal
                    }

                    else -> {
                        textFieldGradientError
                    }
                }
            )
            .onFocusChanged { focusState = it.isFocused }
            .border(
                width = 1.dp,
                color = when (focusState) {
                    true -> {
                        DevMeetingAppTheme.colors.purple
                    }

                    else -> {
                        Color.Transparent
                    }
                },
                shape = RoundedCornerShape(16.dp)
            )
            .padding(horizontal = 20.dp, vertical = 16.dp),
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
        textStyle = TextStyle(
            color = DevMeetingAppTheme.colors.black,
            fontSize = DevMeetingAppTheme.typography.subheading1.fontSize,
            fontWeight = DevMeetingAppTheme.typography.bodyText2.fontWeight,
            fontFamily = DevMeetingAppTheme.typography.subheading1.fontFamily,
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
                            fontSize = DevMeetingAppTheme.typography.subheading1.fontSize,
                            fontWeight = DevMeetingAppTheme.typography.bodyText2.fontWeight,
                            fontFamily = DevMeetingAppTheme.typography.subheading1.fontFamily,
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
