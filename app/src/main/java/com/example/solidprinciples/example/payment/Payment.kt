package com.example.solidprinciples.example.payment

import com.example.solidprinciples.example.Shopping

interface Payment {
    fun pay(shopping: Shopping?)
}