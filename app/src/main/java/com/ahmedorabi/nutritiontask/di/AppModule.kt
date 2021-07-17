package com.ahmedorabi.nutritiontask.di

import com.ahmedorabi.nutritiontask.BuildConfig.DEBUG
import com.ahmedorabi.nutritiontask.data.api.ApiService
import com.ahmedorabi.nutritiontask.data.repo.NutritionRepository
import com.ahmedorabi.nutritiontask.ui.framework.ApiNutritionDataSource
import com.ahmedorabi.nutritiontask.usecases.GetNutritionUseCase
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }


    @Provides
    fun provideHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()

    }


    @Singleton
    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return if (DEBUG) {
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        } else {
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)
        }
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson, client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.edamam.com/api/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

//    @Singleton
//    @Provides
//    fun provideNutritionDataSource(apiService: ApiService): NutritionDataSource {
//        return NutritionRepositoryImpl(apiService)
//    }

    @Singleton
    @Provides
    fun provideInApiNutritionDataSource(apiService: ApiService): ApiNutritionDataSource {
        return ApiNutritionDataSource(apiService)
    }

    @Singleton
    @Provides
    fun provideNutritionRepository(apiNutritionDataSource: ApiNutritionDataSource): NutritionRepository {
        return NutritionRepository(apiNutritionDataSource)
    }


    @Singleton
    @Provides
    fun provideUseCase(nutritionRepository: NutritionRepository): GetNutritionUseCase {
        return GetNutritionUseCase(nutritionRepository)
    }


}