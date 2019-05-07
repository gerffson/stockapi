package com.gps.stockapi.repository

import com.gps.stockapi.model.Company
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CompanyRepository : CrudRepository<Company, Int> {

}