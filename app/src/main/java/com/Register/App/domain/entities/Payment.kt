package com.Register.App.domain.entities

data class PaymentResponse(
    val success: Boolean,
    val response: List<Payment>
)

data class Payment(
    val id: Int,
    val title: String,
    val amount: String,
    val created: Long
)