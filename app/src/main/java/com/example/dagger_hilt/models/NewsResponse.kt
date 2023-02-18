package com.example.dagger_hilt.models

// Base Model class to store the data
data class NewsResponse(
    val articles: MutableList<Article>,
    val status: String,
    val totalResults: Int
)