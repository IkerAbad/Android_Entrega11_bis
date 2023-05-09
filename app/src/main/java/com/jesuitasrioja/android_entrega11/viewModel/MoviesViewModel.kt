package com.jesuitasrioja.android_entrega11.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jesuitasrioja.android_entrega11.model.Movie
import com.jesuitasrioja.android_entrega11.services.ApiMoshi
import kotlinx.coroutines.launch

class MoviesViewModel : ViewModel(){
    private val _response = MutableLiveData<List<Movie>>()

    val response: LiveData<List<Movie>>
        get() = _response

    val imgSrcUrl: String
        get() = selectedMovie.image.toString()

    lateinit var selectedMovie :Movie


    fun getMovies(parameter:String){
        viewModelScope.launch {
            try {
                _response.value= ApiMoshi.retrofitMoshiService.getImageRandom(parameter).results
            }catch (e:java.lang.Exception){
                Log.d("error",e.message!!)
            }
        }
    }
    fun changeSelected (movie: Movie){
        selectedMovie=movie
    }
}