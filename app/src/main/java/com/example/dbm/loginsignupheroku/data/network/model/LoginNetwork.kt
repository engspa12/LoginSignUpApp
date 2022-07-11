package com.example.dbm.loginsignupheroku.data.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LoginNetwork (
    @Json(name = "_id")
    var id: String? = null,
    @Json(name = "name")
    var name: String? = null,
    @Json(name = "email")
    var email: String? = null,
    @Json(name = "token")
    var token: String? = null
)