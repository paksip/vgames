package com.example.vgames.ui.main

import android.R.id
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.vgames.R
import com.example.vgames.injector
import com.example.vgames.model.dto.Game
import com.example.vgames.ui.detail.DetailActivity
import com.example.vgames.ui.detail.DetailActivity.Companion.KEY_GAME_ID
import com.example.vgames.ui.utils.hide
import com.example.vgames.ui.utils.show
import com.google.firebase.analytics.FirebaseAnalytics
import kotlinx.android.synthetic.main.activity_item_detail.*
import kotlinx.android.synthetic.main.activity_item_list.*
import kotlinx.android.synthetic.main.item_list.*
import javax.inject.Inject


class MainActivity : AppCompatActivity(), MainScreen, GameListAdapter.Listener {

    private lateinit var listAdapter: GameListAdapter

    private lateinit var firebaseAnalytics: FirebaseAnalytics

    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_list)

        injector.inject(this)

        setSupportActionBar(toolbar as Toolbar?)
        supportActionBar?.title = getString(R.string.app_name)

        setupRecyclerView()
        setUpRefreshView()

        // FABRIC - CRASHLYTICS
        crashButton.setOnClickListener {
            throw RuntimeException("Test Crash") // Force a crash
        }

        // ANALYTICS
        firebaseAnalytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "ITEM_ID")
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "ITEM_NAME")
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image")
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle)
    }

    override fun onResume() {
        super.onResume()
        mainPresenter.attachScreen(this)
        mainPresenter.load()
    }

    override fun onPause() {
        super.onPause()
        mainPresenter.detachScreen()
    }

    override fun onStart() {
        super.onStart()
        mainPresenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        mainPresenter.detachScreen()
    }

    private fun setupRecyclerView() {
        listAdapter = GameListAdapter(this)
        listAdapter.listener = this
        (gameList as RecyclerView).adapter = listAdapter
    }

    private fun setUpRefreshView() {
        (swipeRefreshLayoutGames as SwipeRefreshLayout).setOnRefreshListener {
            mainPresenter.load()
        }
    }

    override fun onGameClicked(game: Game) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(KEY_GAME_ID, game.id)
        startActivity(intent)
    }

    override fun showGames(games: List<Game>?) {
        (swipeRefreshLayoutGames as SwipeRefreshLayout).isRefreshing = false

        if (games?.isEmpty() == true) {
            gameList?.hide()
            tvEmpty?.show()
        } else {
            gameList?.show()
            tvEmpty?.hide()
            listAdapter.submitList(games)

        }
    }

    override fun showNetworkError(message: String) {
        (swipeRefreshLayoutGames as SwipeRefreshLayout).isRefreshing = false
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}