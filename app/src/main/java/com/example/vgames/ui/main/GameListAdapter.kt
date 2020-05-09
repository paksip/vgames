package com.example.vgames.ui.main

import android.content.Context
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.vgames.R
import com.example.vgames.model.dto.Game
import kotlinx.android.synthetic.main.row_game.view.*

class GameListAdapter(val context: Context) : ListAdapter<Game, GameListAdapter.GameViewHolder>(GameComparator) {

    var listener: Listener? = null

    inner class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val gameImage = itemView.gameImage
        private val nameText = itemView.gameNameText
        private val deckText = itemView.gameDeckText

        private var gameItem: Game? = null

        init {
            itemView.setOnClickListener {
                gameItem?.let { listener?.onGameClicked(it) }
            }
        }

        fun bind(game: Game) {
            gameItem = game

            Glide.with(context).load(gameItem!!.image!!.smallUrl).into(gameImage)
            nameText.text = game.name
            deckText.text = game.deck
        }
    }

    interface Listener {
        fun onGameClicked(game: Game)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_game, parent, false)
        return GameViewHolder(view)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}