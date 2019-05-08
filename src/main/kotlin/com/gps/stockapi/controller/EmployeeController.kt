package com.gps.stockapi.controller

import com.gps.stockapi.business.EmployeeBusiness
import com.gps.stockapi.model.Employee
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
class EmployeeController {

    @Autowired
    private lateinit var employeeBusiness: EmployeeBusiness


    @GetMapping("/employees")
    fun getEmployees() : ResponseEntity<List<Employee>> {
        return  ResponseEntity(employeeBusiness.getEmployees(), HttpStatus.OK)
    }

    @RequestMapping(value = ["/employee"], method = [(RequestMethod.POST)])
    fun createEmployee(@RequestBody employee : Employee): ResponseEntity<Employee> {
        val persistedEmployee =  employeeBusiness.saveEmployee(employee)
        return ResponseEntity(persistedEmployee, HttpStatus.CREATED)
    }

    @RequestMapping(value = ["/employee"], method = [(RequestMethod.PUT)])
    fun modifyEmployee(@RequestBody employee : Employee): ResponseEntity<Employee> {
        val persistedEmployee =  employeeBusiness.saveEmployee(employee)
        return ResponseEntity(persistedEmployee, HttpStatus.OK)
    }

}