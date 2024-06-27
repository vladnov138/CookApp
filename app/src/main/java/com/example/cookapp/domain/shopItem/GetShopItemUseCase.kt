package com.example.cookapp.domain.shopItem

class GetShopItemUseCase(private val shopListRepository: ShopListRepository) {

    suspend fun getShopItem(id: Int): ShopItem {
        return shopListRepository.getShopItem(id)
    }
}