package com.example.rxjavaclass.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.rxjavaclass.R
import com.example.rxjavaclass.db.Repo
import kotlinx.android.synthetic.main.star_item.view.*

class RepoAdapter: RecyclerView.Adapter<RepoAdapter.MyViewHolder>()
{
    val data=ArrayList<Repo>();

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MyViewHolder
    {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.star_item,parent,false)
        return MyViewHolder(view);
    }
    override fun getItemCount(): Int
    {
       return data.size
    }
    fun addRepos(repos:ArrayList<Repo>) {
        data.addAll(repos)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(p0: MyViewHolder, position: Int)
    {
       p0.repoName.text =  data[position].name;
        p0.repoLang.text =  data[position].lang;
       // p0.repoStarCount.text =  data[position].count.toString();
        data[position].desc?.let {
            p0.repoDesc.text =  data[position].desc
        }?:run {
            p0.repoDesc.text ="No Desc"

        }
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {

         val repoName = itemView.repoName
         val repoDesc = itemView.desc
         val repoLang = itemView.lang
       //  val repoStarCount = itemView.starCount
    }
}