package com.example.demo.service

import com.example.demo.UrlRepository
import com.example.demo.model.Url
import org.springframework.stereotype.Service

@Service
class UrlService(
        private val urlRepository: UrlRepository
) {
    fun shortenUrl(url: Url): String {
        return urlRepository.save(url).id.toString()
    }
}