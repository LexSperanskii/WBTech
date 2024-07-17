package com.example.spa_wb_junior_devmeetingapp.data.mockData

import com.example.spa_wb_junior_devmeetingapp.R
import com.example.spa_wb_junior_devmeetingapp.model.CommunityItem
import com.example.spa_wb_junior_devmeetingapp.model.Country
import com.example.spa_wb_junior_devmeetingapp.model.EventItem
import com.example.spa_wb_junior_devmeetingapp.model.PhoneNumber


val mockCountryList = listOf(
    Country("Russia", "+7", R.drawable.flag_rus),
    Country("Kazakhstan", "+7", R.drawable.flag_kz),
    Country("UK", "+44", R.drawable.flag_gb),
    Country("China", "+86", R.drawable.flag_cn),
    Country("Germany", "+49", R.drawable.flag_ger),
    )

val mockAccountNumber = PhoneNumber("+7","9995554422")
val mockAccountName = "Иван Иванов"


enum class EventStatus(val status: String) {
    NONE(""),
    FINISHED("Завершилась")
}

const val eventIconURL = "https://i.pinimg.com/564x/9c/b1/64/9cb164c7777bcc08bda333504b6210bf.jpg"
val mockEventsListAll = listOf(
    EventItem(
        eventName = "Все встречи",
        eventStatus = EventStatus.NONE,
        eventDate = "13.09.2024",
        eventPlace = "Петрозаводск",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = eventIconURL,
        eventIsPlaned = true
    ),
    EventItem(
        eventName = "Все встречи",
        eventStatus = EventStatus.FINISHED,
        eventDate = "14.09.2024",
        eventPlace = "Майкоп",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = eventIconURL
    ),
    EventItem(
        eventName = "Все встречи",
        eventStatus = EventStatus.NONE,
        eventDate = "15.09.2024",
        eventPlace = "Владивосток",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = eventIconURL,
        eventIsPlaned = true
    ),
    EventItem(
        eventName = "Все встречи",
        eventStatus = EventStatus.FINISHED,
        eventDate = "16.09.2024",
        eventPlace = "Краснодар",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = eventIconURL
    ),
    EventItem(
        eventName = "Все встречи",
        eventStatus = EventStatus.FINISHED,
        eventDate = "17.09.2024",
        eventPlace = "Рязань",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = eventIconURL,
        eventIsPlaned = true
    ),
    EventItem(
        eventName = "Все встречи",
        eventStatus = EventStatus.NONE,
        eventDate = "18.09.2024",
        eventPlace = "Сочи",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = eventIconURL
    ),
    EventItem(
        eventName = "Все встречи",
        eventStatus = EventStatus.FINISHED,
        eventDate = "19.09.2024",
        eventPlace = "Санкт-Петербург",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = eventIconURL,
        eventIsPlaned = true
    ),
    EventItem(
        eventName = "Все встречи",
        eventStatus = EventStatus.NONE,
        eventDate = "20.09.2024",
        eventPlace = "Москва",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = eventIconURL
    ),
    EventItem(
        eventName = "Все встречи",
        eventStatus = EventStatus.FINISHED,
        eventDate = "21.09.2024",
        eventPlace = "Казань",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = eventIconURL,
        eventIsPlaned = true
    )
)
val mockEventsListActive = listOf(
    EventItem(
        eventName = "Все встречи Активные",
        eventStatus = EventStatus.NONE,
        eventDate = "13.09.2024",
        eventPlace = "Петрозаводск",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = eventIconURL,
        eventIsPlaned = true
    ),
    EventItem(
        eventName = "Все встречи Активные",
        eventStatus = EventStatus.NONE,
        eventDate = "14.09.2024",
        eventPlace = "Майкоп",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = eventIconURL,
        eventIsPlaned = true
    ),
    EventItem(
        eventName = "Все встречи Активные",
        eventStatus = EventStatus.NONE,
        eventDate = "15.09.2024",
        eventPlace = "Владивосток",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = eventIconURL
    ),
    EventItem(
        eventName = "Все встречи Активные",
        eventStatus = EventStatus.NONE,
        eventDate = "16.09.2024",
        eventPlace = "Краснодар",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = eventIconURL
    )
)
val mockEventsListUserPlanned = listOf(
    EventItem(
        eventName = "Мои встречи Запланированные",
        eventStatus = EventStatus.NONE,
        eventDate = "13.09.2024",
        eventPlace = "Петрозаводск",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = eventIconURL,
        eventIsPlaned = true
    ),
    EventItem(
        eventName = "Мои встречи Запланированные",
        eventStatus = EventStatus.NONE,
        eventDate = "14.09.2024",
        eventPlace = "Майкоп",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = eventIconURL,
        eventIsPlaned = true
    ),
    EventItem(
        eventName = "Мои встречи Запланированные",
        eventStatus = EventStatus.NONE,
        eventDate = "15.09.2024",
        eventPlace = "Владивосток",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = eventIconURL,
        eventIsPlaned = true
    ),
    EventItem(
        eventName = "Мои встречи Запланированные",
        eventStatus = EventStatus.NONE,
        eventDate = "16.09.2024",
        eventPlace = "Краснодар",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = eventIconURL,
        eventIsPlaned = true
    ),
    EventItem(
        eventName = "Мои встречи Запланированные",
        eventStatus = EventStatus.NONE,
        eventDate = "17.09.2024",
        eventPlace = "Рязань",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = eventIconURL,
        eventIsPlaned = true
    ),
    EventItem(
        eventName = "Мои встречи Запланированные",
        eventStatus = EventStatus.NONE,
        eventDate = "18.09.2024",
        eventPlace = "Сочи",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = eventIconURL,
        eventIsPlaned = true
    ),
    EventItem(
        eventName = "Мои встречи Запланированные",
        eventStatus = EventStatus.NONE,
        eventDate = "19.09.2024",
        eventPlace = "Санкт-Петербург",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = eventIconURL,
        eventIsPlaned = true
    ),
    EventItem(
        eventName = "Мои встречи Запланированные",
        eventStatus = EventStatus.NONE,
        eventDate = "20.09.2024",
        eventPlace = "Москва",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = eventIconURL,
        eventIsPlaned = true
    ),
    EventItem(
        eventName = "Мои встречи Запланированные",
        eventStatus = EventStatus.NONE,
        eventDate = "21.09.2024",
        eventPlace = "Казань",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = eventIconURL,
        eventIsPlaned = true
    )
)
val mockEventsListUserPassed = listOf(
    EventItem(
        eventName = "Мои встречи Запланированные Прошедшие",
        eventStatus = EventStatus.FINISHED,
        eventDate = "13.09.2024",
        eventPlace = "Петрозаводск",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = eventIconURL
    ),
    EventItem(
        eventName = "Мои встречи Запланированные Прошедшие",
        eventStatus = EventStatus.FINISHED,
        eventDate = "14.09.2024",
        eventPlace = "Майкоп",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = eventIconURL
    ),
    EventItem(
        eventName = "Мои встречи Запланированные Прошедшие",
        eventStatus = EventStatus.FINISHED,
        eventDate = "15.09.2024",
        eventPlace = "Владивосток",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = eventIconURL
    ),
    EventItem(
        eventName = "Мои встречи Запланированные Прошедшие",
        eventStatus = EventStatus.FINISHED,
        eventDate = "16.09.2024",
        eventPlace = "Краснодар",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = eventIconURL
    ),
    EventItem(
        eventName = "Мои встречи Запланированные Прошедшие",
        eventStatus = EventStatus.FINISHED,
        eventDate = "17.09.2024",
        eventPlace = "Рязань",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = eventIconURL
    )
)

