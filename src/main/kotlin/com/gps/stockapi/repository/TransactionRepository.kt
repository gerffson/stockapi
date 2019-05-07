package com.gps.stockapi.repository

import com.gps.stockapi.model.Transaction
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TransactionRepository : CrudRepository<Transaction, Int> {

}