package com.example.cookapp.domain.recipeItem

import com.example.cookapp.domain.shopItem.ShopItem

class GetRecipeItemUseCase(private val recipesRepository: RecipesRepository) {

    fun getShopItem(id: Int): RecipeItem {
        return recipesRepository.getRecipeItem(id)
    }
}