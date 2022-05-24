package com.example.demo.controller

import com.example.demo.dto.UrlRequestDto
import com.example.demo.dto.UrlResponseDto
import com.example.demo.service.UrlService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.web.bind.annotation.*


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
    @PostMapping("/shorten")
    fun shortenUrl(@RequestBody urlRequestDto: UrlRequestDto): UrlResponseDto {
        return urlService.shortenUrl(urlRequestDto.url)
    }
}