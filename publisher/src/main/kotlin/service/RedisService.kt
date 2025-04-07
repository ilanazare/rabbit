package com.example.service

import org.springframework.data.redis.core.RedisTemplate
import org.springframework.stereotype.Service
import java.util.concurrent.TimeUnit

@Service
class RedisService(
    private val redisTemplate: RedisTemplate<String, Any>
) {

    fun setValue(key: String, value: Any, ttl: Long? = null) =
        redisTemplate.opsForValue().set(key, value)
            .run { ttl?.let { redisTemplate.expire(key, it, TimeUnit.SECONDS) } }

    fun getValue(key: String): Any? =
        redisTemplate.opsForValue().get(key)

    fun deleteKey(key: String): Boolean =
        redisTemplate.delete(key)

    fun hasKey(key: String): Boolean =
        redisTemplate.hasKey(key)
}