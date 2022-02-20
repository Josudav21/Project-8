package com.example.project8.api

import com.example.project8.model.RecentAnimeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeAPI {

    @GET("recent/{page}")
    suspend fun getAnimeList(
        @Path("page") page:Int
    ) : Response<List<RecentAnimeResponse>>
}