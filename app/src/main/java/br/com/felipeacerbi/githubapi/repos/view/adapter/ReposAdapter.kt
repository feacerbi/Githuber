package br.com.felipeacerbi.githubapi.repos.view.adapter

import android.arch.lifecycle.MutableLiveData
import android.view.ViewGroup
import br.com.felipeacerbi.githubapi.R
import br.com.felipeacerbi.githubapi.base.view.adapter.BaseListAdapter
import br.com.felipeacerbi.githubapi.base.view.adapter.BaseViewHolder
import br.com.felipeacerbi.githubapi.base.view.adapter.ItemView
import br.com.felipeacerbi.githubapi.repos.viewmodel.ReposViewModel.Action
import br.com.felipeacerbi.githubapi.utils.inflate
import javax.inject.Inject

class ReposAdapter @Inject constructor(
        private val actionLiveData: MutableLiveData<Action>) : BaseListAdapter() {

    override fun getItemViewHolder(parent: ViewGroup): BaseViewHolder<ItemView> {
        return ReposViewHolder(parent.inflate(R.layout.repo_list_item), actionLiveData) as BaseViewHolder<ItemView>
    }

    override fun getLoadingResource(): Int  = R.layout.loading_list_item

    fun getAction() = actionLiveData
}