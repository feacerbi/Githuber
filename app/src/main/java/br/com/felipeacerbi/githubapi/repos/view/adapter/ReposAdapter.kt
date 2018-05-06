package br.com.felipeacerbi.githubapi.repos.view.adapter

import android.arch.lifecycle.MutableLiveData
import android.view.ViewGroup
import br.com.felipeacerbi.githubapi.base.view.adapter.BaseListAdapter
import br.com.felipeacerbi.githubapi.base.view.adapter.BaseViewHolder
import br.com.felipeacerbi.githubapi.base.view.adapter.ItemView
import br.com.felipeacerbi.githubapi.repos.viewmodel.ReposViewModel.Action
import javax.inject.Inject

class ReposAdapter @Inject constructor(
        private val actionLiveData: MutableLiveData<Action>) : BaseListAdapter() {

    override fun getLoadingResource(): Int {
        TODO("Return loading resource")
    }

    override fun getItemViewHolder(parent: ViewGroup): BaseViewHolder<ItemView> {
        TODO("Inflate repo resource")
//        ReposViewHolder(parent.inflate(), actionLiveData)
    }

    fun getAction() = actionLiveData
}