package com.example.pagingtut.api

import com.example.pagingtut.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class Api_Instance {
    companion object{
        @Provides
        @Singleton
        fun clinten() : OkHttpClient {
            val logging = HttpLoggingInterceptor()
            logging.setLevel(HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder().addInterceptor(logging).build()
            return client
        }

        @Provides
        @Singleton
        fun service() : api_interface {
            return  Retrofit.Builder()
                   .baseUrl(Constants.BASE_URL)
                   .addConverterFactory(GsonConverterFactory.create())
                   .client(clinten())
                   .build()
                   .create(api_interface::class.java)
        }
    }
}