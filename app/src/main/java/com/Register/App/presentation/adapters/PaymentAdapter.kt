package com.Register.App.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.Register.App.databinding.PaymentItemBinding
import com.Register.App.domain.entities.Payment

class PaymentAdapter(
    private val list: List<Payment>
): ListAdapter<Payment, PaymentViewHolder>(PaymentDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentViewHolder {
        val binding = PaymentItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PaymentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PaymentViewHolder, position: Int) {
        val payment = list[position]
        holder.bind(payment)
    }
}