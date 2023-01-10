package com.example.lab02.models

data class Movie(val id: Long, val title: String?, val description: String?, val director: String?, val actors: MutableList<String>?) {

}