package com.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ConsumerApplication
fun main(args: Array<String>) {
    runApplication<ConsumerApplication>(*args)
}