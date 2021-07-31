package com.example.androidunittest.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidunittest.R
import com.example.androidunittest.data.db.entities.ShoppingItem
import com.example.androidunittest.databinding.RecyclerviewShoppingItemBinding
import com.example.androidunittest.ui.shoppinglist.ShoppingViewModel

/**
 *   Created by Jeje on 7/27/21
 **/
class ShoppingItemAdapter(var items: List<ShoppingItem>, private val viewModel: ShoppingViewModel)
    : RecyclerView.Adapter<ShoppingItemAdapter.ViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = RecyclerviewShoppingItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val curShoppingItem = items[position]
        with(holder) {
            bind(curShoppingItem)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(val binding: RecyclerviewShoppingItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data: ShoppingItem){
            with(binding){
                tvName.text = data.name
                tvAmount.text = data.amount.toString()

                ivDelete.setOnClickListener {
                    viewModel.delete(data)
                }

                ivPlus.setOnClickListener {
                    data.amount++
                    viewModel.upsert(data)
                }

                ivMinus.setOnClickListener {
                    if (data.amount > 0){
                        data.amount--
                        viewModel.upsert(data)
                    }
                }
            }
        }
    }
}