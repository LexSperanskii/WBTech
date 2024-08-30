package com.example.ui_v2.ui.utils

import com.example.ui_v2.models.CommunityModelUI
import com.example.ui_v2.models.EventModelUI
import com.example.ui_v2.models.PersonalCommunitiesModelUI
import com.example.ui_v2.models.UserModelUI
import java.util.UUID

internal class NewUIMockData {

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
        "BackEnd",
        "ГачиМучи"
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
        EventModelUI(
            id = "0",
            name = "QA Talks - Global tech forum",
            day = 1,
            month = "января",
            year = 2024,
            city = "Санкт-Петербург",
            street = "Невский проспект",
            building = "11",
            imageURL = "https://i.pinimg.com/736x/e5/3b/90/e53b900fe55028bd1305716aaac3602d.jpg",
            listOfTags = listOf("Тестирование", "Разработка", "BackEnd")
        ),
        EventModelUI(
            id = "1",
            name = "Python days 2024",
            day = 2,
            month = "января",
            year = 2024,
            city = "Санкт-Петербург",
            street = "Инженерная улица",
            building = "10А",
            imageURL = "https://i.pinimg.com/564x/e0/59/1d/e0591de77b707dbac61e29394b725ff4.jpg",
            listOfTags = listOf("Тестирование", "Разработка")
        ),
        EventModelUI(
            id = "2",
            name = "Как повышать грейд. Лекция Павла Хорикова",
            day = 3,
            month = "января",
            year = 2024,
            city = "Санкт-Петербург",
            street = "Кожевенная улица",
            building = "40",
            imageURL = "https://i.pinimg.com/564x/20/76/ca/2076ca961b890a0ad175b59fb37248c3.jpg",
            listOfTags = listOf("Маркетинг", "Бизнес")
        ),
        EventModelUI(
            id = "3",
            name = "Android QA",
            day = 4,
            month = "января",
            year = 2024,
            city = "Санкт-Петербург",
            street = "Кожевенная линия",
            building = "105",
            imageURL = "https://i.pinimg.com/736x/8a/59/42/8a59429f123fe135e86fde71864b0921.jpg",
            listOfTags = listOf("Тестирование", "BackEnd")
        ),
        EventModelUI(
            id = "4",
            name = "Путь в IT для школьников",
            day = 5,
            month = "января",
            year = 2024,
            city = "Санкт-Петербург",
            street = "Набережная канала Грибоедова",
            building = "133",
            imageURL = "https://i.pinimg.com/736x/e9/fc/e3/e9fce3127136ff32d329ee248bebcf9f.jpg",
            listOfTags = listOf("Разработка", "Проджект менеджмент")
        ),
        EventModelUI(
            id = "5",
            name = "Дизайн-встреча s8e2",
            day = 6,
            month = "января",
            year = 2024,
            city = "Санкт-Петербург",
            street = "Литейный проспект",
            building = "46",
            imageURL = "https://i.pinimg.com/736x/ee/92/9a/ee929a38297884933c3318ece374fd40.jpg",
            listOfTags = listOf("Дизайн", "Маркетинг", "Mobile")
        ),
        EventModelUI(
            id = "6",
            name = "Офлайн интенсив по брендингу",
            day = 7,
            month = "января",
            year = 2024,
            city = "Санкт-Петербург",
            street = "ул. Марата",
            building = "58",
            imageURL = "https://i.pinimg.com/564x/47/3f/19/473f198dd6051ea58e7ef76e73b86800.jpg",
            listOfTags = listOf("Дизайн", "Маркетинг")
        ),
        EventModelUI(
            id = "7",
            name = "Просмотр",
            day = 8,
            month = "января",
            year = 2024,
            city = "Санкт-Петербург",
            street = "Малая Садовая",
            building = "2",
            imageURL = "https://i.pinimg.com/564x/02/59/69/0259699a168aea21ba838cd4873a1fdc.jpg",
            listOfTags = listOf("Дизайн", "Бизнес")
        ),
        EventModelUI(
            id = "8",
            name = "Семинар по управлению проектами",
            day = 9,
            month = "января",
            year = 2024,
            city = "Санкт-Петербург",
            street = "Большая конюшенная",
            building = "10",
            imageURL = "https://i.pinimg.com/564x/62/36/de/6236ded523155a85746a1121f5f04f1f.jpg",
            listOfTags = listOf("Проджект менеджмент", "Бизнес")
        ),
        EventModelUI(
            id = "9",
            name = "Дизайн-встреча s8e2",
            day = 10,
            month = "января",
            year = 2024,
            city = "Санкт-Петербург",
            street = "Литейный проспект",
            building = "46",
            imageURL = "https://i.pinimg.com/736x/fb/ed/18/fbed1849aa6fc35fb2e2ff6c595f4e78.jpg",
            listOfTags = listOf("Дизайн", "Маркетинг", "Mobile")
        ),
        EventModelUI(
            id = "10",
            name = "Feature-Sliced Design 2024",
            day = 11,
            month = "января",
            year = 2024,
            city = "Санкт-Петербург",
            street = "наб. канала Грибоедова",
            building = "123",
            imageURL = "https://i.pinimg.com/564x/1d/7f/54/1d7f546625f4c22cede2d9958c02d2bc.jpg",
            listOfTags = listOf("Разработка", "FrontEnd")
        ),
        EventModelUI(
            id = "11",
            name = "Геймдев на нейросетях. Лекция Станислава Макарова",
            day = 12,
            month = "января",
            year = 2024,
            city = "Санкт-Петербург",
            street = "Кожевенная линия",
            building = "40",
            imageURL = "https://i.pinimg.com/736x/6a/3e/68/6a3e68e72301cb0927ab72d19caf74d1.jpg",
            listOfTags = listOf("Разработка")
        ),
        EventModelUI(
            id = "12",
            name = "Front talks",
            day = 13,
            month = "января",
            year = 2024,
            city = "Санкт-Петербург",
            street = "ул. 10 Советская",
            building = "16",
            imageURL = "https://i.pinimg.com/564x/28/8c/d3/288cd3492dbf4c8e128c627d48970578.jpg",
            listOfTags = listOf("Маркетинг", "FrontEnd")
        ),
        EventModelUI(
            id = "13",
            name = "Путь дизайнера в России. Лекция Мити Харшака",
            day = 14,
            month = "января",
            year = 2024,
            city = "Санкт-Петербург",
            street = "наб. канала Грибоедова",
            building = "123",
            imageURL = "https://i.pinimg.com/736x/c3/1e/4c/c31e4cc99059d690d6ce1f62f0227b71.jpg",
            listOfTags = listOf("Дизайн")
        ),
        EventModelUI(
            id = "14",
            name = "QA Talks - Наши дни",
            day = 15,
            month = "января",
            year = 2024,
            city = "Санкт-Петербург",
            street = "Союзный",
            building = "11",
            imageURL = "https://i.pinimg.com/736x/cb/02/a1/cb02a1f429e2ae046c5572cdbd5029ae.jpg",
            listOfTags = listOf("Тестирование", "Разработка")
        ),
        EventModelUI(
            id = "15",
            name = "QA Talks - Нашествие",
            day = 16,
            month = "января",
            year = 2024,
            city = "Санкт-Петербург",
            street = "наб. Макарова",
            building = "70",
            imageURL = "https://i.pinimg.com/736x/fd/38/3a/fd383a2a477664d63fc726e25434fe0b.jpg",
            listOfTags = listOf("Тестирование", "Разработка", "BackEnd")
        ),
        EventModelUI(
            id = "16",
            name = "QA Talks - Король и Шут",
            day = 17,
            month = "января",
            year = 2024,
            city = "Санкт-Петербург",
            street = "Каменоостровский проспект",
            building = "55",
            imageURL = "https://i.pinimg.com/736x/55/6e/cc/556ecc1bf5f5a5b86e53cbd10a8b10ef.jpg",
            listOfTags = listOf("Тестирование", "BackEnd")
        ),
        EventModelUI(
            id = "17",
            name = "QA Talks - Дискотека",
            day = 18,
            month = "января",
            year = 2024,
            city = "Санкт-Петербург",
            street = "Думская улица",
            building = "17",
            imageURL = "https://i.pinimg.com/564x/3f/52/9a/3f529a11413837d20d1f436d53bf47c6.jpg",
            listOfTags = listOf("Тестирование", "Разработка", "Тусовки")
        ),
        EventModelUI(
            id = "18",
            name = "Как выбрать качественную алкашку на вечер",
            day = 19,
            month = "января",
            year = 2024,
            city = "Санкт-Петербург",
            street = "улица Дыбенко",
            building = "25",
            imageURL = "https://i.pinimg.com/564x/54/7f/5c/547f5cfc0eadbaf8b455901000cf045d.jpg",
            listOfTags = listOf("Алкашка", "Разработка")
        ), EventModelUI(
            id = "19",
            name = "Лучшие гачимучи фильмы. Мнение экспертов",
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

    val personalCommunities1 = PersonalCommunitiesModelUI(
        id = UUID.randomUUID().toString(),
        nameOfBlock = "Сообщества для тестировщиков",
        listOfCommunities = listOfCommunities()
    )
    val personalCommunities2 = PersonalCommunitiesModelUI(
        id = UUID.randomUUID().toString(),
        nameOfBlock = generateRandomWord((2..7).random()) + generateRandomWord((2..7).random()) + generateRandomWord(
            (2..7).random()
        ),
        listOfCommunities = listOfCommunities()
    )

    private fun listOfCommunities(): List<CommunityModelUI> {
        val realDataListOfCommunities = listOf(
            CommunityModelUI(
                id = "0",
                name = "Хабр",
                imageURL = "https://i.pinimg.com/736x/93/ef/d8/93efd8084d7a45602665b45c5e8a707a.jpg"
            ),
            CommunityModelUI(
                id = "1",
                name = "The IT Crowd",
                imageURL = "https://i.pinimg.com/564x/63/a1/03/63a103287c81e84ebda348010d09a734.jpg"
            ),
            CommunityModelUI(
                id = "2",
                name = "Супер тестировщики",
                imageURL = "https://i.pinimg.com/564x/fd/d5/49/fdd5492da7a8b705cbe1a66bd5cb42ef.jpg"
            ),
        )
        val randomDataListOfCommunities = List((5..20).random()) {
            CommunityModelUI(
                id = UUID.randomUUID().toString(),
                name = generateRandomWord((2..7).random()) + generateRandomWord((2..7).random()),
                imageURL = listOfRealIcons.random()
            )
        }
        return (realDataListOfCommunities + randomDataListOfCommunities).shuffled()
    }

    fun listOfPeople(): List<UserModelUI> {
        val userList = List((10..20).random()) {
            UserModelUI(
                id = UUID.randomUUID().toString(),
                name = generateRandomWord((2..15).random()),
                tag = listOfRealTags.random(),
                imageURL = listOfRealIcons.random()
            )
        }
        return userList
    }

    fun listOfTags(): List<String> {
        val realDataListOfTags = listOfRealTags
        val randomDataListOfTags = List((10..20).random()) {
            generateRandomWord((2..20).random())
        }
        return realDataListOfTags + randomDataListOfTags
    }


    fun listOfMyEvents(): List<EventModelUI> {
        val realDataListOfEvent = listOfRealEvents
        val randomDataListOfEvent = List((5..20).random()) {
            EventModelUI(
                id = UUID.randomUUID().toString(),
                name = generateRandomWord((2..7).random()) + generateRandomWord((2..7).random()) + generateRandomWord(
                    (2..7).random()
                ) + generateRandomWord((2..7).random()),
                day = (1..31).random(),
                month = generateRandomWord((4..7).random()),
                year = (1000..3000).random(),
                city = generateRandomWord((4..20).random()),
                street = generateRandomWord((2..7).random()) + generateRandomWord((2..20).random()),
                building = (1..200).random().toString() + generateRandomWord(1),
                imageURL = listOfRealIcons.random(),
                listOfTags = listOfTags().take((1..5).random())
            )
        }
        return realDataListOfEvent + randomDataListOfEvent
    }
}

fun generateRandomWord(length: Int): String {
    val letters = ('a'..'z') + ('A'..'Z').toList()
    return (1..length)
        .map { letters.random() }
        .joinToString("")
}