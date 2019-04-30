package com.example.rxjavaclass.repository
import com.example.rxjavaclass.RxApp
import com.example.rxjavaclass.db.AppDatabase
import com.example.rxjavaclass.db.Repo
import io.reactivex.Observable

class LocalSource:RepoDataSource{

    override fun fetchRepos(username: String): Observable<List<Repo>> {
        return Observable.fromCallable {
            AppDatabase.getInstance(RxApp.INSTANCE)?.getRepoDao()!!.fetchallStarredRepo()
        }
    }

    override fun saveData(repos: List<Repo>) {
    AppDatabase.getInstance(RxApp.INSTANCE)?.getRepoDao()!!.saveAllStarredRepo(repos)
    }
}