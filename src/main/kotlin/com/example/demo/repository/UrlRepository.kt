package com.example.demo.repository

import com.example.demo.model.Url
import org.springframework.data.jpa.repository.JpaRepository

interface UrlRepository : JpaRepository<Url, Long> {
    fun findByUrl(url: String): Url
}
