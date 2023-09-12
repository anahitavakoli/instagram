package com.example.instagram.models

data class Post(
    val comments: String,
    val description: String,
    val id: Int,
    val imageProfile: String,
    val images: List<Image>,
    val likes: Int,
    val userId: Int,
    val username: String
)