package com.example.androidunittest

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.androidunittest.test.ResourceComparer
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

/**
 * Created by Jeje on 7/23/21
 */
class ResourceComparerTest{
    private lateinit var resourceComparer: ResourceComparer

    @Before
    fun start() {
        resourceComparer = ResourceComparer()
    }

    @Test
    fun stringResourceSameAsGivenString_returnTrue() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparer.isEqual(context, R.string.app_name, "Android Unit Test")
        assertThat(result).isTrue()
    }

    @Test
    fun stringResourceNotSameAsGivenString_returnFalse() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val result = resourceComparer.isEqual(context, R.string.app_name, "Jsdflkj")
        assertThat(result).isFalse()
    }
}