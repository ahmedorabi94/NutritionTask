package com.ahmedorabi.nutritiontask.data.repo

import com.ahmedorabi.nutritiontask.domain.Recipe
import javax.inject.Inject

class NutritionRepository @Inject constructor (private val dataSource: NutritionDataSource) {

    suspend fun getNutritionResponse(recipe: Recipe) = dataSource.getNutritionResponse(recipe)

}