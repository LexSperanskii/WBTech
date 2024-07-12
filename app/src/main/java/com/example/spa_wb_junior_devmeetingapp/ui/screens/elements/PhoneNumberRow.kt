package com.example.spa_wb_junior_devmeetingapp.ui.screens.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
import com.example.spa_wb_junior_devmeetingapp.R
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
        CountryCode(
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
                if (it.isDigitsOnly())
                    onPhoneNumberChange(it.take(phoneLength))
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
                    innerTextField() // Отображаем поле ввода
                }
            },
            visualTransformation = PhoneVisualTransformation()
        )
    }
}
class PhoneVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val trimmed = if (text.text.length > 10) text.text.substring(0..9) else text.text
        var output = ""
        for (i in trimmed.indices) {
            output += trimmed[i]
            when (i) {
                2 -> output += " "
                5 -> output += "-"
                7 -> output += "-"
            }
        }

        val phoneNumberOffsetTranslator = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {
                if (offset <= 2) return offset
                if (offset <= 5) return offset + 1
                if (offset <= 7) return offset + 2
                if (offset <= 9) return offset + 3
                return 13
            }

            override fun transformedToOriginal(offset: Int): Int {
                if (offset <= 3) return offset
                if (offset <= 7) return offset - 1
                if (offset <= 10) return offset - 2
                if (offset <= 13) return offset - 3
                return 10
            }
        }

        return TransformedText(AnnotatedString(output), phoneNumberOffsetTranslator)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryCode(
    country: Country,
    listOfCountries : List<Country>,
    onDropdownMenuItemClick: (Country)->Unit,
    modifier: Modifier = Modifier
) {
    var isExpanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = isExpanded,
        onExpandedChange = {isExpanded = !isExpanded},
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .padding(end = 8.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(color = ExtraLightGray)
                .menuAnchor(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 10.dp)
                    .size(16.dp)
                    .clip(RoundedCornerShape(4.dp)),
                painter = painterResource(id = country.flag),
                contentDescription = stringResource(id = R.string.country_code)
            )
            Text(
                modifier = Modifier.padding(end = 8.dp),
                text = country.countryCode,
                color = GrayForCommunityCard,
                fontSize = MaterialTheme.typography.BodyText1.fontSize,
                fontWeight = FontWeight.SemiBold,
                fontFamily = SFProDisplay
            )
        }
        ExposedDropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { isExpanded = !isExpanded },
            modifier = Modifier
                .widthIn(76.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(color = ExtraLightGray)
        ) {
            listOfCountries.forEach {
                DropdownMenuItem(
                    modifier = Modifier,
                    text = {
                        Row(
                            modifier = Modifier,
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Image(
                                modifier = Modifier
                                    .size(16.dp)
                                    .clip(RoundedCornerShape(4.dp)),
                                painter = painterResource(id = it.flag),
                                contentDescription = stringResource(id = R.string.country_code)
                            )
                            Text(
                                modifier = Modifier,
                                text = it.countryCode,
                                color = GrayForCommunityCard,
                                fontSize = MaterialTheme.typography.BodyText1.fontSize,
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = SFProDisplay
                            )
                        }
                    },
                    onClick = { onDropdownMenuItemClick(it) }
                )
            }
        }
    }
}

