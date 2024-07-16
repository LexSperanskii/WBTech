package com.example.spa_wb_junior_devmeetingapp.ui.screens.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spa_wb_junior_devmeetingapp.R
import com.example.spa_wb_junior_devmeetingapp.ui.screens.utils.UiUtils.replaceFirstCharToCapitalCase
import com.example.spa_wb_junior_devmeetingapp.ui.theme.BodyText1
import com.example.spa_wb_junior_devmeetingapp.ui.theme.ExtraDarkPurpleForBottomBar
import com.example.spa_wb_junior_devmeetingapp.ui.theme.ExtraLightGray
import com.example.spa_wb_junior_devmeetingapp.ui.theme.GrayForCommunityCard
import com.example.spa_wb_junior_devmeetingapp.ui.theme.SFProDisplay

@Composable
fun MySearchBar(
    value : String,
    onValueChange: (String) -> Unit,
    onDoneKeyboardPressed: () -> Unit,
    modifier: Modifier = Modifier,
    placeholder : String = stringResource(id = R.string.search),
) {
    val focusManager = LocalFocusManager.current
    var focusState by remember { mutableStateOf(false) }

    BasicTextField(
        modifier = modifier
            .fillMaxWidth()
            .heightIn(36.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(color = ExtraLightGray)
            .onFocusChanged { focusState = it.isFocused }
            .padding(horizontal = 8.dp, vertical = 6.dp),
        value = value,
        onValueChange = {
            onValueChange(replaceFirstCharToCapitalCase(it))
        },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
        ),
        keyboardActions = KeyboardActions(onDone = {
            onDoneKeyboardPressed()
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
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = stringResource(id = R.string.search),
                    tint = GrayForCommunityCard,
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .size(24.dp)
                )
                when{
                    !focusState && value.isEmpty() -> {
                        Text(
                            text = placeholder,
                            color = GrayForCommunityCard,
                            fontSize = MaterialTheme.typography.BodyText1.fontSize,
                            fontWeight = FontWeight.SemiBold,
                            fontFamily = SFProDisplay,
                            lineHeight = 24.sp
                        )
                    }
                    else -> {
                        innerTextField()
                    }
                }
            }
        }
    )
}