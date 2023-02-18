package com.example.dagger_hilt.repository

import com.example.dagger_hilt.api.ApiService
import com.example.dagger_hilt.models.NewsResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PostRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getPosts():Flow<NewsResponse> = flow {
        val response = apiService.getBreakingNews()
        emit(response)
    }.flowOn(Dispatchers.IO)

}