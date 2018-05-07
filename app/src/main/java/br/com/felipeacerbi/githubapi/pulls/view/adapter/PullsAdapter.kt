package br.com.felipeacerbi.githubapi.pulls.view.adapter

import android.arch.lifecycle.MutableLiveData
import android.view.ViewGroup
import br.com.felipeacerbi.githubapi.R
import br.com.felipeacerbi.githubapi.base.view.adapter.BaseListAdapter
import br.com.felipeacerbi.githubapi.base.view.adapter.BaseViewHolder
import br.com.felipeacerbi.githubapi.base.view.adapter.ItemView
import br.com.felipeacerbi.githubapi.pulls.viewmodel.PullsViewModel.Action
import br.com.felipeacerbi.githubapi.utils.inflate
import javax.inject.Inject

class PullsAdapter @Inject constructor(
        private val actionLiveData: MutableLiveData<Action>) : BaseListAdapter() {

    override fun getItemViewHolder(parent: ViewGroup): BaseViewHolder<ItemView> {
        return PullsViewHolder(parent.inflate(R.layout.pull_list_item), actionLiveData) as BaseViewHolder<ItemView>
    }

    override fun getLoadingResource(): Int  = R.layout.loading_list_item

    fun getAction() = actionLiveData

}