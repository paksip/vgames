package com.example.vgames.ui.detail

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.bumptech.glide.Glide
import com.example.vgames.R
import com.example.vgames.injector
import com.example.vgames.model.dto.Game
import com.example.vgames.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_item_detail.*
import kotlinx.android.synthetic.main.row_game.*
import kotlinx.android.synthetic.main.row_game.gameImage
import javax.inject.Inject

class DetailActivity : AppCompatActivity(), DetailScreen {

    companion object {
        const val KEY_GAME_ID = "GAME_ID"
    }

    private var gameId: Long = 0

    @Inject
    lateinit var detailPresenter: DetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)
        setSupportActionBar(detail_toolbar as Toolbar)

        injector.inject(this)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        initArguments()
    }

    private fun initArguments() {
        println(intent?.extras?.getLong(KEY_GAME_ID))
        gameId = intent?.extras?.getLong(KEY_GAME_ID)?.toLong() ?: 0
        println()
    }

    override fun onOptionsItemSelected(item: MenuItem) =
        when (item.itemId) {
            android.R.id.home -> {
                navigateUpTo(Intent(this, MainActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    override fun onResume() {
        super.onResume()
        detailPresenter.attachScreen(this)
        detailPresenter.load(gameId)
    }

    override fun onPause() {
        super.onPause()
        detailPresenter.detachScreen()
    }

    override fun showNetworkError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun showGame(game: Game?) {
        if (game != null) {
            Glide.with(this).load(game.image!!.smallUrl!!).into(gameImage)
            name.text = game.name
            originalReleaseDateText.text = game.originalReleaseDate ?: ""
            descriptionText.text = Html.fromHtml(game.description ?: "")
        }
    }
}