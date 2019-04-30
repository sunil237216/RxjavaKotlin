package com.example.rxjavaclass.network

import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object GithubApiClient {

    val BASE_URL="https://api.github.com"
    val gitHubService:GitHubService;

    init
    {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val okhttpClient =  OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .readTimeout(6000,TimeUnit.SECONDS)
            .connectTimeout(6000,TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .client(okhttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        gitHubService = retrofit.create(GitHubService::class.java)
    }

    fun getgitHubService():GitHubService = gitHubService
}