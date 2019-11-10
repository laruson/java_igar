package com.example.myapplication.ui.mainScreen.list

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.entity.Post
import kotlinx.android.synthetic.main.recycler_item.view.*

class PostListViewHolderKt(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(post: Post) {
        Glide.with(itemView).asBitmap().load("https://media.tvzvezda.ru/news/vstrane_i_mire/content/201808261603-xg2y.htm/1.jpg").into(itemView.photo)
        itemView.name.text = post.body
        itemView.age.text = post.title
    }
}