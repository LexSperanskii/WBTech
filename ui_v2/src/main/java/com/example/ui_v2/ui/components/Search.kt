package com.example.ui_v2.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.example.ui_v2.R
import com.example.ui_v2.ui.theme.DevMeetingAppTheme
import com.example.ui_v2.ui.utils.UiUtils.replaceFirstCharToCapitalCase

@Composable
internal fun SearchFieldBar(
    searchField: String,
    onSearchFieldChange: (String) -> Unit,
    onClearIconClick: () -> Unit,
    onUserIconClick: () -> Unit,
    onCancelClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Search(
            searchField = searchField,
            onSearchFieldChange = onSearchFieldChange,
            onClearIconClick = onClearIconClick,
            modifier = Modifier.weight(1f)
        )
        when (searchField.isEmpty()) {
            true -> {
                Icon(
                    painter = painterResource(id = R.drawable.icon_user),
                    contentDescription = stringResource(id = R.string.icon),
                    tint = DevMeetingAppTheme.colors.buttonTextPurple,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .size(32.dp, 44.dp)
                        .clickable { onUserIconClick() }
                )
            }

            else -> {
                Text(
                    text = stringResource(id = R.string.cancel),
                    color = DevMeetingAppTheme.colors.buttonTextPurple,
                    style = DevMeetingAppTheme.typography.metadata2,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .clickable { onCancelClick() }
                )
            }
        }
    }
}

@Composable
internal fun Search(
    searchField: String,
    onSearchFieldChange: (String) -> Unit,
    onClearIconClick: () -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = stringResource(id = R.string.search_placeholder),
) {
    val focusManager = LocalFocusManager.current
    var focusState by remember { mutableStateOf(false) }

    BasicTextField(
        modifier = modifier
            .height(44.dp)
            .clip(RoundedCornerShape(DevMeetingAppTheme.dimensions.cornerShapeMedium))
            .background(color = DevMeetingAppTheme.colors.disabledButtonGray)
            .onFocusChanged { focusState = it.isFocused }
            .padding(horizontal = 10.dp, vertical = 12.dp),
        value = searchField,
        onValueChange = {
            onSearchFieldChange(replaceFirstCharToCapitalCase(it))
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
        ),
        keyboardActions = KeyboardActions(onDone = {
            focusManager.clearFocus()
        }),
        textStyle = TextStyle(
            color = DevMeetingAppTheme.colors.black,
            fontSize = DevMeetingAppTheme.typography.metadata1.fontSize,
            fontWeight = DevMeetingAppTheme.typography.metadata1.fontWeight,
            fontFamily = DevMeetingAppTheme.typography.metadata1.fontFamily,
            lineHeight = DevMeetingAppTheme.typography.metadata1.lineHeight
        ),
        decorationBox = { innerTextField ->
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.weight(1f)
                ) {
                    when {
                        !focusState && searchField.isEmpty() -> {
                            SearchPlaceholder(
                                placeholder = placeholder
                            )
                        }

                        else -> {
                            innerTextField()
                        }
                    }
                }
                if (searchField.isNotEmpty()) {
                    ClearIcon(
                        onClearIconClick = onClearIconClick,
                        modifier = Modifier
                    )
                }
            }
        }
    )
}

@Composable
private fun SearchPlaceholder(
    placeholder: String,
) {
    Icon(
        imageVector = Icons.Outlined.Search,
        contentDescription = stringResource(id = R.string.search),
        tint = DevMeetingAppTheme.colors.eventCardText,
        modifier = Modifier
            .padding(end = 6.dp)
            .size(22.dp)
    )
    Text(
        text = placeholder,
        color = DevMeetingAppTheme.colors.grayForCommunityCard,
        style = DevMeetingAppTheme.typography.metadata1,
    )
}

@Composable
private fun ClearIcon(
    onClearIconClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Icon(
        painter = painterResource(id = R.drawable.icon_cross),
        contentDescription = stringResource(id = R.string.search),
        tint = DevMeetingAppTheme.colors.eventCardText,
        modifier = modifier
            .padding(start = 6.dp)
            .clickable {
                onClearIconClick()
            }
            .size(22.dp)
    )
}