package com.example.domain.models.mock


import com.example.domain.models.ClientModelDomain
import com.example.domain.models.CommunitiesAdvertBlockModelDomain
import com.example.domain.models.CommunityDescriptionModelDomain
import com.example.domain.models.CommunityModelDomain
import com.example.domain.models.CountryModelDomain
import com.example.domain.models.EventAdvertBlockModelDomain
import com.example.domain.models.EventDescriptionModelDomain
import com.example.domain.models.EventLocationModelDomain
import com.example.domain.models.EventModelDomain
import com.example.domain.models.MetroModelDomain
import com.example.domain.models.PhoneNumberModelDomain
import com.example.domain.models.SocialMediaModelDomain
import com.example.domain.models.UserModelDomain
import java.util.UUID

class MockData {

    private var client = ClientModelDomain()
    private var clientPinCode = "5555"
    private val availableCountries = listOf(
        CountryModelDomain(0, "Россия", "+7"),
        CountryModelDomain(1, "Казахстан", "+7"),
        CountryModelDomain(2, "Белоруссия", "+375"),
        CountryModelDomain(3, "Киргизия", "+996"),
        CountryModelDomain(4, "Азербайджан", "+994")
    )
    private val colorsStringList =
        listOf("0xFF00FF00", "0xFFFFFF00", "0xFF0000FF", "0xFFFF0000", "0xFFFFA500", "0xFF800080")
    private val listOfSocialMedia = listOf(
        SocialMediaModelDomain(
            socialMediaId = "0",
            socialMediaIconURL = "https://habrastorage.org/getpro/moikrug/uploads/company/901/244/761/logo/medium_c35efb293cd85320d66e74304d3a8076.jpg",
            socialMediaName = "Хабр",
            userNickname = "Ssdfweeeqww"
        ),
        SocialMediaModelDomain(
            socialMediaId = "1",
            socialMediaIconURL = "https://w7.pngwing.com/pngs/460/412/png-transparent-telegram-computer-icons-email-filtering-angle-text-triangle.png",
            socialMediaName = "Телеграм",
            userNickname = "asdfsdfsdf"
        )
    )
    private val metroStations = listOf(
        "Приморская",
        "Улица Дыбенко",
        "Проспект Большевиков",
        "Адмиралтейская",
        "Спасская",
        "Гостинный Двор"
    )
    private val listOfRealTags = listOf(
        "Тестирование",
        "Разработка",
        "BackEnd",
        "Маркетинг",
        "Бизнес",
        "Проджект менеджмент",
        "Дизайн",
        "Mobile",
        "FrontEnd",
        "Гачи",
        "Мучи",
        "DevOps",
        "HR",
        "Бухгалтерия"
    )
    private val listOfRealIcons = listOf(
        "https://i.pinimg.com/564x/dc/c4/ef/dcc4ef15c657260d1d13331daf3a13c8.jpg",
        "https://i.pinimg.com/564x/dc/c4/ef/dcc4ef15c657260d1d13331daf3a13c8.jpg",
        "https://i.pinimg.com/564x/dc/c4/ef/dcc4ef15c657260d1d13331daf3a13c8.jpg",
        "https://i.pinimg.com/736x/62/e5/50/62e550bc4e1bcc5bfd75b26127e63b6a.jpg",
        "https://i.pinimg.com/564x/f4/e0/c8/f4e0c8655494b4ed5fb490df336c5dcb.jpg",
        "https://i.pinimg.com/564x/25/b9/d5/25b9d5877b216b9edd7fbdd93955d968.jpg",
        "https://i.pinimg.com/564x/07/1e/f4/071ef43b8a3e3a3e32eba626da61faa9.jpg",
        "https://i.pinimg.com/736x/e5/3b/90/e53b900fe55028bd1305716aaac3602d.jpg",
        "https://i.pinimg.com/564x/e0/59/1d/e0591de77b707dbac61e29394b725ff4.jpg",
        "https://i.pinimg.com/564x/20/76/ca/2076ca961b890a0ad175b59fb37248c3.jpg",
        "https://i.pinimg.com/736x/8a/59/42/8a59429f123fe135e86fde71864b0921.jpg",
        "https://i.pinimg.com/736x/e9/fc/e3/e9fce3127136ff32d329ee248bebcf9f.jpg",
        "https://i.pinimg.com/736x/ee/92/9a/ee929a38297884933c3318ece374fd40.jpg",
        "https://i.pinimg.com/564x/47/3f/19/473f198dd6051ea58e7ef76e73b86800.jpg",
        "https://i.pinimg.com/564x/02/59/69/0259699a168aea21ba838cd4873a1fdc.jpg",
        "https://i.pinimg.com/564x/62/36/de/6236ded523155a85746a1121f5f04f1f.jpg",
        "https://i.pinimg.com/736x/fb/ed/18/fbed1849aa6fc35fb2e2ff6c595f4e78.jpg",
        "https://i.pinimg.com/564x/1d/7f/54/1d7f546625f4c22cede2d9958c02d2bc.jpg",
        "https://i.pinimg.com/736x/6a/3e/68/6a3e68e72301cb0927ab72d19caf74d1.jpg",
        "https://i.pinimg.com/564x/28/8c/d3/288cd3492dbf4c8e128c627d48970578.jpg",
        "https://i.pinimg.com/736x/c3/1e/4c/c31e4cc99059d690d6ce1f62f0227b71.jpg",
        "https://i.pinimg.com/736x/cb/02/a1/cb02a1f429e2ae046c5572cdbd5029ae.jpg",
        "https://i.pinimg.com/736x/fd/38/3a/fd383a2a477664d63fc726e25434fe0b.jpg",
        "https://i.pinimg.com/736x/55/6e/cc/556ecc1bf5f5a5b86e53cbd10a8b10ef.jpg",
        "https://i.pinimg.com/564x/3f/52/9a/3f529a11413837d20d1f436d53bf47c6.jpg",
        "https://i.pinimg.com/564x/54/7f/5c/547f5cfc0eadbaf8b455901000cf045d.jpg",
        "https://i.pinimg.com/564x/79/a6/d2/79a6d27000d0f0a834a0ead3edca44fe.jpg",
        "https://i.pinimg.com/736x/93/ef/d8/93efd8084d7a45602665b45c5e8a707a.jpg"
    )
    private val listOfRealEvents = listOf(
        EventModelDomain(
            id = "0",
            name = "QA Talks - Global tech forum",
            time = "13:00",
            day = 1,
            month = "января",
            year = 2024,
            city = "Санкт-Петербург",
            street = "Невский проспект",
            building = "11",
            imageURL = "https://i.pinimg.com/736x/e5/3b/90/e53b900fe55028bd1305716aaac3602d.jpg",
            listOfTags = listOf(
                "Тестирование", "Разработка", "BackEnd", "Гачи"
            )
        ),
        EventModelDomain(
            id = "1",
            name = "Python days 2024",
            time = "14:00",
            day = 2,
            month = "января",
            year = 2024,
            city = "Санкт-Петербург",
            street = "Инженерная улица",
            building = "10А",
            imageURL = "https://i.pinimg.com/564x/e0/59/1d/e0591de77b707dbac61e29394b725ff4.jpg",
            listOfTags = listOf("Тестирование", "Разработка")
        ),
        EventModelDomain(
            id = "2",
            name = "Как повышать грейд. Лекция Павла Хорикова",
            time = "15:00",
            day = 3,
            month = "января",
            year = 2024,
            city = "Санкт-Петербург",
            street = "Кожевенная улица",
            building = "40",
            imageURL = "https://i.pinimg.com/564x/20/76/ca/2076ca961b890a0ad175b59fb37248c3.jpg",
            listOfTags = listOf("Маркетинг", "Бизнес")
        ),
        EventModelDomain(
            id = "3",
            name = "Android QA",
            time = "16:00",
            day = 4,
            month = "января",
            year = 2024,
            city = "Санкт-Петербург",
            street = "Кожевенная линия",
            building = "105",
            imageURL = "https://i.pinimg.com/736x/8a/59/42/8a59429f123fe135e86fde71864b0921.jpg",
            listOfTags = listOf("Тестирование", "BackEnd")
        ),
        EventModelDomain(
            id = "4",
            name = "Путь в IT для школьников",
            time = "17:00",
            day = 5,
            month = "января",
            year = 2024,
            city = "Санкт-Петербург",
            street = "Набережная канала Грибоедова",
            building = "133",
            imageURL = "https://i.pinimg.com/736x/e9/fc/e3/e9fce3127136ff32d329ee248bebcf9f.jpg",
            listOfTags = listOf("Разработка", "Проджект менеджмент")
        ),
        EventModelDomain(
            id = "5",
            name = "Дизайн-встреча s8e2",
            time = "18:00",
            day = 6,
            month = "января",
            year = 2024,
            city = "Санкт-Петербург",
            street = "Литейный проспект",
            building = "46",
            imageURL = "https://i.pinimg.com/736x/ee/92/9a/ee929a38297884933c3318ece374fd40.jpg",
            listOfTags = listOf("Дизайн", "Маркетинг", "Mobile")
        ),
        EventModelDomain(
            id = "6",
            name = "Офлайн интенсив по брендингу",
            time = "19:00",
            day = 7,
            month = "января",
            year = 2024,
            city = "Санкт-Петербург",
            street = "ул. Марата",
            building = "58",
            imageURL = "https://i.pinimg.com/564x/47/3f/19/473f198dd6051ea58e7ef76e73b86800.jpg",
            listOfTags = listOf("Дизайн", "Маркетинг")
        ),
        EventModelDomain(
            id = "7",
            name = "Просмотр",
            time = "20:00",
            day = 8,
            month = "января",
            year = 2024,
            city = "Санкт-Петербург",
            street = "Малая Садовая",
            building = "2",
            imageURL = "https://i.pinimg.com/564x/02/59/69/0259699a168aea21ba838cd4873a1fdc.jpg",
            listOfTags = listOf("Дизайн", "Бизнес")
        ),
        EventModelDomain(
            id = "8",
            name = "Семинар по управлению проектами",
            time = "21:00",
            day = 9,
            month = "января",
            year = 2024,
            city = "Санкт-Петербург",
            street = "Большая конюшенная",
            building = "10",
            imageURL = "https://i.pinimg.com/564x/62/36/de/6236ded523155a85746a1121f5f04f1f.jpg",
            listOfTags = listOf("Проджект менеджмент", "Бизнес")
        ),
        EventModelDomain(
            id = "9",
            name = "Дизайн-встреча s8e2",
            time = "22:00",
            day = 10,
            month = "января",
            year = 2024,
            city = "Санкт-Петербург",
            street = "Литейный проспект",
            building = "46",
            imageURL = "https://i.pinimg.com/736x/fb/ed/18/fbed1849aa6fc35fb2e2ff6c595f4e78.jpg",
            listOfTags = listOf("Дизайн", "Маркетинг", "Mobile")
        ),
        EventModelDomain(
            id = "10",
            name = "Feature-Sliced Design 2024",
            time = "23:00",
            day = 11,
            month = "января",
            year = 2024,
            city = "Санкт-Петербург",
            street = "наб. канала Грибоедова",
            building = "123",
            imageURL = "https://i.pinimg.com/564x/1d/7f/54/1d7f546625f4c22cede2d9958c02d2bc.jpg",
            listOfTags = listOf("Разработка", "FrontEnd")
        ),
        EventModelDomain(
            id = "11",
            name = "Геймдев на нейросетях. Лекция Станислава Макарова",
            time = "13:30",
            day = 12,
            month = "января",
            year = 2024,
            city = "Санкт-Петербург",
            street = "Кожевенная линия",
            building = "40",
            imageURL = "https://i.pinimg.com/736x/6a/3e/68/6a3e68e72301cb0927ab72d19caf74d1.jpg",
            listOfTags = listOf("Разработка")
        ),
        EventModelDomain(
            id = "12",
            name = "Front talks",
            time = "14:30",
            day = 13,
            month = "января",
            year = 2024,
            city = "Санкт-Петербург",
            street = "ул. 10 Советская",
            building = "16",
            imageURL = "https://i.pinimg.com/564x/28/8c/d3/288cd3492dbf4c8e128c627d48970578.jpg",
            listOfTags = listOf("Маркетинг", "FrontEnd")
        ),
        EventModelDomain(
            id = "13",
            name = "Путь дизайнера в России. Лекция Мити Харшака",
            time = "15:30",
            day = 14,
            month = "января",
            year = 2024,
            city = "Санкт-Петербург",
            street = "наб. канала Грибоедова",
            building = "123",
            imageURL = "https://i.pinimg.com/736x/c3/1e/4c/c31e4cc99059d690d6ce1f62f0227b71.jpg",
            listOfTags = listOf("Дизайн")
        ),
        EventModelDomain(
            id = "14",
            name = "QA Talks - Наши дни",
            time = "16:30",
            day = 15,
            month = "января",
            year = 2024,
            city = "Санкт-Петербург",
            street = "Союзный",
            building = "11",
            imageURL = "https://i.pinimg.com/736x/cb/02/a1/cb02a1f429e2ae046c5572cdbd5029ae.jpg",
            listOfTags = listOf("Тестирование", "Разработка")
        ),
        EventModelDomain(
            id = "15",
            name = "QA Talks - Нашествие",
            time = "17:30",
            day = 16,
            month = "января",
            year = 2024,
            city = "Санкт-Петербург",
            street = "наб. Макарова",
            building = "70",
            imageURL = "https://i.pinimg.com/736x/fd/38/3a/fd383a2a477664d63fc726e25434fe0b.jpg",
            listOfTags = listOf("Тестирование", "Разработка", "BackEnd")
        ),
        EventModelDomain(
            id = "16",
            name = "QA Talks - Король и Шут",
            time = "18:30",
            day = 17,
            month = "января",
            year = 2024,
            city = "Санкт-Петербург",
            street = "Каменоостровский проспект",
            building = "55",
            imageURL = "https://i.pinimg.com/736x/55/6e/cc/556ecc1bf5f5a5b86e53cbd10a8b10ef.jpg",
            listOfTags = listOf("Тестирование", "BackEnd")
        ),
        EventModelDomain(
            id = "17",
            name = "QA Talks - Дискотека",
            time = "19:30",
            day = 18,
            month = "января",
            year = 2024,
            city = "Санкт-Петербург",
            street = "Думская улица",
            building = "17",
            imageURL = "https://i.pinimg.com/564x/3f/52/9a/3f529a11413837d20d1f436d53bf47c6.jpg",
            listOfTags = listOf("Тестирование", "Разработка", "Тусовки")
        ),
        EventModelDomain(
            id = "18",
            name = "Как выбрать качественную алкашку на вечер",
            time = "20:30",
            day = 19,
            month = "января",
            year = 2024,
            city = "Санкт-Петербург",
            street = "улица Дыбенко",
            building = "25",
            imageURL = "https://i.pinimg.com/564x/54/7f/5c/547f5cfc0eadbaf8b455901000cf045d.jpg",
            listOfTags = listOf("Алкашка", "Разработка")
        ),
        EventModelDomain(
            id = "19",
            name = "Лучшие гачимучи фильмы. Мнение экспертов",
            time = "21:30",
            day = 20,
            month = "января",
            year = 2024,
            city = "Санкт-Петербург",
            street = "Кронверская наб.",
            building = "47",
            imageURL = "https://i.pinimg.com/564x/79/a6/d2/79a6d27000d0f0a834a0ead3edca44fe.jpg",
            listOfTags = listOf("Гачи", "Мучи", "BackEnd")
        )
    )
    private val listOfRealCommunities = List(20) { index ->
        CommunityModelDomain(
            id = "C$index",
            name = generateRandomWord((7..15).random()),
            description = generateRandomWord((50..100).random()),
            imageURL = listOfRealIcons.random()
        )
    }
    private val listOfRealUsers = List(20) { index ->
        UserModelDomain(
            id = "$index",
            nameSurname = generateRandomWord((7..15).random()),
            city = "Санкт-Петербург",
            listOfTags = listOfRealTags.take((2..5).random()),
            description = generateRandomWord((50..100).random()),
            imageURL = listOfRealIcons.random(),
            listOfSocialMediaImageURL = listOfSocialMedia,
            userEventsList = listOfRealEvents.take(10),
            userCommunitiesList = listOfRealCommunities.take(10)
        )
    }
    private val listOfRealEventDescriptions = List(20) { index ->
        EventDescriptionModelDomain(
            id = listOfRealEvents[index].id,
            name = listOfRealEvents[index].name,
            time = listOfRealEvents[index].time,
            day = listOfRealEvents[index].day,
            month = listOfRealEvents[index].month,
            year = listOfRealEvents[index].year,
            city = listOfRealEvents[index].city,
            street = listOfRealEvents[index].street,
            building = listOfRealEvents[index].building,
            imageURL = listOfRealEvents[index].imageURL,
            listOfTags = listOfRealEvents[index].listOfTags,
            description = generateRandomWord((200..400).random()),
            pitcher = listOfRealUsers[index],
            location = EventLocationModelDomain(),
            metroStation = MetroModelDomain(
                name = metroStations.random(),
                tint = colorsStringList.random()
            ),
            listOfParticipants = listOfRealUsers.shuffled().take((5..15).random()),
            organizer = listOfRealCommunities[index],
            availableCapacity = index,
        )
    }
    private val listOfRealCommunityDescriptions = List(20) { index ->
        CommunityDescriptionModelDomain(
            id = listOfRealCommunities[index].id,
            name = listOfRealCommunities[index].name,
            description = listOfRealCommunities[index].description,
            imageURL = listOfRealCommunities[index].imageURL,
            listOfTags = listOfRealTags.shuffled().take(5),
            listOfParticipants = listOfRealUsers.shuffled().take((5..15).random()),
            listOfEvents = listOfRealEvents.shuffled().take((3..5).random()),
            listOfPastEvents = listOfRealEvents.shuffled().take((3..10).random())
        )
    }

