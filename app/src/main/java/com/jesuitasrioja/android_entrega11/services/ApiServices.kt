package com.jesuitasrioja.android_entrega11.services

import com.jesuitasrioja.android_entrega11.model.Album
import com.jesuitasrioja.android_entrega11.model.AlbumFound
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

// https://itunes.apple.com/search
// https://itunes.apple.com/search?term=senderos&entity=album&attribute=albumTerm
private const val BASE_URL = "https://itunes.apple.com/"
/*
    Using Moshi to convert JSON response
 */

interface ApiServiceMoshi {

    //@GET("{parameter}")
    //suspend fun getImageRandom(@Path("parameter") parameter:String):AlbumFound

    @GET("search") // becomes post/search?term=senderos
    suspend fun getAlbums (@Query("term") search: String): List<Album>


}

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofitMoshi = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

object ApiMoshi {
    val retrofitMoshiService : ApiServiceMoshi by lazy {
        retrofitMoshi.create(ApiServiceMoshi::class.java) }
}