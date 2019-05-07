package com.gps.stockapi.business

import com.gps.stockapi.model.Transaction
import com.gps.stockapi.repository.TransactionRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class TransactionBusiness {

    @Autowired
    private lateinit var transactionRepository: TransactionRepository

    fun getTransactions() : List<Transaction> {
        return transactionRepository.findAll().toList()
    }


    fun saveTransaction(entity : Transaction): Transaction{
        return transactionRepository.save(entity)
    }
}