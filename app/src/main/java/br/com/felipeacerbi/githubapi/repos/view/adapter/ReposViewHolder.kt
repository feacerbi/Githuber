package br.com.felipeacerbi.githubapi.repos.view.adapter

import android.arch.lifecycle.MutableLiveData
import android.view.View
import br.com.felipeacerbi.githubapi.R
import br.com.felipeacerbi.githubapi.base.view.adapter.BaseViewHolder
import br.com.felipeacerbi.githubapi.repos.model.Repo
import br.com.felipeacerbi.githubapi.repos.viewmodel.ReposViewModel.Action
import br.com.felipeacerbi.githubapi.utils.loadGlide
import kotlinx.android.synthetic.main.repo_list_item.view.*

class ReposViewHolder(itemView: View,
                      private val actionLiveData: MutableLiveData<Action>
) : BaseViewHolder<Repo>(itemView) {

    override fun bind(item: Repo) {
        container.setOnClickListener { actionLiveData.value = Action.ClickRepo(item) }
        with(itemView) {
            tv_repo_name.text = item.name
            tv_repo_description.text = item.description
            tv_repo_username.text = item.authorUsername
            tv_repo_stars.text = item.stars.toString()
            tv_repo_forks.text = item.forks.toString()

            iv_user_icon.loadGlide(
                    item.authorPhoto ?: "",
                    R.drawable.ic_person_black_24dp,
                    R.drawable.ic_person_black_24dp)
        }
    }
}