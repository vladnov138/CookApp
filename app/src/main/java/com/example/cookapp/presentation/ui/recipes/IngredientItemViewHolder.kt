package com.example.cookapp.presentation.ui.recipes

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cookapp.R

class IngredientItemViewHolder(val v: View): RecyclerView.ViewHolder(v) {
    val tvName = v.findViewById<TextView>(R.id.name)
    val tvCount = v.findViewById<TextView>(R.id.count)
}