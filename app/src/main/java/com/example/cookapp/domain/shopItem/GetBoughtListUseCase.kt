package com.example.cookapp.domain.shopItem

import androidx.lifecycle.LiveData

class GetBoughtListUseCase(private val shopListRepository: ShopListRepository) {

    fun getBoughtList(): LiveData<List<ShopItem>> {
        return shopListRepository.getShopList(isBought = true)
    }
}