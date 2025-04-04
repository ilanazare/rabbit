package com.example.entity

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import java.io.Serializable

@RedisHash("Customer")
data class Customer(
    @Id
    val customer: String,
    val username: String,
    val email: String
): Serializable
