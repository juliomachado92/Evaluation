package com.inter.evaluation.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(private val userDao: UserDao) {

    fun getUsers() = userDao.getUsers()

    fun getUser(id: String) = userDao.getUser(id)

}