    private val communitiesAdvertBlock1 = CommunitiesAdvertBlockModelDomain(
        id = UUID.randomUUID().toString(),
        nameOfBlock = "Сообщества для тестировщиков",
        listOfCommunities = getListOfCommunities().take(5)
    )
    private val communitiesAdvertBlock2 = CommunitiesAdvertBlockModelDomain(
        id = UUID.randomUUID().toString(),
        nameOfBlock = "Популярные сообщества в IT",
        listOfCommunities = getListOfCommunities().take(12)
    )
    private val eventsAdvertBlock = EventAdvertBlockModelDomain(
        id = UUID.randomUUID().toString(),
        nameOfBlock = "Встречи для разработчиков",
        listOfEvents = getListOfEvents().take(10)
    )

    private val myCommunitiesList = mutableListOf<CommunityModelDomain>()
    private val myChosenTags = mutableListOf<String>()


    fun getMyCommunitiesList(): List<CommunityModelDomain> = myCommunitiesList
    fun addToMyCommunities(community: CommunityModelDomain) = myCommunitiesList.add(community)
    fun removeFromMyCommunities(community: CommunityModelDomain) =
        myCommunitiesList.remove(community)
//    fun isInMyCommunityList(communityId: String): Boolean = myCommunitiesList.any { it.id == communityId }

