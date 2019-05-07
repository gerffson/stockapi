package com.gps.stockapi.repository

import com.gps.stockapi.model.TransactionUser
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TransactionUserRepository : CrudRepository<TransactionUser, Int> {

}