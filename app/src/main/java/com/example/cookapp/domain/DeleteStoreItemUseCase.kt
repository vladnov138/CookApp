package com.example.cookapp.domain

class DeleteStoreItemUseCase(private val storeListRepository: StoreListRepository) {

    fun deleteShopItem(storeItem: ShopItem) {
        storeListRepository.deleteStoreItem(storeItem)
    }
}