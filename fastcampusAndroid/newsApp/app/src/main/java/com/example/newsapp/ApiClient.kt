package com.example.newsapp

import com.tickaroo.tikxml.TikXml
import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory
import retrofit2.Retrofit

object ApiClient {
    private const val MK_NEWS_BASE_URL="https://www.mk.co.kr/"
    private const val GOOGLE_NEWS_BASE_URL="https://news.google.com/"

    val retrofit_mk = retrofit(MK_NEWS_BASE_URL)
    val retrofit_google =retrofit(GOOGLE_NEWS_BASE_URL)

    private fun retrofit(BASE_URL:String): Retrofit {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                TikXmlConverterFactory.create(
                    TikXml.Builder()
                        .exceptionOnUnreadXml(false) // XML 전부 파싱하지 않고 필요한 부분만 맵핑하기 위해서 false
                        .build()
                )
            ).build()
        return retrofit

    }
}