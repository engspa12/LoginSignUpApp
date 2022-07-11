package com.example.dbm.loginsignupheroku.data.network.mapper

import com.example.dbm.loginsignupheroku.data.network.model.LoginNetwork
import com.example.dbm.loginsignupheroku.domain.model.LoginDomain

class LoginNetworkMapper {

    fun toDomain(loginNetwork: LoginNetwork): LoginDomain {
        return LoginDomain(
            name = loginNetwork.name ?: "Empty Username",
            email = loginNetwork.email ?: "Empty Email"
        )
    }
}