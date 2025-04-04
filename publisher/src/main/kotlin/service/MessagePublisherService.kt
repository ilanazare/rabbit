package com.example.service

import com.example.config.RabbitMQConfig
import com.example.dto.MessageDto
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Service

@Service
class MessagePublisherService(
    val rabbitTemplate: RabbitTemplate
) {
    private val queueName = "test_queue"
    fun sendMessage(message: MessageDto) = rabbitTemplate
        .convertAndSend(
            RabbitMQConfig.EXCHANGE_NAME,
            RabbitMQConfig.ROUTING_KEY,
            message
        )
}