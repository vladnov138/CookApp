package com.example.cookapp.presentation.ui.shopList

import androidx.lifecycle.ViewModel
import com.example.cookapp.data.ShopListRepositoryImpl
import com.example.cookapp.domain.AddShopItemUseCase
import com.example.cookapp.domain.DeleteShopItemUseCase
import com.example.cookapp.domain.EditShopItemUseCase
import com.example.cookapp.domain.GetShopItemUseCase
import com.example.cookapp.domain.GetShopListUseCase
import com.example.cookapp.domain.ShopItem

class ShopListViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val addShopItemUseCase = AddShopItemUseCase(repository)
    private val getShopItemUseCase = GetShopItemUseCase(repository)
    private val getShopListUseCase = GetShopListUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun getShopList() {
        val list = getShopListUseCase.getShopList()
    }

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeShopItemState(shopItem: ShopItem) {
        val newItem = shopItem.copy(isBought = !shopItem.isBought)
        editShopItemUseCase.editShopItem(newItem)
    }
}