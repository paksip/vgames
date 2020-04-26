package com.example.vgames.test

import com.example.vgames.testInjector
import com.example.vgames.ui.main.MainPresenter
import com.example.vgames.ui.main.MainScreen
import com.example.vgames.utils.mock
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.verify
import org.robolectric.RobolectricTestRunner
import javax.inject.Inject

@RunWith(RobolectricTestRunner::class)
class MainTest {
    @Inject
    lateinit var mainPresenter: MainPresenter
    private lateinit var mainScreen: MainScreen

    @Throws(Exception::class)
    @Before
    fun setup() {
        testInjector.inject(this)
        mainScreen = mock()
        mainPresenter.attachScreen(mainScreen)
    }

    @Test
    fun testListGames() {
        mainPresenter.showGames()
        verify(mainScreen).showGames()
    }

    @After
    fun tearDown() {
        mainPresenter.detachScreen()
    }
}