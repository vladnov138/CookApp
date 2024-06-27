package com.example.cookapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cookapp.domain.recipeItem.RecipeItem
import com.example.cookapp.domain.recipeItem.RecipesRepository
import com.example.cookapp.domain.shopItem.ShopItem

object RecipesRepositoryImpl: RecipesRepository {

    private val recipes = mutableListOf<RecipeItem>()
    private val recipesLD = MutableLiveData<List<RecipeItem>>()

    private var autoIncrementId = 0

    init {
        for (i in 0 until 1000) {
            val item = RecipeItem("Name $i", listOf(ShopItem(
                "Product $i",
                1.0,
                "kg",
                id = i
            )))
            recipes.add(item)
        }
        updateList()
    }

    override fun getRecipeItem(id: Int): RecipeItem {
        return recipes.find {
            elem -> elem.id == id
        } ?: throw RuntimeException("Element with id $id not found")
    }

    override fun getRecipes(): LiveData<List<RecipeItem>> {
        return recipesLD
    }

    private fun updateList() {
        recipesLD.value = recipes.toList()
    }
}