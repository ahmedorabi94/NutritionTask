package com.ahmedorabi.nutritiontask.data.repo

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ahmedorabi.nutritiontask.TestCoroutineRule
import com.ahmedorabi.nutritiontask.data.api.ApiService
import com.ahmedorabi.nutritiontask.data.api.ResultWrapper
import com.ahmedorabi.nutritiontask.domain.NutritionResponse
import com.ahmedorabi.nutritiontask.domain.Recipe
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.stub
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
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

//    @get:Rule
//    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()
//
//    @get:Rule
//    val testCoroutineRule = TestCoroutineRule()


    @Mock
    lateinit var apiService: ApiService


    private lateinit var repository: NutritionRepositoryImpl


    @Before
    fun setup() {

     repository = NutritionRepositoryImpl(apiService)

    }

    @Test
    fun `should get user details`() = runBlocking {

        val nutritionResponse = NutritionResponse(
            "null", 2, 3, 10, 1.0, emptyList(), emptyList(),
            emptyList(), null, null, emptyList(), null
        )


        val result = ResultWrapper.Success(
            nutritionResponse
        )

//        doReturn(nutritionResponse)
//            .`when`(apiService)
//            .getNutritionResponseAsync(
//                "123", "5", Recipe(ArrayList())
//            )

//        val apiService = mock<ApiService>() {
//            onBlocking {
//                getNutritionResponseAsync(
//                    "1",
//                    "2",
//                    Recipe(ArrayList())
//                )
//            } doReturn nutritionResponse
//        }

        apiService.stub {
            onBlocking {
                getNutritionResponseAsync(
                    "1",
                    "2",
                    Recipe(ArrayList())
                )
            } doReturn nutritionResponse
        }

     //   repository = NutritionRepositoryImpl(apiService)

        val reee =  repository.getNutritionResponseTes(Recipe(ArrayList())).toList()

        //assertEquals(reee.calories , 3)

        assertEquals(reee,nutritionResponse)


         Unit
//        // Test & Verify
//      val flow = repository.getNutritionResponseTes(Recipe(ArrayList()))
//
//
//
//
//        flow.collect { data ->
//
//            //   val result = data.calories
//
//            assertEquals(data.calories, 3)
//
//            //   data `should equal` result
//        }
    }


}