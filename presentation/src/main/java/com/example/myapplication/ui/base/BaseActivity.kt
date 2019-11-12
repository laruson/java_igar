package com.example.myapplication.ui.base

import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<Presenter : BasePresenter> : AppCompatActivity() {
    protected lateinit var presenter: Presenter

    abstract fun initPresenter()

    override fun onStop() {
        super.onStop()
        presenter.onStop()
    }

    override fun onStart() {
        super.onStart()
        presenter.onStart()
    }
}