package com.example.project8.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project8.model.RecentAnimeResponse
import com.example.project8.repository.AnimeRepository
import com.example.project8.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(
    private val repo: AnimeRepository
) : ViewModel() {

    private val _recentAnimeResource = MutableLiveData<Resource<List<RecentAnimeResponse>>>()
    val recentAnimeResource: LiveData<Resource<List<RecentAnimeResponse>>> = _recentAnimeResource

    var currentPage = 1

    fun executeGetRecentAnime(page: Int) = viewModelScope.launch {
        var resource = repo.getRecentAnimeList(currentPage)
        when (resource) {
            is Resource.OK -> {
                currentPage++
            }
        }
        _recentAnimeResource.value = resource
    }
}