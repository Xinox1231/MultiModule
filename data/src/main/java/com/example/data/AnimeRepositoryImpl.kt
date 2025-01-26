package com.example.data

import com.example.domain.AnimeRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AnimeRepositoryImpl(
    private val service: AnimeQuoteService
) : AnimeRepository {

    constructor() : this(
        Retrofit.Builder()
            .baseUrl("//https://animechan.xyz/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AnimeQuoteService::class.java)
    )

    override suspend fun loadQuote(): Pair<Boolean, String> {
        try {
            val quote = service.animeQuote().quote
            return Pair(true, quote)
        } catch (e: Exception) {
            return Pair(false, e.message ?: "error")
        }
    }
}