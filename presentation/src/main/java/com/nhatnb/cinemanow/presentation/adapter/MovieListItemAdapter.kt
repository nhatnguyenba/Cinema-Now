package com.nhatnb.cinemanow.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.nhatnb.cinemanow.data.BuildConfig
import com.nhatnb.cinemanow.databinding.ItemMovieBinding
import com.nhatnb.cinemanow.presentation.entities.MovieListItem

class MovieListItemAdapter : PagingDataAdapter<MovieListItem, MovieListItemAdapter.MovieListItemViewHolder>(MOVIE_LIST_ITEM_COMPARATOR) {

    class MovieListItemViewHolder(
        val itemMovieBinding: ItemMovieBinding
    ) : RecyclerView.ViewHolder(itemMovieBinding.root)

    override fun onBindViewHolder(holder: MovieListItemViewHolder, position: Int) {
        val movieListItem = getItem(position)
        holder.itemMovieBinding.apply {
            movieListItem?.let { movie ->
                tvMovieTitle.text = movie.title
                tvMovieRating.text = movie.rating.toString()
                Glide.with(this.root)
                    .load(BuildConfig.BASE_IMG_URL + movie.imageUrl)
                    .diskCacheStrategy(DiskCacheStrategy.DATA)
                    .into(ivMovieItem)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListItemViewHolder {
        return MovieListItemViewHolder(
            ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    companion object {
        private val MOVIE_LIST_ITEM_COMPARATOR = object : DiffUtil.ItemCallback<MovieListItem>() {
            override fun areItemsTheSame(oldItem: MovieListItem, newItem: MovieListItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: MovieListItem, newItem: MovieListItem): Boolean =
                oldItem == newItem
        }
    }
}
