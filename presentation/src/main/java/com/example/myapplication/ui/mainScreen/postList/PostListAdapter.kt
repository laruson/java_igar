package com.example.myapplication.ui.mainScreen.postList

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.domain.entity.Post
import com.example.myapplication.R
import com.example.myapplication.ui.base.BaseListAdapter

class PostListAdapter : BaseListAdapter<PostListViewHolder, Post>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PostListViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item, parent, false))
}