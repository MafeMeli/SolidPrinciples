package com.example.solidprinciples.example.payment

import com.example.solidprinciples.example.Shopping

class CreditCard: Payment {
    override fun pay(shopping: Shopping?) {
        // Hace el pago usando el medio de pago de tarjeta de crédito
    }
}