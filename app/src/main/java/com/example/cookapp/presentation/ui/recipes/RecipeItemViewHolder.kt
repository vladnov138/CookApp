package com.example.cookapp.presentation.ui.recipes

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cookapp.R

class RecipeItemViewHolder(val v: View): RecyclerView.ViewHolder(v) {
    val tvName = v.findViewById<TextView>(R.id.tv_name)
    val rvIngredients = v.findViewById<RecyclerView>(R.id.rv_ingredients)
}