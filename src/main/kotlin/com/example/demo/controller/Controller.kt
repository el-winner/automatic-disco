package com.example.demo.controller

import com.example.demo.dto.UrlResponseDto
import com.example.demo.service.UrlService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller(
    private val urlService: UrlService
) {

    @Operation(summary = "Shortens url", description = "Returns numeric and alphanumeric representation of url")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Returns 202 if successful"),
            ApiResponse(responseCode = "500", description = "Returns 500 if unsuccessful")
        ]
    )
    @GetMapping("/shorten")
    fun shortenUrl(@RequestParam @Schema(required = true, minLength = 1) url: String): UrlResponseDto {
        return urlService.shortenUrl(url)
    }
}
