package com.example.cookapp.domain.recipeItem

import androidx.lifecycle.LiveData
import com.example.cookapp.domain.shopItem.ShopItem

class GetRecipesUseCase(private val recipesRepository: RecipesRepository) {

    fun getRecipes(): LiveData<List<RecipeItem>> {
        return recipesRepository.getRecipes()
    }
}