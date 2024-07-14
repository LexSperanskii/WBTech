package com.example.spa_wb_junior_devmeetingapp.ui.screens.elements

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.spa_wb_junior_devmeetingapp.R
import com.example.spa_wb_junior_devmeetingapp.ui.theme.ExtraDarkPurpleForBottomBar
import com.example.spa_wb_junior_devmeetingapp.ui.theme.Purple
import com.example.spa_wb_junior_devmeetingapp.ui.theme.SFProDisplay
import com.example.spa_wb_junior_devmeetingapp.ui.theme.Subheading1


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarBackNameAction(
    title: String,
    isNavigateBack : Boolean= true,
    onClickNavigateBack: () -> Unit = {},
    isAddCapable: Boolean = true,
    onAddCLick: () -> Unit = {},
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                color = ExtraDarkPurpleForBottomBar,
                fontSize = MaterialTheme.typography.Subheading1.fontSize,
                fontWeight = FontWeight.SemiBold,
                fontFamily = SFProDisplay,
                modifier = if (isNavigateBack) Modifier.padding(start = 0.dp) else Modifier.padding(start = 8.dp)
            )
        },
        navigationIcon = {
            if (isNavigateBack){
                IconButton(onClick = onClickNavigateBack) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                        contentDescription = stringResource(R.string.back_button),
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        },
        actions = {
            if (isAddCapable) {
                IconButton(
                    modifier = Modifier.padding(end = 16.dp),
                    onClick = onAddCLick
                ) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = stringResource(id = R.string.top_bar_action),
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        },
        modifier = modifier
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarForProfile(
    title: String,
    onClickNavigateBack: () -> Unit,
    onEditClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                color = ExtraDarkPurpleForBottomBar,
                fontSize = MaterialTheme.typography.Subheading1.fontSize,
                fontWeight = FontWeight.SemiBold,
                fontFamily = SFProDisplay,
                modifier = Modifier
            )
        },
        navigationIcon = {
            IconButton(onClick = onClickNavigateBack) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = stringResource(R.string.back_button),
                    modifier = Modifier.size(24.dp)
                )
            }
        },
        actions = {
            IconButton(
                modifier = Modifier.padding(end = 16.dp),
                onClick = onEditClick
            ) {
                Icon(
                    imageVector = Icons.Filled.Edit,
                    contentDescription = stringResource(id = R.string.top_bar_action),
                    modifier = Modifier.size(24.dp)
                )
            }
        },
        modifier = modifier
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarForEventDetails(
    title: String,
    onClickNavigateBack: () -> Unit,
    isStatusPlanned: Boolean,
    onStatusCLick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                color = ExtraDarkPurpleForBottomBar,
                fontSize = MaterialTheme.typography.Subheading1.fontSize,
                fontWeight = FontWeight.SemiBold,
                fontFamily = SFProDisplay,
                modifier = Modifier
            )
        },
        navigationIcon = {
            IconButton(onClick = onClickNavigateBack) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                    contentDescription = stringResource(R.string.back_button),
                    modifier = Modifier.size(24.dp)
                )
            }
        },
        actions = {
            if (isStatusPlanned){
                IconButton(
                    modifier = Modifier.padding(end = 16.dp),
                    onClick = onStatusCLick
                ) {
                    Icon(
                        imageVector = Icons.Filled.Done,
                        contentDescription = stringResource(id = R.string.top_bar_action),
                        tint = Purple,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        },
        modifier = modifier
    )
}