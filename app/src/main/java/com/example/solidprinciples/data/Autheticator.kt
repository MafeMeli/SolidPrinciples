package com.example.solidprinciples.data

import com.example.solidprinciples.data.model.LoggedInUser

interface Autheticator {
    fun login(): Result<LoggedInUser>
    fun logout()
}