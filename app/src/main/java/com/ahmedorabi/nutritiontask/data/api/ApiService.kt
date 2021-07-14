package com.ahmedorabi.nutritiontask.data.api

import com.ahmedorabi.nutritiontask.data.model.NutritionResponse
import com.ahmedorabi.nutritiontask.data.model.Recipe
import retrofit2.http.*

interface ApiService {


    @POST("nutrition-details")
    suspend fun getNutritionResponseAsync(
        @Query("app_id") id: String, @Query("app_key") key: String, @Body ingr : Recipe
    ): NutritionResponse


}