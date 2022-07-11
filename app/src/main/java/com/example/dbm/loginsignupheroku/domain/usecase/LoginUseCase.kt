package com.example.dbm.loginsignupheroku.domain.usecase

import com.example.dbm.loginsignupheroku.data.repository.LoginRepository
import com.example.dbm.loginsignupheroku.domain.usecase.ILoginUseCase
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) : ILoginUseCase {

    override suspend operator fun invoke(email: String, password: String) {
        loginRepository.sendLoginData(email, password)
    }
}


