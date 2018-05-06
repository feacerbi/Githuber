package br.com.felipeacerbi.githubapi.repos.view.adapter

import android.arch.lifecycle.MutableLiveData
import android.view.View
import br.com.felipeacerbi.githubapi.base.view.adapter.BaseViewHolder
import br.com.felipeacerbi.githubapi.repos.model.Repo
import br.com.felipeacerbi.githubapi.repos.viewmodel.ReposViewModel.Action

class ReposViewHolder(itemView: View,
                      private val actionLiveData: MutableLiveData<Action>
) : BaseViewHolder<Repo>(itemView) {

    override fun bind(item: Repo) {
        container.setOnClickListener { actionLiveData.value = Action.ClickRepo(item) }
        TODO("Bind to layout")
    }
}