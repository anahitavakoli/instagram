package com.example.instagram.models

data class UserInfo(
    val bio: String,
    val email: String,
    val id: String,
    val image: String,
    val posts_count: Int,
    val username: String,
    val website: String
)