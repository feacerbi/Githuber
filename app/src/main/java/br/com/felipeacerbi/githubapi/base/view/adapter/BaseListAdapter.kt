package br.com.felipeacerbi.githubapi.base.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import br.com.felipeacerbi.githubapi.base.view.adapter.Constants.ITEM_VIEWTYPE
import br.com.felipeacerbi.githubapi.base.view.adapter.Constants.LOADING_VIEWTYPE
import br.com.felipeacerbi.githubapi.utils.inflate

abstract class BaseListAdapter : RecyclerView.Adapter<BaseViewHolder<ItemView>>() {

    private val itemsList: MutableList<ItemView> = mutableListOf()

    private val loadingItem = object : ItemView {
        override val type: Int
            get() = Constants.LOADING_VIEWTYPE
    }

    init {
        itemsList.add(loadingItem)
    }

    fun addItems(items: List<ItemView>) {
        val initPosition = getLastPosition()

        itemsList.removeAt(initPosition)
        notifyItemRemoved(initPosition)

        itemsList.addAll(items)
        itemsList.add(loadingItem)
        notifyItemRangeChanged(initPosition, itemsList.size + 1)
    }

    private fun getLastPosition() = if(itemsList.lastIndex == -1) 0 else itemsList.lastIndex

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<ItemView> =
            when(viewType) {
                LOADING_VIEWTYPE -> {
                    LoadingViewHolder(parent.inflate(getLoadingResource()))
                }
                ITEM_VIEWTYPE -> { getItemViewHolder(parent) }
                else -> throw RuntimeException()
            }

    override fun getItemCount() = itemsList.size

    override fun getItemViewType(position: Int) = itemsList[position].type

    override fun onBindViewHolder(holder: BaseViewHolder<ItemView>, position: Int) {
        holder.bind(itemsList[position])
    }

    abstract fun getLoadingResource(): Int

    abstract fun getItemViewHolder(parent: ViewGroup): BaseViewHolder<ItemView>
}