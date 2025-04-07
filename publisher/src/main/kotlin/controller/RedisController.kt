package com.example.controller

import com.example.service.RedisService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/redis")
class RedisController(
    private val redisService: RedisService
) {

    @PostMapping
    fun setValue(
        @RequestParam key: String,
        @RequestBody value: Any,
        @RequestParam(required = false) ttl: Long? = null
    ): ResponseEntity<String> {
        redisService.setValue(key, value, ttl)
        return ResponseEntity.ok("Value set successfully for key: $key")
    }

    @GetMapping
    fun getValue(@RequestParam key: String): ResponseEntity<Any> {
        return redisService.getValue(key)?.let {
            ResponseEntity.ok(it)
        } ?: ResponseEntity.notFound().build()
    }

    @GetMapping("/exists")
    fun hasKey(@RequestParam key: String): ResponseEntity<Boolean> {
        return ResponseEntity.ok(redisService.hasKey(key))
    }

    @DeleteMapping
    fun deleteKey(@RequestParam key: String): ResponseEntity<String> {
        return if (redisService.deleteKey(key)) {
            ResponseEntity.ok("Key $key deleted successfully")
        } else {
            ResponseEntity.notFound().build()
        }
    }
}