package com.example.cookapp.presentation

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cookapp.R

class ShopItemViewHolder(val v: View) : RecyclerView.ViewHolder(v) {
    val tvName = v.findViewById<TextView>(R.id.name)
    val tvNum = v.findViewById<TextView>(R.id.num)
}