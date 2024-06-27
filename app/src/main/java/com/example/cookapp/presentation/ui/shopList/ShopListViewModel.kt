package com.example.cookapp.presentation.ui.shopList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.cookapp.data.ShopListRepositoryImpl
import com.example.cookapp.domain.shopItem.AddShopItemUseCase
import com.example.cookapp.domain.shopItem.DeleteShopItemUseCase
import com.example.cookapp.domain.shopItem.EditShopItemUseCase
import com.example.cookapp.domain.shopItem.GetShopItemUseCase
import com.example.cookapp.domain.shopItem.GetShopListUseCase
import com.example.cookapp.domain.shopItem.ShopItem
import kotlinx.coroutines.launch

class ShopListViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ShopListRepositoryImpl(application)

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
        viewModelScope.launch {
            deleteShopItemUseCase.deleteShopItem(shopItem)
        }
    }

    fun changeShopItemState(shopItem: ShopItem) {
        val newItem = shopItem.copy(isBought = !shopItem.isBought)
        viewModelScope.launch {
            editShopItemUseCase.editShopItem(newItem)
        }
    }
}