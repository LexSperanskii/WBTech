package com.example.spa_wb_junior_devmeetingapp.ui.screens.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.spa_wb_junior_devmeetingapp.R
import com.example.spa_wb_junior_devmeetingapp.models.CountryModelUI
import com.example.spa_wb_junior_devmeetingapp.ui.theme.DevMeetingAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryCodeDropDown(
    country: CountryModelUI,
    listOfCountries : List<CountryModelUI>,
    onDropdownMenuItemClick: (CountryModelUI)->Unit,
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
                .background(color = DevMeetingAppTheme.colors.extraLightGray)
                .menuAnchor(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(country.flag)
                    .crossfade(true)
                    .build(),
                contentScale = ContentScale.Crop,
                error = painterResource(R.drawable.ic_broken_image),
                placeholder = painterResource(R.drawable.loading_img),
                contentDescription = stringResource(id = R.string.country_code),
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 10.dp)
                    .size(16.dp)
                    .clip(RoundedCornerShape(4.dp))
            )
            Text(
                modifier = Modifier.padding(end = 8.dp),
                text = country.code,
                color = DevMeetingAppTheme.colors.grayForCommunityCard,
                style = DevMeetingAppTheme.typography.bodyText1,
            )
        }
        ExposedDropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { isExpanded = !isExpanded },
            modifier = Modifier
                .widthIn(76.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(color = DevMeetingAppTheme.colors.extraLightGray)
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
                            AsyncImage(
                                model = ImageRequest.Builder(context = LocalContext.current)
                                    .data(it.flag)
                                    .crossfade(true)
                                    .build(),
                                contentScale = ContentScale.Crop,
                                error = painterResource(R.drawable.ic_broken_image),
                                placeholder = painterResource(R.drawable.loading_img),
                                contentDescription = stringResource(id = R.string.country_code),
                                modifier = Modifier
                                    .size(16.dp)
                                    .clip(RoundedCornerShape(4.dp))
                            )
                            Text(
                                modifier = Modifier,
                                text = it.code,
                                color = DevMeetingAppTheme.colors.grayForCommunityCard,
                                style = DevMeetingAppTheme.typography.bodyText1,
                            )
                        }
                    },
                    onClick = {
                        isExpanded = !isExpanded
                        onDropdownMenuItemClick(it)
                    }
                )
            }
        }
    }
}