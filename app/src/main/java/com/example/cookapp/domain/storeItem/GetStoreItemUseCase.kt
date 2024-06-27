package com.example.cookapp.domain.storeItem

import com.example.cookapp.domain.shopItem.ShopItem

class GetStoreItemUseCase(private val storeListRepository: StoreListRepository) {

    fun getShopItem(id: Int): ShopItem {
        return storeListRepository.getStoreItem(id)
    }
}