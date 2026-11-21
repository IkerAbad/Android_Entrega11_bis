package com.jesuitasrioja.android_entrega11.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jesuitasrioja.android_entrega11.model.Album
import com.jesuitasrioja.android_entrega11.services.ApiMoshi
import kotlinx.coroutines.launch

class AlbumViewModel : ViewModel(){
    private val _response = MutableLiveData<List<Album>>()

    val response: LiveData<List<Album>>
        get() = _response

    val imgSrcUrl: String
        get() = selectedAlbum.artworkUrl100

    lateinit var selectedAlbum :Album


    fun getAlbums(parameter:String){
        viewModelScope.launch {
            try {
                //println(ApiMoshi.retrofitMoshiService.getAlbums(parameter))
                _response.value= ApiMoshi.retrofitMoshiService.getAlbums(parameter).results
            }catch (e:java.lang.Exception){
                Log.d("error",e.message!!)
            }
        }
    }
    fun changeSelected (album: Album){
        selectedAlbum=album
    }
}