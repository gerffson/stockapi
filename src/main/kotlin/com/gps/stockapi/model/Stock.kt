package com.gps.stockapi.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Stock (
    @Id
    @GeneratedValue
    var id: Int? = null,
    var locationId: Long? = null,
    var productId: Long? = null,
    var quantity: Double? = null
) {

}

