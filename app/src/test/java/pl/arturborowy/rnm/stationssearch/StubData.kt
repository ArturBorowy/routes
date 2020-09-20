package pl.arturborowy.rnm.stationssearch

import pl.arturborowy.rnm.data.remote.stations.StationDto
import pl.arturborowy.rnm.data.remote.stations.keywords.KeywordDto
import pl.arturborowy.rnm.domain.stations.model.KeywordEntity
import pl.arturborowy.rnm.domain.stations.model.StationEntity

object StubData {
    const val KEYWORD_WITH_MATCHING_STATION_ID = 1L
    const val KEYWORD_WITH_MATCHING_STATION_KEYWORD = "Karkow"
    const val KEYWORD_WITH_MATCHING_STATION_STATION_ID = 1000L

    object Keyword {
        val WITHOUT_MATCHING_STATION_DTO = KeywordDto(0, "Warsaw", -1000)

        val WITH_MATCHING_STATION_DTO = KeywordDto(
            KEYWORD_WITH_MATCHING_STATION_ID,
            KEYWORD_WITH_MATCHING_STATION_KEYWORD,
            KEYWORD_WITH_MATCHING_STATION_STATION_ID
        )

        val WITH_MATCHING_STATION_ENTITY =
            KeywordEntity(
                KEYWORD_WITH_MATCHING_STATION_ID,
                KEYWORD_WITH_MATCHING_STATION_KEYWORD,
                KEYWORD_WITH_MATCHING_STATION_STATION_ID
            )

        val ALL_DTO = listOf(WITH_MATCHING_STATION_DTO, WITHOUT_MATCHING_STATION_DTO)
    }

    object Stations {

        val MATCHING_ENTITY = StationEntity(
            KEYWORD_WITH_MATCHING_STATION_KEYWORD,
            1,
            KEYWORD_WITH_MATCHING_STATION_STATION_ID,
            "Kraków",
            KEYWORD_WITH_MATCHING_STATION_KEYWORD,
            1.0,
            2.0
        )

        val ENTITY_2 = StationEntity(
            KEYWORD_WITH_MATCHING_STATION_KEYWORD,
            100,
            KEYWORD_WITH_MATCHING_STATION_STATION_ID,
            "Kraków",
            KEYWORD_WITH_MATCHING_STATION_KEYWORD,
            1.0,
            1.0
        )

        val ALL_ENTITIES = listOf(MATCHING_ENTITY, ENTITY_2)

        val MATCHING_DTO =
            StationDto(
                    KEYWORD_WITH_MATCHING_STATION_KEYWORD,
                    "Poland",
                    1,
                    null,
                    KEYWORD_WITH_MATCHING_STATION_STATION_ID,
                    1.0,
                    "Kraków",
                    1.0,
                    KEYWORD_WITH_MATCHING_STATION_KEYWORD,
                    "KRK",
                    "Małopolskie"
                )

        val DTO_2 =
            StationDto(
                KEYWORD_WITH_MATCHING_STATION_KEYWORD,
                "Poland",
                100,
                null,
                KEYWORD_WITH_MATCHING_STATION_STATION_ID,
                1.0,
                "Kraków",
                1.0,
                KEYWORD_WITH_MATCHING_STATION_KEYWORD,
                "KRK",
                "Małopolskie"
            )

        val ALL_DTO = listOf(MATCHING_DTO, DTO_2)
    }
}