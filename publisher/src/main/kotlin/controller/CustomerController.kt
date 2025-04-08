package com.example.controller

import com.example.entity.Customer
import com.example.service.CustomerService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping("/api/customer")
class CustomerController(
    val customerService: CustomerService
) {
    @PostMapping
    fun createCustomer(
        @RequestBody request:Customer
    ): ResponseEntity<String> {
        customerService.createCustomer(request)
        return ResponseEntity.ok("Customer set successfully in database: ${request.customer}")
    }

    @GetMapping
    fun findCustomerByCustomer(@RequestParam customer: String): ResponseEntity<Optional<Customer>> {
        return customerService.findCustomerByCustomer(customer).let {
            ResponseEntity.ok(it)
        }
    }
}