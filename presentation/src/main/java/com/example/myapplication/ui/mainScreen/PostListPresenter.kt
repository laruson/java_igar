package com.example.myapplication.ui.mainScreen

import com.example.data.repository.PostRepositoryImpl
import com.example.data.rest.service.Service
import com.example.domain.repository.PostRepository
import com.example.myapplication.ui.base.BasePresenter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.zipWith
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class PostListPresenter(private val activity: PostsListActivity) : BasePresenter(), PostListContract.Presenter {
    private val postRepository: PostRepository

    init {
        postRepository = PostRepositoryImpl(Service())
    }

    override fun getPostsList() {
        addDisposable(postRepository.post
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
                        {
                            activity.onGetPostsListSuccess(it)
                        },
                        {
                            activity.onGetPostsListError(it)
                        }
                ))
    }
}