package com.example.cookapp.domain

class EditStoreItemUseCase(private val storeListRepository: StoreListRepository) {

    fun editStoreItem(storeItem: ShopItem) {
        storeListRepository.editStoreItem(storeItem)
    }
}