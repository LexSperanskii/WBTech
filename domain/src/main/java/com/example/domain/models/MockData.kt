package com.example.domain.models

class MockData {

    private var user = User(
        id = 0,
        name = "",
        surname = "",
        phoneNumber = PhoneNumber("",""),
        iconURL = null
    )
    private val pinCode = "5555"

    fun pinCodeVerification(pin: String) = pin == pinCode

    fun setUserPhoneNumber(code: String, number: String){
        user = user.copy(
            phoneNumber = PhoneNumber(code,number)
        )
    }
    fun getUserPhoneNumber() : PhoneNumber{
        return user.phoneNumber
    }
    fun setUserName(name: String){
        user = user.copy(
            name = name
        )
    }
    fun setUserSurname(surname: String){
        user = user.copy(
            surname = surname
        )
    }

    fun setUserAvatar(avatarURL: String?){
        user = user.copy(
            iconURL = avatarURL
        )
    }
    fun getUserAvatar() : String{
        return IconURL1
    }
    fun getUser(): User{
        return user
    }
    fun getAvailableCountries(): List<Country> = mockAvailableCountries
    fun getListOfEvents(): List<Event> = listOfEvents
    fun getEventDetail(eventId: Int): EventDetail =
        when (eventId % 2 == 0) {
            true -> {
                eventDetail
            }

            else -> {
                eventDetail2
            }
        }
    fun addUserAsParticipant(participant: RegisteredPerson) {
        eventDetail = eventDetail.copy(
            listOfParticipants =  listOf(participant).plus(eventDetail.listOfParticipants)
        )
    }
    fun removeUserAsParticipant(participant: RegisteredPerson) {
        eventDetail = eventDetail.copy(
            listOfParticipants = eventDetail.listOfParticipants.minus(participant)
        )
    }
    fun getListOfCommunities(): List<Community> = communities
    fun getCommunity(communityId: Int): CommunityDetail =
        when (communityId % 2 == 0) {
            true -> {
                communityDetail
            }

            else -> {
                communityDetail2
            }
        }

    private val longText = "Гай Ю́лий Це́зарь (аутентичное произношение близко к Ка́йсар[4]; лат. Gaius Iulius Caesar [ˈgaːjʊs ˈjuːliʊs ˈkae̯sar]; 12 июля 100 года до н. э.[5] — 15 марта 44 года до н. э.) — древнеримский государственный и политический деятель, полководец, писатель. Консул 59, 48, 46, 45 и 44 годов до н. э., диктатор 49, 48—47 и 46—44 годов до н. э., великий понтифик с 63 года до н. э.\n" +
            "\n" +
            "Происходивший из древней патрицианской семьи, Цезарь последовательно добивался всех ординарных римских должностей (cursus honorum) и сделал себе имя на борьбе с консервативными сенаторами (оптиматами). В 60 году до н. э. организовал первый триумвират с двумя влиятельными политиками — Гнеем Помпеем Великим и Марком Лицинием Крассом. С 58 года до н. э. более восьми лет провёл на территории современных Швейцарии, Франции, Бельгии, Германии и Великобритании в Галльской войне, присоединив к Римской республике огромную территорию от Атлантического океана до Рейна и снискав славу талантливого полководца. В начале 49 года до н. э. начал гражданскую войну из-за непримиримых разногласий с сенаторами по вопросам о деталях своего возвращения в Рим и о гарантиях судебной неприкосновенности за должностные преступления (подкупы на выборах, взятки должностным лицам, нарушение договоров, насильственные действия и другие нарушения). За четыре года сторонники сената, сгруппировавшиеся вокруг Помпея, были разбиты Цезарем в Италии, Испании (дважды), Греции и Африке, также им были разбиты войска правителей Египта и Понта.\n" +
            "\n" +
            "Придерживался «политики милосердия», но в то же время казнил ряд своих ключевых оппонентов. Добившись полной победы над противниками, сконцентрировал в своих руках власть консула и чрезвычайные полномочия диктатора (в конце концов — в виде пожизненной должности), провёл ряд реформ во всех сферах жизни общества. При жизни Цезаря началось его обожествление, почётный титул полководца-победителя «император» стал частью его имени, однако он отказывался от власти древних римских царей. После убийства Цезаря группой сенаторов во главе с Марком Юнием Брутом внучатый племянник Цезаря Гай Октавий принял его имя и получил большую часть наследства по завещанию, став впоследствии первым императором.\n" +
            "\n" +
            "К Цезарю по-разному относились при жизни, и эта традиция сохранилась в Римской империи: его имя всячески обелялось сторонниками правителей, а оппозиционеры восхваляли его жертв и заговорщиков. Очень популярной была личность Цезаря в Средние века и Новое время. Помимо политической и военной деятельности, Цезарь известен и как литератор. Из-за простоты и ясности стиля, его сочинения считаются классикой древнеримской литературы и используются при обучении латыни. К имени Юлия Цезаря восходят титулы кайзер и царь, название седьмого месяца года во многих языках мира — июль."

