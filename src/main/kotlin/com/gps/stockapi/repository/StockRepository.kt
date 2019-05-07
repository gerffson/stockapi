package com.gps.stockapi.repository

import com.gps.stockapi.model.Stock
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface StockRepository : CrudRepository<Stock, Int> {

}