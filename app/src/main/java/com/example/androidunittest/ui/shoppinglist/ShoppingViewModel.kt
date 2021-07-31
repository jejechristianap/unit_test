package com.example.androidunittest.ui.shoppinglist

import androidx.lifecycle.ViewModel
import com.example.androidunittest.data.db.entities.ShoppingItem
import com.example.androidunittest.data.repositories.ShoppingRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 *   Created by Jeje on 7/26/21
 **/
class ShoppingViewModel(private val repository: ShoppingRepository) : ViewModel() {
    fun upsert(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(item)
    }

    fun delete(item: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(item)
    }

    fun getAllShoppingItem() = repository.getAllShoppingItem()
}