package com.example.androidunittest

import com.example.androidunittest.test.RegisterUtils
import com.google.common.truth.Truth.assertThat
import org.junit.Test

/**
 * Created by Jeje on 7/23/21
 */
class RegisterUtilsTest{

    @Test
    fun `empty username returns false`(){
        val result = RegisterUtils.validateInput(
            "",
            "123456",
            "123456"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `password is less than 5 return false`(){
        val result = RegisterUtils.validateInput(
            "Aditya",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `username is taken return false`(){
        val result = RegisterUtils.validateInput(
            "Jeje",
            "1234",
            "1234"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `password is not equals to confirmation returns false`(){
        val result = RegisterUtils.validateInput(
            "Jeremia",
            "1234",
            "124"
        )
        assertThat(result).isFalse()
    }
}