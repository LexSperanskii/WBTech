package com.example.spa_wb_junior_devmeetingapp.ui.screens.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import com.example.spa_wb_junior_devmeetingapp.ui.mockData.Country
import com.example.spa_wb_junior_devmeetingapp.ui.mockData.countryList
import com.example.spa_wb_junior_devmeetingapp.ui.theme.BodyText1
import com.example.spa_wb_junior_devmeetingapp.ui.theme.ExtraDarkPurpleForBottomBar
import com.example.spa_wb_junior_devmeetingapp.ui.theme.ExtraLightGray
import com.example.spa_wb_junior_devmeetingapp.ui.theme.GrayForCommunityCard
import com.example.spa_wb_junior_devmeetingapp.ui.theme.SFProDisplay

@Composable
fun PhoneNumberRow(
    phoneNumber: String,
    onPhoneNumberChange :  (String) -> Unit,
    countryCode: Country,
    listOfCountriesCodes :List<Country> = countryList,
    onCountryCodeChange :  (Country) -> Unit,
    placeholder : String = "000 000-00-00",
    modifier: Modifier = Modifier
) {
    val phoneLength = 10
    val focusManager = LocalFocusManager.current
    var focusState by remember { mutableStateOf(false) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        CountryCodeDropDown(
            country = countryCode,
            listOfCountries = listOfCountriesCodes,
            onDropdownMenuItemClick = {onCountryCodeChange(it)}
        )
        BasicTextField(
            modifier = Modifier
                .weight(1f)
                .height(36.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(color = ExtraLightGray)
                .onFocusChanged { focusState = it.isFocused }
                .padding(horizontal = 8.dp, vertical = 6.dp),
            value = phoneNumber,
            onValueChange = {
                if (it.isDigitsOnly()){
                    onPhoneNumberChange(it.take(phoneLength))
                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Number
            ),
            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() }),
            maxLines = 1,
            textStyle= TextStyle(
                color = ExtraDarkPurpleForBottomBar,
                fontSize = MaterialTheme.typography.BodyText1.fontSize,
                fontWeight = FontWeight.SemiBold,
                fontFamily = SFProDisplay,
                lineHeight = 24.sp
            ),
            decorationBox = { innerTextField ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                ) {
                    if (!focusState && phoneNumber.isEmpty()) Text(
                        text = placeholder,
                        color = GrayForCommunityCard,
                        fontSize = MaterialTheme.typography.BodyText1.fontSize,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = SFProDisplay
                    )
                    innerTextField()
                }
            },
            visualTransformation = PhoneVisualTransformation()
        )
    }
}
class PhoneVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val formattedText = StringBuilder()
        for (i in text.indices) {
            formattedText.append(text[i])
            when (i) {
                2 -> formattedText.append(" ")
                5 -> formattedText.append("-")
                7 -> formattedText.append("-")
            }
        }

        val phoneNumberOffsetTranslator = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int = when {
                offset <= 2 -> offset
                offset <= 5 -> offset + 1
                offset <= 7 -> offset + 2
                offset <= 9 -> offset + 3
                else -> 13
            }

            override fun transformedToOriginal(offset: Int): Int = when{
                offset <= 3 -> offset
                offset <= 7 -> offset - 1
                offset <= 10 -> offset - 2
                offset <= 13 -> offset - 3
                else -> 10
            }
        }

        return TransformedText(AnnotatedString(formattedText.toString()), phoneNumberOffsetTranslator)
    }
}

