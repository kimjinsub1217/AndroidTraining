package com.example.newsapp

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    //홈
    @GET("rss/30000001/")
    fun mainFeed(): Call<NewsRss>

    //정치
    @GET("rss/30200030/")
    fun politicsNews(): Call<NewsRss>

    //경제
    @GET("rss/30100041/")
    fun economyNews(): Call<NewsRss>

    //사회
    @GET("rss/50400012/")
    fun societyNews(): Call<NewsRss>

    //문화/연예
    @GET("rss/30000023/")
    fun cultureNews(): Call<NewsRss>

    //스포츠
    @GET("rss/71000001")
    fun sportNews(): Call<NewsRss>

    //검색
    @GET("rss/search?hl=ko&gl=KR&ceid=KR%3Ako")
    fun search(@Query("q") query: String): Call<NewsRss>


}