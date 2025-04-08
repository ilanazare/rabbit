package com.example.service

import com.example.entity.Customer
import com.example.repository.CustomerRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
) {
    fun createCustomer(request: Customer) =
                customerRepository.save(request)

    fun findCustomerByCustomer(customer: String): Optional<Customer> =
        customerRepository.findById(customer)
}