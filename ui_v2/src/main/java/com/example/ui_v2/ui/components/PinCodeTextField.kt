package com.example.ui_v2.ui.components

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.ui_v2.R
import com.example.ui_v2.ui.theme.DevMeetingAppTheme
import com.example.ui_v2.ui.utils.UiUtils.PIN_CODE_LENGTH


@Composable
internal fun PinCodeTextField(
    value: String,
    isValid: Boolean,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = stringResource(id = R.string.pin_code_placeholder),
    numberOfDigits: Int = PIN_CODE_LENGTH,
) {
    val focusManager = LocalFocusManager.current
    var focusState by remember { mutableStateOf(false) }

    BasicTextField(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(56.dp)
            .clip(RoundedCornerShape(DevMeetingAppTheme.dimensions.cornerShapeMedium))
            .background(
                brush = when (isValid) {
                    true -> {
                        DevMeetingAppTheme.brush.textFieldGradientNormal
                    }

                    else -> {
                        DevMeetingAppTheme.brush.textFieldGradientError
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
            onValueChange(it)
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number,
            imeAction = ImeAction.Done,
        ),
        keyboardActions = KeyboardActions(onDone = {
            focusManager.clearFocus()
        }),
        textStyle = TextStyle(
            color = DevMeetingAppTheme.colors.black,
            fontSize = DevMeetingAppTheme.typography.subheading1.fontSize,
            fontWeight = DevMeetingAppTheme.typography.subheading1.fontWeight,
            fontFamily = DevMeetingAppTheme.typography.subheading1.fontFamily,
            lineHeight = DevMeetingAppTheme.typography.subheading1.lineHeight
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
                            style = DevMeetingAppTheme.typography.subheading1
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