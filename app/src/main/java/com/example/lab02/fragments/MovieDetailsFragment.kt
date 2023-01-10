package com.example.lab02.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.lab02.R
import com.example.lab02.databinding.FragmentMovieDetailsBinding
import com.example.lab02.models.Movie
import com.example.lab02.viewmodels.SelectedMovieViewModel


class MovieDetailsFragment : Fragment() {

    private val selectedMovieViewModel: SelectedMovieViewModel by activityViewModels()

    private var _binding: FragmentMovieDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movie_details, container, false)

        _binding = FragmentMovieDetailsBinding.bind(view)

        selectedMovieViewModel.selectedMovie.observe(viewLifecycleOwner) {
            binding.movieId.text = it.id.toString()
            binding.movieTitle.text = it.title
            binding.movieDirector.text = it.director
            binding.movieDescrpition.text = it.description

            val listView = view.findViewById<ListView>(R.id.movieActors)

            listView.adapter = ArrayAdapter(view.context, android.R.layout.simple_list_item_1, it.actors!!)
        }

        return view
    }
}