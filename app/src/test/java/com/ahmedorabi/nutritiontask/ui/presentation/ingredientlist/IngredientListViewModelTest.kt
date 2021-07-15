package com.ahmedorabi.nutritiontask.ui.presentation.ingredientlist

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.ahmedorabi.nutritiontask.TestCoroutineRule
import com.ahmedorabi.nutritiontask.data.api.ErrorResponse
import com.ahmedorabi.nutritiontask.data.api.Resource
import com.ahmedorabi.nutritiontask.data.api.ResultWrapper
import com.ahmedorabi.nutritiontask.domain.*
import com.ahmedorabi.nutritiontask.usecases.GetNutritionUseCase
import com.nhaarman.mockitokotlin2.doReturn
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner


@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class IngredientListViewModelTest {


    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    private lateinit var apiUsersObserver: Observer<Resource<NutritionResponse>>

    private lateinit var viewModel: IngredientListViewModel

    @Mock
    private lateinit var useCase: GetNutritionUseCase


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
        viewModel = IngredientListViewModel(useCase)
    }

    @Test
    fun givenResponseSuccess_whenFetch_shouldReturnSuccess() {

        val flow = flow {
            emit(
                ResultWrapper.Success(nutritionResponse)
            )
        }

        val recipe = Recipe(arrayListOf("1 fresh ham"))


        testCoroutineRule.runBlockingTest {
            doReturn(flow)
                .`when`(useCase)
                .invoke(recipe)


            viewModel.items.observeForever(apiUsersObserver)

            viewModel.foodText.value = recipe

            viewModel.getNutritionResponseFlow(recipe)

            verify(useCase).invoke(
                Recipe(arrayListOf("1 fresh ham"))
            )

            verify(apiUsersObserver).onChanged(
                Resource.success(
                    nutritionResponse
                )
            )
            viewModel.items.removeObserver(apiUsersObserver)
        }


    }

    @Test
    fun givenResponseError_whenFetch_shouldReturnError() {


        val flow = flow {
            emit(
                ResultWrapper.Error(404, ErrorResponse(message = "404 Not Found"))
            )
        }
        val recipe = Recipe(arrayListOf("1 fresh ham"))


        testCoroutineRule.runBlockingTest {
            doReturn(flow)
                .`when`(useCase)
                .invoke(recipe)

            viewModel.items.observeForever(apiUsersObserver)

            viewModel.foodText.value = recipe

            viewModel.getNutritionResponseFlow(recipe)

            verify(useCase).invoke(
                Recipe(arrayListOf("1 fresh ham"))
            )

            verify(apiUsersObserver).onChanged(
                Resource.error(data = null, message = "404 Not Found")
            )

            viewModel.items.removeObserver(apiUsersObserver)
        }
    }

}