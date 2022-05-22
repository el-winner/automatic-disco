package com.example.demo.model

import javax.persistence.*

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