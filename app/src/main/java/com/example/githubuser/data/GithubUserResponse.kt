package com.example.githubuser.data

import com.google.gson.annotations.SerializedName

data class GithubUserResponse(
    @SerializedName("id")
    val id: String?,

    @SerializedName("login")
    val login: String?,

    @SerializedName("node_id")
    val nodeId: String?,

    @SerializedName("avatar_url")
    val avatarUrl: String?,

    @SerializedName("url")
    val url: String?,

    @SerializedName("followers_url")
    val followersUrl: String?,

    @SerializedName("following_url")
    val followingUrl: String?,

    @SerializedName("gists_url")
    val gistsUrl: String?,

    @SerializedName("starred_url")
    val starredUrl: String?,

    @SerializedName("subscriptions_url")
    val subscriptionsUrl: String?,

    @SerializedName("organizations_url")
    val organizationsUrl: String?,

    @SerializedName("repos_url")
    val reposUrl: String?,

    @SerializedName("events_url")
    val eventsUrl: String?,

    @SerializedName("received_events_url")
    val receivedEventsUrl: String?,

    @SerializedName("type")
    val type: String?
)