package com.example.cookapp.domain

class AddStoreItemUseCase(private val storeRepository: StoreListRepository) {

    fun addShopItem(storeItem: ShopItem) {
        storeRepository.addStoreItem(storeItem)
    }
}