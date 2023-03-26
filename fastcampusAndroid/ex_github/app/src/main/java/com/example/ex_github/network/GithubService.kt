package com.example.ex_github.network

import com.example.ex_github.model.Repo
import com.example.ex_github.model.UserDto
import retrofit2.Call
import retrofit2.http.*

interface GithubService {

    @GET("/users/{username}/repos")
    fun listRepos(@Path("username") username: String, @Query("page") page: Int): Call<List<Repo>>


    @GET("/search/users")
    fun searchUsers(@Query("q") query: String) : Call<UserDto>
}