package com.gps.stockapi.business

import com.gps.stockapi.model.Employee
import com.gps.stockapi.repository.EmployeeRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class EmployeeBusiness {

    @Autowired
    private lateinit var employeeRepository: EmployeeRepository

    fun getEmployees() : List<Employee> {
        return employeeRepository.findAll().toList()
    }


    fun saveEmployee(entity : Employee): Employee {
        return employeeRepository.save(entity)
    }

}