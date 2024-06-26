package com.example.cookapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.cookapp.domain.ShopItem
import com.example.cookapp.domain.StoreListRepository

object StoreListRepositoryImpl : StoreListRepository {

    private val storeList = mutableListOf<ShopItem>()
    private val storeListLD = MutableLiveData<List<ShopItem>>()

    private var autoIncrementId = 0

    init {
        for (i in 0 until 1000) {
            val item = ShopItem("Name $i", i.toDouble(), "kg")
            addStoreItem(item)
        }
    }

    override fun addStoreItem(storeItem: ShopItem) {
        if (storeItem.id == ShopItem.DEFAULT_VALUE) {
            storeItem.id = autoIncrementId++
        }
        storeList.add(storeItem)
        updateList()
    }

    override fun getStoreItem(id: Int): ShopItem {
        return storeList.find {
                elem -> elem.id == id
        } ?: throw RuntimeException("Element with id $id not found")
    }

    override fun getStoreList(): LiveData<List<ShopItem>> {
        return storeListLD
    }

    override fun editStoreItem(storeItem: ShopItem) {
        val oldStoreItem = getStoreItem(storeItem.id)
        deleteStoreItem(oldStoreItem)
        storeList.add(storeItem)
    }

    override fun deleteStoreItem(storeItem: ShopItem) {
        storeList.remove(storeItem)
        updateList()
    }

    private fun updateList() {
        storeListLD.value = storeList.toList()
    }
}