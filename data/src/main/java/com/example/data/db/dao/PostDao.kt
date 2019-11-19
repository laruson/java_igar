package com.example.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.data.db.entity.PostDb
import io.reactivex.Observable

@Dao
interface PostDao {
    @Insert
    fun insertPost(post: PostDb)

    @Insert
    fun insertPosts(posts: List<PostDb>)

    @Query("SELECT * FROM posts  WHERE userId=:id")
    fun getPost(id: Int): Observable<PostDb>

    @Query("SELECT * FROM posts")
    fun getPosts(): Observable<List<PostDb>>
}