    private val IconURL1 = "https://i.pinimg.com/564x/dc/c4/ef/dcc4ef15c657260d1d13331daf3a13c8.jpg"
    private val IconURL2 = "https://i.pinimg.com/564x/01/01/a5/0101a59c68793d844cc2d23e3cd26274.jpg"
    private val IconURL3 = "https://i.pinimg.com/564x/df/eb/ab/dfebab351d764bc388c05a5f866b46d4.jpg"
    private val IconURL4 = "https://i.pinimg.com/736x/62/e5/50/62e550bc4e1bcc5bfd75b26127e63b6a.jpg"
    private val IconURL5 = "https://i.pinimg.com/564x/f4/e0/c8/f4e0c8655494b4ed5fb490df336c5dcb.jpg"
    private val IconURL6 = "https://i.pinimg.com/564x/25/b9/d5/25b9d5877b216b9edd7fbdd93955d968.jpg"
    private val IconURL7 = "https://i.pinimg.com/564x/07/1e/f4/071ef43b8a3e3a3e32eba626da61faa9.jpg"

    private val mockAvailableCountries = listOf(
        Country("Russia", "+7", "https://i.pinimg.com/564x/42/8d/91/428d9169accc5277fc03a0c41394eb10.jpg"),
        Country("Kazakhstan", "+7", "https://i.pinimg.com/564x/12/d9/f9/12d9f9633023c5f053a654da6035af7f.jpg"),
        Country("UK", "+44","https://i.pinimg.com/564x/aa/7d/c8/aa7dc8130b972fdd4837c19a189717fc.jpg"),
        Country("China", "+86", "https://i.pinimg.com/564x/51/08/62/510862488ad2a8037423567218afe069.jpg"),
        Country("Germany", "+49", "https://i.pinimg.com/564x/4c/b7/8b/4cb78bce83b82a83382d18d207423f48.jpg")
    )

    private val eventsActive = List(10){
        Event(
            id = it,
            name = "Встреча разработчиков $it",
            date = "13.09.2024",
            city = "Москва",
            category = listOf("Python", "Junior", "Moscow"),
            iconURL = IconURL2,
            isFinished = false
        )
    }
    private val eventsFinished = List(10){
        Event(
            id = it+10,
            name = "Встреча разработчиков ${it+10}",
            date = "05.12.2024",
            city = "Санкт-Петербург",
            category = listOf("Python", "Junior", "Moscow"),
            iconURL = IconURL4,
            isFinished = true
        )
    }

    private val listOfEvents = eventsActive.plus(eventsFinished).shuffled()

    private val listOfParticipants = listOf(
        RegisteredPerson(1, IconURL3),
        RegisteredPerson(2, IconURL4),
        RegisteredPerson(3, IconURL5),
        RegisteredPerson(4, IconURL6),
        RegisteredPerson(5, IconURL7),
        RegisteredPerson(6, IconURL2)
    )
    private val listOfParticipantsSmall = listOf(
        RegisteredPerson(1, IconURL3),
        RegisteredPerson(2, IconURL4),
        RegisteredPerson(3, IconURL2)
    )

    private var eventDetail = EventDetail(
        id = 0,
        name = "Встреча разработчиков Kotlon 1",
        date = "13.09.2024",
        address = EventAddress("Москва","ул. Громова", "4"),
        category = listOf("Python", "Junior", "Moscow"),
        locationCoordinates ="115.22455 , 5554.15651",
        description = longText,
        listOfParticipants = listOfParticipants,
        isFinished = false,
    )
    private var eventDetail2 = EventDetail(
        id = 0,
        name = "Встреча разработчиков Kotlon 2",
        date = "13.09.2024",
        address = EventAddress("Москва", "ул. Громова", "4"),
        category = listOf("Python", "Junior", "Moscow"),
        locationCoordinates = "115.22455 , 5554.15651",
        description = longText,
        listOfParticipants = listOfParticipants,
        isFinished = true,
    )

    private val communities = List(20) {
        Community(
            id = it,
            name = "Имя сообщества $it",
            size = it,
            iconURL = IconURL3
        )
    }

    private val communityDetail = CommunityDetail(
        id = 0,
        name = "Имя сообщества 1",
        description = longText,
        events = listOfEvents.take(7)
    )
    private val communityDetail2 = CommunityDetail(
        id = 0,
        name = "Имя сообщества 2",
        description = longText,
        events = listOfEvents.take(2)
    )
}