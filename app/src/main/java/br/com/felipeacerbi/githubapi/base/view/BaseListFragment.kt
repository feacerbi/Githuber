package br.com.felipeacerbi.githubapi.base.view

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.felipeacerbi.githubapi.R
import br.com.felipeacerbi.githubapi.base.view.adapter.BaseListAdapter
import br.com.felipeacerbi.githubapi.base.view.adapter.ItemView
import br.com.felipeacerbi.githubapi.utils.InfiniteScrollListener
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_item_list.*
import kotlinx.android.synthetic.main.fragment_item_list.view.*

abstract class BaseListFragment : DaggerFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)

        with(view) {
            rv_list.adapter = getAdapter()
            if(isInfinite()) rv_list.addOnScrollListener(InfiniteScrollListener(::request, rv_list.layoutManager))

            sr_refresh.setOnRefreshListener { showRefreshed() }
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sr_refresh.isRefreshing = true
        startObservers()
        request()
    }

    abstract fun getAdapter(): BaseListAdapter

    abstract fun startObservers()

    abstract fun request()

    abstract fun isInfinite(): Boolean

    private fun getErrorBar(view: View) =
            Snackbar.make(view, getString(R.string.error_loading_message), Snackbar.LENGTH_INDEFINITE)
                .setAction(getString(R.string.retry_snackbar_button), { request() })

    fun showLoading() {
        // Not needed
    }

    fun onItemsLoaded(items: List<ItemView>, infinite: Boolean) {
        val animate = getAdapter().isEmpty()

        getAdapter().addItems(items, infinite)

        if(animate) rv_list.scheduleLayoutAnimation()
    }

    fun showContent() {
        getErrorBar(rv_list).dismiss()
        sr_refresh.isRefreshing = false
    }

    fun showError() {
        getErrorBar(rv_list).show()
        sr_refresh.isRefreshing = false
    }

    open fun showRefreshed() {
        getAdapter().clearItems()
        request()
    }
}
