package com.example.cookapp.presentation.ui.store

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.cookapp.data.ShopListRepositoryImpl
import com.example.cookapp.domain.shopItem.AddShopItemUseCase
import com.example.cookapp.domain.shopItem.DeleteShopItemUseCase
import com.example.cookapp.domain.shopItem.EditShopItemUseCase
import com.example.cookapp.domain.shopItem.GetBoughtListUseCase
import com.example.cookapp.domain.shopItem.GetShopItemUseCase
import com.example.cookapp.domain.shopItem.GetShopListUseCase
import com.example.cookapp.domain.shopItem.ShopItem
import kotlinx.coroutines.launch

class StoreViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ShopListRepositoryImpl(application)

    private val addShopItemUseCase = AddShopItemUseCase(repository)
    private val getShopItemUseCase = GetShopItemUseCase(repository)
    private val getShopListUseCase = GetShopListUseCase(repository)
    private val getBoughtListUseCase = GetBoughtListUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)

    val storeList = getBoughtListUseCase.getBoughtList()

    fun deleteShopItem(shopItem: ShopItem) {
        viewModelScope.launch {
            deleteShopItemUseCase.deleteShopItem(shopItem)
        }
    }

    fun changeShopItemState(shopItem: ShopItem) {
        viewModelScope.launch {
            val newItem = shopItem.copy(isBought = !shopItem.isBought)
            editShopItemUseCase.editShopItem(newItem)
        }
    }
}