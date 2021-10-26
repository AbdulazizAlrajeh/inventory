package com.example.inventory.fragments

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.inventory.database.models.ItemModel
import com.example.inventory.repositories.InventoryRepository
import kotlinx.coroutines.launch


class InventoryViewModel :ViewModel() {

    private val inventoryRepository = InventoryRepository.get()

    var inventoryItem = inventoryRepository.getItem()

    var selectedItemMutableLiveData = MutableLiveData<ItemModel>()

    fun addItem(name:String,price:Double,inStock:Boolean){
        viewModelScope.launch {
            inventoryRepository.addItem(ItemModel(name, price, inStock))
        }
    }

    fun updateItem (itemModel: ItemModel){
        viewModelScope.launch {
            inventoryRepository.updateItem(itemModel)
        }
    }


    fun deleteItem(itemModel: ItemModel){
        viewModelScope.launch {
            inventoryRepository.deleteItem(itemModel)
        }
    }
}