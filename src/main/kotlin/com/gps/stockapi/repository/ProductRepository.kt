package com.gps.stockapi.repository

import com.gps.stockapi.model.Product
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : CrudRepository<Product, Int> {

}