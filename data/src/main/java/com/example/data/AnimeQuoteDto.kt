package com.example.data

import com.google.gson.annotations.SerializedName

data class AnimeQuoteDto(
    @SerializedName("quote")
    val quote: String
)