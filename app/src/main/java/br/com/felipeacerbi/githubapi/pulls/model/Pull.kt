package br.com.felipeacerbi.githubapi.pulls.model

import br.com.felipeacerbi.githubapi.base.view.adapter.Constants
import br.com.felipeacerbi.githubapi.base.view.adapter.ItemView

data class Pull(
        val title: String,
        val description: String,
        val authorUsername: String,
        val authorPhoto: String,
        val date: String,
        override val type: Int = Constants.ITEM_VIEWTYPE
) : ItemView