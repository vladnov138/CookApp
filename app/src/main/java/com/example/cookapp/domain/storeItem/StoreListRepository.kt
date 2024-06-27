package com.example.cookapp.domain.storeItem

import androidx.lifecycle.LiveData
import com.example.cookapp.domain.shopItem.ShopItem

interface StoreListRepository {
    fun addStoreItem(storeItem: ShopItem)

    fun getStoreItem(id: Int): ShopItem

    fun getStoreList(): LiveData<List<ShopItem>>

    fun editStoreItem(storeItem: ShopItem)

    fun deleteStoreItem(storeItem: ShopItem)
}