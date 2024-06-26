package com.example.cookapp.domain

class GetStoreItemUseCase(private val storeListRepository: StoreListRepository) {

    fun getShopItem(id: Int): ShopItem {
        return storeListRepository.getStoreItem(id)
    }
}