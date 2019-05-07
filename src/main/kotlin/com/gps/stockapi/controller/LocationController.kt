package com.gps.stockapi.controller

import com.gps.stockapi.business.LocationBusiness
import com.gps.stockapi.model.Location
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class LocationController {

    @Autowired
    private lateinit var locationBusiness: LocationBusiness


    @GetMapping("/locations")
    fun getCategories() : ResponseEntity<List<Location>> {
        return  ResponseEntity(locationBusiness.getLocations(), HttpStatus.OK)
    }

    @RequestMapping(value = ["/location"], method = [(RequestMethod.POST)])
    fun createLocation(@RequestBody location : Location): ResponseEntity<Location> {
        val persistedLocation =  locationBusiness.saveLocation(location)
        return ResponseEntity(persistedLocation, HttpStatus.CREATED)
    }

    @RequestMapping(value = ["/location"], method = [(RequestMethod.PUT)])
    fun modifyLocation(@RequestBody location : Location): ResponseEntity<Location> {
        val persistedLocation =  locationBusiness.saveLocation(location)
        return ResponseEntity(persistedLocation, HttpStatus.OK)
    }

}