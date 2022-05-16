package com.example.demo.model

import javax.persistence.*

@Entity
@Table(name = "urls")
class Url(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long? = null,

        val url: String
)