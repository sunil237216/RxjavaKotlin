package com.example.rxjavaclass.db
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Observable

@Dao
interface RepoDao {

    @Query("SELECT * FROM repo")
    fun fetchallStarredRepo():List<Repo>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllStarredRepo(repo:List<Repo>)

}