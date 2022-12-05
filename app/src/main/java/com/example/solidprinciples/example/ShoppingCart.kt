package com.example.solidprinciples.example

import com.example.solidprinciples.example.payment.Payment
import com.example.solidprinciples.example.persistence.Persistence

// ToDo: ¿Como podemos implementar los principios Solid para mejorar esta clase?
class ShoppingCart(
    private val persistence: Persistence,
    private val paymentMethod: Payment
) {
    fun buy(shopping: Shopping?) {
        persistence.save(shopping)
        paymentMethod.pay(shopping)
    }
}