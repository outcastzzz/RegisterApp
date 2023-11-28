package com.Register.App.presentation.adapters

import androidx.recyclerview.widget.RecyclerView
import com.Register.App.databinding.PaymentItemBinding
import com.Register.App.domain.entities.Payment

class PaymentViewHolder(
    binding: PaymentItemBinding
): RecyclerView.ViewHolder(binding.root) {
    private val amountTv = binding.tvAmount
    private val createdTv = binding.tvCreated
    private val titleTv = binding.tvTitle

    fun bind(payment: Payment) {
        amountTv.text = payment.amount
        createdTv.text = payment.created.toString()
        titleTv.text = payment.title
    }
}