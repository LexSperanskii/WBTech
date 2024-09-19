package com.example.ui_v2.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.ui_v2.R
import com.example.ui_v2.models.CountryModelUI
import com.example.ui_v2.ui.theme.DevMeetingAppTheme

@Composable
internal fun UserInfoBlock(
    nameSurnameValue: String,
    isNameSurnameValid: Boolean,
    onNameSurnameChange: (String) -> Unit,
    number: String,
    onNumberChange: (String) -> Unit,
    isNumberValid: Boolean,
    isCountryCodeValid: Boolean,
    countryCode: CountryModelUI,
    onCountryCodeChange: (CountryModelUI) -> Unit,
    listOfCountriesCodes: List<CountryModelUI>,
    cityValue: String,
    isCityValid: Boolean,
    onCityChange: (String) -> Unit,
    aboutUserValue: String,
    isAboutUserValid: Boolean,
    onAboutUserChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
            .padding(horizontal = DevMeetingAppTheme.dimensions.paddingMedium)
    ) {
        NameSurnameTextField(
            value = nameSurnameValue,
            isValid = isNameSurnameValid,
            onValueChange = onNameSurnameChange,
            modifier = Modifier
        )
        PhoneNumberInput(
            number = number,
            onNumberChange = onNumberChange,
            isNumberValid = isNumberValid,
            isCountryCodeValid = isCountryCodeValid,
            countryCode = countryCode,
            onCountryCodeChange = onCountryCodeChange,
            listOfCountriesCodes = listOfCountriesCodes
        )
        NameSurnameTextField(
            value = cityValue,
            isValid = isCityValid,
            onValueChange = onCityChange,
            placeholder = stringResource(id = R.string.city),
            modifier = Modifier
        )
        NameAboutYourselfField(
            value = aboutUserValue,
            isValid = isAboutUserValid,
            onValueChange = onAboutUserChange,
            placeholder = stringResource(id = R.string.about_yourself),
            modifier = Modifier
        )
    }
}