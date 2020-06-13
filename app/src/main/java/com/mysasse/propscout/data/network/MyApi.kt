package com.mysasse.propscout.data.network

import com.mysasse.propscout.data.BASE_URL
import com.mysasse.propscout.data.models.Property
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MyApi {

    @GET("properties")
    suspend fun getProperties(): Response<List<Property>>

    companion object {
        operator fun invoke(): MyApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                .create(MyApi::class.java)
        }
    }
}