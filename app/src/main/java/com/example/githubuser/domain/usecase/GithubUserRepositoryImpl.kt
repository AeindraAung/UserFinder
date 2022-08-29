package com.example.githubuser.domain.usecase

import com.example.githubuser.data.GithubUserData
import com.example.githubuser.data.mapper.GithubUserMapper
import com.example.githubuser.data.remote.GithubUserApiService
import javax.inject.Inject

class GithubUserRepositoryImpl @Inject constructor(
    private val service: GithubUserApiService,
    private val mapper: GithubUserMapper
) : GithubUserRepository {
    override suspend fun getUserList(): List<GithubUserData> {
        val datas = service.getUsers()
        return mapper.map(datas)
    }
}
