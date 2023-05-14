package com.example.mediasearchapp


import com.example.mediasearchapp.model.ImageListResponse
import com.example.mediasearchapp.model.VideoListResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface SearchService {

    @Headers("Authorization: KakaoAK ${BuildConfig.kakaoApi}")
    @GET("image")
    fun searchImage(@Query("query") query: String): Observable<ImageListResponse>

    @Headers("Authorization: KakaoAK ${BuildConfig.kakaoApi}")
    @GET("vclip")
    fun searchVideo(@Query("query") query: String): Observable<VideoListResponse>
}