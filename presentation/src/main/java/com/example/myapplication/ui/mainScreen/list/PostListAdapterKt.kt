package com.example.myapplication.ui.mainScreen.list

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.entity.Post
import com.example.myapplication.R

class PostListAdapterKt : RecyclerView.Adapter<PostListViewHolderKt>() {
    val list = mutableListOf<Post>()
    private lateinit var onClick: () -> Unit

    fun addPosts(list: MutableList<Post>) {
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    fun setOnCLick (onClick: () -> Unit) {
        this.onClick = onClick
    }

    fun addPost(post: Post) {
        list.add(post)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostListViewHolderKt = PostListViewHolderKt(LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item, parent, false))

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PostListViewHolderKt, position: Int) {
        holder.bind(list[position])
        holder.itemView.setOnClickListener { onClick() }
    }

}