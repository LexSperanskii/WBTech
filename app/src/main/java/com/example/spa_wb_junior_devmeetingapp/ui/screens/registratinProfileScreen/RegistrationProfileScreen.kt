package com.example.spa_wb_junior_devmeetingapp.ui.screens.registratinProfileScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.spa_wb_junior_devmeetingapp.R
import com.example.spa_wb_junior_devmeetingapp.ui.navigation.NavigationDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.CustomTextField
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.PersonAvatar
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.TopAppBarBackNameAction
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.buttons.CustomButton
import com.example.spa_wb_junior_devmeetingapp.ui.theme.DarkPurple
import com.example.spa_wb_junior_devmeetingapp.ui.theme.Purple
import com.example.spa_wb_junior_devmeetingapp.ui.theme.SFProDisplay
import com.example.spa_wb_junior_devmeetingapp.ui.theme.Subheading2

object RegistrationProfileDestination : NavigationDestination {
    override val route = "registration_profile"
    override val title = R.string.profile
}

@Composable
fun RegistrationProfileScreen(
    onClickNavigateBack: () -> Unit,
    navigateToEventsAllScreen: () -> Unit
) {

    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBarBackNameAction(
                title = stringResource(id = RegistrationProfileDestination.title),
                isNavigateBack = true,
                onClickNavigateBack = onClickNavigateBack,
                isAddCapable = false
            )
        }
    ) { innerPadding ->
        RegistrationProfileScreenBody(
            modifier = Modifier.padding(innerPadding),
            name = name,
            onNameChange = {name = it},
            surname = surname ,
            onSurnameChange = {surname = it},
            onButtonSafeClick = navigateToEventsAllScreen,
            isButtonSafeEnabled = name.isNotEmpty()
        )
    }
}

@Composable
fun RegistrationProfileScreenBody(
    name: String,
    onNameChange: (String) -> Unit,
    surname: String,
    onSurnameChange: (String) -> Unit,
    onButtonSafeClick: () -> Unit,
    isButtonSafeEnabled:Boolean,
    modifier: Modifier = Modifier
    ) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        PersonAvatar(
            size = 100.dp,
            isEdit = true,
            modifier = Modifier.padding(top = 46.dp, bottom = 31.dp)
        )
        CustomTextField(
            value = name,
            placeholder = stringResource(id = R.string.name_required),
            onValueChange = onNameChange,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        CustomTextField(
            value = surname,
            placeholder = stringResource(id = R.string.surname_optional),
            onValueChange = onSurnameChange,
            modifier = Modifier.padding(bottom = 56.dp)
        )
        CustomButton(
            onClick = onButtonSafeClick,
            pressedColor = DarkPurple,
            containerColor = Purple,
            enabled = isButtonSafeEnabled,
            text = stringResource(id = R.string.safe),
            fontSize = MaterialTheme.typography.Subheading2.fontSize,
            fontWeight = FontWeight.SemiBold,
            fontFamily = SFProDisplay,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
        )

    }
}