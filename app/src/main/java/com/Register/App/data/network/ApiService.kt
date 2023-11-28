package com.Register.App.data.network

import com.Register.App.domain.entities.PaymentResponse
import com.Register.App.domain.entities.TokenResponse
import com.Register.App.domain.entities.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {

    @POST("login")
    suspend fun login(
        @Header("app-key") appKey: String = "12345",
        @Header("v") v: String = "1",
        @Body user: User
    ): Response<TokenResponse>

    @GET("payments")
    suspend fun getPayments(
        @Header("app-key") appKey: String = "12345",
        @Header("v") v: String = "1",
        @Header("token") token: String
    ): Response<PaymentResponse>
}