package com.example.project8.repository

import com.example.project8.model.RecentAnimeResponse
import com.example.project8.utils.Resource
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeRepository {

    suspend fun getRecentAnimeList(
        page: Int
    ): Resource<List<RecentAnimeResponse>>
}