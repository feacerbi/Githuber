package br.com.felipeacerbi.githubapi.pulls.view.adapter

import android.arch.lifecycle.MutableLiveData
import android.view.View
import br.com.felipeacerbi.githubapi.base.view.adapter.BaseViewHolder
import br.com.felipeacerbi.githubapi.pulls.model.Pull
import br.com.felipeacerbi.githubapi.pulls.viewmodel.PullsViewModel.Action

class PullsViewHolder(itemView: View,
                      private val actionLiveData: MutableLiveData<Action>
) : BaseViewHolder<Pull>(itemView) {

    override fun bind(item: Pull) {
        container.setOnClickListener { actionLiveData.value = Action.ClickPull(item) }
        TODO("Bind to layout")
    }
}