package com.example.lab02.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab02.R
import com.example.lab02.models.Movie

class MovieAdapter(private val movies: MutableList<Movie>, private val onMovieClick: (position: Int) -> Unit) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    class ViewHolder(view: View, private val onMovieClick: (position: Int) -> Unit) : RecyclerView.ViewHolder(view), View.OnClickListener {
        val movieId: TextView = view.findViewById(R.id.movieIdText)
        val movieTitle: TextView = view.findViewById(R.id.movieTitleText)
        val movieDirector: TextView = view.findViewById(R.id.movieDirectorText)

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = absoluteAdapterPosition
            onMovieClick(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_list_item, parent, false)
        return ViewHolder(view){ position ->
            onMovieClick(
                position
            )
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentMovie = movies[position]

        holder.movieId.text = "id: ${currentMovie.id.toString()}"
        holder.movieTitle.text = "title: ${currentMovie.title}"
        holder.movieDirector.text = "director: ${currentMovie.director}"
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}