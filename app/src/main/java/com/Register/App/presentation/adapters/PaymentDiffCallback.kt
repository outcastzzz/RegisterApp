package com.Register.App.presentation.adapters

import androidx.recyclerview.widget.DiffUtil
import com.Register.App.domain.entities.Payment

object PaymentDiffCallback: DiffUtil.ItemCallback<Payment>() {

    override fun areItemsTheSame(oldItem: Payment, newItem: Payment): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Payment, newItem: Payment): Boolean {
        return oldItem == newItem
    }
}