package com.example.cookapp.domain

data class ShopItem(
    val name: String,
    val count: Double,
    val unit: String,
    val isBought: Boolean,
    var id: Int = DEFAULT_VALUE
) {

    companion object {
        const val DEFAULT_VALUE = -1
    }
}
