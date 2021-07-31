package com.example.androidunittest.data.repositories

import com.example.androidunittest.data.db.ShoppingDatabase
import com.example.androidunittest.data.db.entities.ShoppingItem

/**
 *   Created by Jeje on 7/26/21
 **/
class ShoppingRepository(private val db: ShoppingDatabase) {
    suspend fun upsert(item: ShoppingItem) = db.getShoppingDao().upsert(item)

    suspend fun delete(item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingItem() = db.getShoppingDao().getAllShoppingItem()
}