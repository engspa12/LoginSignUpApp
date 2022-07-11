package com.example.dbm.loginsignupheroku.di

import com.example.dbm.loginsignupheroku.data.network.mapper.LoginNetworkMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class MappersModule {

    @Provides
    fun provideNetworkMapper(): LoginNetworkMapper {
        return LoginNetworkMapper()
    }
}