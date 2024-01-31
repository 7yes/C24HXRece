package com.jes.c24hxrece.di

import com.jes.c24hxrece.data.SampleApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Singleton
    @Provides
     fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://demo3038897.mockable.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
     fun  providesApiClient(retrofit: Retrofit):SampleApi{
         return retrofit.create(SampleApi::class.java)
     }
}
