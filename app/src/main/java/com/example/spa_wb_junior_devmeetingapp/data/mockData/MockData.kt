package com.example.spa_wb_junior_devmeetingapp.data.mockData

import com.example.spa_wb_junior_devmeetingapp.R
import com.example.spa_wb_junior_devmeetingapp.model.CommunityItem
import com.example.spa_wb_junior_devmeetingapp.model.Country
import com.example.spa_wb_junior_devmeetingapp.model.EventItem
import com.example.spa_wb_junior_devmeetingapp.model.EventStatus
import org.threeten.bp.LocalDate


val mockCountryList = listOf(
    Country("Russia", "+7", R.drawable.flag_rus),
    Country("Kazakhstan", "+7", R.drawable.flag_kz),
    Country("UK", "+44", R.drawable.flag_gb),
    Country("China", "+86", R.drawable.flag_cn),
    Country("Germany", "+49", R.drawable.flag_ger),
)

const val avatarIconURL =  "https://i.pinimg.com/564x/01/01/a5/0101a59c68793d844cc2d23e3cd26274.jpg"
const val IconURL1 = "https://i.pinimg.com/564x/07/1e/f4/071ef43b8a3e3a3e32eba626da61faa9.jpg"
const val IconURL2 = "https://i.pinimg.com/564x/25/b9/d5/25b9d5877b216b9edd7fbdd93955d968.jpg"
const val IconURL3 = "https://i.pinimg.com/564x/f4/e0/c8/f4e0c8655494b4ed5fb490df336c5dcb.jpg"
const val IconURL4 = "https://i.pinimg.com/564x/51/c8/ed/51c8ed24ded0e56fbeedd10fa8d424d5.jpg"
const val IconURL5 = "https://i.pinimg.com/736x/62/e5/50/62e550bc4e1bcc5bfd75b26127e63b6a.jpg"
const val IconURL6 = "https://i.pinimg.com/564x/df/eb/ab/dfebab351d764bc388c05a5f866b46d4.jpg"
const val IconURL7 = "https://i.pinimg.com/564x/01/01/a5/0101a59c68793d844cc2d23e3cd26274.jpg"
const val IconURL8 = "https://i.pinimg.com/564x/dc/c4/ef/dcc4ef15c657260d1d13331daf3a13c8.jpg"

