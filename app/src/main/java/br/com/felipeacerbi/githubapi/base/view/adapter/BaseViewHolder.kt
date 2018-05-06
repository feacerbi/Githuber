package br.com.felipeacerbi.githubapi.base.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.View

abstract class BaseViewHolder<T>(view: View ) : RecyclerView.ViewHolder(view) {

    val container: View = itemView

    abstract fun bind(item: T)

}