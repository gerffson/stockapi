package com.gps.stockapi.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Stock (
    @Id
    @GeneratedValue
    var id: Int? = null,
    var locationId: Int? = null,
    var productId: Int? = null,
    var quantity: Double = 0.0
) {

    constructor(locationId: Int?,productId: Int?,quantity: Double ): this(null, locationId, productId, quantity) {}

}

