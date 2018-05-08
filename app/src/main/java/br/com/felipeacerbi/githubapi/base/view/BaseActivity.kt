package br.com.felipeacerbi.githubapi.base.view

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.widget.Toolbar
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResourceId)
        setSupportActionBar(getToolbarView())
    }

    @get:LayoutRes
    protected abstract val layoutResourceId: Int

    abstract fun getToolbarView(): Toolbar?
}