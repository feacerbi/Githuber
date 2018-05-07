package br.com.felipeacerbi.githubapi.repos.view

import android.os.Bundle
import android.support.v7.widget.Toolbar
import br.com.felipeacerbi.githubapi.R
import br.com.felipeacerbi.githubapi.base.view.BaseActivity
import br.com.felipeacerbi.githubapi.repos.view.adapter.SectionsPagerAdapter
import kotlinx.android.synthetic.main.activity_repos.*

class ReposActivity(override val layoutResourceId: Int = R.layout.activity_repos) : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vp_container.adapter = SectionsPagerAdapter(supportFragmentManager)
        vp_container.offscreenPageLimit = 2
        tl_tabs.setupWithViewPager(vp_container)
    }

    override fun getToolbarView(): Toolbar?  = toolbar
}
