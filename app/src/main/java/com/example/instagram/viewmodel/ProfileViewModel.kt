package com.example.instagram.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.instagram.models.UserInfo
import com.example.instagram.repository.ProfileRepository

class ProfileViewModel(): ViewModel() {

    private val repository:ProfileRepository = ProfileRepository.instance
    fun userProfile(userId: String) : MutableLiveData<UserInfo> {
        return repository.getUserInfo(userId)
    }

}