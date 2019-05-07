package com.gps.stockapi.controller

import com.gps.stockapi.business.CompanyBusiness
import com.gps.stockapi.model.Company
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class CompanyController {

    @Autowired
    private lateinit var companyBusiness: CompanyBusiness


    @GetMapping("/companies")
    fun getCategories() : ResponseEntity<List<Company>> {
        return  ResponseEntity(companyBusiness.getCompanys(), HttpStatus.OK)
    }

    @RequestMapping(value = ["/company"], method = [(RequestMethod.POST)])
    fun createCategory(@RequestBody company : Company): ResponseEntity<Company> {
        val persistedCompany=  companyBusiness.saveCompany(company)
        return ResponseEntity(persistedCompany, HttpStatus.CREATED)
    }

    @RequestMapping(value = ["/company"], method = [(RequestMethod.PUT)])
    fun modifyCategory(@RequestBody company: Company): ResponseEntity<Company> {
        val persistedCompany =  companyBusiness.saveCompany(company)
        return ResponseEntity(persistedCompany, HttpStatus.OK)
    }


}