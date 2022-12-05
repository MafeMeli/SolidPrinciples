package com.example.solidprinciples.example

import com.example.solidprinciples.example.payment.CreditCard
import com.example.solidprinciples.example.persistence.SQLDatabase
import com.example.solidprinciples.example.persistence.Server

class ImplementationActivity {

    /**
     * Lo vamos a poder usar con la base de datos o el server, o con paypal o credit cart
     */
    fun useShoppingCart() {
        ShoppingCart(SQLDatabase(), CreditCard())
        ShoppingCart(Server(), CreditCard())
    }
}