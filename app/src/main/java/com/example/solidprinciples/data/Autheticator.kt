package com.example.solidprinciples.data

import com.example.solidprinciples.data.model.LoggedInUser

interface Autheticator {
    fun login(username: String, password: String): Result<LoggedInUser>
    fun logout()
}