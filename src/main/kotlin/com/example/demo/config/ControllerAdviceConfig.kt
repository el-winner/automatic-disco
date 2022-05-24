package com.example.demo.config

import com.example.demo.exception.ShortUrlNotGeneratedException
import org.hibernate.annotations.common.util.impl.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ControllerAdviceConfig {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleIllegalStateException(e: ShortUrlNotGeneratedException): String? {
        log.warn(e.message, e)
        return e.message
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleIllegalArgumentException(e: IllegalStateException): String? {
        log.warn(e.message, e)
        return e.message
    }

    companion object {
        private val log = LoggerFactory.logger(ControllerAdviceConfig::class.java)
    }
}
