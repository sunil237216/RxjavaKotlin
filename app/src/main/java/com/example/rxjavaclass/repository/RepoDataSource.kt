package com.example.rxjavaclass.repository

import com.example.rxjavaclass.db.Repo
import io.reactivex.Observable

interface RepoDataSource {

    fun fetchRepos(username:String):Observable<List<Repo>>

    fun saveData(repos:List<Repo>)

}