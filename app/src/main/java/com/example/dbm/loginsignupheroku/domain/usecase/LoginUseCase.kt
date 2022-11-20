package com.example.dbm.loginsignupheroku.domain.usecase

import com.example.dbm.loginsignupheroku.domain.repository.ILoginRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val loginRepository: ILoginRepository
) : ILoginUseCase {

    override suspend operator fun invoke(email: String, password: String) {
        loginRepository.sendLoginData(email, password)
    }
}


