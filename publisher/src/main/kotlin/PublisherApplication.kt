package com.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
@EnableCaching
class PublisherApplication
fun main(args: Array<String>) {
    runApplication<PublisherApplication>(*args)
}