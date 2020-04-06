package com.example.vgames.ui.detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import javax.inject.Inject

class DetailActivity : AppCompatActivity(), DetailScreen {

    @Inject
    lateinit var detailPresenter: DetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        detailPresenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        detailPresenter.detachScreen()
    }
}