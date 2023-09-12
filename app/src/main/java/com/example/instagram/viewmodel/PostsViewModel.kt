package com.example.instagram.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.anahitavakoli.myapplication.api.ApiService
import com.anahitavakoli.myapplication.api.IService
import com.example.instagram.models.PostModel
import com.example.instagram.repository.PostRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostsViewModel: ViewModel() {

    private lateinit var listPost: MutableLiveData<PostModel>

    fun getPosts(): MutableLiveData<PostModel>{
        listPost = MutableLiveData<PostModel>()
        loadPosts()
        return listPost
    }

    private fun loadPosts() {
        var iService : IService = ApiService.retrofit.create(IService::class.java)
        iService.getPosts().enqueue(object:Callback<PostModel>{
            override fun onResponse(call: Call<PostModel>, response: Response<PostModel>) {
                listPost.value = response.body()
            }

            override fun onFailure(call: Call<PostModel>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    private val postRepo: PostRepository = PostRepository.instance
    fun getUserPost(userId: String,from: Int, to: Int) : MutableLiveData<PostModel>{
        return postRepo.getUserPosts(userId,from,to)
    }
}