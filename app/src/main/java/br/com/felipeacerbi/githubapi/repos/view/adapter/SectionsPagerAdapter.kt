package br.com.felipeacerbi.githubapi.repos.view.adapter

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import br.com.felipeacerbi.githubapi.repos.view.ReposListFragment

class SectionsPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int) = ReposListFragment.newInstance(tabs[position].language)

    override fun getPageTitle(position: Int) = tabs[position].title

    override fun getCount() = tabs.size

    companion object {
        data class TabItem(val title: String, val language: String)

        val tabs = listOf(
                TabItem("JAVA", "language:Java"),
                TabItem("JAVASCRIPT", "language:JavaScript"),
                TabItem("NODE.JS", "Node.js")
        )
    }
}