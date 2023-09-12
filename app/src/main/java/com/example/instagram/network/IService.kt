package com.anahitavakoli.myapplication.api

import com.example.instagram.models.LoginModel
import com.example.instagram.models.PostModel
import com.example.instagram.models.UserInfo
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface IService {

    @POST("login.php")
    @FormUrlEncoded
    fun login(@Field("username") user: String, @Field("password") pass: String) : Call<LoginModel>

    @POST("login.php")
    @FormUrlEncoded
    suspend fun loginUser(@Field("username") user: String, @Field("password") pass: String) : Response<LoginModel>

    @GET("posts.php")
    fun getPosts(): Call<PostModel>

    @POST("user_information.php")
    @FormUrlEncoded
    suspend fun getUserInfo(@Field("id") id: String) : Response<UserInfo>

    @POST("myPosts.php")
    @FormUrlEncoded
    suspend fun getUserPosts(@Field("id") id: String,@Field("from") from: Int,@Field("to") to: Int): Response<PostModel>

}