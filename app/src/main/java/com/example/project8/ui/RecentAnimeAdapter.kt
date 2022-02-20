package com.example.project8.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.project8.databinding.ItemRecentAnimeBinding
import com.example.project8.model.RecentAnimeResponse

class RecentAnimeAdapter : RecyclerView.Adapter<RecentAnimeAdapter.ViewHolder>() {

    private val listContainer = mutableListOf<RecentAnimeResponse>()

    inner class ViewHolder(private val binding: ItemRecentAnimeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(anime: RecentAnimeResponse) {
            binding.apply {
                Glide.with(itemView).load(anime.imageUrl).into(ivPoster)
                tvTitle.text = anime.title
                tvEpisode.text = anime.episode
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemRecentAnimeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val anime = listContainer[position]
        holder.bind(anime)
    }

    override fun getItemCount(): Int {
        return listContainer.size
    }

    fun populateData(input: List<RecentAnimeResponse>) {
//        listContainer.clear()
        listContainer.addAll(input)
        notifyDataSetChanged()
    }
}