package com.gps.stockapi.repository

import com.gps.stockapi.model.Employee
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface EmployeeRepository : CrudRepository<Employee, Int> {

}