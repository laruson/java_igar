package com.example.myapplication.ui.mainScreen.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.domain.entity.Post;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class PostListAdapter extends RecyclerView.Adapter<PostListViewHolder> {
    private List<Post> list = new ArrayList<>();

    public void addPosts(List<Post> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void addPost(Post post) {
        list.add(post);
        notifyItemChanged(list.size() - 1);
    }


    @NonNull
    @Override
    public PostListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false);
        return new PostListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostListViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
