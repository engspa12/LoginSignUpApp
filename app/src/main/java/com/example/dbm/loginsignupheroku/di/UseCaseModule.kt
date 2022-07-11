package com.example.dbm.loginsignupheroku.di

import com.example.dbm.loginsignupheroku.data.repository.LoginRepository
import com.example.dbm.loginsignupheroku.domain.usecase.ILoginUseCase
import com.example.dbm.loginsignupheroku.domain.usecase.LoginUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideUseCase(loginRepository: LoginRepository): ILoginUseCase {
        return LoginUseCase(loginRepository)
    }
}