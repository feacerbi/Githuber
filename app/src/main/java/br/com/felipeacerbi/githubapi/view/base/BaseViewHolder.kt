package br.com.felipeacerbi.githubapi.view.base

import android.content.Context
import android.content.res.Resources
import android.support.v7.widget.RecyclerView
import android.view.View

abstract class BaseViewHolder<T>(view: View) : RecyclerView.ViewHolder(view) {

    val container: View = itemView
    val context: Context = itemView.context
    val resources: Resources = itemView.resources

    abstract fun bind(item: T)

}