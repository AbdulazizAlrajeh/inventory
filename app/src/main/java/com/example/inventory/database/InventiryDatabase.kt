package com.example.inventory.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.inventory.database.models.ItemModel

@Database(entities = [ItemModel::class],version = 1)
abstract class InventoryDatabase :RoomDatabase(){
    abstract fun inventoryDao():InventoryDao
}