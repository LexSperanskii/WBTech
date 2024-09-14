package com.example.ui_v2.ui

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
import com.example.ui_v2.models.CommunitiesAdvertBlockModelUI
import com.example.ui_v2.models.CommunityModelUI
import com.example.ui_v2.models.CountryModelUI
import com.example.ui_v2.models.EventModelUI
import com.example.ui_v2.models.UserModelUI
import com.example.ui_v2.navigation.NavigationDestination
import com.example.ui_v2.ui.components.BackBar
import com.example.ui_v2.ui.components.BackShareBar
import com.example.ui_v2.ui.components.Banner
import com.example.ui_v2.ui.components.ButtonWithStatus
import com.example.ui_v2.ui.components.ClassicSwitch
import com.example.ui_v2.ui.components.CommunitiesAdvertBlockCarousel
import com.example.ui_v2.ui.components.CommunityCard
import com.example.ui_v2.ui.components.CustomSwitch
import com.example.ui_v2.ui.components.EvensCarousel
import com.example.ui_v2.ui.components.EvensFixBlockCarousel
import com.example.ui_v2.ui.components.EventCard
import com.example.ui_v2.ui.components.JoinEventButton
import com.example.ui_v2.ui.components.MorePeople
import com.example.ui_v2.ui.components.NameSurnameTextField
import com.example.ui_v2.ui.components.NetworkIcon
import com.example.ui_v2.ui.components.OverlappingPeopleRow
import com.example.ui_v2.ui.components.PeopleCarousel
import com.example.ui_v2.ui.components.PersonCard
import com.example.ui_v2.ui.components.PhoneNumberInput
import com.example.ui_v2.ui.components.PitcherBlock
import com.example.ui_v2.ui.components.SearchFieldBar
import com.example.ui_v2.ui.components.TagBig
import com.example.ui_v2.ui.components.TagBlock
import com.example.ui_v2.ui.components.TagMedium
import com.example.ui_v2.ui.components.TagSmall
import com.example.ui_v2.ui.theme.DevMeetingAppTheme
import com.example.ui_v2.ui.utils.ButtonStatus
import java.util.UUID

internal object DeveloperDestination : NavigationDestination {
    override val route = "developer"
}

