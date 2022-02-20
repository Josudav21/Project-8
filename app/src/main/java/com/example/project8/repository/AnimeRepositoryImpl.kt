package com.example.project8.repository

import com.example.project8.api.AnimeAPI
import com.example.project8.model.RecentAnimeResponse
import com.example.project8.utils.Resource

class AnimeRepositoryImpl(
    private val api: AnimeAPI
) : AnimeRepository {

    override suspend fun getRecentAnimeList(page: Int): Resource<List<RecentAnimeResponse>> {
        return try {
            val response = api.getAnimeList(page)
            val result = response.body()
            if (response.isSuccessful && result != null) {
                Resource.OK(result, "Success load recent anime list")
            } else {
                Resource.Failed(response.message())
            }
        } catch (e: Exception) {
            Resource.Failed(e.message ?: "No internet connection")
        }
    }

}