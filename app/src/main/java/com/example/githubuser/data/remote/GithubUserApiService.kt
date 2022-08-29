package com.example.githubuser.data.remote

import com.example.githubuser.data.GithubUserResponse
import retrofit2.http.GET

interface GithubUserApiService {

    @GET("users")
    suspend fun getUsers(): List<GithubUserResponse>
}