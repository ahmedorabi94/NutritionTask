package com.ahmedorabi.nutritiontask.usecases

import com.ahmedorabi.nutritiontask.data.repo.NutritionRepository
import com.ahmedorabi.nutritiontask.domain.Recipe
import javax.inject.Inject

class GetNutritionUseCase @Inject constructor(private val nutritionRepository: NutritionRepository) {


    suspend operator fun invoke(recipe: Recipe) = nutritionRepository.getNutritionResponse(recipe)

}