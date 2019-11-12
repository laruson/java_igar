package com.example.myapplication.ui.mainScreen

import com.example.domain.entity.Post

interface PostListContract {
    interface Presenter {
        fun getPostsList()
    }

    interface View {
        fun onGetPostsListSuccess(pair: Pair<Post, Long>)

        fun onGetPostsListError(error: Throwable)
    }
}