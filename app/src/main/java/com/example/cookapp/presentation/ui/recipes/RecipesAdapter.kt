package com.example.cookapp.presentation.ui.recipes

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.cookapp.R
import com.example.cookapp.domain.recipeItem.RecipeItem

class RecipesAdapter(var ingredientsAdapter: IngredientsAdapter) :  ListAdapter<RecipeItem, RecipeItemViewHolder>(RecipeItemDiffCallback()){

    var onShopItemClickListener: ((RecipeItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeItemViewHolder {
        val layout = R.layout.recipe_item
        val view = LayoutInflater.from(parent.context).inflate(
            layout,
            parent,
            false
        )
        val holder = RecipeItemViewHolder(view)
        holder.rvIngredients.adapter = ingredientsAdapter
        return holder
    }

    override fun onBindViewHolder(holder: RecipeItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.tvName.text = item.name
        ingredientsAdapter.submitList(item.ingredients)
        Log.d("test", ingredientsAdapter.toString())
        holder.v.setOnClickListener {
            onShopItemClickListener?.invoke(item)
        }
    }
}