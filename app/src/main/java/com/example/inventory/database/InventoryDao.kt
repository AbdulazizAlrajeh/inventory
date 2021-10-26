package com.example.inventory.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.inventory.database.models.ItemModel

@Dao
interface InventoryDao {
    @Insert
    suspend fun addItem(itemModel:ItemModel)

    @Query("SELECT * FROM itemmodel")
    fun getItem(): LiveData<List<ItemModel>>

    @Delete
    suspend fun deleteItem(itemModel: ItemModel)

    @Update
    suspend fun updateItem (itemModel: ItemModel)


}