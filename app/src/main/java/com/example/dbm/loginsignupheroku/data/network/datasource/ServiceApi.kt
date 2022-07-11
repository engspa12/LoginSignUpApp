package com.example.dbm.loginsignupheroku.data.network.datasource

import com.example.dbm.loginsignupheroku.data.network.model.LoginNetwork
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ServiceApi {
    @FormUrlEncoded
    @POST("/api/users/login")
    suspend fun sendLoginData(@Field("email") email: String, @Field("password") password: String): Response<LoginNetwork>
}