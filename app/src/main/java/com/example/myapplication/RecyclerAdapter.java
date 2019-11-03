package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private List<User> list = new ArrayList<>();

    public void addUsers(List<User> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void addUser(User user) {
        list.add(user);
        notifyItemChanged(list.size()-1);
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView ageView;
        private TextView nameView;
        private ImageView photoView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ageView = itemView.findViewById(R.id.age);
            nameView = itemView.findViewById(R.id.name);
            photoView = itemView.findViewById(R.id.photo);
        }

        public void bind(User user) {
            Glide.with(itemView).asBitmap().load(user.getPhoto()).into(photoView);
            ageView.setText(user.getAge()+"");
            nameView.setText(user.getName());
        }
    }
}
