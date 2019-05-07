package com.gps.stockapi.business

import com.gps.stockapi.model.Location
import com.gps.stockapi.repository.LocationRepository
import org.springframework.beans.factory.annotation.Autowired

class LocationBusiness {

    @Autowired
    private lateinit var locationRepository: LocationRepository

    fun getLocations() : List<Location> {
        return locationRepository.findAll().toList()
    }


    fun saveLocation(entity : Location): Location{
        return locationRepository.save(entity)
    }

}