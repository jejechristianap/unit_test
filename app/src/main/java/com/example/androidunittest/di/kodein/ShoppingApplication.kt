package com.example.androidunittest.di.kodein

import android.app.Application
import com.example.androidunittest.data.db.ShoppingDatabase
import com.example.androidunittest.data.repositories.ShoppingRepository
import com.example.androidunittest.ui.shoppinglist.ShoppingViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

/**
 *   Created by Jeje on 7/27/21
 **/
class ShoppingApplication: Application(), KodeinAware {
    override val kodein: Kodein = Kodein.lazy {
        import(androidXModule((this@ShoppingApplication)))
        bind() from singleton { ShoppingDatabase(instance()) }
        bind() from singleton { ShoppingRepository(instance()) }
        bind() from provider { ShoppingViewModelFactory(instance()) }
    }
}