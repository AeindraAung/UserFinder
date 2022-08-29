package com.example.githubuser.data.mapper

import com.example.githubuser.data.GithubUserData
import com.example.githubuser.data.GithubUserResponse
import javax.inject.Inject

class GithubUserMapper @Inject constructor() {
    fun map(list: List<GithubUserResponse>): List<GithubUserData> {
        return list.map {
            GithubUserData(
                id = it.id ?: "",
                name = it.login ?: "",
                avatarUrl = it.avatarUrl ?: ""
            )
        }
    }
}