package com.example.vgames.mock.network

import com.example.vgames.model.dto.ResponseList
import com.example.vgames.model.dto.ResponseOne
import com.example.vgames.network.GamesApi
import retrofit2.Call

class MockGamesApi: GamesApi {
    override fun getOneGame(gameId: Long?, apiKey: String?, format: String?): Call<ResponseOne> {
        TODO("Not yet implemented")
    }

    override fun getAllGames(apiKey: String?, format: String?): Call<ResponseList> {
        TODO("Not yet implemented")
    }

}