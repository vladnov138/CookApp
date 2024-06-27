package com.example.cookapp.data

import com.example.cookapp.domain.recipeItem.RecipeItem
import retrofit2.Call
import retrofit2.http.GET

interface RecipeApiService {
    @GET("recipes")
    fun getRecipes(): Call<List<RecipeItem>>
}