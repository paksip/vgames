package com.example.vgames.test

import com.example.vgames.testInjector
import com.example.vgames.ui.main.MainPresenter
import com.example.vgames.ui.main.MainScreen
import com.example.vgames.utils.mock
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import javax.inject.Inject

@RunWith(RobolectricTestRunner::class)
class GamesTest {
    @Inject
    lateinit var mainPresenter: MainPresenter

    private lateinit var mainScreen: MainScreen
    private lateinit var query: String

    @Before
    @Throws(Exception::class)
    fun setup() {
        testInjector.inject(this)
        mainScreen = mock()
        mainPresenter.attachScreen(mainScreen)
    }

    @Test
    fun test() {
        // TODO: IMPLEMENT...
    }

    @After
    fun tearDown() {
        mainPresenter.detachScreen()
    }
}