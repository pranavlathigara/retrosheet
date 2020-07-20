package com.theapache64.retrosheet.sample

import com.theapache64.retrosheet.RetrosheetInterceptor
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by theapache64 : Jul 21 Tue,2020 @ 02:11
 */
fun main() = runBlocking {


    val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(RetrosheetInterceptor())
        .build()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://docs.google.com/spreadsheets/d/1IcZTH6-g7cZeht_xr82SHJOuJXD_p55QueMrZcnsAvQ/")
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val nemoApi = retrofit.create(NemoApi::class.java)
    println("Got ${nemoApi.getProducts().products.size} products")

}