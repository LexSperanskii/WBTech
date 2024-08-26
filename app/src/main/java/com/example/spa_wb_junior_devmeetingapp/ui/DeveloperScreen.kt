package com.example.spa_wb_junior_devmeetingapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.spa_wb_junior_devmeetingapp.R
import com.example.ui_v2.models.CountryModelUI
import com.example.ui_v2.models.NewCommunityModelUI
import com.example.ui_v2.models.NewCountryModelUI
import com.example.ui_v2.models.NewEventModelUI
import com.example.ui_v2.models.NewUserModelUI
import com.example.ui_v2.models.RegisteredPersonModelUI
import com.example.ui_v2.ui.navigation.NavigationDestination
import com.example.spa_wb_junior_devmeetingapp.ui.newUi.components.BackBar
import com.example.spa_wb_junior_devmeetingapp.ui.newUi.components.BackShareBar
import com.example.spa_wb_junior_devmeetingapp.ui.newUi.components.Banner
import com.example.spa_wb_junior_devmeetingapp.ui.newUi.components.ButtonStatus
import com.example.spa_wb_junior_devmeetingapp.ui.newUi.components.ButtonWithStatus
import com.example.spa_wb_junior_devmeetingapp.ui.newUi.components.ClassicSwitch
import com.example.spa_wb_junior_devmeetingapp.ui.newUi.components.CommunitiesCarousel
import com.example.spa_wb_junior_devmeetingapp.ui.newUi.components.CustomSwitch
import com.example.spa_wb_junior_devmeetingapp.ui.newUi.components.EvensCarousel
import com.example.spa_wb_junior_devmeetingapp.ui.newUi.components.MorePeople
import com.example.spa_wb_junior_devmeetingapp.ui.newUi.components.NameSurnameTextField
import com.example.spa_wb_junior_devmeetingapp.ui.newUi.components.NetworkIcon
import com.example.spa_wb_junior_devmeetingapp.ui.newUi.components.NewCommunityCard
import com.example.spa_wb_junior_devmeetingapp.ui.newUi.components.NewEventCard
import com.example.spa_wb_junior_devmeetingapp.ui.newUi.components.NewPhoneNumberInput
import com.example.spa_wb_junior_devmeetingapp.ui.newUi.components.PeopleCarousel
import com.example.spa_wb_junior_devmeetingapp.ui.newUi.components.PersonCard
import com.example.spa_wb_junior_devmeetingapp.ui.newUi.components.SearchFieldBar
import com.example.spa_wb_junior_devmeetingapp.ui.newUi.components.TagBig
import com.example.spa_wb_junior_devmeetingapp.ui.newUi.components.TagBlock
import com.example.spa_wb_junior_devmeetingapp.ui.newUi.components.TagMedium
import com.example.spa_wb_junior_devmeetingapp.ui.newUi.components.TagSmall
import com.example.spa_wb_junior_devmeetingapp.ui.newUi.components.UpcomingEvensCarousel
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.elements.CommunityCard
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.elements.CustomFilterChip
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.elements.EventCard
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.elements.MySearchBar
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.elements.OverlappingPeopleRow
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.elements.PersonAvatar
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.elements.PhoneNumberInput
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.elements.PinCodeInput
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.elements.TypographyItem
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.elements.TypographyRow
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.elements.buttons.CustomButton
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.elements.buttons.CustomButtonOutlined
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.elements.buttons.CustomButtonOutlinedRipple
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.elements.buttons.CustomButtonRipple
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.elements.buttons.CustomButtonText
import com.example.spa_wb_junior_devmeetingapp.ui.theme.DevMeetingAppTheme

internal object DeveloperDestination : com.example.ui_v2.ui.navigation.NavigationDestination {
    override val route = "developer"
    override val title = R.string.developer
}

