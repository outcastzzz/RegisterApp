package com.Register.App.data.repository

import com.Register.App.data.network.ApiService
import com.Register.App.domain.AppRepository
import com.Register.App.domain.entities.Payment
import com.Register.App.domain.entities.User
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val apiService: ApiService
): AppRepository {

    override suspend fun login(
        user: User
    ): String = apiService.login(user = user).body()!!.response.token

    override suspend fun getPayments(
        token: String
    ): List<Payment> = apiService.getPayments(token = token).body()!!.response
}