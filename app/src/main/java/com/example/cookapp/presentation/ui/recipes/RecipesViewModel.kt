package com.example.cookapp.presentation.ui.recipes

import androidx.lifecycle.ViewModel
import com.example.cookapp.data.RecipesRepositoryImpl
import com.example.cookapp.domain.recipeItem.GetRecipeItemUseCase
import com.example.cookapp.domain.recipeItem.GetRecipesUseCase

class RecipesViewModel : ViewModel() {

    private val repository = RecipesRepositoryImpl

    private val getRecipesUseCase = GetRecipesUseCase(repository)
    private val getRecipeItemUseCase = GetRecipeItemUseCase(repository)

    val recipes = getRecipesUseCase.getRecipes()
}