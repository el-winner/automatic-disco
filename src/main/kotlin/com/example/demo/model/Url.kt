package com.example.demo.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.SequenceGenerator
import javax.persistence.Table

@Entity
@Table(name = "urls")
class Url(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "urls_id_sequence")
    @SequenceGenerator(
        name = "urls_id_sequence",
        sequenceName = "urls_id_seq",
        initialValue = 1,
        allocationSize = 1
    )
    var id: Long? = null,

    val url: String
)
