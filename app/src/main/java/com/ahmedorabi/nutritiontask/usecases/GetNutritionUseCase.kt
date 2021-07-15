package com.ahmedorabi.nutritiontask.usecases

import com.ahmedorabi.nutritiontask.data.repo.NutritionDataSource
import com.ahmedorabi.nutritiontask.domain.Recipe
import javax.inject.Inject

class GetNutritionUseCase @Inject constructor(private val repository: NutritionDataSource) {


    suspend operator fun invoke(recipe: Recipe) = repository.getNutritionResponse(recipe)

}