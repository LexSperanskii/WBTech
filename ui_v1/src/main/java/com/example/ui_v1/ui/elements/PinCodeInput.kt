package com.example.ui_v1.ui.elements

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import com.example.ui_v1.ui.theme.DevMeetingAppTheme
import com.example.ui_v1.utils.UiUtils.PIN_CODE_LENGTH


@Composable
internal fun PinCodeInput(
    value: String,
    onValueChange: (String) -> Unit,
    onDoneKeyboardPressed: () -> Unit,
    modifier: Modifier = Modifier,
    numberOfDigits: Int = PIN_CODE_LENGTH
) {
    val focusManager = LocalFocusManager.current

    BasicTextField(
        value = value,
        onValueChange = {
            if (it.isDigitsOnly())
                onValueChange(it.take(numberOfDigits))
        },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Number
        ),
        keyboardActions = KeyboardActions(onDone = {
            onDoneKeyboardPressed()
            focusManager.clearFocus()
        }),
        maxLines = 1,
        decorationBox = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(40.dp),
                modifier = Modifier.heightIn(40.dp)
            ) {
                repeat(numberOfDigits) { index ->
                    when (index in value.indices) {
                        true -> Text(
                            text = value[index].toString(),
                            color = DevMeetingAppTheme.colors.extraDarkPurpleForBottomBar,
                            style = DevMeetingAppTheme.typography.heading1,
                            modifier = Modifier.width(32.dp)
                        )
                        else -> Box(
                            modifier = Modifier
                                .padding(horizontal = 4.dp)
                                .size(24.dp)
                                .clip(CircleShape)
                                .background(DevMeetingAppTheme.colors.lightGray)
                        )
                    }
                }
            }
        },
        modifier = modifier
    )
}