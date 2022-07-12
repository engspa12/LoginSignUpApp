package com.example.dbm.loginsignupheroku.data.repository

import com.example.dbm.loginsignupheroku.data.network.mapper.LoginNetworkMapper
import com.example.dbm.loginsignupheroku.data.network.datasource.ServiceApi
import com.example.dbm.loginsignupheroku.di.DispatchersModule
import com.example.dbm.loginsignupheroku.domain.repository.ILoginRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val api: ServiceApi,
    private val loginNetworkMapper: LoginNetworkMapper,
    @DispatchersModule.IODispatcher private val dispatcher: CoroutineDispatcher
): ILoginRepository {

    override suspend fun sendLoginData(email: String, password: String) {
        return withContext(dispatcher){
            try {
                val response = api.sendLoginData(email = email, password = password)

                val result = response.body()

                if(response.isSuccessful && result != null){
                    // This could be returned to Domain Layer
                    val loginDomain = loginNetworkMapper.toDomain(result)
                    println(loginDomain)
                } else {
                    println("Error code is: ${response.code()}")
                    println(response.errorBody()!!.string())
                }
            } catch (e: Exception){
                println(e.message ?: "Error during network call")
            }
        }
    }
}