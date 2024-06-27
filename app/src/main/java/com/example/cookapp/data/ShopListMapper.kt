package com.example.cookapp.data

import com.example.cookapp.domain.shopItem.ShopItem

class ShopListMapper {

    fun mapEntityToDbModel(shopItem: ShopItem): ShopItemDbModel {
        return ShopItemDbModel(
            id = shopItem.id,
            name = shopItem.name,
            count = shopItem.count,
            isBought = shopItem.isBought,
            unit = shopItem.unit
        )
    }

    fun mapDbModelToEntity(shopItemDbModel: ShopItemDbModel): ShopItem {
        return ShopItem(
            id = shopItemDbModel.id,
            name = shopItemDbModel.name,
            count = shopItemDbModel.count,
            isBought = shopItemDbModel.isBought,
            unit = shopItemDbModel.unit
        )
    }

    fun mapListDbModelToListEntity(list: List<ShopItemDbModel>): List<ShopItem> =
        list.map { mapDbModelToEntity(it) }
}