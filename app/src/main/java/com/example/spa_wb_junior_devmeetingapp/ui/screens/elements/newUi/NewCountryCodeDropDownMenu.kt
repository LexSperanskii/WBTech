package com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.newUi

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.spa_wb_junior_devmeetingapp.R
import com.example.spa_wb_junior_devmeetingapp.models.NewCountryModelUI
import com.example.spa_wb_junior_devmeetingapp.ui.theme.DevMeetingAppTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun NewCountryCodeDropDownMenu(
    country: NewCountryModelUI,
    listOfCountries: List<NewCountryModelUI>,
    onDropdownMenuItemClick: (NewCountryModelUI) -> Unit,
    modifier: Modifier = Modifier
) {
    var isExpanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = isExpanded,
        onExpandedChange = { isExpanded = !isExpanded },
        modifier = modifier
    ) {
        CountryCodeDropdownMenuDefaultItem(
            country = country,
            modifier = Modifier
                .menuAnchor()
        )
        DropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { isExpanded = !isExpanded },
            modifier = Modifier
                .background(DevMeetingAppTheme.colors.disabledButtonGray)
        ) {
            listOfCountries.forEach {
                DropdownMenuItem(
                    text = {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                            modifier = Modifier
                        ) {
                            Image(
                                painter = painterResource(id = it.flag),
                                contentDescription = stringResource(id = R.string.country_code),
                                modifier = Modifier
                                    .size(16.dp)
                                    .clip(RoundedCornerShape(4.dp))
                            )
                            Text(
                                text = it.code,
                                color = DevMeetingAppTheme.colors.black,
                                fontFamily = DevMeetingAppTheme.typography.subheading1.fontFamily,
                                fontSize = DevMeetingAppTheme.typography.subheading1.fontSize,
                                fontWeight = FontWeight.Medium,
                                maxLines = 1,
                                modifier = Modifier
                            )
                        }
                    },
                    onClick = {
                        isExpanded = !isExpanded
                        onDropdownMenuItemClick(it)
                    },
                    modifier = Modifier
                )
            }
        }
    }
}

@Composable
internal fun CountryCodeDropdownMenuDefaultItem(
    country: NewCountryModelUI,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(color = DevMeetingAppTheme.colors.disabledButtonGray)
            .padding(vertical = 16.dp, horizontal = 20.dp)
    ) {
        Image(
            painter = painterResource(country.flag),
            contentDescription = stringResource(id = R.string.country_code),
            modifier = Modifier
                .size(16.dp)
                .clip(RoundedCornerShape(4.dp))
        )
        Text(
            text = country.code,
            color = DevMeetingAppTheme.colors.black,
            fontFamily = DevMeetingAppTheme.typography.subheading1.fontFamily,
            fontSize = DevMeetingAppTheme.typography.subheading1.fontSize,
            fontWeight = FontWeight.Medium,
            modifier = Modifier
        )
    }
}