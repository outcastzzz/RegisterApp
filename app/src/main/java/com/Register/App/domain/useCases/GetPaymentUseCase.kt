package com.Register.App.domain.useCases

import com.Register.App.domain.AppRepository
import com.Register.App.domain.entities.Payment

import javax.inject.Inject

class GetPaymentUseCase @Inject constructor(
    private val repository: AppRepository
) {

    suspend fun execute(token: String): List<Payment> = repository.getPayments(token)

}