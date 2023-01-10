package com.example.lab02.dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.example.lab02.R
import kotlin.random.Random

class AddMovieDialog: DialogFragment() {

    interface AddMovieDialogListener {

        fun addMovie(title: String, description: String, actors: String, director: String, id: Int)
    }

    private lateinit var listener: AddMovieDialogListener


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val builder = AlertDialog.Builder(activity)

        val layoutInflater = activity?.layoutInflater

        val view = layoutInflater?.inflate(R.layout.add_movie_dialog, null)

        val title: EditText? = view?.findViewById(R.id.newMovie)
        val description: EditText? = view?.findViewById(R.id.newDescription)
        val actors: EditText? = view?.findViewById(R.id.newActors)
        val director: EditText? = view?.findViewById(R.id.newDirector)

        val index = Random.nextInt(3,9999)

        builder.setView(view)
            .setTitle("Add a new Movie")
            .setPositiveButton("Add the Movie") { _, _ ->

                val movieTitleValue: String = title?.text.toString()
                val movieDescriptionValue: String = director?.text.toString()
                val movieActorsValue: String = actors?.text.toString()
                val movieDirectorValue: String = director?.text.toString()

                listener.addMovie(
                    movieTitleValue,
                    movieDescriptionValue,
                    movieActorsValue,
                    movieDirectorValue,
                    index)
            }
            .setNegativeButton("Back") { _, _ -> }

        return builder.create()
    }


    fun setAddMovieDialogListener(listener: AddMovieDialogListener) {

        this.listener = listener
    }
}