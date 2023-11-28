package com.Register.App.domain.entities

data class TokenResponse(
    val success: Boolean,
    val response: Response
)

data class Response(
    val token: String
)
