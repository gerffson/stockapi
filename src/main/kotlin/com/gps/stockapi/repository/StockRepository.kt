package com.gps.stockapi.repository

import com.gps.stockapi.model.Stock
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface StockRepository : CrudRepository<Stock, Int> {

    override fun findById(stockId : Int) : Optional<Stock>
    fun findByLocationIdAndProductId(locationId : Int, productId : Int) : Optional<Stock>

}