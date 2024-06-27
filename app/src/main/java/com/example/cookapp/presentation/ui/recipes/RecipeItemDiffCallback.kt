package com.example.cookapp.presentation.ui.recipes

import androidx.recyclerview.widget.DiffUtil
import com.example.cookapp.domain.recipeItem.RecipeItem
import com.example.cookapp.domain.shopItem.ShopItem

class RecipeItemDiffCallback: DiffUtil.ItemCallback<RecipeItem>() {

    override fun areItemsTheSame(oldItem: RecipeItem, newItem: RecipeItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: RecipeItem, newItem: RecipeItem): Boolean {
        return oldItem == newItem
    }
}