package com.example.cookapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cookapp.domain.ShopItem
import com.example.cookapp.domain.ShopListRepository

object ShopListRepositoryImpl : ShopListRepository {

    private val shopList = mutableListOf<ShopItem>()
    private val shopListLD = MutableLiveData<List<ShopItem>>()

    private var autoIncrementId = 0

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.DEFAULT_VALUE) {
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
        updateList()
    }

    override fun getShopItem(id: Int): ShopItem {
        return shopList.find {
            elem -> elem.id == id
        } ?: throw RuntimeException("Element with id $id not found")
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopListLD
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldShopItem = getShopItem(shopItem.id)
        deleteShopItem(oldShopItem)
        shopList.add(shopItem)
    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
        updateList()
    }

    private fun updateList() {
        shopListLD.value = shopList.toList()
    }
}