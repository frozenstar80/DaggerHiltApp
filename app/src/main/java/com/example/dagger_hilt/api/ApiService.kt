package com.example.dagger_hilt.api

import com.example.dagger_hilt.models.NewsResponse
import com.example.dagger_hilt.utils.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    // interface class to call the breaking news end point .
    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country")
        countryCode: String = "in",
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey")
        apiKey: String = API_KEY
    ): NewsResponse
}