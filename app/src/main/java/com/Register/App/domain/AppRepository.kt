package com.Register.App.domain

import androidx.lifecycle.LiveData
import com.Register.App.domain.entities.Payment
import com.Register.App.domain.entities.TokenResponse
import com.Register.App.domain.entities.User
import retrofit2.Response

interface AppRepository {

    suspend fun login(
        user: User
    ): String

    suspend fun getPayments(
        token: String
    ): List<Payment>

}