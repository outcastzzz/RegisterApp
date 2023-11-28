package com.Register.App.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.Register.App.data.network.ApiService
import com.Register.App.data.repository.AppRepositoryImpl
import com.Register.App.domain.entities.Payment
import com.Register.App.domain.entities.User
import com.Register.App.domain.useCases.GetPaymentUseCase
import com.Register.App.domain.useCases.LoginUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.Exception

class MainViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val getPaymentUseCase: GetPaymentUseCase,
    private val api: ApiService
): ViewModel() {

    private val _token = MutableLiveData<String>()
    val token: LiveData<String> = _token

    private val _payments = MutableLiveData<List<Payment>>()
    val payments: LiveData<List<Payment>> = _payments

    private val _errorMessage = MutableLiveData<String>()
    val errorMessage: LiveData<String> = _errorMessage

    fun login(user: User) {
        viewModelScope.launch {
            try {
                val response = loginUseCase.execute(user)
                _token.value = response
            } catch (e: Exception) {
                _errorMessage.value = e.message
            }
        }
    }

    fun getPayment(token: String) {
        viewModelScope.launch {
            try {
                Log.d("MyTag", "done00")
                val paymentResponse = getPaymentUseCase.execute(token)
                Log.d("MyTag", "done000")
                _payments.value = paymentResponse
                Log.d("MyTag", "done0000")
            } catch (e: Exception) {
                throw RuntimeException("Payment list crashed: ${e.message}")
            }
        }
    }
}