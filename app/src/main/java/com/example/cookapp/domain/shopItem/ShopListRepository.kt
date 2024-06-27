package com.example.cookapp.domain.shopItem

import androidx.lifecycle.LiveData

interface ShopListRepository {

    suspend fun addShopItem(shopItem: ShopItem)

    suspend fun getShopItem(id: Int): ShopItem

    fun getShopList(isBought: Boolean = false): LiveData<List<ShopItem>>

    suspend fun editShopItem(shopItem: ShopItem)

    suspend fun deleteShopItem(shopItem: ShopItem)
}