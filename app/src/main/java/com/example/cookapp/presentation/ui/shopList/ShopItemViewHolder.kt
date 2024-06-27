package com.example.cookapp.presentation.ui.shopList

import android.util.Log
import android.view.View
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cookapp.R
import com.example.cookapp.domain.shopItem.ShopItem

class ShopItemViewHolder(
    val v: View
) : RecyclerView.ViewHolder(v) {
    val tvName = v.findViewById<TextView>(R.id.name)
    val tvNum = v.findViewById<TextView>(R.id.num)
    val radioBtn = v.findViewById<RadioButton>(R.id.radiobtn)

    fun bind(shopItem: ShopItem, radioButtonClickListener: ((ShopItem) -> Unit)?) {
        Log.d("test", radioBtn.toString())
        radioBtn.setOnClickListener {
            radioButtonClickListener?.invoke(shopItem)
        }
    }
}