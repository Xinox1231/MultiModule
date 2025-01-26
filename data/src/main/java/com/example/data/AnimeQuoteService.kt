package com.example.data

import retrofit2.http.GET

interface AnimeQuoteService {

    @GET("api/random")
    suspend fun animeQuote(): AnimeQuoteDto
}