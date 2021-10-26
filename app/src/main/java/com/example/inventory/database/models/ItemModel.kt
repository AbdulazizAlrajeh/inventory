package com.example.inventory.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ItemModel(
    val name:String,
    val price: Double,
    var inStock : Boolean,
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0

) {
}