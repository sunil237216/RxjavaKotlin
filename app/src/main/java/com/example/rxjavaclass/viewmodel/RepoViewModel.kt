package com.example.rxjavaclass.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rxjavaclass.db.Repo
import com.example.rxjavaclass.network.GithubApiClient
import com.example.rxjavaclass.repository.LocalSource
import com.example.rxjavaclass.repository.RemoteSource
import com.example.rxjavaclass.repository.RepoRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class RepoViewModel: ViewModel() {

    val RepoLiveData=MutableLiveData<List<Repo>>()
    val compositeDisposable = CompositeDisposable()
    val repository = RepoRepository(RemoteSource(), LocalSource())

    fun getStartsRepos(username:String){

        val cdisposable = repository.fetchRepos(username)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).
                subscribe {
                         RepoLiveData.value = it

                }
        compositeDisposable.add(cdisposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    fun getLiveData():LiveData<List<Repo>>
    {
        println("list is2 "+RepoLiveData)
        return RepoLiveData
    }
}