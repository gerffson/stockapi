package com.gps.stockapi.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id


@Entity
data class Transaction (
    @Id
    @GeneratedValue
    var id: Int? = null,
    var transactionType: Transaction.TransactionType? = null
) {

   enum class TransactionType(var varue: Any){
        transfer("transfer"),
        invoice("invoice");
    }

}

