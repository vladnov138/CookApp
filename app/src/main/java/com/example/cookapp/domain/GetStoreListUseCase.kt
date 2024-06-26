package com.example.cookapp.domain

import androidx.lifecycle.LiveData

class GetStoreListUseCase(private val storeListRepository: StoreListRepository) {

    fun getStoreList(): LiveData<List<ShopItem>> {
        return storeListRepository.getStoreList()
    }
}