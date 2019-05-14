package com.gps.stockapi.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id


@Entity
data class TransactionTransfer (
    @Id
    @GeneratedValue
    var transactionTransferId: Int? = null,
    var transactionId: Int? = null,
    var stockId: Int? = null,
    var quantity: Double? = null,
    var transactionTransferType: TransactionTransferType? = null
) {


    enum class TransactionTransferType(var value: String){
        IN("in"),
        OUT("out");
    }

}

