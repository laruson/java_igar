package com.example.myapplication.ui.mainScreen.postList

import android.view.View
import com.bumptech.glide.Glide
import com.example.domain.entity.Post
import com.example.myapplication.ui.base.BaseViewHolder
import kotlinx.android.synthetic.main.recycler_item.view.*

class PostListViewHolder(itemView: View) : BaseViewHolder<Post>(itemView) {

    override fun bind(item: Post) {
        Glide.with(itemView).asBitmap().load("https://media.tvzvezda.ru/news/vstrane_i_mire/content/201808261603-xg2y.htm/1.jpg").into(itemView.photo)
        itemView.name.text = item.body
        itemView.age.text = item.title
    }
}