package com.example.project8.depedency_injection

import com.example.project8.api.AnimeAPI
import com.example.project8.repository.AnimeRepository
import com.example.project8.repository.AnimeRepositoryImpl
import com.example.project8.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAnimeAPI(): AnimeAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AnimeAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideAnimeRepository(
        api: AnimeAPI
    ): AnimeRepository {
        return AnimeRepositoryImpl  (api)
    }
}