package com.gps.stockapi.repository

import com.gps.stockapi.model.Category
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository : CrudRepository<Category, Int> {

}