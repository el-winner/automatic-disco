package com.example.demo

import com.example.demo.service.UrlService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers


@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UrlRepositoryTCTest {

    @Autowired
    private lateinit var urlService: UrlService

    companion object {

        @Container
        val container = PostgreSQLContainer<Nothing>("postgres:12").apply {
            withDatabaseName("my-db")
            withUsername("elvina")
            withPassword("elvina")
        }

        @JvmStatic
        @DynamicPropertySource
        fun properties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", container::getJdbcUrl)
            registry.add("spring.datasource.password", container::getPassword)
            registry.add("spring.datasource.username", container::getUsername)
        }
    }

    @Test
    fun `should return shortened string`() {
        val result = urlService.shortenUrl("lala")
        assertThat(result.numeric).isEqualTo(1)
        assertThat(result.alphanumeric).isEqualTo("a")
    }
}
