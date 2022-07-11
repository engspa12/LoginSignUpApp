package com.example.dbm.loginsignupheroku.domain.usecase

interface ILoginUseCase {
    suspend operator fun invoke(email: String, password: String)
}