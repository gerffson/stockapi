package com.gps.stockapi.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class TransationAquisition (
        @Id
        @GeneratedValue
        var TransationAquisitionId: Int? = null,
        var transactionId: Int? = null,
        var stockId: Int? = null,
        var quantity: Double? = null
) {


}

