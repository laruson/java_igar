package com.example.data.repository

import android.util.Log
import com.example.data.db.dao.PostDao
import com.example.data.db.entity.transformToPost
import com.example.data.db.entity.transformToPostDb
import com.example.data.rest.service.Service
import com.example.domain.entity.Post
import com.example.domain.repository.PostRepository
import io.reactivex.Observable

class PostRepositoryImpl(private val service: Service, private val postDao: PostDao) : PostRepository {

    override fun getPost(): Observable<List<Post>> {
        return postDao.getPosts()
                .flatMap { postsDb ->
                    if (postsDb.isEmpty()) {
                        Log.e("AAA", "rest")
                        service.getPosts().flatMap { listRest ->
                            listRest.map { post ->
                                postDao.insertPost(post.transformToPostDb())
                            }
                            Observable.just(listRest)
                        }
                    } else {
                        Log.e("AAA", "db")
                        Observable.just(postsDb.map { it.transformToPost() })
                    }
                }

    }
}

