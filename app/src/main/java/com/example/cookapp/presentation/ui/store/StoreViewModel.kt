package com.example.cookapp.presentation.ui.store

import androidx.lifecycle.ViewModel
import com.example.cookapp.data.StoreListRepositoryImpl
import com.example.cookapp.domain.AddStoreItemUseCase
import com.example.cookapp.domain.DeleteStoreItemUseCase
import com.example.cookapp.domain.EditStoreItemUseCase
import com.example.cookapp.domain.GetStoreItemUseCase
import com.example.cookapp.domain.GetStoreListUseCase
import com.example.cookapp.domain.ShopItem

class StoreViewModel : ViewModel() {

    private val repository = StoreListRepositoryImpl

    private val addStoreItemUseCase = AddStoreItemUseCase(repository)
    private val getStoreItemUseCase = GetStoreItemUseCase(repository)
    private val getStoreListUseCase = GetStoreListUseCase(repository)
    private val editStoreItemUseCase = EditStoreItemUseCase(repository)
    private val deleteStoreItemUseCase = DeleteStoreItemUseCase(repository)

    val storeList = getStoreListUseCase.getStoreList()

    fun getShopList() {
        val list = getStoreListUseCase.getStoreList()
    }

    fun deleteShopItem(storeItem: ShopItem) {
        deleteStoreItemUseCase.deleteShopItem(storeItem)
    }

    fun changeShopItemState(storeItem: ShopItem) {
        val newItem = storeItem.copy(isBought = !storeItem.isBought)
        editStoreItemUseCase.editStoreItem(newItem)
    }
}