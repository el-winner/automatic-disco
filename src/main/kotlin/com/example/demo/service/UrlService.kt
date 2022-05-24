package com.example.demo.service

import com.example.demo.dto.UrlResponseDto
import com.example.demo.exception.ShortUrlNotGeneratedException
import com.example.demo.model.Url
import com.example.demo.repository.UrlRepository
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.stereotype.Service

@Service
class UrlService(
    private val urlRepository: UrlRepository,
    private val alphaNumericService: AlphaNumericService
) {
    fun shortenUrl(url: String): UrlResponseDto {
        val numeric = try {
            urlRepository.save(Url(url = url)).id
        } catch (e: DataIntegrityViolationException) {
            urlRepository.findByUrl(url).id
        } catch (e: Exception) {
            throw ShortUrlNotGeneratedException()
        } ?: throw IllegalStateException("Короткий url не может быть null")

        val alphanumeric = alphaNumericService.convertIdToAlphaNumericString(numeric)
        return UrlResponseDto(numeric, alphanumeric)
    }
}
