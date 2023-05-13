package com.example.pagingtut.api

import com.example.pagingtut.models.CharacterResponse
import com.example.pagingtut.util.Constants
import com.example.pagingtut.util.Constants.Companion.BASE_URL
import dagger.Binds
import dagger.Provides
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface api_interface {
    @GET("character")
    suspend fun getAllCharacters(@Query("page") page: Int) : Response<CharacterResponse>
}