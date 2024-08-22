package com.example.spa_wb_junior_devmeetingapp.ui.newUi.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import com.example.spa_wb_junior_devmeetingapp.models.NewCountryModelUI
import com.example.spa_wb_junior_devmeetingapp.ui.theme.DevMeetingAppTheme
import com.example.spa_wb_junior_devmeetingapp.ui.utils.UiUtils.PHONE_NUMBER_LENGTH

@Composable
internal fun NewPhoneNumberInput(
    number: String,
    onNumberChange: (String) -> Unit,
    countryCode: NewCountryModelUI,
    onCountryCodeChange: (NewCountryModelUI) -> Unit,
    listOfCountriesCodes: List<NewCountryModelUI>,
    modifier: Modifier = Modifier,
    placeholder: String = "000 000-00-00"
) {
    val focusManager = LocalFocusManager.current
    var focusState by remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        NewCountryCodeDropDownMenu(
            country = countryCode,
            listOfCountries = listOfCountriesCodes,
            onDropdownMenuItemClick = { onCountryCodeChange(it) }
        )
        BasicTextField(
            modifier = Modifier
                .weight(1f)
                .heightIn(56.dp)
                .clip(RoundedCornerShape(DevMeetingAppTheme.dimensions.cornerShapeMedium))
                .background(color = DevMeetingAppTheme.colors.disabledButtonGray)
                .onFocusChanged { focusState = it.isFocused }
                .padding(start = 16.dp),
            value = number,
            onValueChange = {
                if (it.isDigitsOnly()) {
                    onNumberChange(it.take(PHONE_NUMBER_LENGTH))
                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Number
            ),
            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
            maxLines = 1,
            textStyle = TextStyle(
                color = DevMeetingAppTheme.colors.black,
                fontSize = DevMeetingAppTheme.typography.newBodyText1.fontSize,
                fontFamily = DevMeetingAppTheme.typography.newBodyText1.fontFamily,
                fontWeight = DevMeetingAppTheme.typography.newBodyText1.fontWeight,
                lineHeight = DevMeetingAppTheme.typography.newBodyText1.lineHeight
            ),
            decorationBox = { innerTextField ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                ) {
                    when {
                        !focusState && number.isEmpty() -> {
                            Text(
                                text = placeholder,
                                color = DevMeetingAppTheme.colors.grayForCommunityCard,
                                style = DevMeetingAppTheme.typography.newBodyText1
                            )
                        }

                        else -> {
                            innerTextField()
                        }
                    }
                }
            },
            visualTransformation = NewPhoneVisualTransformation()
        )
    }
}

internal class NewPhoneVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val formattedText = StringBuilder()
        text.forEachIndexed { index, char ->
            formattedText.append(char)
            when (index) {
                SPACE_POSITION -> formattedText.append(SPACE)
                FIRST_DASH_POSITION, SECOND_DASH_POSITION -> formattedText.append(DASH)
            }
        }

        val phoneNumberOffsetTranslator = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int = when (offset) {
                in ZERO..SPACE_POSITION -> offset
                in SPACE_POSITION + ONE..FIRST_DASH_POSITION -> offset + ONE
                in FIRST_DASH_POSITION + ONE..SECOND_DASH_POSITION -> offset + TWO
                else -> offset + THREE
            }

            override fun transformedToOriginal(offset: Int): Int = when (offset) {
                in ZERO..SPACE_POSITION + ONE -> offset
                in SPACE_POSITION + TWO..FIRST_DASH_POSITION + TWO -> offset - ONE
                in FIRST_DASH_POSITION + THREE..SECOND_DASH_POSITION + THREE -> offset - TWO
                else -> offset - THREE
            }

        }

        return TransformedText(
            AnnotatedString(formattedText.toString()),
            phoneNumberOffsetTranslator
        )
    }

    private companion object {
        const val SPACE_POSITION = 2
        const val FIRST_DASH_POSITION = 5
        const val SECOND_DASH_POSITION = 7

        const val SPACE = " "
        const val DASH = "-"
        const val ZERO = 0
        const val ONE = 1
        const val TWO = 2
        const val THREE = 3
    }
}