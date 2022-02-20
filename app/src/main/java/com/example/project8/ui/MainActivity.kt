package com.example.project8.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.project8.databinding.ActivityMainBinding
import com.example.project8.utils.Resource
import com.example.project8.view_model.AnimeViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: RecentAnimeAdapter
    private val viewModel: AnimeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.apply {
            viewModel.apply {
                initializeRecycleView()

                fabAdd.setOnClickListener {
                    executeGetRecentAnime(1) //bikin button klo di klik ngeload page
                }

                recentAnimeResource.observe(this@MainActivity, {resource ->
                    when (resource) {
                        is Resource.OK -> {
                            Snackbar.make(binding.root, resource.msg, Snackbar.LENGTH_SHORT).show()
                            adapter.populateData(resource.data!!)
                        }
                        is Resource.Failed -> {
                            Snackbar.make(binding.root, resource.msg, Snackbar.LENGTH_SHORT).show()
                        }
                    }
                })
            }

        }
    }

    private fun initializeRecycleView() {
        adapter = RecentAnimeAdapter()
        binding.apply {
            rvRecentAnime.adapter = adapter
            rvRecentAnime.layoutManager =
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        }

    }
}