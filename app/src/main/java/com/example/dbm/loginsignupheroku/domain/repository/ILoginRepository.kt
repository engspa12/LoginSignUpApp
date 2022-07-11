package com.example.dbm.loginsignupheroku.domain.repository

interface ILoginRepository {
    suspend fun sendLoginData(email: String, password: String)
}