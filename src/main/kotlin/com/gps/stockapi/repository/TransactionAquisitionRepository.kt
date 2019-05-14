package com.gps.stockapi.repository

import com.gps.stockapi.model.TransationAquisition
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface TransactionAquisitionRepository : CrudRepository<TransationAquisition, Int> {

}