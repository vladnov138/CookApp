package com.example.cookapp.domain.storeItem

import com.example.cookapp.domain.shopItem.ShopItem

class DeleteStoreItemUseCase(private val storeListRepository: StoreListRepository) {

    fun deleteShopItem(storeItem: ShopItem) {
        storeListRepository.deleteStoreItem(storeItem)
    }
}