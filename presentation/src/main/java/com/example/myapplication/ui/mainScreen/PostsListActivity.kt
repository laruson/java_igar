package com.example.myapplication.ui.mainScreen

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.entity.Post
import com.example.myapplication.R
import com.example.myapplication.ui.base.BaseActivity
import com.example.myapplication.ui.mainScreen.postList.PostListAdapter
import kotlinx.android.synthetic.main.activity_main.*

class PostsListActivity : BaseActivity<PostListPresenter>(), PostListContract.View {
    private val adapter = PostListAdapter()

    override fun initPresenter() {
        presenter = PostListPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = PostListPresenter(this)
        recycler.layoutManager = LinearLayoutManager(this)
        adapter.setOnCLick { Log.e("AAAA", "test") }
        recycler.adapter = adapter
        presenter.getPostsList()
    }

    override fun onGetPostsListSuccess(pair: Pair<Post, Long>) {
        adapter.addItem(pair.first)
    }

    override fun onGetPostsListError(error: Throwable) {
        Toast.makeText(this, error.message, Toast.LENGTH_LONG).show()
    }
}