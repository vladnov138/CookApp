package com.example.cookapp.domain.recipeItem

import com.example.cookapp.domain.shopItem.ShopItem

data class RecipeItem(
    val name: String,
    val ingredients: List<ShopItem>,
    val id: Int = DEFAULT_VALUE
) {
    companion object {
        const val DEFAULT_VALUE = -1
    }
}