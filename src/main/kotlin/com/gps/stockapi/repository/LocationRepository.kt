package com.gps.stockapi.repository

import com.gps.stockapi.model.Location
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface LocationRepository : CrudRepository<Location, Int> {

}