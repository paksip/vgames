package com.example.vgames.mock.network

import com.example.vgames.model.dto.*
import com.example.vgames.network.GamesApi
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.util.*

class MockGamesApi: GamesApi {
    override fun getOneGame(gameId: Long?, apiKey: String?, format: String?): Call<ResponseOne> {
        val image = Image("imageurl")
        val platform = Platform("Playstation")
        val game = Game(
            1,
            "game",
            image,
            "gamedeck",
            "gamedescription",
            "date",
            Collections.singletonList(platform)
        )
        val responseOne = ResponseOne(game)

        val call = object : Call<ResponseOne> {
            @Throws(IOException::class)
            override fun execute(): Response<ResponseOne> {
                return Response.success(responseOne)
            }

            override fun enqueue(callback: Callback<ResponseOne>) {

            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {

            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun clone(): Call<ResponseOne> {
                return this
            }

            override fun request(): Request? {
                return null
            }
        }
        return call
    }

    override fun getAllGames(apiKey: String?, format: String?): Call<ResponseList> {
        val image = Image("imageurl")
        val platform = Platform("Playstation")
        val game = Game(
            1,
            "game",
            image,
            "gamedeck",
            "gamedescription",
            "date",
            Collections.singletonList(platform)
        )
        val responseList = ResponseList(Collections.singletonList(game))

        val call = object : Call<ResponseList> {
            @Throws(IOException::class)
            override fun execute(): Response<ResponseList> {
                return Response.success(responseList)
            }

            override fun enqueue(callback: Callback<ResponseList>) {

            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {

            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun clone(): Call<ResponseList> {
                return this
            }

            override fun request(): Request? {
                return null
            }
        }
        return call
    }

}