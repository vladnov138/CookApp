package com.example.cookapp.presentation.ui.shopList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.cookapp.R
import com.example.cookapp.domain.shopItem.ShopItem

class ShopListAdapter : ListAdapter<ShopItem, ShopItemViewHolder>(ShopItemDiffCallback()) {

    companion object {
        const val VIEW_TYPE_NOT_BOUGHT = 0
        const val VIEW_TYPE_BOUGHT = 1

        const val MAX_POOL_SIZE = 15
    }

    var onShopItemLongClickListener: ((ShopItem) -> Unit)? = null
    var onShopItemClickListener: ((ShopItem) -> Unit)? = null
    var onRadioButtonClickListener: ((ShopItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        val layout = when(viewType) {
            VIEW_TYPE_BOUGHT -> R.layout.item_shop_bought
            VIEW_TYPE_NOT_BOUGHT -> R.layout.item_shop
            else -> throw RuntimeException("Unknown view type: $viewType")
        }
        val view = LayoutInflater.from(parent.context).inflate(
            layout,
            parent,
            false
        )
        return ShopItemViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return if (item.isBought) {
            VIEW_TYPE_BOUGHT
        } else {
            VIEW_TYPE_NOT_BOUGHT
        }
    }
    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.tvName.text = item.name
        holder.tvNum.text = item.count.toString()
        holder.v.setOnLongClickListener {
            onShopItemLongClickListener?.invoke(item)
            true
        }
        holder.v.setOnClickListener {
            onShopItemClickListener?.invoke(item)
        }
        if (!item.isBought) {
            holder.bind(item, onRadioButtonClickListener)
        }
    }
}