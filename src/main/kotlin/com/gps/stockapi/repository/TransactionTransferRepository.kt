package com.gps.stockapi.repository

import com.gps.stockapi.model.TransactionTransfer
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TransactionTransferRepository : CrudRepository<TransactionTransfer, Int> {

}