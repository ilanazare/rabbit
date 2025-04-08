package com.example.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "customer")
data class Customer(
    @Id
    @Column(name = "customer", unique = true)
    val customer: String,
    val username: String,
    var email: String,
)
