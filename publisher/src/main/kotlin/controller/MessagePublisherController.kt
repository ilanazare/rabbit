package com.example.controller

import com.example.dto.MessageDto
import com.example.service.MessagePublisherService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MessagePublisherController(
    val messagePublisherService: MessagePublisherService
) {

    @PostMapping("/send")
    fun sendMessage(
        @RequestBody message: MessageDto
    ): String {
        messagePublisherService.sendMessage(message)
        return "Message send to RabbitMq successfully"
    }
}