package com.ahmedorabi.nutritiontask.data.repo

import com.ahmedorabi.nutritiontask.data.api.ApiService
import com.ahmedorabi.nutritiontask.data.api.ResultWrapper
import com.ahmedorabi.nutritiontask.data.api.safeApiCall
import com.ahmedorabi.nutritiontask.data.model.NutritionResponse
import com.ahmedorabi.nutritiontask.data.model.Recipe
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class HomeRepo @Inject constructor(
    private val apiService: ApiService
) {

    private val dispatcher: CoroutineDispatcher = Dispatchers.IO


    suspend fun getNutritionResponseFlow(
        id: String, key: String, recipe: Recipe

    ): Flow<ResultWrapper<NutritionResponse>> {


        return flow {

            emit(safeApiCall(dispatcher) {
                apiService.getNutritionResponseAsync(id, key, recipe)
            })


        }.flowOn(Dispatchers.IO)
    }


}