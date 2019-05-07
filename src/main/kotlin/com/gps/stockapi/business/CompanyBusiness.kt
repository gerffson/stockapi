package com.gps.stockapi.business

import com.gps.stockapi.model.Company
import com.gps.stockapi.repository.CompanyRepository
import org.springframework.beans.factory.annotation.Autowired

class CompanyBusiness {

    @Autowired
    private lateinit var companyRepository: CompanyRepository

    fun getCompanys() : List<Company> {
        return companyRepository.findAll().toList()
    }


    fun saveCompany(company : Company): Company {
        return companyRepository.save(company)
    }

}