package com.example.controller

import com.example.service.MessagePublisherService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class MessagePublisherController(
    val messagePublisherService: MessagePublisherService
) {

    @PostMapping("/send/customer")
    fun sendMessage(
        @RequestParam customer: String
    ): String {
        messagePublisherService.sendMessage(customer)
        return "Message send to RabbitMq successfully"
    }
}