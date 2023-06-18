package com.su.modernmovieapp.network.fake

import com.su.modernmovieapp.data.model.PlayingMovieUiModel
import com.su.modernmovieapp.network.network_model.MovieResult
import org.intellij.lang.annotations.Language

object FakeDataSource {
    val samplePlayingMovie = PlayingMovieUiModel(
        id = 475557,
        title = "Joker",
        posterPath = "/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg",
        voteAverage = 8.5,
        overview = "During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure.",
        releaseDate = "2019-10-04",
        backdropPath = "/n6bUvigpRFqSwmPp1m2YADdbRBc.jpg"
    )

    val movieResult = MovieResult(
        534.771,
        4809,
        false,
        "/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg",
        475557,
        false,
        "/n6bUvigpRFqSwmPp1m2YADdbRBc.jpg",
        "en",
        "Joker",
        listOf(
            80,
            18,
            53
        ),
        "Joker",
        8.5,
        "During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure.",
        "2019-10-04"
    )

    @Language("JSON")
    val playingMovieData = """ 
        [
            {
              "popularity": 534.771,
              "vote_count": 4809,
              "video": false,
              "poster_path": "/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg",
              "id": 475557,
              "adult": false,
              "backdrop_path": "/n6bUvigpRFqSwmPp1m2YADdbRBc.jpg",
              "original_language": "en",
              "original_title": "Joker",
              "genre_ids": [
                80,
                18,
                53
              ],
              "title": "Joker",
              "vote_average": 8.5,
              "overview": "During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure.",
              "release_date": "2019-10-04"
            },
            {
              "popularity": 374.6,
              "vote_count": 296,
              "video": false,
              "poster_path": "/vqzNJRH4YyquRiWxCCOH0aXggHI.jpg",
              "id": 290859,
              "adult": false,
              "backdrop_path": "/a6cDxdwaQIFjSkXf7uskg78ZyTq.jpg",
              "original_language": "en",
              "original_title": "Terminator: Dark Fate",
              "genre_ids": [
                28,
                878
              ],
              "title": "Terminator: Dark Fate",
              "vote_average": 6.6,
              "overview": "More than two decades have passed since Sarah Connor prevented Judgment Day, changed the future, and re-wrote the fate of the human race. Dani Ramos is living a simple life in Mexico City with her brother and father when a highly advanced and deadly new Terminator – a Rev-9 – travels back through time to hunt and kill her. Dani's survival depends on her joining forces with two warriors: Grace, an enhanced super-soldier from the future, and a battle-hardened Sarah Connor. As the Rev-9 ruthlessly destroys everything and everyone in its path on the hunt for Dani, the three are led to a T-800 from Sarah’s past that may be their last best hope.",
              "release_date": "2019-11-01"
            },
            {
              "popularity": 214.876,
              "vote_count": 671,
              "video": false,
              "poster_path": "/tBuabjEqxzoUBHfbyNbd8ulgy5j.jpg",
              "id": 420809,
              "adult": false,
              "backdrop_path": "/skvI4rYFrKXS73BJxWGH54Omlvv.jpg",
              "original_language": "en",
              "original_title": "Maleficent: Mistress of Evil",
              "genre_ids": [
                12,
                14,
                10751
              ],
              "title": "Maleficent: Mistress of Evil",
              "vote_average": 7.2,
              "overview": "Maleficent and her goddaughter Aurora begin to question the complex family ties that bind them as they are pulled in different directions by impending nuptials, unexpected allies, and dark new forces at play.",
              "release_date": "2019-10-18"
            },
            {
              "popularity": 108.112,
              "vote_count": 1288,
              "video": false,
              "poster_path": "/ePXuKdXZuJx8hHMNr2yM4jY2L7Z.jpg",
              "id": 559969,
              "adult": false,
              "backdrop_path": "/ijiE9WoGSwSzM16zTxvUneJ8RXc.jpg",
              "original_language": "en",
              "original_title": "El Camino: A Breaking Bad Movie",
              "genre_ids": [
                80,
                18,
                53
              ],
              "title": "El Camino: A Breaking Bad Movie",
              "vote_average": 7.1,
              "overview": "In the wake of his dramatic escape from captivity, Jesse Pinkman must come to terms with his past in order to forge some kind of future.",
              "release_date": "2019-10-11"
            },
            {
              "popularity": 107.197,
              "vote_count": 150,
              "video": false,
              "poster_path": "/g4z7mDmJmx23vsVg6XNWcnXb6gc.jpg",
              "id": 480105,
              "adult": false,
              "backdrop_path": "/3uG3aOhEzFCjcQulsJQiAzLSrw8.jpg",
              "original_language": "en",
              "original_title": "47 Meters Down: Uncaged",
              "genre_ids": [
                12,
                18,
                27,
                53
              ],
              "title": "47 Meters Down: Uncaged",
              "vote_average": 5.1,
              "overview": "A group of backpackers diving in a ruined underwater city discover that they have stumbled into the territory of the ocean's deadliest shark species.",
              "release_date": "2019-08-16"
            },
            {
              "popularity": 106.325,
              "vote_count": 261,
              "video": false,
              "poster_path": "/pIcV8XXIIvJCbtPoxF9qHMKdRr2.jpg",
              "id": 338967,
              "adult": false,
              "backdrop_path": "/jCCdt0e8Xe9ttvevD4S3TSMNdH.jpg",
              "original_language": "en",
              "original_title": "Zombieland: Double Tap",
              "genre_ids": [
                28,
                35,
                27
              ],
              "title": "Zombieland: Double Tap",
              "vote_average": 7.4,
              "overview": "Columbus, Tallahassee, Wichita, and Little Rock move to the American heartland as they face off against evolved zombies, fellow survivors, and the growing pains of the snarky makeshift family.",
              "release_date": "2019-10-18"
            },
            {
              "popularity": 122.885,
              "vote_count": 314,
              "video": false,
              "poster_path": "/tximyCXMEnWIIyOy9STkOduUprG.jpg",
              "id": 521777,
              "adult": false,
              "backdrop_path": "/zIZv4pPJRg3YTnWWuotwXnYu1fM.jpg",
              "original_language": "en",
              "original_title": "Good Boys",
              "genre_ids": [
                35
              ],
              "title": "Good Boys",
              "vote_average": 6.6,
              "overview": "A group of young boys on the cusp of becoming teenagers embark on an epic quest to fix their broken drone before their parents get home.",
              "release_date": "2019-08-16"
            },
            {
              "popularity": 159.667,
              "vote_count": 64,
              "video": false,
              "poster_path": "/4E2lyUGLEr3yH4q6kJxPkQUhX7n.jpg",
              "id": 568012,
              "adult": false,
              "backdrop_path": "/iGnCzXEx0cFlUbpyAMeHwHWhPhx.jpg",
              "original_language": "ja",
              "original_title": "ワンピーススタンピード",
              "genre_ids": [
                28,
                12,
                16
              ],
              "title": "One Piece: Stampede",
              "vote_average": 7.6,
              "overview": "One Piece: Stampede is a stand-alone film that celebrates the anime's 20th Anniversary and takes place outside the canon of the \"One Piece\" TV series. Monkey D. Luffy and his Straw Hat pirate crew are invited to a massive Pirate Festival that brings many of the most iconic characters from throughout the franchise to participate in competition with the Straw Hats to find Roger's treasure. It also pits the Straw Hats against a new enemy named Bullet, a former member of Roger's crew.",
              "release_date": "2019-10-24"
            },
            {
              "popularity": 94.595,
              "vote_count": 127,
              "video": false,
              "poster_path": "/p69QzIBbN06aTYqRRiCOY1emNBh.jpg",
              "id": 501170,
              "adult": false,
              "backdrop_path": "/4D4Ic9N4tnwaW4x241LGb1XOi7O.jpg",
              "original_language": "en",
              "original_title": "Doctor Sleep",
              "genre_ids": [
                27
              ],
              "title": "Doctor Sleep",
              "vote_average": 7,
              "overview": "A traumatized, alcoholic Dan Torrance meets Abra, a kid who also has the ability to \"shine.\" He tries to protect her from the True Knot, a cult whose goal is to feed off people like them in order to remain immortal.",
              "release_date": "2019-11-08"
            },
            {
              "popularity": 79.143,
              "vote_count": 469,
              "video": false,
              "poster_path": "/uTALxjQU8e1lhmNjP9nnJ3t2pRU.jpg",
              "id": 453405,
              "adult": false,
              "backdrop_path": "/c3F4P2oauA7IQmy4hM0OmRt2W7d.jpg",
              "original_language": "en",
              "original_title": "Gemini Man",
              "genre_ids": [
                28,
                53
              ],
              "title": "Gemini Man",
              "vote_average": 5.8,
              "overview": "Henry Brogen, an aging assassin tries to get out of the business but finds himself in the ultimate battle: fighting his own clone who is 25 years younger than him and at the peak of his abilities.",
              "release_date": "2019-10-11"
            },
            {
              "popularity": 72.731,
              "vote_count": 1856,
              "video": false,
              "poster_path": "/zfE0R94v1E8cuKAerbskfD3VfUt.jpg",
              "id": 474350,
              "adult": false,
              "backdrop_path": "/8moTOzunF7p40oR5XhlDvJckOSW.jpg",
              "original_language": "en",
              "original_title": "It Chapter Two",
              "genre_ids": [
                27
              ],
              "title": "It Chapter Two",
              "vote_average": 6.9,
              "overview": "27 years after overcoming the malevolent supernatural entity Pennywise, the former members of the Losers' Club, who have grown up and moved away from Derry, are brought back together by a devastating phone call.",
              "release_date": "2019-09-06"
            },
            {
              "popularity": 80.121,
              "vote_count": 530,
              "video": false,
              "poster_path": "/q5298SICFzqMcKtQoBktk8p6FH.jpg",
              "id": 417384,
              "adult": false,
              "backdrop_path": "/qBI3Spq93lNxGzecdGpbwV5lOvU.jpg",
              "original_language": "en",
              "original_title": "Scary Stories to Tell in the Dark",
              "genre_ids": [
                27,
                53
              ],
              "title": "Scary Stories to Tell in the Dark",
              "vote_average": 6.3,
              "overview": "Mill Valley, Pennsylvania, Halloween night, 1968. After playing a joke on a school bully, Sarah and her friends decide to sneak into a supposedly haunted house that once belonged to the powerful Bellows family, unleashing dark forces that they will be unable to control.",
              "release_date": "2019-08-09"
            },
            {
              "popularity": 56.554,
              "vote_count": 247,
              "video": false,
              "poster_path": "/ebe8hJRCwdflNQbUjRrfmqtUiNi.jpg",
              "id": 454640,
              "adult": false,
              "backdrop_path": "/k7sE3loFwuU2mqf7FbZBeE3rjBa.jpg",
              "original_language": "en",
              "original_title": "The Angry Birds Movie 2",
              "genre_ids": [
                12,
                16,
                35,
                10751
              ],
              "title": "The Angry Birds Movie 2",
              "vote_average": 6.4,
              "overview": "Red, Chuck, Bomb and the rest of their feathered friends are surprised when a green pig suggests that they put aside their differences and unite to fight a common threat. Aggressive birds from an island covered in ice are planning to use an elaborate weapon to destroy the fowl and swine.",
              "release_date": "2019-08-14"
            },
            {
              "popularity": 65.448,
              "vote_count": 140,
              "video": false,
              "poster_path": "/uaXNjRkDdjfxfVuKHo25wkA6CiA.jpg",
              "id": 481084,
              "adult": false,
              "backdrop_path": "/ur4NTeFGZmQ6Hz5uEkAMgPI3WRg.jpg",
              "original_language": "en",
              "original_title": "The Addams Family",
              "genre_ids": [
                16,
                35,
                14,
                10751
              ],
              "title": "The Addams Family",
              "vote_average": 6.1,
              "overview": "The Addams family's lives begin to unravel when they face-off against a treacherous, greedy crafty reality-TV host while also preparing for their extended family to arrive for a major celebration.",
              "release_date": "2019-10-11"
            },
            {
              "popularity": 59.892,
              "vote_count": 3113,
              "video": false,
              "poster_path": "/ziEuG1essDuWuC5lpWUaw1uXY2O.jpg",
              "id": 458156,
              "adult": false,
              "backdrop_path": "/stemLQMLDrlpfIlZ5OjllOPT8QX.jpg",
              "original_language": "en",
              "original_title": "John Wick: Chapter 3 - Parabellum",
              "genre_ids": [
                28,
                80,
                53
              ],
              "title": "John Wick: Chapter 3 - Parabellum",
              "vote_average": 7.1,
              "overview": "Super-assassin John Wick returns with a ${'$'}14 million price tag on his head and an army of bounty-hunting killers on his trail. After killing a member of the shadowy international assassin’s guild, the High Table, John Wick is excommunicado, but the world’s most ruthless hit men and women await his every turn.",
              "release_date": "2019-05-17"
            },
            {
              "popularity": 46.848,
              "vote_count": 1017,
              "video": false,
              "poster_path": "/7IiTTgloJzvGI1TAYymCfbfl3vT.jpg",
              "id": 496243,
              "adult": false,
              "backdrop_path": "/TU9NIjwzjoKPwQHoHshkFcQUCG.jpg",
              "original_language": "ko",
              "original_title": "기생충",
              "genre_ids": [
                35,
                18,
                53
              ],
              "title": "Parasite",
              "vote_average": 8.5,
              "overview": "All unemployed, Ki-taek's family takes peculiar interest in the wealthy and glamorous Parks for their livelihood until they get entangled in an unexpected incident.",
              "release_date": "2019-10-11"
            },
            {
              "popularity": 49.586,
              "vote_count": 51,
              "video": false,
              "poster_path": "/fjmMu9fpqMMF17mCyLhNfkagKB0.jpg",
              "id": 578189,
              "adult": false,
              "backdrop_path": "/zBAoNL50oFRCAJvEEQEKD8M48pV.jpg",
              "original_language": "en",
              "original_title": "Black and Blue",
              "genre_ids": [
                28,
                80,
                18
              ],
              "title": "Black and Blue",
              "vote_average": 5.1,
              "overview": "Exposure follows a rookie Detroit African-American female cop who stumbles upon corrupt officers who are murdering a drug dealer, an incident captured by her body cam. They pursue her through the night in an attempt to destroy the footage, but to make matters worse, they've tipped off a criminal gang that she's responsible for the dealer's death.",
              "release_date": "2019-10-25"
            },
            {
              "popularity": 37.882,
              "vote_count": 7,
              "video": false,
              "poster_path": "/y2nzyAsOufAhqEEhsr0ArTCQBPz.jpg",
              "id": 565348,
              "adult": false,
              "backdrop_path": "/5GXreixVQdsHyirE8jJAlmoE8wT.jpg",
              "original_language": "en",
              "original_title": "Adopt a Highway",
              "genre_ids": [
                18
              ],
              "title": "Adopt a Highway",
              "vote_average": 8.2,
              "overview": "An ex-felon discovers a live baby left in a dumpster.",
              "release_date": "2019-11-01"
            },
            {
              "popularity": 46.447,
              "vote_count": 910,
              "video": false,
              "poster_path": "/1rjaRIAqFPQNnMtqSMLtg0VEABi.jpg",
              "id": 515195,
              "adult": false,
              "backdrop_path": "/t5Kp02Jzixl0KfpwthHp9ZUex9t.jpg",
              "original_language": "en",
              "original_title": "Yesterday",
              "genre_ids": [
                35,
                14,
                10402,
                10749
              ],
              "title": "Yesterday",
              "vote_average": 6.7,
              "overview": "Jack Malik is a struggling singer-songwriter in an English seaside town whose dreams of fame are rapidly fading, despite the fierce devotion and support of his childhood best friend, Ellie. After a freak bus accident during a mysterious global blackout, Jack wakes up to discover that he's the only person on Earth who can remember The Beatles.",
              "release_date": "2019-06-28"
            },
            {
              "popularity": 42.627,
              "vote_count": 15423,
              "video": false,
              "poster_path": "/lZpWprJqbIFpEV5uoHfoK0KCnTW.jpg",
              "id": 603,
              "adult": false,
              "backdrop_path": "/icmmSD4vTTDKOq2vvdulafOGw93.jpg",
              "original_language": "en",
              "original_title": "The Matrix",
              "genre_ids": [
                28,
                878
              ],
              "title": "The Matrix",
              "vote_average": 8.1,
              "overview": "Set in the 22nd century, The Matrix tells the story of a computer hacker who joins a group of underground insurgents fighting the vast and powerful computers who now rule the earth.",
              "release_date": "1999-03-30"
            }
          ]
    """.trimIndent()

}