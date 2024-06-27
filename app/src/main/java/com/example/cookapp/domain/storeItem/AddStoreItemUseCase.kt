package com.example.cookapp.domain.storeItem

import com.example.cookapp.domain.shopItem.ShopItem

class AddStoreItemUseCase(private val storeRepository: StoreListRepository) {

    fun addShopItem(storeItem: ShopItem) {
        storeRepository.addStoreItem(storeItem)
    }
}