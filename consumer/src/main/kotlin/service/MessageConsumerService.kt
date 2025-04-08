package com.example.service

import com.example.config.RabbitMQConfig
import com.example.dto.CustomerDTO
import com.example.repository.CustomerRepository
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Service

@Service
class MessageConsumerService(
    val customerRepository: CustomerRepository
) {

    @RabbitListener(queues = [RabbitMQConfig.QUEUE_NAME])
    fun receiveCustomerMessage(@Payload customerDto: CustomerDTO) {
        println("Received customer: $customerDto")
        customerRepository.save(customerDto.toEntity())
    }

}