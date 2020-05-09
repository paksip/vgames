package com.example.vgames.test

import com.example.vgames.model.dto.Game
import com.example.vgames.testInjector
import com.example.vgames.ui.detail.DetailPresenter
import com.example.vgames.ui.detail.DetailScreen
import com.example.vgames.ui.main.MainPresenter
import com.example.vgames.ui.main.MainScreen
import com.example.vgames.utils.argumentCaptor
import com.example.vgames.utils.mock
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.robolectric.RobolectricTestRunner
import javax.inject.Inject

@RunWith(RobolectricTestRunner::class)
class GamesTest {
    @Inject
    lateinit var detailsPresenter: DetailPresenter
    private lateinit var detailScreen: DetailScreen

    @Before
    @Throws(Exception::class)
    fun setup() {
        testInjector.inject(this)
        detailScreen = mock()
        detailsPresenter.attachScreen(detailScreen)
    }

    @Test
    fun test() {
        detailsPresenter.load(1)

        val game = argumentCaptor<Game>()
        Mockito.verify(detailScreen).showGame(game.capture())
        assert(game.value.description == "gamedescription")
    }

    @After
    fun tearDown() {
        detailsPresenter.detachScreen()
    }
}