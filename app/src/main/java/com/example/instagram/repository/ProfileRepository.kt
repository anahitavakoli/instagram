package com.example.instagram.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.anahitavakoli.myapplication.api.ApiService
import com.anahitavakoli.myapplication.api.IService
import com.example.instagram.models.UserInfo
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.create

class ProfileRepository() {

    private var mutableProfile : MutableLiveData<UserInfo> = MutableLiveData<UserInfo>()

    companion object{
        val instance = ProfileRepository()
    }

//    val getUserInformation : MutableLiveData<UserInfo>?
//
//    get() {
//        val iService :IService = ApiService.retrofit.create(IService::class.java)
//
//        GlobalScope.launch {
//            val response = iService.getUserInfo(userId)
//            mutableProfile?.postValue(response.body())
//        }
//        return mutableProfile
//    }

    fun getUserInfo(userId: String) : MutableLiveData<UserInfo> {
        val iService :IService = ApiService.retrofit.create(IService::class.java)

        GlobalScope.launch {
            val response = iService.getUserInfo(userId)
            mutableProfile?.postValue(response.body())
        }
        return mutableProfile
    }

}