@Composable
internal fun DeveloperScreen() {
    val typographyList = listOf(
        TypographyItem(
            style = DevMeetingAppTheme.typography.heading1,
            title = "Heading 1",
            subTitle = "SF Pro Display/32/Bold"
        ),
        TypographyItem(
            style = DevMeetingAppTheme.typography.heading2,
            title = "Heading 2",
            subTitle = "SF Pro Display/24/Bold"
        ),
        TypographyItem(
            style = DevMeetingAppTheme.typography.subheading1,
            title = "Subheading 1",
            subTitle = "SF Pro Display/18/SemiBold"
        ),
        TypographyItem(
            style = DevMeetingAppTheme.typography.subheading2,
            title = "Subheading 2",
            subTitle = "SF Pro Display/16/SemiBold"
        ),
        TypographyItem(
            style = DevMeetingAppTheme.typography.bodyText1,
            title = "Body Text 1",
            subTitle = "SF Pro Display/14/SemiBold"
        ),
        TypographyItem(
            style = DevMeetingAppTheme.typography.bodyText2,
            title = "Body Text 2",
            subTitle = "SF Pro Display/14/Regular"
        ),
        TypographyItem(
            style = DevMeetingAppTheme.typography.metadata1,
            title = "Metadata 1",
            subTitle = "SF Pro Display/12/Regular"
        ),
        TypographyItem(
            style = DevMeetingAppTheme.typography.metadata2,
            title = "Metadata 2",
            subTitle = "SF Pro Display/10/Regular"
        ),
        TypographyItem(
            style = DevMeetingAppTheme.typography.metadata3,
            title = "Metadata 3",
            subTitle = "SF Pro Display/10/SemiBold"
        )
    )
    val chipList = listOf(
        "Python",
        "Junior",
        "Moscow"
    )
    val listOfParticipantsForDevScreen = listOf(
        com.example.ui_v2.models.RegisteredPersonModelUI(
            0,
            "https://i.pinimg.com/564x/01/01/a5/0101a59c68793d844cc2d23e3cd26274.jpg"
        ),
        com.example.ui_v2.models.RegisteredPersonModelUI(
            1,
            "https://i.pinimg.com/564x/df/eb/ab/dfebab351d764bc388c05a5f866b46d4.jpg"
        ),
        com.example.ui_v2.models.RegisteredPersonModelUI(
            2,
            "https://i.pinimg.com/736x/62/e5/50/62e550bc4e1bcc5bfd75b26127e63b6a.jpg"
        ),
        com.example.ui_v2.models.RegisteredPersonModelUI(
            3,
            "https://i.pinimg.com/564x/f4/e0/c8/f4e0c8655494b4ed5fb490df336c5dcb.jpg"
        ),
        com.example.ui_v2.models.RegisteredPersonModelUI(
            4,
            "https://i.pinimg.com/564x/25/b9/d5/25b9d5877b216b9edd7fbdd93955d968.jpg"
        ),
        com.example.ui_v2.models.RegisteredPersonModelUI(
            5,
            "https://i.pinimg.com/564x/07/1e/f4/071ef43b8a3e3a3e32eba626da61faa9.jpg"
        )
    )
    val listOfParticipantsSmallForDevScreen = listOf(
        com.example.ui_v2.models.RegisteredPersonModelUI(
            0,
            "https://i.pinimg.com/564x/01/01/a5/0101a59c68793d844cc2d23e3cd26274.jpg"
        ),
        com.example.ui_v2.models.RegisteredPersonModelUI(
            1,
            "https://i.pinimg.com/564x/df/eb/ab/dfebab351d764bc388c05a5f866b46d4.jpg"
        ),
        com.example.ui_v2.models.RegisteredPersonModelUI(
            2,
            "https://i.pinimg.com/736x/62/e5/50/62e550bc4e1bcc5bfd75b26127e63b6a.jpg"
        )
    )
    val mockAvailableCountriesForDevScreen = listOf(
        com.example.ui_v2.models.CountryModelUI(
            "Russia",
            "+7",
            "https://i.pinimg.com/564x/42/8d/91/428d9169accc5277fc03a0c41394eb10.jpg"
        ),
        com.example.ui_v2.models.CountryModelUI(
            "Kazakhstan",
            "+7",
            "https://i.pinimg.com/564x/12/d9/f9/12d9f9633023c5f053a654da6035af7f.jpg"
        ),
        com.example.ui_v2.models.CountryModelUI(
            "UK",
            "+44",
            "https://i.pinimg.com/564x/aa/7d/c8/aa7dc8130b972fdd4837c19a189717fc.jpg"
        ),
        com.example.ui_v2.models.CountryModelUI(
            "China",
            "+86",
            "https://i.pinimg.com/564x/51/08/62/510862488ad2a8037423567218afe069.jpg"
        ),
        com.example.ui_v2.models.CountryModelUI(
            "Germany",
            "+49",
            "https://i.pinimg.com/564x/4c/b7/8b/4cb78bce83b82a83382d18d207423f48.jpg"
        )
    )
    val listOfEvents = listOf(
        com.example.ui_v2.models.NewEventModelUI(
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
        com.example.ui_v2.models.NewEventModelUI(
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
        com.example.ui_v2.models.NewEventModelUI(
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
        com.example.ui_v2.models.NewEventModelUI(
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
        com.example.ui_v2.models.NewEventModelUI(
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
        com.example.ui_v2.models.NewCommunityModelUI(
            id = 0,
            name = "Супер тестировщики",
            imageURL = "https://i.pinimg.com/564x/2b/03/46/2b03464cf3499a819d8533f88bcb3275.jpg"
        ),
        com.example.ui_v2.models.NewCommunityModelUI(
            id = 1,
            name = "Супер программисты",
            imageURL = "https://i.pinimg.com/564x/2b/03/46/2b03464cf3499a819d8533f88bcb3275.jpg"
        ),
        com.example.ui_v2.models.NewCommunityModelUI(
            id = 2,
            name = "Катающие на пудже",
            imageURL = "https://i.pinimg.com/564x/2b/03/46/2b03464cf3499a819d8533f88bcb3275.jpg"
        ), com.example.ui_v2.models.NewCommunityModelUI(
            id = 3,
            name = "Чел",
            imageURL = "https://i.pinimg.com/564x/2b/03/46/2b03464cf3499a819d8533f88bcb3275.jpg"
        ), com.example.ui_v2.models.NewCommunityModelUI(
            id = 4,
            name = "Бомбящие пуканы",
            imageURL = "https://i.pinimg.com/564x/2b/03/46/2b03464cf3499a819d8533f88bcb3275.jpg"
        ),
        com.example.ui_v2.models.NewCommunityModelUI(
            id = 5,
            name = "Вкусно и точка",
            imageURL = "https://i.pinimg.com/564x/2b/03/46/2b03464cf3499a819d8533f88bcb3275.jpg"
        ),
        com.example.ui_v2.models.NewCommunityModelUI(
            id = 6,
            name = "IT Crew",
            imageURL = "https://i.pinimg.com/564x/2b/03/46/2b03464cf3499a819d8533f88bcb3275.jpg"
        ),
        com.example.ui_v2.models.NewCommunityModelUI(
            id = 7,
            name = "Отчаянные домохозйки",
            imageURL = "https://i.pinimg.com/564x/2b/03/46/2b03464cf3499a819d8533f88bcb3275.jpg"
        )
    )

    val listOfPeople = listOf(
        com.example.ui_v2.models.NewUserModelUI(
            id = 0,
            name = "Маша",
            tag = "Разработка",
            imageURL = "https://i.pinimg.com/564x/01/01/a5/0101a59c68793d844cc2d23e3cd26274.jpg"
        ),
        com.example.ui_v2.models.NewUserModelUI(
            id = 1,
            name = "Коля",
            tag = "Менеджмент",
            imageURL = "https://i.pinimg.com/564x/01/01/a5/0101a59c68793d844cc2d23e3cd26274.jpg"
        ),
        com.example.ui_v2.models.NewUserModelUI(
            id = 2,
            name = "Миша",
            tag = "Тестирование",
            imageURL = "https://i.pinimg.com/564x/01/01/a5/0101a59c68793d844cc2d23e3cd26274.jpg"
        ),
        com.example.ui_v2.models.NewUserModelUI(
            id = 3,
            name = "Женя",
            tag = "Разработка",
            imageURL = "https://i.pinimg.com/564x/01/01/a5/0101a59c68793d844cc2d23e3cd26274.jpg"
        ),
        com.example.ui_v2.models.NewUserModelUI(
            id = 4,
            name = "Даша",
            tag = "Менеджмент",
            imageURL = "https://i.pinimg.com/564x/01/01/a5/0101a59c68793d844cc2d23e3cd26274.jpg"
        ), com.example.ui_v2.models.NewUserModelUI(
            id = 5,
            name = "Витя",
            tag = "Тестирование",
            imageURL = "https://i.pinimg.com/564x/01/01/a5/0101a59c68793d844cc2d23e3cd26274.jpg"
        ), com.example.ui_v2.models.NewUserModelUI(
            id = 6,
            name = "Саша",
            tag = "Разработка",
            imageURL = "https://i.pinimg.com/564x/01/01/a5/0101a59c68793d844cc2d23e3cd26274.jpg"
        ), com.example.ui_v2.models.NewUserModelUI(
            id = 7,
            name = "Сережа",
            tag = "Менеджмент",
            imageURL = "https://i.pinimg.com/564x/01/01/a5/0101a59c68793d844cc2d23e3cd26274.jpg"
        ), com.example.ui_v2.models.NewUserModelUI(
            id = 8,
            name = "Федя",
            tag = "Тестирование",
            imageURL = "https://i.pinimg.com/564x/01/01/a5/0101a59c68793d844cc2d23e3cd26274.jpg"
        ), com.example.ui_v2.models.NewUserModelUI(
            id = 9,
            name = "Валя",
            tag = "Разработка",
            imageURL = "https://i.pinimg.com/564x/01/01/a5/0101a59c68793d844cc2d23e3cd26274.jpg"
        )
    )

    var pinCode by remember { mutableStateOf("") }
    var countryCode by remember { mutableStateOf(mockAvailableCountriesForDevScreen[0]) }
    var phoneNumber by remember { mutableStateOf("") }

    var searchField by remember { mutableStateOf("") }
    var nameSurnameField by remember { mutableStateOf("") }

    val availableCountries = listOf(
        com.example.ui_v2.models.NewCountryModelUI("Россия", "+7", R.drawable.flag_ru),
        com.example.ui_v2.models.NewCountryModelUI("Казахстан", "+7", R.drawable.flag_kz),
        com.example.ui_v2.models.NewCountryModelUI("Белоруссия", "+375", R.drawable.flag_by),
        com.example.ui_v2.models.NewCountryModelUI("Киргизия", "+996", R.drawable.flag_kg),
        com.example.ui_v2.models.NewCountryModelUI("Азербайджан", "+994", R.drawable.flag_az)
    )
    var countryCode2 by remember { mutableStateOf(availableCountries[0]) }

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
            item {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    PinCodeInput(
                        value = pinCode,
                        onValueChange = { pinCode = it},
                        onDoneKeyboardPressed = {}
                    )
                }
            }
            item {
                PhoneNumberInput(
                    number = phoneNumber,
                    onNumberChange = { phoneNumber = it },
                    countryCode = countryCode,
                    onCountryCodeChange = { countryCode = it },
                    listOfCountriesCodes = mockAvailableCountriesForDevScreen
                )
            }
            item {
                Text(text = "Ripple Effect Buttons")
            }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    CustomButtonRipple(
                        onClick = {},
                        containerColor = DevMeetingAppTheme.colors.purple,
                        contentColor = Color.White,
                        pressedColor = DevMeetingAppTheme.colors.darkPurple,
                        rippleColor = DevMeetingAppTheme.colors.lightGray,
                        enabled = true,
                    )
                    CustomButtonOutlinedRipple(
                        onClick = {},
                        contentColor = DevMeetingAppTheme.colors.purple,
                        pressedColor = DevMeetingAppTheme.colors.darkPurple,
                        rippleColor = DevMeetingAppTheme.colors.lightGray,
                        enabled = true,
                        border = true
                    )
                    CustomButtonOutlinedRipple(
                        onClick = {},
                        contentColor = DevMeetingAppTheme.colors.purple,
                        pressedColor = DevMeetingAppTheme.colors.darkPurple,
                        rippleColor = DevMeetingAppTheme.colors.lightGray,
                        enabled = true,
                        border = false
                    )
                }
            }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    CustomButtonRipple(
                        onClick = {},
                        containerColor = DevMeetingAppTheme.colors.purple,
                        contentColor = Color.White,
                        pressedColor = DevMeetingAppTheme.colors.darkPurple,
                        rippleColor = DevMeetingAppTheme.colors.lightGray,
                        enabled = false,
                    )
                    CustomButtonOutlinedRipple(
                        onClick = {},
                        contentColor = DevMeetingAppTheme.colors.purple,
                        pressedColor = DevMeetingAppTheme.colors.darkPurple,
                        rippleColor = DevMeetingAppTheme.colors.lightGray,
                        enabled = false,
                        border = true
                    )
                    CustomButtonOutlinedRipple(
                        onClick = {},
                        contentColor = DevMeetingAppTheme.colors.purple,
                        pressedColor = DevMeetingAppTheme.colors.darkPurple,
                        rippleColor = DevMeetingAppTheme.colors.lightGray,
                        enabled = false,
                        border = false
                    )
                }
            }
            item {
                HorizontalDivider(
                    modifier = Modifier,
                    thickness = 2.dp,
                    color = Color.Black
                )
            }
            item {
                Text(text = "No Ripple Effect Buttons")
            }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    CustomButton(
                        onClick = {},
                        pressedColor = DevMeetingAppTheme.colors.darkPurple,
                        containerColor = DevMeetingAppTheme.colors.purple,
                        contentColor = Color.White
                    )
                    CustomButtonOutlined(
                        onClick = {},
                        pressedColor = DevMeetingAppTheme.colors.darkPurple,
                        containerColor = Color. Transparent,
                        contentColor = DevMeetingAppTheme.colors.purple
                    )
                    CustomButtonText(
                        onClick = {},
                        pressedColor = DevMeetingAppTheme.colors.darkPurple,
                        contentColor = DevMeetingAppTheme.colors.purple
                    )
                }
            }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    CustomButton(
                        onClick = {},
                        pressedColor = DevMeetingAppTheme.colors.darkPurple,
                        containerColor = DevMeetingAppTheme.colors.purple,
                        contentColor = Color.White,
                        enabled = false
                    )
                    CustomButtonOutlined(
                        onClick = {},
                        pressedColor = DevMeetingAppTheme.colors.darkPurple,
                        containerColor = Color. Transparent,
                        contentColor = DevMeetingAppTheme.colors.purple,
                        enabled = false
                    )
                    CustomButtonText(
                        onClick = {},
                        pressedColor = DevMeetingAppTheme.colors.darkPurple,
                        contentColor = DevMeetingAppTheme.colors.purple,
                        enabled = false
                    )
                }
            }
            item {
                typographyList.forEach{
                    TypographyRow(
                        style = it.style,
                        title = it.title,
                        subTitle = it.subTitle,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                }
            }
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    PersonAvatar(
                        size = 200.dp,
                        imageURL = null,
                        isEdit = false
                    )
                    Image(
                        painter = painterResource(id = R.drawable.avatar_meeting),
                        contentDescription = "avatar meeting",
                        modifier = Modifier.size(48.dp),
                        contentScale = ContentScale.Fit
                    )
                }
            }
            item {
                MySearchBar(
                    value = searchField,
                    onValueChange = {searchField = it},
                    onDoneKeyboardPressed = {},
                    modifier = Modifier
                )
            }
            item {
                Row(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    chipList.forEach {
                        CustomFilterChip(it)
                    }
                }
            }
            item {
                EventCard(
                    eventName = "Developer Meeting",
                    isEventFinished = true,
                    eventDate = "05.14.2023",
                    eventCity = "Москва",
                    eventCategories = listOf("Python", "Junior", "Moscow"),
                    eventIconURL = "",
                    onEventItemClick = {},
                    modifier = Modifier
                )
            }
            item {
                EventCard(
                    eventName = "Developer Meeting",
                    isEventFinished = false,
                    eventDate = "05.14.2023",
                    eventCity = "Москва",
                    eventCategories = listOf("Python", "Junior", "Moscow"),
                    eventIconURL = "",
                    onEventItemClick = {},
                    modifier = Modifier
                )
            }
            item {
                CommunityCard(
                    communityName = "Designa",
                    communitySize = 1000000,
                    communityIconURL = "",
                    onCommunityItemClick = {},
                    modifier = Modifier
                )
            }
            item {
                CommunityCard(
                    communityName = "Designa",
                    communitySize = 1,
                    communityIconURL = "",
                    onCommunityItemClick = {},
                    modifier = Modifier
                )
            }
            item {
                OverlappingPeopleRow(
                    participantsList = listOfParticipantsForDevScreen,
                    modifier = Modifier
                )
            }
            item {
                OverlappingPeopleRow(
                    participantsList = listOfParticipantsSmallForDevScreen,
                    modifier = Modifier
                )
            }
            item {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    PersonAvatar(
                        size = 200.dp,
                        isEdit = false,
                        imageURL = null
                    )
                    PersonAvatar(
                        size = 100.dp,
                        isEdit = true,
                        imageURL = null
                    )
                }
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