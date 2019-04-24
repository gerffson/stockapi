package com.gps.stockapi.repository

import org.springframework.data.repository.CrudRepository
import com.gps.stockapi.model.Supplier
import org.springframework.stereotype.Repository

@Repository
interface SupplierRepository : CrudRepository<Supplier,Int>{

}