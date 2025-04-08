package com.example.service

import com.example.config.RabbitMQConfig
import com.example.repository.CustomerRepository
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Service

@Service
class MessagePublisherService(
    val rabbitTemplate: RabbitTemplate,
    val customerRepository: CustomerRepository
) {
    private val queueName = "test_queue"
    fun sendMessage(customer: String) {
        val customerResponse = customerRepository.findById(customer)
        val payload = customerResponse.orElse(null)
        rabbitTemplate
            .convertAndSend(
                RabbitMQConfig.EXCHANGE_NAME,
                RabbitMQConfig.ROUTING_KEY,
                payload
            )
    }
}