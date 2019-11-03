package com.example.myapplication.ui.mainScreen.list;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.domain.entity.Post;
import com.example.myapplication.R;

public class PostListViewHolder extends RecyclerView.ViewHolder {
    private TextView ageView;
    private TextView nameView;
    private ImageView photoView;

    public PostListViewHolder(@NonNull View itemView) {
        super(itemView);
        ageView = itemView.findViewById(R.id.age);
        nameView = itemView.findViewById(R.id.name);
        photoView = itemView.findViewById(R.id.photo);
    }

    public void bind(Post post) {
        Glide.with(itemView).asBitmap().load("https://media.tvzvezda.ru/news/vstrane_i_mire/content/201808261603-xg2y.htm/1.jpg").into(photoView);
        ageView.setText(post.getBody());
        nameView.setText(post.getTitle());
    }
}
