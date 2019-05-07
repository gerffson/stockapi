package com.gps.stockapi.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id


@Entity
data class TransactionTransfer (
    @Id
    @GeneratedValue
    var transactionTransferId: Int? = null,
    var transactionId: Long? = null,
    var stockId: Long? = null,
    var productId: Long? = null,
    var quantity: Double? = null,
    /* Transaction Transfer type */
    var transactionTransferType: TransactionTransfer.TransactionTransferType? = null
) {


    enum class TransactionTransferType(var varue: Any){
        `in`("in"),
        `out`("out");
    }

}