const val communityIconURL = "https://i.pinimg.com/564x/dc/c4/ef/dcc4ef15c657260d1d13331daf3a13c8.jpg"
val mockListOfCommunities = listOf(
    CommunityItem(
        communityName = "Имя сообщества",
        communitySize = 1,
        communityIconURL = communityIconURL
    ),
    CommunityItem(
        communityName = "Имя сообщества",
        communitySize = 2,
        communityIconURL = communityIconURL
    ),
    CommunityItem(
        communityName = "Имя сообщества",
        communitySize = 4,
        communityIconURL = communityIconURL
    ),
    CommunityItem(
        communityName = "Имя сообщества",
        communitySize = 5,
        communityIconURL = communityIconURL
    ),
    CommunityItem(
        communityName = "Имя сообщества",
        communitySize = 1500,
        communityIconURL = communityIconURL
    ),
    CommunityItem(
        communityName = "Имя сообщества",
        communitySize = 7000,
        communityIconURL = communityIconURL
    ),
    CommunityItem(
        communityName = "Имя сообщества",
        communitySize = 15000,
        communityIconURL = communityIconURL
    ),
    CommunityItem(
        communityName = "Имя сообщества",
        communitySize = 150000,
        communityIconURL = communityIconURL
    ),
    CommunityItem(
        communityName = "Имя сообщества",
        communitySize = 1000000,
        communityIconURL = communityIconURL
    ),
    CommunityItem(
        communityName = "Имя сообщества",
        communitySize = 10000000,
        communityIconURL = communityIconURL
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
    "https://i.pinimg.com/564x/07/1e/f4/071ef43b8a3e3a3e32eba626da61faa9.jpg",
    "https://i.pinimg.com/564x/25/b9/d5/25b9d5877b216b9edd7fbdd93955d968.jpg",
    "https://i.pinimg.com/564x/f4/e0/c8/f4e0c8655494b4ed5fb490df336c5dcb.jpg",
    "https://i.pinimg.com/564x/51/c8/ed/51c8ed24ded0e56fbeedd10fa8d424d5.jpg",
    "https://i.pinimg.com/736x/62/e5/50/62e550bc4e1bcc5bfd75b26127e63b6a.jpg",
    "https://i.pinimg.com/564x/df/eb/ab/dfebab351d764bc388c05a5f866b46d4.jpg",
    "https://i.pinimg.com/564x/01/01/a5/0101a59c68793d844cc2d23e3cd26274.jpg"
)
val mockAccountsIconsURLList2 = listOf(
    "https://i.pinimg.com/564x/07/1e/f4/071ef43b8a3e3a3e32eba626da61faa9.jpg",
    "https://i.pinimg.com/564x/25/b9/d5/25b9d5877b216b9edd7fbdd93955d968.jpg",
    "https://i.pinimg.com/564x/f4/e0/c8/f4e0c8655494b4ed5fb490df336c5dcb.jpg",
)