@Composable
internal fun DeveloperScreen() {
    val listOfEvents = listOf(
        EventModelUI(
            id = "0",
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
            id = "1",
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
            id = "2",
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
            id = "3",
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
            id = "4",
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
            id = "0",
            name = "Супер тестировщики",
            imageURL = "https://i.pinimg.com/564x/2b/03/46/2b03464cf3499a819d8533f88bcb3275.jpg"
        ),
        CommunityModelUI(
            id = "1",
            name = "Супер программисты",
            imageURL = "https://i.pinimg.com/564x/2b/03/46/2b03464cf3499a819d8533f88bcb3275.jpg"
        ),
        CommunityModelUI(
            id = "2",
            name = "Катающие на пудже",
            imageURL = "https://i.pinimg.com/564x/2b/03/46/2b03464cf3499a819d8533f88bcb3275.jpg"
        ), CommunityModelUI(
            id = "3",
            name = "Чел",
            imageURL = "https://i.pinimg.com/564x/2b/03/46/2b03464cf3499a819d8533f88bcb3275.jpg"
        ), CommunityModelUI(
            id = "4",
            name = "Бомбящие пуканы",
            imageURL = "https://i.pinimg.com/564x/2b/03/46/2b03464cf3499a819d8533f88bcb3275.jpg"
        ),
        CommunityModelUI(
            id = "5",
            name = "Вкусно и точка",
            imageURL = "https://i.pinimg.com/564x/2b/03/46/2b03464cf3499a819d8533f88bcb3275.jpg"
        ),
        CommunityModelUI(
            id = "6",
            name = "IT Crew",
            imageURL = "https://i.pinimg.com/564x/2b/03/46/2b03464cf3499a819d8533f88bcb3275.jpg"
        ),
        CommunityModelUI(
            id = "7",
            name = "Отчаянные домохозйки",
            imageURL = "https://i.pinimg.com/564x/2b/03/46/2b03464cf3499a819d8533f88bcb3275.jpg"
        )
    )

    val listOfPeople = listOf(
        UserModelUI(
            id = "0",
            nameSurname = "Маша",
            listOfTags = listOf("Разработка"),
            imageURL = "https://i.pinimg.com/564x/01/01/a5/0101a59c68793d844cc2d23e3cd26274.jpg"
        ),
        UserModelUI(
            id = "1",
            nameSurname = "Коля",
            listOfTags = listOf("Разработка"),
            imageURL = "https://i.pinimg.com/564x/01/01/a5/0101a59c68793d844cc2d23e3cd26274.jpg"
        ),
        UserModelUI(
            id = "2",
            nameSurname = "Миша",
            listOfTags = listOf("Разработка"),
            imageURL = "https://i.pinimg.com/564x/01/01/a5/0101a59c68793d844cc2d23e3cd26274.jpg"
        ),
        UserModelUI(
            id = "3",
            nameSurname = "Женя",
            listOfTags = listOf("Разработка"),
            imageURL = "https://i.pinimg.com/564x/01/01/a5/0101a59c68793d844cc2d23e3cd26274.jpg"
        ),
        UserModelUI(
            id = "4",
            nameSurname = "Даша",
            listOfTags = listOf("Разработка"),
            imageURL = "https://i.pinimg.com/564x/01/01/a5/0101a59c68793d844cc2d23e3cd26274.jpg"
        ), UserModelUI(
            id = "5",
            nameSurname = "Витя",
            listOfTags = listOf("Разработка"),
            imageURL = "https://i.pinimg.com/564x/01/01/a5/0101a59c68793d844cc2d23e3cd26274.jpg"
        ), UserModelUI(
            id = "6",
            nameSurname = "Саша",
            listOfTags = listOf("Разработка"),
            imageURL = "https://i.pinimg.com/564x/01/01/a5/0101a59c68793d844cc2d23e3cd26274.jpg"
        ), UserModelUI(
            id = "7",
            nameSurname = "Сережа",
            listOfTags = listOf("Разработка"),
            imageURL = "https://i.pinimg.com/564x/01/01/a5/0101a59c68793d844cc2d23e3cd26274.jpg"
        ), UserModelUI(
            id = "8",
            nameSurname = "Федя",
            listOfTags = listOf("Разработка"),
            imageURL = "https://i.pinimg.com/564x/01/01/a5/0101a59c68793d844cc2d23e3cd26274.jpg"
        ), UserModelUI(
            id = "9",
            nameSurname = "Валя",
            listOfTags = listOf("Разработка"),
            imageURL = "https://i.pinimg.com/564x/01/01/a5/0101a59c68793d844cc2d23e3cd26274.jpg"
        )
    )
    val listOfPeople2 = listOf(
        UserModelUI(
            id = "0",
            nameSurname = "Маша",
            listOfTags = listOf("Разработка"),
            imageURL = "https://i.pinimg.com/564x/01/01/a5/0101a59c68793d844cc2d23e3cd26274.jpg"
        ),
        UserModelUI(
            id = "1",
            nameSurname = "Коля",
            listOfTags = listOf("Разработка"),
            imageURL = "https://i.pinimg.com/564x/01/01/a5/0101a59c68793d844cc2d23e3cd26274.jpg"
        ),
        UserModelUI(
            id = "2",
            nameSurname = "Миша",
            listOfTags = listOf("Разработка"),
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
                PitcherBlock(
                    pitcher = UserModelUI(
                        id = "0",
                        nameSurname = "Павел Хориков",
                        listOfTags = listOf("HR"),
                        description = "Ведущий специалист по подбору персонала в одной из крупнейших IT-компаний в ЕС.",
                        imageURL = "https://i.pinimg.com/564x/25/b9/d5/25b9d5877b216b9edd7fbdd93955d968.jpg"
                    ),
                    onPitcherClick = { }
                )
            }
            item {
                OverlappingPeopleRow(
                    participantsList = listOfPeople2,
                    onOverlappingRowClick = {},
                    reverse = true
                )
            }
            item {
                JoinEventButton(
                    eventRestCapacity = 1,
                    onButtonClick = { },
                    buttonStatus = ButtonStatus.Active,
                    isButtonEnabled = true
                )
            }
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
                CommunitiesAdvertBlockCarousel(
                    communitiesAdvert = CommunitiesAdvertBlockModelUI(
                        id = UUID.randomUUID().toString(),
                        nameOfBlock = "Сообщества для тестировщиков",
                        listOfCommunities = communitiesList
                    ),
                    myCommunitiesList = listOf(),
                    onCommunityButtonClick = { communityButton = !communityButton },
                    onCommunityClick = {}
                )
            }
            item {
                EvensFixBlockCarousel(
                    blockText = "Ближайшие встречи",
                    blockEventsList = listOfEvents,
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
                    isShowProfile = true,
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
                    networkIcon = R.drawable.label_xabr,
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
                EventCard(
                    event = listOfEvents[0],
                    onEventCardClick = {},
                    eventCardWidth = 212.dp
                )
            }
            item {
                EventCard(
                    event = listOfEvents[0],
                    onEventCardClick = {},
                )
            }
            item {
                CommunityCard(
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
                PhoneNumberInput(
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
                    notPressedText = "Оплатить",
                    pressedText = "Оплатить",
                    onClick = {},
                    buttonStatus = ButtonStatus.Active,
                    isButtonEnabled = true
                )
            }
            item {
                ButtonWithStatus(
                    notPressedText = "Оплатить",
                    pressedText = "Оплатить",
                    onClick = {},
                    buttonStatus = ButtonStatus.Active,
                    isButtonEnabled = true
                )
            }
            item {
                ButtonWithStatus(
                    notPressedText = "Оплатить",
                    pressedText = "Оплатить",
                    onClick = {},
                    buttonStatus = ButtonStatus.Loading,
                    isButtonEnabled = true
                )
            }
            item {
                ButtonWithStatus(
                    notPressedText = "Оплатить",
                    pressedText = "Оплатить",
                    onClick = {},
                    buttonStatus = ButtonStatus.Pressed,
                    isButtonEnabled = true
                )
            }
            item {
                ButtonWithStatus(
                    notPressedText = "Оплатить",
                    pressedText = "Оплатить",
                    onClick = {},
                    buttonStatus = ButtonStatus.Active,
                    isButtonEnabled = false
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