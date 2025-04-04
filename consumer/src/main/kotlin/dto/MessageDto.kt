package com.example.dto

import java.io.Serializable

data class MessageDto(
    val id: String,
    val content: String,
    val timestamp: Long = System.currentTimeMillis()
): Serializable