val mockListEventsAll = listOf(
    EventItem(
        eventName = "Все встречи 1",
        eventStatus = EventStatus.NONE,
        eventDate = LocalDate.of(2023, 9, 1),
        eventPlace = "Петрозаводск",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = IconURL1,
        eventIsScheduled = true,
        communityId = 1
    ),
    EventItem(
        eventName = "Все встречи 2",
        eventStatus = EventStatus.FINISHED,
        eventDate = LocalDate.of(2023, 9, 2),
        eventPlace = "Майкоп",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = IconURL2,
        eventIsScheduled = false,
        communityId = 2
    ),
    EventItem(
        eventName = "Все встречи 3",
        eventStatus = EventStatus.NONE,
        eventDate = LocalDate.of(2023, 9, 3),
        eventPlace = "Владивосток",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = IconURL3,
        eventIsScheduled = true,
        communityId = 3
    ),
    EventItem(
        eventName = "Все встречи 4",
        eventStatus = EventStatus.FINISHED,
        eventDate = LocalDate.of(2023, 9, 4),
        eventPlace = "Краснодар",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = IconURL4,
        eventIsScheduled = false,
        communityId = 4
    ),
    EventItem(
        eventName = "Все встречи 5",
        eventStatus = EventStatus.NONE,
        eventDate = LocalDate.of(2023, 9, 5),
        eventPlace = "Рязань",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = IconURL5,
        eventIsScheduled = true,
        communityId = 1
    ),
    EventItem(
        eventName = "Все встречи 6",
        eventStatus = EventStatus.FINISHED,
        eventDate = LocalDate.of(2023, 9, 6),
        eventPlace = "Сочи",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = IconURL6,
        eventIsScheduled = false,
        communityId = 2
    ),
    EventItem(
        eventName = "Все встречи 7",
        eventStatus = EventStatus.NONE,
        eventDate = LocalDate.of(2023, 9, 7),
        eventPlace = "Санкт-Петербург",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = IconURL7,
        eventIsScheduled = true,
        communityId = 3
    ),
    EventItem(
        eventName = "Все встречи 7",
        eventStatus = EventStatus.FINISHED,
        eventDate = LocalDate.of(2023, 9, 8),
        eventPlace = "Москва",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = IconURL8,
        eventIsScheduled = false,
        communityId = 4
    ),
    EventItem(
        eventName = "Все встречи 9",
        eventStatus = EventStatus.NONE,
        eventDate = LocalDate.of(2023, 9, 9),
        eventPlace = "Казань",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = IconURL1,
        eventIsScheduled = true,
        communityId = 1
    ),
    EventItem(
        eventName = "Все встречи 10",
        eventStatus = EventStatus.FINISHED,
        eventDate = LocalDate.of(2023, 9, 10),
        eventPlace = "Петрозаводск",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = IconURL2,
        eventIsScheduled = false,
        communityId = 2
    ),
    EventItem(
        eventName = "Все встречи 11",
        eventStatus = EventStatus.NONE,
        eventDate = LocalDate.of(2023, 9, 10),
        eventPlace = "Майкоп",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = IconURL3,
        eventIsScheduled = true,
        communityId = 3
    ),
    EventItem(
        eventName = "Все встречи 12",
        eventStatus = EventStatus.FINISHED,
        eventDate = LocalDate.of(2023, 9, 12),
        eventPlace = "Владивосток",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = IconURL4,
        eventIsScheduled = false,
        communityId = 4
    ),
    EventItem(
        eventName = "Все встречи 13",
        eventStatus = EventStatus.NONE,
        eventDate = LocalDate.of(2023, 9, 10),
        eventPlace = "Краснодар",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = IconURL5,
        eventIsScheduled = true,
        communityId = 1
    ),
    EventItem(
        eventName = "Мои встречи 14",
        eventStatus = EventStatus.FINISHED,
        eventDate = LocalDate.of(2023, 9, 14),
        eventPlace = "Петрозаводск",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = IconURL6,
        eventIsScheduled = false,
        communityId = 2
    ),
    EventItem(
        eventName = "Мои встречи 15",
        eventStatus = EventStatus.NONE,
        eventDate = LocalDate.of(2023, 9, 15),
        eventPlace = "Майкоп",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = IconURL7,
        eventIsScheduled = true,
        communityId = 3
    ),
    EventItem(
        eventName = "Мои встречи 16",
        eventStatus = EventStatus.FINISHED,
        eventDate = LocalDate.of(2023, 9, 16),
        eventPlace = "Владивосток",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = IconURL8,
        eventIsScheduled = false,
        communityId = 4
    ),
    EventItem(
        eventName = "Мои встречи 17",
        eventStatus = EventStatus.NONE,
        eventDate = LocalDate.of(2023, 9, 17),
        eventPlace = "Краснодар",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = IconURL1,
        eventIsScheduled = true,
        communityId = 1
    ),
    EventItem(
        eventName = "Мои встречи 18",
        eventStatus = EventStatus.FINISHED,
        eventDate = LocalDate.of(2023, 9, 18),
        eventPlace = "Рязань",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = IconURL2,
        eventIsScheduled = false,
        communityId = 2
    ),
    EventItem(
        eventName = "Мои встречи 19",
        eventStatus = EventStatus.NONE,
        eventDate = LocalDate.of(2023, 9, 19),
        eventPlace = "Сочи",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = IconURL3,
        eventIsScheduled = true,
        communityId = 3
    ),
    EventItem(
        eventName = "Мои встречи 20",
        eventStatus = EventStatus.FINISHED,
        eventDate = LocalDate.of(2023, 9, 20),
        eventPlace = "Санкт-Петербург",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = IconURL4,
        eventIsScheduled = false,
        communityId = 4
    )
)

