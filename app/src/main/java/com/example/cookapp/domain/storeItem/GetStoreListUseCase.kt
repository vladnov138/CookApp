package com.example.cookapp.domain.storeItem

import androidx.lifecycle.LiveData
import com.example.cookapp.domain.shopItem.ShopItem

class GetStoreListUseCase(private val storeListRepository: StoreListRepository) {

    fun getStoreList(): LiveData<List<ShopItem>> {
        return storeListRepository.getStoreList()
    }
}