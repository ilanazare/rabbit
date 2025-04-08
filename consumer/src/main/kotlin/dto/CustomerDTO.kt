package com.example.dto

import com.example.entity.Customer

data class CustomerDTO(
    val customer: String,
    val username: String,
    val email: String
) {
    companion object {
        fun fromEntity(entity: Customer): CustomerDTO {
            return CustomerDTO(
                customer = entity.customer,
                username = entity.username,
                email = entity.email.toString()
            )
        }
    }

    fun toEntity(): Customer {
        return Customer(
            customer = this.customer,
            username = this.username,
            email = this.email
        )
    }
}