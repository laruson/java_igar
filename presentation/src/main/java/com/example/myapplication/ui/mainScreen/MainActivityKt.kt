package com.example.myapplication.ui.mainScreen

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.data.repository.PostRepositoryImpl
import com.example.data.rest.service.Service
import com.example.domain.repository.PostRepository
import com.example.myapplication.R
import com.example.myapplication.ui.mainScreen.list.PostListAdapterKt
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.zipWith
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivityKt : AppCompatActivity() {
    private val TAG = "MainActivity"
    private var service: Service? = null
    private var postRepository: PostRepository? = null
    private val disposeList = CompositeDisposable()

    init {
        service = Service()
        postRepository = PostRepositoryImpl(service)
    }

    override fun onPause() {
        super.onPause()
        disposeList.clear()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler.layoutManager = LinearLayoutManager(this)
        val adapter = PostListAdapterKt()
        adapter.setOnCLick { Log.e("AAAA", "test") }
        recycler.adapter = adapter
        postRepository?.let { postRepository ->
            disposeList.add(
                    postRepository.post
                            .subscribeOn(Schedulers.io())
                            //Observable<List<Post>>
                            .flatMap {
                                Observable
                                        .fromIterable(it)
                                        //Post
                                        .zipWith(Observable.interval(0, 1, TimeUnit.SECONDS))
                            }
                            //Observable<Pair<Post, Long>>
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(
                                    //onNext
                                    { pair ->
                                        adapter.addPost(pair.first)
                                    },
                                    { throwable ->
                                        Log.e(TAG, throwable.message)
                                    }
                            )
            )
        }
    }
}