package com.example.cookapp.domain.shopItem

import androidx.lifecycle.LiveData

interface ShopListRepository {

    fun addShopItem(shopItem: ShopItem)

    fun getShopItem(id: Int): ShopItem

    fun getShopList(): LiveData<List<ShopItem>>

    fun editShopItem(shopItem: ShopItem)

    fun deleteShopItem(shopItem: ShopItem)
}