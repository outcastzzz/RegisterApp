package com.Register.App.domain.useCases

import com.Register.App.domain.AppRepository
import com.Register.App.domain.entities.User
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: AppRepository
) {

    suspend fun execute(user: User): String = repository.login(user)
}