val mockListOfCommunities = listOf(
    CommunityItem(
        communityName = "Имя сообщества 1",
        communitySize = 1,
        communityIconURL = IconURL1
    ),
    CommunityItem(
        communityName = "Имя сообщества 2",
        communitySize = 2,
        communityIconURL = IconURL2
    ),
    CommunityItem(
        communityName = "Имя сообщества 3",
        communitySize = 4,
        communityIconURL = IconURL3
    ),
    CommunityItem(
        communityName = "Имя сообщества 4",
        communitySize = 5,
        communityIconURL = IconURL4
    ),
    CommunityItem(
        communityName = "Имя сообщества 5",
        communitySize = 1500,
        communityIconURL = IconURL5
    ),
    CommunityItem(
        communityName = "Имя сообщества 6",
        communitySize = 7000,
        communityIconURL = IconURL6
    ),
    CommunityItem(
        communityName = "Имя сообщества 7",
        communitySize = 15000,
        communityIconURL = IconURL7
    ),
    CommunityItem(
        communityName = "Имя сообщества 8",
        communitySize = 150000,
        communityIconURL = IconURL8
    ),
    CommunityItem(
        communityName = "Имя сообщества 9",
        communitySize = 1000000,
        communityIconURL = IconURL1
    ),
    CommunityItem(
        communityName = "Имя сообщества 10",
        communitySize = 10000000,
        communityIconURL = IconURL2
    )
)

const val longText = "Гай Ю́лий Це́зарь (аутентичное произношение близко к Ка́йсар[4]; лат. Gaius Iulius Caesar [ˈgaːjʊs ˈjuːliʊs ˈkae̯sar]; 12 июля 100 года до н. э.[5] — 15 марта 44 года до н. э.) — древнеримский государственный и политический деятель, полководец, писатель. Консул 59, 48, 46, 45 и 44 годов до н. э., диктатор 49, 48—47 и 46—44 годов до н. э., великий понтифик с 63 года до н. э.\n" +
        "\n" +
        "Происходивший из древней патрицианской семьи, Цезарь последовательно добивался всех ординарных римских должностей (cursus honorum) и сделал себе имя на борьбе с консервативными сенаторами (оптиматами). В 60 году до н. э. организовал первый триумвират с двумя влиятельными политиками — Гнеем Помпеем Великим и Марком Лицинием Крассом. С 58 года до н. э. более восьми лет провёл на территории современных Швейцарии, Франции, Бельгии, Германии и Великобритании в Галльской войне, присоединив к Римской республике огромную территорию от Атлантического океана до Рейна и снискав славу талантливого полководца. В начале 49 года до н. э. начал гражданскую войну из-за непримиримых разногласий с сенаторами по вопросам о деталях своего возвращения в Рим и о гарантиях судебной неприкосновенности за должностные преступления (подкупы на выборах, взятки должностным лицам, нарушение договоров, насильственные действия и другие нарушения). За четыре года сторонники сената, сгруппировавшиеся вокруг Помпея, были разбиты Цезарем в Италии, Испании (дважды), Греции и Африке, также им были разбиты войска правителей Египта и Понта.\n" +
        "\n" +
        "Придерживался «политики милосердия», но в то же время казнил ряд своих ключевых оппонентов. Добившись полной победы над противниками, сконцентрировал в своих руках власть консула и чрезвычайные полномочия диктатора (в конце концов — в виде пожизненной должности), провёл ряд реформ во всех сферах жизни общества. При жизни Цезаря началось его обожествление, почётный титул полководца-победителя «император» стал частью его имени, однако он отказывался от власти древних римских царей. После убийства Цезаря группой сенаторов во главе с Марком Юнием Брутом внучатый племянник Цезаря Гай Октавий принял его имя и получил большую часть наследства по завещанию, став впоследствии первым императором.\n" +
        "\n" +
        "К Цезарю по-разному относились при жизни, и эта традиция сохранилась в Римской империи: его имя всячески обелялось сторонниками правителей, а оппозиционеры восхваляли его жертв и заговорщиков. Очень популярной была личность Цезаря в Средние века и Новое время. Помимо политической и военной деятельности, Цезарь известен и как литератор. Из-за простоты и ясности стиля, его сочинения считаются классикой древнеримской литературы и используются при обучении латыни. К имени Юлия Цезаря восходят титулы кайзер и царь, название седьмого месяца года во многих языках мира — июль."


val mockAccountsIconsURLList1 = listOf(
    IconURL1,IconURL2,IconURL3,IconURL4,IconURL5,IconURL6,IconURL7,IconURL8
)
val mockAccountsIconsURLList2 = listOf(
    IconURL1,IconURL2,IconURL3
)