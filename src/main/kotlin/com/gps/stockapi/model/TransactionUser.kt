package com.gps.stockapi.model

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class TransactionUser (
    @Id
    var transactionId: Int? = null,
    var stockId: Long? = null,
    var productId: Long? = null,
    var quantity: Double? = null,
    /* Transaction User Type */
    var transactionUserType: TransactionUser.TransactionUserType? = null
) {
    enum class TransactionUserType(var varue: Any){
        `in`("in"),
        `out`("out");
    }
}

