package br.com.felipeacerbi.githubapi.pulls.view.adapter

import android.arch.lifecycle.MutableLiveData
import android.view.View
import br.com.felipeacerbi.githubapi.R
import br.com.felipeacerbi.githubapi.base.view.adapter.BaseViewHolder
import br.com.felipeacerbi.githubapi.pulls.model.Pull
import br.com.felipeacerbi.githubapi.pulls.viewmodel.PullsViewModel.Action
import br.com.felipeacerbi.githubapi.utils.loadGlide
import kotlinx.android.synthetic.main.pull_list_item.view.*

class PullsViewHolder(itemView: View,
                      private val actionLiveData: MutableLiveData<Action>
) : BaseViewHolder<Pull>(itemView) {

    override fun bind(item: Pull) {
        container.setOnClickListener { actionLiveData.value = Action.ClickPull(item) }
        with(itemView) {
            tv_pull_name.text = item.title
            tv_pull_description.text = item.description
            tv_pull_username.text = item.authorUsername
            tv_created.text = item.date

            iv_user_icon.loadGlide(
                    item.authorPhoto ?: "",
                    R.drawable.ic_person_black_24dp,
                    R.drawable.ic_person_black_24dp)
        }
    }
}