package com.example.cookapp.domain.recipeItem

import androidx.lifecycle.LiveData
import com.example.cookapp.domain.shopItem.ShopItem

interface RecipesRepository {

    fun getRecipeItem(id: Int): RecipeItem

    fun getRecipes(): LiveData<List<RecipeItem>>
}