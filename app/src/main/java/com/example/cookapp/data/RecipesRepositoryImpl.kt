package com.example.cookapp.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cookapp.domain.recipeItem.RecipeItem
import com.example.cookapp.domain.recipeItem.RecipesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory

object RecipesRepositoryImpl : RecipesRepository {

    private val recipes = mutableListOf<RecipeItem>()
    private val recipesLD = MutableLiveData<List<RecipeItem>>()

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.0.13:8000/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val recipeApiService = retrofit.create(RecipeApiService::class.java)

    override fun getRecipeItem(id: Int): RecipeItem {
        return recipes.find { it.id == id }
            ?: throw RuntimeException("Element with id $id not found")
    }

    override fun getRecipes(): LiveData<List<RecipeItem>> {
        Log.d("test", "here")
        fetchRecipesFromApi()
        return recipesLD
    }

    private fun updateList() {
        recipesLD.value = recipes.toList()
    }

    private fun fetchRecipesFromApi() {
        kotlinx.coroutines.GlobalScope.launch(Dispatchers.IO) {
            try {
                val response = recipeApiService.getRecipes().awaitResponse()
                Log.d("test", response.toString())
                if (response.isSuccessful) {
                    response.body()?.let {
                        recipes.clear()
                        recipes.addAll(it)
                        withContext(Dispatchers.Main) {
                            updateList()
                        }
                    }
                } else {

                }
            } catch (e: Exception) {
                Log.e("test", e.message.toString())
            }
        }
    }

//    override suspend fun getRecipeItemFromApi(id: Int): RecipeItem {
//        return withContext(Dispatchers.IO) {
//            val response = recipeApiService.getRecipeItem(id).awaitResponse()
//            if (response.isSuccessful) {
//                response.body() ?: throw RuntimeException("Element with id $id not found")
//            } else {
//                throw RuntimeException("Element with id $id not found")
//            }
//        }
//    }
}