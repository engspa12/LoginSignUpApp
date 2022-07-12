package com.example.dbm.loginsignupheroku.data.repository

import android.util.Log
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
                    Log.d("LoginRepository", "You are logged in!! The user is: $loginDomain")
                } else {
                    Log.d("LoginRepository","Error code is: ${response.code()}")
                    Log.d("LoginRepository", "The error body is ${response.errorBody()!!.string()}")
                }
            } catch (e: Exception){
                println(e.message ?: "Error during network call")
            }
        }
    }
}