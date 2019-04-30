package com.example.rxjavaclass.repository

import com.example.rxjavaclass.db.Repo
import com.example.rxjavaclass.network.GithubApiClient
import io.reactivex.Observable

class RemoteSource:RepoDataSource{
    override fun fetchRepos(username: String): Observable<List<Repo>> {

        return GithubApiClient.getgitHubService().getStarredRepo(username)
    }

    override fun saveData(repos: List<Repo>) {

    }


}