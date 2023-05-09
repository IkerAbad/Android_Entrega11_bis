package com.jesuitasrioja.android_entrega11.model

data class MovieFound (
    val searchType: String,
    val expression: String,
    val results: List<Movie>,
    val errorMessage: String
)