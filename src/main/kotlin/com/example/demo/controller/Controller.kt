package com.example.demo.controller

import com.example.demo.model.Url
import com.example.demo.service.UrlService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller(
        private val urlService: UrlService
) {

    @GetMapping("/shorten")
    fun shorten(@RequestParam url: String): String {
        return urlService.shortenUrl(Url(url = url))
    }
}