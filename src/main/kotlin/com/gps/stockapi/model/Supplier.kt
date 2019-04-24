package com.gps.stockapi.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id


@Entity
data class Supplier(
        @Id
        @GeneratedValue
        var id: Int = 0,
        var cnpj: String = "",
        var name: String = ""
)