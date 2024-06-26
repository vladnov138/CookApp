package com.example.cookapp.domain

import androidx.lifecycle.LiveData

interface StoreListRepository {
    fun addStoreItem(storeItem: ShopItem)

    fun getStoreItem(id: Int): ShopItem

    fun getStoreList(): LiveData<List<ShopItem>>

    fun editStoreItem(storeItem: ShopItem)

    fun deleteStoreItem(storeItem: ShopItem)
}