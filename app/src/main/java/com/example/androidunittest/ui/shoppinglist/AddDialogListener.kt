package com.example.androidunittest.ui.shoppinglist

import com.example.androidunittest.data.db.entities.ShoppingItem

/**
 *   Created by Jeje on 7/27/21
 **/
interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}