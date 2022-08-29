package com.example.githubuser.ui.main

import android.service.autofill.UserData
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubuser.data.GithubUserData
import com.example.githubuser.domain.usecase.GithubUserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: GithubUserRepository
) : ViewModel() {
    private val _userList = MutableLiveData<List<GithubUserData>>()
    val userList: LiveData<List<GithubUserData>> = _userList

    init {
        getUserList()
    }

    fun getUserList() {
        viewModelScope.launch {
            try {
                val list = repository.getUserList()
                _userList.value = list
            } catch (error: Throwable) {

            }
        }
    }
}