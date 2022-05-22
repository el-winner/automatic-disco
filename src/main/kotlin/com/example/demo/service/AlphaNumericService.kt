package com.example.demo.service

import org.springframework.stereotype.Service

@Service
class AlphaNumericService {

    fun convertIdToAlphaNumericString(id: Long): String {
        var result = ""
        var temp = id
        val chars = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        val len = chars.length
        do {
            val remainder: Int = (temp % len).toInt()
            temp /= len
            result = if (remainder == 0)
                chars[len - 1] + result
            else
                chars[remainder - 1] + result
        } while (temp != 0L)
        return result
    }
}
