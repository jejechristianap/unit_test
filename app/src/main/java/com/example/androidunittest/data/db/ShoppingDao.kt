package com.example.androidunittest.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.androidunittest.data.db.entities.ShoppingItem

/**
 *   Created by Jeje on 7/26/21
 **/

@Dao
interface ShoppingDao {

    // Mix of update and insert
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item: ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("SELECT * FROM shopping_items")
    fun getAllShoppingItem() : LiveData<List<ShoppingItem>>
}