    fun getMyChosenTagsList(): List<String> = myChosenTags
    fun addToMyChosenTags(tag: String) = myChosenTags.add(tag)
    fun removeFromMyChosenTags(tag: String) = myChosenTags.remove(tag)

    fun getCommunitiesAdvertBlock1(): CommunitiesAdvertBlockModelDomain = communitiesAdvertBlock1
    fun getCommunitiesAdvertBlock2(): CommunitiesAdvertBlockModelDomain = communitiesAdvertBlock2
    fun getEventsAdvertBlock(): EventAdvertBlockModelDomain = eventsAdvertBlock

    fun getListOfCommunities(): List<CommunityModelDomain> = listOfRealCommunities

    fun getListOfPeople(): List<UserModelDomain> = listOfRealUsers

    fun getListOfTags(): List<String> = listOfRealTags

    fun getListOfEvents(): List<EventModelDomain> = listOfRealEvents //+

    fun getEventDescription(eventId: String): EventDescriptionModelDomain {
        return listOfRealEventDescriptions.find { it.id == eventId }
            ?: EventDescriptionModelDomain()
    }

    fun getCommunityDescription(communityId: String): CommunityDescriptionModelDomain {
        return listOfRealCommunityDescriptions.find { it.id == communityId }
            ?: CommunityDescriptionModelDomain()
    }

