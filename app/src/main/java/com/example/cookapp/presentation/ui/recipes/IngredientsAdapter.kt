package com.example.cookapp.presentation.ui.recipes

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.cookapp.R
import com.example.cookapp.domain.shopItem.ShopItem

class IngredientsAdapter:  ListAdapter<ShopItem, IngredientItemViewHolder>(IngredientItemDiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientItemViewHolder {
        val layout = R.layout.item_ingredient
        val view = LayoutInflater.from(parent.context).inflate(
            layout,
            parent,
            false
        )
        return IngredientItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: IngredientItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.tvName.text = item.name
        holder.tvCount.text = item.count.toString()
    }
}