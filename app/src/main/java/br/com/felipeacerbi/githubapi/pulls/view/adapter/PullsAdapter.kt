package br.com.felipeacerbi.githubapi.pulls.view.adapter

import android.arch.lifecycle.MutableLiveData
import android.view.ViewGroup
import br.com.felipeacerbi.githubapi.base.view.adapter.BaseListAdapter
import br.com.felipeacerbi.githubapi.base.view.adapter.BaseViewHolder
import br.com.felipeacerbi.githubapi.base.view.adapter.ItemView
import br.com.felipeacerbi.githubapi.pulls.viewmodel.PullsViewModel.Action
import javax.inject.Inject

class PullsAdapter @Inject constructor(
        private val actionLiveData: MutableLiveData<Action>) : BaseListAdapter() {

    override fun getLoadingResource(): Int {
        TODO("Return loading resource")
    }

    override fun getItemViewHolder(parent: ViewGroup): BaseViewHolder<ItemView> {
        TODO("Inflate pull resource")
//        PullsViewHolder(parent.inflate(), actionLiveData)
    }

    fun getAction() = actionLiveData

}