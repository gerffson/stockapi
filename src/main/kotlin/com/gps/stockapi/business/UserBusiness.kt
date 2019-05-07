package com.gps.stockapi.business

import com.gps.stockapi.model.User
import com.gps.stockapi.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired

class UserBusiness {

    @Autowired
    private lateinit var userRepository: UserRepository

    fun getUsers() : List<User> {
        return userRepository.findAll().toList()
    }


    fun saveUser(entity : User): User{
        return userRepository.save(entity)
    }

}