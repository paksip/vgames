package com.example.vgames.network

import com.example.vgames.model.ResponseList
import com.example.vgames.model.ResponseOne
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface GamesApi {
    /**
     * Get a video game
     *
     * @param gameId ID of game to return
     * @param apiKey The API key
     * @param format Response format
     * @return Call<ComponentsschemasResponseOne>
    </ComponentsschemasResponseOne> */
    @GET("game/{gameId}")
    fun getOneGame(
        @Path("gameId") gameId: Long?,
        @Query("api_key") apiKey: String?,
        @Query("format") format: String?
    ): Call<ResponseOne?>?

    /**
     * Get all video games
     *
     * @param apiKey The API key
     * @param format Response format
     * @return Call<List></List><ComponentsschemasResponseList>>
    </ComponentsschemasResponseList> */
    @GET("games")
    fun getAllGames(
        @Query("api_key") apiKey: String?,
        @Query("format") format: String?
    ): Call<List<ResponseList?>?>?
}
