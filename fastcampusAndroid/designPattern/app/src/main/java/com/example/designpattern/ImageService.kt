package com.example.designpattern

import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ImageService {
    @Headers("Authorization: Client-ID "+BuildConfig.unsplashKey)
    @GET("photos/random")
    fun getRandomImage() : Call<ImageResponse>

    @Headers("Authorization: Client-ID "+BuildConfig.unsplashKey)
    @GET("photos/random")
    fun getRandomImageRx() : Single<ImageResponse>


}