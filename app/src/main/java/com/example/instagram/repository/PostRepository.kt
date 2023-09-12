package com.example.instagram.repository

import androidx.lifecycle.MutableLiveData
import com.anahitavakoli.myapplication.api.ApiService
import com.anahitavakoli.myapplication.api.IService
import com.example.instagram.models.PostModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PostRepository {

    private var mutableLiveData : MutableLiveData<PostModel> = MutableLiveData<PostModel>()

    companion object{
        val instance = PostRepository()
    }

    fun getUserPosts(userId: String,from: Int, to: Int) : MutableLiveData<PostModel>{

        val iService: IService = ApiService.retrofit.create(IService::class.java)

        GlobalScope.launch {
            val response = iService.getUserPosts(userId,from,to)
            mutableLiveData?.postValue(response.body())
        }

        return mutableLiveData
    }
}