package com.gps.stockapi.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Location (
    @Id
    @GeneratedValue
    var id: Int? = null,
    var name: String? = null
) {

}

