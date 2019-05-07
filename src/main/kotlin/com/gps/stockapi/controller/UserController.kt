package com.gps.stockapi.controller

import com.gps.stockapi.business.UserBusiness
import com.gps.stockapi.model.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class UserController {

    @Autowired
    private lateinit var userBusiness: UserBusiness


    @GetMapping("/users")
    fun getCategories() : ResponseEntity<List<User>> {
        return  ResponseEntity(userBusiness.getUsers(), HttpStatus.OK)
    }

    @RequestMapping(value = ["/user"], method = [(RequestMethod.POST)])
    fun createUser(@RequestBody user : User): ResponseEntity<User> {
        val persistedUser =  userBusiness.saveUser(user)
        return ResponseEntity(persistedUser, HttpStatus.CREATED)
    }

    @RequestMapping(value = ["/user"], method = [(RequestMethod.PUT)])
    fun modifyUser(@RequestBody user : User): ResponseEntity<User> {
        val persistedUser =  userBusiness.saveUser(user)
        return ResponseEntity(persistedUser, HttpStatus.OK)
    }
}