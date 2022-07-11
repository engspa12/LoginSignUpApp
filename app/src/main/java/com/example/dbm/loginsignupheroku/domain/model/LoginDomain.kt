package com.example.dbm.loginsignupheroku.domain.model

import com.example.dbm.loginsignupheroku.presentation.model.LoginView

data class LoginDomain(
    val name: String,
    val email: String
)

fun LoginDomain.toView(): LoginView {
    return LoginView(this.name, this.email)
}