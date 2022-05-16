package com.example.demo

import com.example.demo.model.Url
import org.springframework.data.jpa.repository.JpaRepository

interface UrlRepository : JpaRepository<Url, Long>