    fun getListOfParticipants(id: String): List<UserModelDomain> {
        return when (id.contains(char = 'C', ignoreCase = true)) {
            true -> {
                listOfRealCommunityDescriptions.find { it.id == id }?.listOfParticipants ?: listOf()
            }

            else -> {
                listOfRealEventDescriptions.find { it.id == id }?.listOfParticipants ?: listOf()
            }
        }
    }

    fun getAvailableCountriesList(): List<CountryModelDomain> = availableCountries

    fun setClientName(nameSurname: String) {
        client = client.copy(nameSurname = nameSurname)
    }

    fun setClientPhoneNumber(countryCode: String, number: String) {
        client = client.copy(
            phoneNumber = client.phoneNumber.copy(
                countryCode = countryCode,
                number = number
            )
        )
    }

    fun getClientPhoneNumber(): PhoneNumberModelDomain {
        return client.phoneNumber
    }

    fun setClientPinCode(pinCode: String): Boolean {
        return pinCode == clientPinCode
    }

    fun getClient(): ClientModelDomain {
        return client
    }

    fun getUser(id: String): UserModelDomain {
        return listOfRealUsers.find { it.id == id } ?: UserModelDomain()
    }
}

fun generateRandomWord(length: Int): String {
    val letters = ('а'..'я') + ('А'..'Я').toList()
    return (1..length)
        .map { letters.random() }
        .joinToString("")
}