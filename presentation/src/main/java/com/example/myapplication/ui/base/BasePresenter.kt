package com.example.myapplication.ui.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BasePresenter {
    private val disposeList = CompositeDisposable()

    fun onStart() {
        //todo
    }

    fun onStop() {
        disposeList.clear()
    }

    fun addDisposable(disposable: Disposable) {
        disposeList.add(disposable)
    }
}