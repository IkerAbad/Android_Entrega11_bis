package com.jesuitasrioja.android_entrega11.model

data class Movie (
    val id:String,
    val resultType:String,
    val image:String,
    val title:String,
    val description :String
){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false

        val secondaryMovie = other as Movie

        if (id != secondaryMovie.id) return false
        if (image != secondaryMovie.image) return false

        return true
    }
}