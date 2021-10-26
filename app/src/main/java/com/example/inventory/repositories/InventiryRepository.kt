package com.example.inventory.repositories

import android.content.Context
import androidx.room.Room
import com.example.inventory.database.InventoryDatabase
import com.example.inventory.database.models.ItemModel
import java.lang.Exception

private const val databaseName = "Inventory Database"
class InventoryRepository (context: Context){
    private val database:InventoryDatabase =
        Room.databaseBuilder(
        context,
        InventoryDatabase::class.java,
        databaseName
    ).fallbackToDestructiveMigration().build()

    private val inventoryDao = database.inventoryDao()

    fun getItem() = inventoryDao.getItem()
    suspend fun addItem (itemModel: ItemModel) = inventoryDao.addItem(itemModel)
    suspend fun deleteItem(itemModel: ItemModel) = inventoryDao.deleteItem(itemModel)
    suspend fun updateItem (itemModel: ItemModel) = inventoryDao.updateItem(itemModel)


    companion object{
        private var instance :InventoryRepository? = null

        fun init(context: Context){
            if (instance == null)
                instance = InventoryRepository(context)

        }
        fun get():InventoryRepository{
            return instance ?:throw Exception("Inventory Repository must be initialise")
        }
    }
}