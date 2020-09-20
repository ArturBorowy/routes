package pl.arturborowy.rnm.stationssearch

import io.mockk.every
import io.mockk.mockk
import io.reactivex.Single
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.module
import org.koin.test.AutoCloseKoinTest
import org.koin.test.inject
import pl.arturborowy.rnm.base.di.definitionModule
import pl.arturborowy.rnm.base.error.ThrowableHandler
import pl.arturborowy.rnm.base.rx.RemoteFetchSchedulerProvider
import pl.arturborowy.rnm.base.rx.SchedulerProvider
import pl.arturborowy.rnm.data.remote.StationsService
import pl.arturborowy.rnm.testutils.MockSchedulerProvider

class StationsSearchViewModelTest : AutoCloseKoinTest() {

    private val mockStationsService = mockk<StationsService>()
    private val mockThrowableHandler = mockk<ThrowableHandler>()

    private val stationsSearchViewModel by inject<StationsSearchViewModel>()

    @Before
    fun setUp() {
        startKoin {
            modules(definitionModule + module {
                single<SchedulerProvider>(
                    override = true,
                    qualifier = named<RemoteFetchSchedulerProvider>()
                ) { MockSchedulerProvider() }

                single(override = true) { mockStationsService }
                single(override = true) { mockThrowableHandler }
            })
        }
    }

    @Test
    fun `onViewCreated sets only matching keywords with matching stations`() {
        every { mockStationsService.getKeywords() } returns Single.just(StubData.Keyword.ALL)

        every { mockStationsService.getStations() } returns
                Single.just(listOf(StubData.Stations.MATCHING_DTO))

        stationsSearchViewModel.onViewCreated()

        Assert.assertEquals(
            listOf(StubData.Keyword.WITH_MATCHING_STATION_ENTITY),
            stationsSearchViewModel.keywords.get()
        )
    }

    @Test
    fun `onViewCreated sets stations`() {
        every { mockStationsService.getKeywords() } returns Single.just(listOf())

        every { mockStationsService.getStations() } returns
                Single.just(listOf(StubData.Stations.MATCHING_DTO))

        stationsSearchViewModel.onViewCreated()

        Assert.assertEquals(
            listOf(StubData.Stations.MATCHING_ENTITY),
            stationsSearchViewModel.stations.get()
        )
    }
}