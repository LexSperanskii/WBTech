package com.example.ui_v2.ui.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui_v2.R
import com.example.ui_v2.models.CommunityModelUI
import com.example.ui_v2.models.CountryModelUI
import com.example.ui_v2.models.EventModelUI
import com.example.ui_v2.models.UserModelUI
import com.example.ui_v2.ui.navigation.NavigationDestination
import com.example.ui_v2.ui.ui.components.BackBar
import com.example.ui_v2.ui.ui.components.BackShareBar
import com.example.ui_v2.ui.ui.components.Banner
import com.example.ui_v2.ui.ui.components.ButtonStatus
import com.example.ui_v2.ui.ui.components.ButtonWithStatus
import com.example.ui_v2.ui.ui.components.ClassicSwitch
import com.example.ui_v2.ui.ui.components.CommunitiesCarousel
import com.example.ui_v2.ui.ui.components.CustomSwitch
import com.example.ui_v2.ui.ui.components.EvensCarousel
import com.example.ui_v2.ui.ui.components.MorePeople
import com.example.ui_v2.ui.ui.components.NameSurnameTextField
import com.example.ui_v2.ui.ui.components.NetworkIcon
import com.example.ui_v2.ui.ui.components.NewCommunityCard
import com.example.ui_v2.ui.ui.components.NewEventCard
import com.example.ui_v2.ui.ui.components.NewPhoneNumberInput
import com.example.ui_v2.ui.ui.components.PeopleCarousel
import com.example.ui_v2.ui.ui.components.PersonCard
import com.example.ui_v2.ui.ui.components.SearchFieldBar
import com.example.ui_v2.ui.ui.components.TagBig
import com.example.ui_v2.ui.ui.components.TagBlock
import com.example.ui_v2.ui.ui.components.TagMedium
import com.example.ui_v2.ui.ui.components.TagSmall
import com.example.ui_v2.ui.ui.components.UpcomingEvensCarousel
import com.example.ui_v2.ui.ui.theme.DevMeetingAppTheme

internal object DeveloperDestination : NavigationDestination {
    override val route = "developer"
}

