package com.example.vgames.ui.main

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.vgames.R
import com.example.vgames.model.dto.Game
import kotlinx.android.synthetic.main.row_game.view.*

class GameListAdapter(val context: Context) : ListAdapter<Game, GameListAdapter.GameViewHolder>(GameComparator),
    Parcelable {

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

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<GameListAdapter> {
        override fun createFromParcel(parcel: Parcel): GameListAdapter {
            return GameListAdapter(parcel as Context)
        }

        override fun newArray(size: Int): Array<GameListAdapter?> {
            return arrayOfNulls(size)
        }
    }

}