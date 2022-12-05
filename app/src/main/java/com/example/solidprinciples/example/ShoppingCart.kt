package com.example.solidprinciples.example
// ToDo: ¿Como podemos implementar los principios Solid para mejorar esta clase?
class ShoppingCart {
    fun buy(shopping: Shopping?) {
        val db = SQLDatabase()
        db.save(shopping)
        val creditCard = CreditCard()
        creditCard.pay(shopping)
    }
}