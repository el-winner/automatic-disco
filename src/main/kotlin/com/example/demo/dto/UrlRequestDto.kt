package com.example.demo.dto

import io.swagger.v3.oas.annotations.media.Schema

data class UrlRequestDto(
    @Schema(required = true, type = "string", minLength = 1)
    val url: String
)