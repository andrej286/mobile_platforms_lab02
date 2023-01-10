package com.example.lab02.fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab02.R
import com.example.lab02.adapters.MovieAdapter
import com.example.lab02.dialogs.AddMovieDialog
import com.example.lab02.models.Movie
import com.example.lab02.services.FakeApiService
import com.example.lab02.viewmodels.SelectedMovieViewModel

class MovieListFragment : Fragment(R.layout.fragment_movie_list), AddMovieDialog.AddMovieDialogListener {

    private lateinit var data: MutableList<Movie>
    private val service = FakeApiService()
    private lateinit var adapter : MovieAdapter
    private val selectedMovieViewModel: SelectedMovieViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        data = service.getAllMovies()

        val recyclerView = view.findViewById<RecyclerView>(R.id.movieRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(view.context)
        recyclerView.setHasFixedSize(true)

        adapter = MovieAdapter(data){ position ->
            onMovieClick(
                position
            )
        }

        recyclerView.adapter = adapter

        val dialogButton = view.findViewById<Button>(R.id.addMovie)

        dialogButton.setOnClickListener{
            val dialogInstance = AddMovieDialog()
            dialogInstance.setAddMovieDialogListener(this)
            fragmentManager?.let { dialogInstance.show(it, "Add a Movie") }
        }
    }

    private fun onMovieClick(position: Int){

        selectedMovieViewModel.selectMovie(data[position]);

        val fragment: Fragment = MovieDetailsFragment()
        val fragmentManager = activity!!.supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container_view, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    override fun addMovie(
        title: String,
        description: String,
        actors: String,
        director: String,
        id: Int
    ) {

        val actorsAsList: MutableList<String>  = actors.split(";") as MutableList<String>
        val movie = Movie(id.toLong(), title, description, director, actorsAsList)

        service.addMovie(movie)

        adapter.notifyItemChanged(0)
    }
}