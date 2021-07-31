package com.example.androidunittest.test

import android.content.Context

/**
 *   Created by Jeje on 7/23/21
 **/
class ResourceComparer {
    fun isEqual(context: Context, resId: Int, string: String) : Boolean {
        return context.getString(resId) == string
    }
}