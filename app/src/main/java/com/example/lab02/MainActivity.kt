package com.example.lab02

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.example.lab02.fragments.MovieListFragment
import com.example.lab02.viewmodels.SelectedMovieViewModel

class MainActivity : AppCompatActivity() {

    private val selectedMovieViewModel: SelectedMovieViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState==null) {
            val fragmentManager: FragmentManager = supportFragmentManager
            fragmentManager.beginTransaction()
                .add(R.id.fragment_container_view, MovieListFragment())
                .setReorderingAllowed(true)
                .addToBackStack(null)
                .commit()

        }
    }
}