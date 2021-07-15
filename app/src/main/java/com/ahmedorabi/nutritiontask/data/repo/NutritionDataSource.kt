package com.ahmedorabi.nutritiontask.data.repo

import com.ahmedorabi.nutritiontask.data.api.ResultWrapper
import com.ahmedorabi.nutritiontask.domain.NutritionResponse
import com.ahmedorabi.nutritiontask.domain.Recipe
import kotlinx.coroutines.flow.Flow

interface NutritionDataSource {

    suspend fun getNutritionResponse(recipe: Recipe): Flow<ResultWrapper<NutritionResponse>>


}