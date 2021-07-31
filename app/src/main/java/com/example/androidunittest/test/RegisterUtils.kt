package com.example.androidunittest.test

/**
 *   Created by Jeje on 7/23/21
 **/
object RegisterUtils {
    private val existingUsers = listOf("Jeje", "Jeremia")
    fun validateInput(
        username: String,
        password: String,
        confirmation: String
    ) : Boolean{
        if (username.isEmpty() || password.isEmpty()){
            return false
        }
        if (username in existingUsers){
            return false
        }
        if (password != confirmation){
            return false
        }
        if (password.count {it.isDigit()} < 5) {
            return false
        }
        return true
    }
}