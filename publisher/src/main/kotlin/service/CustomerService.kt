package com.example.service

import com.example.entity.Customer
import com.example.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
) {
    fun createCustomer(request: Customer) =
                customerRepository.save(request)
}