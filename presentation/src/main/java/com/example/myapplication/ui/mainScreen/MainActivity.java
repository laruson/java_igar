package com.example.myapplication.ui.mainScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.data.repository.PostRepositoryImpl;
import com.example.data.rest.service.Service;
import com.example.domain.entity.Post;
import com.example.domain.repository.PostRepository;
import com.example.myapplication.R;
import com.example.myapplication.ui.mainScreen.list.PostListAdapter;

import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private String TAG = "MainActivity";
    private Service service;
    private PostRepository postRepository;

    private void initRepo() {
        service = new Service();
        postRepository = new PostRepositoryImpl(service);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRepo();
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final PostListAdapter adapter = new PostListAdapter();
        Disposable disposable = postRepository.getPost()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        new Consumer<List<Post>>() {
                            @Override
                            public void accept(List<Post> posts) throws Exception {
                                adapter.addPosts(posts);
                            }
                        },
                        new Consumer<Throwable>() {
                            @Override
                            public void accept(Throwable throwable) throws Exception {
                                Log.e(TAG, throwable.getMessage());
                            }
                        }
                );

        recyclerView.setAdapter(adapter);
//        FragmentManager manager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = manager.beginTransaction();
//        fragmentTransaction.add(R.id.content1, TestScreenFragment.newInstance());
//        fragmentTransaction.add(R.id.content2, TestScreenFragment2.newInstance());
//        fragmentTransaction.commit();
    }
}
