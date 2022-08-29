package com.example.githubuser.domain.usecase

import com.example.githubuser.data.GithubUserData

interface GithubUserRepository {
    suspend fun getUserList(): List<GithubUserData>
}