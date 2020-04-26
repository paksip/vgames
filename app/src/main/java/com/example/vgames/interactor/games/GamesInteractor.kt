package com.example.vgames.interactor.games

import android.util.Log
import com.example.vgames.interactor.games.event.GetAllGamesEvent
import com.example.vgames.interactor.games.event.GetGameByIdEvent
import com.example.vgames.network.GamesApi
import com.example.vgames.network.NetworkConfig
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

class GamesInteractor @Inject constructor(private var gamesApi: GamesApi) {
    fun getAllGames() {
        val event = GetAllGamesEvent()

        try {
            val gamesQueryCall = gamesApi.getAllGames(NetworkConfig.API_KEY, NetworkConfig.RESPONSE_FORMAT)

            val response = gamesQueryCall.execute()
            Log.d("getAllGames Reponse", response.body().toString())
            if (response.code() != 200) {
                throw Exception("getAllGames result code is not 200: ${response.code()}")
            }
            event.code = response.code()
            event.games = response.body()?.results
            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }

    fun getGameById(gameId: Long) {
        val event = GetGameByIdEvent()

        try {
            val gameQueryCall = gamesApi.getOneGame(gameId, NetworkConfig.API_KEY, NetworkConfig.RESPONSE_FORMAT)

            val response = gameQueryCall.execute()
            Log.d("getGameById Reponse", response.body().toString())
            if (response.code() != 200 && response.code() != 404) {
                throw Exception("getGameById result code is not 200")
            }
            event.code = response.code()
            event.game = response.body()?.results
            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.throwable = e
            EventBus.getDefault().post(event)
        }
    }
}