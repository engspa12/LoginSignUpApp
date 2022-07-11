package com.example.dbm.loginsignupheroku.di

import com.example.dbm.loginsignupheroku.data.network.datasource.ServiceApi
import com.example.dbm.loginsignupheroku.global.Constants
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RetrofitModule {

    @Singleton
    @Provides
    fun provideMoshi(): Moshi {
        return Moshi.Builder().build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(baseUrl: String, mosh: Moshi): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create(mosh))
            .build()
    }

    @Singleton
    @Provides
    fun provideNewsService(mosh: Moshi): ServiceApi {
        return provideRetrofit(Constants.BASE_URL, mosh).create(ServiceApi::class.java)
    }
}