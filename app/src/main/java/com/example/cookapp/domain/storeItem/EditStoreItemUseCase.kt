package com.example.cookapp.domain.storeItem

import com.example.cookapp.domain.shopItem.ShopItem

class EditStoreItemUseCase(private val storeListRepository: StoreListRepository) {

    fun editStoreItem(storeItem: ShopItem) {
        storeListRepository.editStoreItem(storeItem)
    }
}