package com.example.service

import com.example.config.RabbitMQConfig
import com.example.dto.MessageDto
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Service

@Service
class MessageConsumerService {

    @RabbitListener(queues = [RabbitMQConfig.QUEUE_NAME])
    fun receiveMessage(message: MessageDto) =
        println("Received message: $message")
}