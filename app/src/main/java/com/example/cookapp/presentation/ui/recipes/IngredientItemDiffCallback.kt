package com.example.cookapp.presentation.ui.recipes

import androidx.recyclerview.widget.DiffUtil
import com.example.cookapp.domain.shopItem.ShopItem

class IngredientItemDiffCallback: DiffUtil.ItemCallback<ShopItem>() {

    override fun areItemsTheSame(oldItem: ShopItem, newItem: ShopItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ShopItem, newItem: ShopItem): Boolean {
        return oldItem == newItem
    }
}