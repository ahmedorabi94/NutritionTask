package com.ahmedorabi.nutritiontask.data.repo

import com.ahmedorabi.nutritiontask.data.api.ApiService
import com.ahmedorabi.nutritiontask.data.api.ResultWrapper
import com.ahmedorabi.nutritiontask.data.api.safeApiCall
import com.ahmedorabi.nutritiontask.domain.NutritionResponse
import com.ahmedorabi.nutritiontask.domain.Recipe
import com.ahmedorabi.nutritiontask.uils.AppConstants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NutritionRepositoryImpl @Inject constructor(private val apiService: ApiService) :
    NutritionDataSource {


    override suspend fun getNutritionResponse(recipe: Recipe): Flow<ResultWrapper<NutritionResponse>> {


        return flow {

            emit(safeApiCall(Dispatchers.IO) {
                apiService.getNutritionResponseAsync(
                    AppConstants.APP_ID,
                    AppConstants.API_KEY,
                    recipe
                )
            })


        }.flowOn(Dispatchers.IO)
    }


     suspend fun getNutritionResponseTes(recipe: Recipe): Flow<NutritionResponse> {


        return flow {

            emit(

                    apiService.getNutritionResponseAsync(
                        AppConstants.APP_ID,
                        AppConstants.API_KEY,
                        recipe
                    )


            )


        }.flowOn(Dispatchers.IO)
    }


}