@Composable
internal fun DeveloperScreen() {
    val listOfEvents = listOf(
        EventModelUI(
            id = 0,
            name = "Python days",
            day = 10,
            month = "августа",
            year = 2024,
            city = "Москва",
            street = "Кожевенная линия",
            building = "40",
            imageURL = "https://i.pinimg.com/564x/2b/03/46/2b03464cf3499a819d8533f88bcb3275.jpg",
            listOfTags = listOf(
                "Тестирование",
                "Котлин",
                "Go",
                "Пудж",
                "Java",
                "Варенье"
            )
        ),
        EventModelUI(
            id = 1,
            name = "Python days",
            day = 10,
            month = "августа",
            year = 2024,
            city = "Москва",
            street = "Кожевенная линия",
            building = "40",
            imageURL = "https://i.pinimg.com/564x/2b/03/46/2b03464cf3499a819d8533f88bcb3275.jpg",
            listOfTags = listOf(
                "Тестирование",
                "Котлин",
                "Go",
                "Пудж",
                "Java",
                "Варенье"
            )
        ),
        EventModelUI(
            id = 2,
            name = "Python days",
            day = 10,
            month = "августа",
            year = 2024,
            city = "Москва",
            street = "Кожевенная линия",
            building = "40",
            imageURL = "https://i.pinimg.com/564x/2b/03/46/2b03464cf3499a819d8533f88bcb3275.jpg",
            listOfTags = listOf(
                "Тестирование",
                "Котлин",
                "Go",
                "Пудж",
                "Java",
                "Варенье"
            )
        ),
        EventModelUI(
            id = 3,
            name = "Python days",
            day = 10,
            month = "августа",
            year = 2024,
            city = "Москва",
            street = "Кожевенная линия",
            building = "40",
            imageURL = "https://i.pinimg.com/564x/2b/03/46/2b03464cf3499a819d8533f88bcb3275.jpg",
            listOfTags = listOf(
                "Тестирование",
                "Котлин",
                "Go",
                "Пудж",
                "Java",
                "Варенье"
            )
        ),
        EventModelUI(
            id = 4,
            name = "Python days",
            day = 10,
            month = "августа",
            year = 2024,
            city = "Москва",
            street = "Кожевенная линия",
            building = "40",
            imageURL = "https://i.pinimg.com/564x/2b/03/46/2b03464cf3499a819d8533f88bcb3275.jpg",
            listOfTags = listOf(
                "Тестирование",
                "Котлин",
                "Go",
                "Пудж",
                "Java",
                "Варенье"
            )
        )
    )
    val communitiesList = listOf(
        CommunityModelUI(
            id = 0,
            name = "Супер тестировщики",
            imageURL = "https://i.pinimg.com/564x/2b/03/46/2b03464cf3499a819d8533f88bcb3275.jpg"
        ),
        CommunityModelUI(
            id = 1,
            name = "Супер программисты",
            imageURL = "https://i.pinimg.com/564x/2b/03/46/2b03464cf3499a819d8533f88bcb3275.jpg"
        ),
        CommunityModelUI(
            id = 2,
            name = "Катающие на пудже",
            imageURL = "https://i.pinimg.com/564x/2b/03/46/2b03464cf3499a819d8533f88bcb3275.jpg"
        ), CommunityModelUI(
            id = 3,
            name = "Чел",
            imageURL = "https://i.pinimg.com/564x/2b/03/46/2b03464cf3499a819d8533f88bcb3275.jpg"
        ), CommunityModelUI(
            id = 4,
            name = "Бомбящие пуканы",
            imageURL = "https://i.pinimg.com/564x/2b/03/46/2b03464cf3499a819d8533f88bcb3275.jpg"
        ),
        CommunityModelUI(
            id = 5,
            name = "Вкусно и точка",
            imageURL = "https://i.pinimg.com/564x/2b/03/46/2b03464cf3499a819d8533f88bcb3275.jpg"
        ),
        CommunityModelUI(
            id = 6,
            name = "IT Crew",
            imageURL = "https://i.pinimg.com/564x/2b/03/46/2b03464cf3499a819d8533f88bcb3275.jpg"
        ),
        CommunityModelUI(
            id = 7,
            name = "Отчаянные домохозйки",
            imageURL = "https://i.pinimg.com/564x/2b/03/46/2b03464cf3499a819d8533f88bcb3275.jpg"
        )
    )

    val listOfPeople = listOf(
        UserModelUI(
            id = 0,
            name = "Маша",
            tag = "Разработка",
            imageURL = "https://i.pinimg.com/564x/01/01/a5/0101a59c68793d844cc2d23e3cd26274.jpg"
        ),
        UserModelUI(
            id = 1,
            name = "Коля",
            tag = "Менеджмент",
            imageURL = "https://i.pinimg.com/564x/01/01/a5/0101a59c68793d844cc2d23e3cd26274.jpg"
        ),
        UserModelUI(
            id = 2,
            name = "Миша",
            tag = "Тестирование",
            imageURL = "https://i.pinimg.com/564x/01/01/a5/0101a59c68793d844cc2d23e3cd26274.jpg"
        ),
        UserModelUI(
            id = 3,
            name = "Женя",
            tag = "Разработка",
            imageURL = "https://i.pinimg.com/564x/01/01/a5/0101a59c68793d844cc2d23e3cd26274.jpg"
        ),
        UserModelUI(
            id = 4,
            name = "Даша",
            tag = "Менеджмент",
            imageURL = "https://i.pinimg.com/564x/01/01/a5/0101a59c68793d844cc2d23e3cd26274.jpg"
        ), UserModelUI(
            id = 5,
            name = "Витя",
            tag = "Тестирование",
            imageURL = "https://i.pinimg.com/564x/01/01/a5/0101a59c68793d844cc2d23e3cd26274.jpg"
        ), UserModelUI(
            id = 6,
            name = "Саша",
            tag = "Разработка",
            imageURL = "https://i.pinimg.com/564x/01/01/a5/0101a59c68793d844cc2d23e3cd26274.jpg"
        ), UserModelUI(
            id = 7,
            name = "Сережа",
            tag = "Менеджмент",
            imageURL = "https://i.pinimg.com/564x/01/01/a5/0101a59c68793d844cc2d23e3cd26274.jpg"
        ), UserModelUI(
            id = 8,
            name = "Федя",
            tag = "Тестирование",
            imageURL = "https://i.pinimg.com/564x/01/01/a5/0101a59c68793d844cc2d23e3cd26274.jpg"
        ), UserModelUI(
            id = 9,
            name = "Валя",
            tag = "Разработка",
            imageURL = "https://i.pinimg.com/564x/01/01/a5/0101a59c68793d844cc2d23e3cd26274.jpg"
        )
    )
    val availableCountries = listOf(
        CountryModelUI("Россия", "+7", R.drawable.flag_ru),
        CountryModelUI("Казахстан", "+7", R.drawable.flag_kz),
        CountryModelUI("Белоруссия", "+375", R.drawable.flag_by),
        CountryModelUI("Киргизия", "+996", R.drawable.flag_kg),
        CountryModelUI("Азербайджан", "+994", R.drawable.flag_az)
    )
    var countryCode2 by remember { mutableStateOf(availableCountries[0]) }
    var phoneNumber by remember { mutableStateOf("") }
    var nameSurnameField by remember { mutableStateOf("") }
    var search by remember { mutableStateOf("") }
    var tagBig by remember { mutableStateOf(false) }
    var tagMedium by remember { mutableStateOf(false) }
    var tagSmall by remember { mutableStateOf(false) }
    var communityButton by remember { mutableStateOf(false) }
    var toggle by remember { mutableStateOf(false) }
    val listOfChosenTags = remember { mutableStateListOf<String>() }


    Scaffold { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(24.dp)
        ) {
            item {
                PeopleCarousel(
                    blockText = "Вы можете их знать",
                    listOfPeople = listOfPeople,
                    onPersonCardClick = {}
                )
            }
            item {
                TagBlock(
                    blockText = "Другие встречи",
                    listOfTags = listOf(
                        "Дизайн",
                        "Разработка", "Backend",
                        "Продакт Менеджмент", "Mobile",
                        "Проджект менеджмент",
                        "Frontend",
                        "Тестирование", "Продажи", "Бизнес",
                        "Безопасность", "Web", "Девопс", "Маркетинг", "Аналитика"
                    ),
                    listOfChosenTags = listOfChosenTags,
                    onTagClick = {
                        when (listOfChosenTags.contains(it)) {
                            true -> {
                                listOfChosenTags.remove(it)
                            }

                            else -> {
                                listOfChosenTags.add(it)
                            }
                        }
                    }
                )
            }
            item {
                CommunitiesCarousel(
                    blockText = "Сообщества для тестировщиков",
                    communitiesList = communitiesList,
                    isCommunityButtonClicked = communityButton,
                    onCommunityButtonClick = { communityButton = !communityButton },
                    onCommunityClick = {}
                )
            }
            item {
                UpcomingEvensCarousel(
                    eventsList = listOfEvents,
                    onEventCardClick = {},
                )
            }
            item {
                EvensCarousel(
                    eventsList = listOfEvents,
                    onEventCardClick = {},
                )
            }
            item {
                BackBar(
                    barText = "Пойдут на встречу",
                    onArrowClick = {}
                )
            }
            item {
                BackBar(
                    barText = "Как повышать грейд. Лекция о чем то то так и там длинный текст называния чтобы было перекрытие",
                    onArrowClick = {}
                )
            }
            item {
                BackShareBar(
                    barText = "Как повышать грейд. Лекция о чем то то так и там длинный текст называния чтобы было перекрытие",
                    onArrowClick = {},
                    onShareClick = {}
                )
            }
            item {
                SearchFieldBar(
                    searchField = search,
                    onSearchFieldChange = { search = it },
                    onClearIconClick = { search = "" },
                    onUserIconClick = {},
                    onCancelClick = {}
                )
            }
            item {
                Banner(
                    bannerText = "Расскажите о своих интересах, чтобы мы рекомендовали полезные встречи",
                    tagText = "Выбрать интересы",
                    onBannerTagClick = { /*TODO*/ }
                )
            }
            item {
                MorePeople(
                    quantity = 48
                )
            }
            item {
                CustomSwitch(
                    checked = toggle,
                    onCheckedChange = { toggle = it }
                )
            }
            item {
                ClassicSwitch(
                    checked = toggle,
                    onCheckedChange = { toggle = it }
                )
            }
            item {
                NetworkIcon(
                    networkIcon = R.drawable.label_instagram,
                    onNetworkIconClick = {}
                )
            }
            item {
                NetworkIcon(
                    networkIcon = R.drawable.label_random_social_network,
                    onNetworkIconClick = {}
                )
            }
            item {
                NetworkIcon(
                    networkIcon = R.drawable.label_telegramm,
                    onNetworkIconClick = {}
                )
            }
            item {
                NewEventCard(
                    event = listOfEvents[0],
                    onEventCardClick = {},
                    eventCardWidth = 212.dp
                )
            }
            item {
                NewEventCard(
                    event = listOfEvents[0],
                    onEventCardClick = {},
                )
            }
            item {
                NewCommunityCard(
                    community = communitiesList[0],
                    isCommunityButtonClicked = communityButton,
                    onCommunityButtonClick = { communityButton = !communityButton },
                    onCommunityClick = {}
                )
            }
            item {
                PersonCard(
                    person = listOfPeople[0],
                    onPersonCardClick = {},
                )
            }
            item {
                TagBig(
                    tagText = "Тестирование",
                    onTagClick = { tagBig = !tagBig },
                    isClicked = tagBig,
                )
            }
            item {
                TagMedium(
                    tagText = "Тестирование",
                    onTagClick = { tagMedium = !tagMedium },
                    isClicked = tagMedium,
                )
            }
            item {
                TagSmall(
                    tagText = "Тестирование",
                    onTagClick = { tagSmall = !tagSmall },
                    isClicked = tagSmall,
                )
            }
            item {
                NewPhoneNumberInput(
                    number = phoneNumber,
                    onNumberChange = { phoneNumber = it },
                    countryCode = countryCode2,
                    onCountryCodeChange = { countryCode2 = it },
                    listOfCountriesCodes = availableCountries
                )
            }
            item {
                NameSurnameTextField(
                    value = nameSurnameField,
                    isValid = true,
                    onValueChange = {
                        nameSurnameField = it
                    }
                )
            }
            item {
                ButtonWithStatus(
                    text = "Оплатить",
                    isEnabled = true,
                    onClick = {},
                    buttonStatus = ButtonStatus.NotPressed
                )
            }
            item {
                ButtonWithStatus(
                    text = "Оплатить",
                    isEnabled = false,
                    onClick = {},
                    buttonStatus = ButtonStatus.NotPressed
                )
            }
            item {
                ButtonWithStatus(
                    text = "Оплатить",
                    isEnabled = true,
                    onClick = {},
                    buttonStatus = ButtonStatus.Loading
                )
            }
            item {
                ButtonWithStatus(
                    text = "Оплачено",
                    isEnabled = true,
                    onClick = {},
                    buttonStatus = ButtonStatus.Pressed
                )
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
internal fun FirstScreenPreview() {
    DevMeetingAppTheme {
        Surface {
            DeveloperScreen()
        }
    }
}