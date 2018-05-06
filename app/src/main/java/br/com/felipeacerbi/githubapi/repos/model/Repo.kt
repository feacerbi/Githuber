package br.com.felipeacerbi.githubapi.repos.model

import br.com.felipeacerbi.githubapi.base.view.adapter.Constants
import br.com.felipeacerbi.githubapi.base.view.adapter.ItemView
import org.parceler.Parcel

@Parcel
data class Repo(
        val name: String = "",
        val description: String = "",
        val authorUsername: String = "",
        val authorPhoto: String = "",
        val stars: Int = 0,
        val forks: Int = 0,
        override val type: Int = Constants.ITEM_VIEWTYPE
) : ItemView