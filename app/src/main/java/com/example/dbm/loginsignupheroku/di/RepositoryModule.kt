package com.example.dbm.loginsignupheroku.di

import com.example.dbm.loginsignupheroku.data.network.mapper.LoginNetworkMapper
import com.example.dbm.loginsignupheroku.domain.repository.ILoginRepository
import com.example.dbm.loginsignupheroku.data.repository.LoginRepository
import com.example.dbm.loginsignupheroku.data.network.datasource.ServiceApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(api: ServiceApi, loginNetworkMapper: LoginNetworkMapper, dispatcher: CoroutineDispatcher) : ILoginRepository {
        return LoginRepository(api, loginNetworkMapper, dispatcher)
    }
}