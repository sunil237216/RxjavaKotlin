package com.example.rxjavaclass.repository

import com.example.rxjavaclass.db.Repo
import io.reactivex.Observable

class RepoRepository(val remoteRepoSource:RemoteSource,val localRepoSouce:LocalSource) : RepoDataSource
{
    override fun fetchRepos(username: String): Observable<List<Repo>> {
        return Observable.concat(localRepoSouce.fetchRepos(username),remoteRepoSource.fetchRepos(username).
            doOnNext { it -> saveData(it)
            }
            .onErrorResumeNext(Observable.empty()))
    }
    override fun saveData(repos: List<Repo>) {

        localRepoSouce.saveData(repos)

    }

}