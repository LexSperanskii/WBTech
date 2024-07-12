package com.example.spa_wb_junior_devmeetingapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spa_wb_junior_devmeetingapp.R
import com.example.spa_wb_junior_devmeetingapp.ui.navigation.NavigationDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.PersonAvatar
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.PhoneVisualTransformation
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.TopAppBarBackNameAction
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.buttons.CustomButton
import com.example.spa_wb_junior_devmeetingapp.ui.theme.BodyText1
import com.example.spa_wb_junior_devmeetingapp.ui.theme.DarkPurple
import com.example.spa_wb_junior_devmeetingapp.ui.theme.ExtraDarkPurpleForBottomBar
import com.example.spa_wb_junior_devmeetingapp.ui.theme.ExtraLightGray
import com.example.spa_wb_junior_devmeetingapp.ui.theme.GrayForCommunityCard
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
            onButtonClick = navigateToEventsAllScreen,
            isButtonEnabled = name.isNotEmpty() && surname.isNotEmpty()
        )
    }
}

@Composable
fun RegistrationProfileScreenBody(
    modifier: Modifier = Modifier,
    name: String,
    onNameChange: (String) -> Unit,
    surname: String,
    onSurnameChange: (String) -> Unit,
    onButtonClick: () -> Unit,
    isButtonEnabled:Boolean
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
            onClick = onButtonClick,
            pressedColor = DarkPurple,
            containerColor = Purple,
            enabled = isButtonEnabled,
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

@Composable
fun CustomTextField(
    value: String,
    placeholder: String,
    onValueChange : (String) -> Unit,
    modifier: Modifier = Modifier
){
    val focusManager = LocalFocusManager.current
    var focusState by remember { mutableStateOf(false) }

    BasicTextField(
        modifier = modifier
            .fillMaxWidth()
            .height(36.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(color = ExtraLightGray)
            .onFocusChanged { focusState = it.isFocused }
            .padding(horizontal = 8.dp, vertical = 6.dp),
        value = value,
        onValueChange = onValueChange,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
        ),
        keyboardActions = KeyboardActions(onDone = {
            focusManager.clearFocus()
        }),
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
                if (!focusState && value.isEmpty()) Text(
                    text = placeholder,
                    color = GrayForCommunityCard,
                    fontSize = MaterialTheme.typography.BodyText1.fontSize,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = SFProDisplay,
                    lineHeight = 24.sp
                )
                innerTextField()
            }
        },
        visualTransformation = NameSurnameVisualTransformation(),
        maxLines = 1
    )
}
class NameSurnameVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        // Change the first character to uppercase if it exists
        val transformedText = if (text.text.isNotEmpty()) {
            text.text.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
        } else {
            text.text
        }

        return TransformedText(
            AnnotatedString(transformedText),
            OffsetMapping.Identity
        )
    }
}