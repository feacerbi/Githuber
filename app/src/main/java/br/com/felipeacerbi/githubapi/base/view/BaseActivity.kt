package br.com.felipeacerbi.githubapi.base.view

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v7.widget.Toolbar
import br.com.felipeacerbi.githubapi.R
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResourceId)
        setSupportActionBar(getToolbarView())
    }

    fun addFragment(fragment: Fragment) {
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fl_container, fragment)
                    .commitAllowingStateLoss()
    }

    @get:LayoutRes
    protected abstract val layoutResourceId: Int

    abstract fun getToolbarView(): Toolbar?
}