package com.example.rxjavaclass

import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.rxjavaclass.adapter.RepoAdapter
import com.example.rxjavaclass.db.Repo
import com.example.rxjavaclass.viewmodel.RepoViewModel
import kotlinx.android.synthetic.main.activity_repo_starred.*

class RepoStarredActivity : AppCompatActivity() {

   // val repoList = ArrayList<Repo>()
    private  lateinit var repoManager:RepoAdapter
    private lateinit var  repoviewModel:RepoViewModel;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo_starred)

        val linearLayoutManager = LinearLayoutManager(applicationContext)
        val devider= DividerItemDecoration(
            this,
            DividerItemDecoration.VERTICAL
        )
        recyclerepo.layoutManager = linearLayoutManager
           repoManager = RepoAdapter()
        recyclerepo.addItemDecoration(devider)
        repoviewModel = ViewModelProviders.of(this).get(RepoViewModel::class.java)
        recyclerepo.adapter = repoManager
        getStarredRepo(repoviewModel)
    }

    fun getStarredRepo(repoviewModel:RepoViewModel)
    {
        repoviewModel.getStartsRepos("mrabelwahed")
        observMyStarred()
    }
    fun observMyStarred()
    {
        repoviewModel.getLiveData()
            .observe(this, Observer{ repos ->
                println(repos)
                repoManager.addRepos(ArrayList(repos))

        })
    }
}
