package com.example.rxjavaclass.network

import com.example.rxjavaclass.db.Repo
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {

    @GET("users/{user}/starred")
    fun getStarredRepo(@Path("user") username:String) : Observable<List<Repo>>

}