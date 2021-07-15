package com.ahmedorabi.nutritiontask.data.repo

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ahmedorabi.nutritiontask.TestCoroutineRule
import com.ahmedorabi.nutritiontask.data.api.ApiService
import com.ahmedorabi.nutritiontask.data.api.ResultWrapper
import com.ahmedorabi.nutritiontask.domain.*
import com.ahmedorabi.nutritiontask.uils.AppConstants
import com.nhaarman.mockitokotlin2.doReturn
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner


@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class NutritionRepositoryImplTest {

    val testDispatcher = TestCoroutineDispatcher()

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()


    @Mock
    lateinit var apiService: ApiService


    private lateinit var repository: NutritionRepositoryImpl


    private val totalDaily = TotalDaily(
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null
    )
    private val totalNutrients = TotalNutrients(
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null,
        null
    )
    private val totalNutrientsKCal = TotalNutrientsKCal(null, null, null, null)

    private val nutritionResponse = NutritionResponse(
        "null", 2, 3, 10, 1.0, emptyList(), emptyList(),
        emptyList(), totalNutrients, totalDaily, emptyList(), totalNutrientsKCal
    )

    @Before
    fun setup() {

        repository = NutritionRepositoryImpl(apiService)

    }

    @Test
    fun shouldGetNutritionResponse() {


        val recipe = Recipe(arrayListOf("1 fresh ham"))



        runBlocking {


            doReturn(nutritionResponse)
                .`when`(apiService)
                .getNutritionResponseAsync(
                    AppConstants.APP_ID, AppConstants.API_KEY, recipe
                )

            val response = repository.getNutritionResponse(recipe).first()

            when (response) {
                is ResultWrapper.Success -> {
                    val result = response.value
                    assertEquals(result.calories, 3)

                }

            }


        }
    }

}