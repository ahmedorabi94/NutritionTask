package com.ahmedorabi.nutritiontask.ui.presentation.ingredientlist

import androidx.lifecycle.*
import com.ahmedorabi.nutritiontask.data.api.Resource
import com.ahmedorabi.nutritiontask.data.api.ResultWrapper
import com.ahmedorabi.nutritiontask.domain.NutritionResponse
import com.ahmedorabi.nutritiontask.domain.Recipe
import com.ahmedorabi.nutritiontask.usecases.GetNutritionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import timber.log.Timber
import javax.inject.Inject


@HiltViewModel
class IngredientListViewModel @Inject constructor(
    private val useCase: GetNutritionUseCase,
) :
    ViewModel() {

    val foodText = MutableStateFlow<Recipe?>(null)

    private val _items = foodText
        .filter { query ->
            return@filter query != null
        }
        .flatMapLatest { query ->
            getNutritionResponseFlow(query!!)
        }


    val items = _items.asLiveData()


    fun getRoundFloat(value: Double): Double {

        return "%.1f".format(value).toDouble()

    }


    private fun getNutritionResponseFlow(recipe: Recipe): Flow<Resource<NutritionResponse>> {


        return flow {
            useCase.invoke(
                recipe
            )
                .onStart {
                    Timber.e("Start")
                    emit(Resource.loading(data = null))
                }.catch { exception ->
                    Timber.e(exception)
                    emit(Resource.error(data = null, message = "Unknown Error"))

                }.onCompletion {
                    Timber.e("onCompletion")
                }.collect { response ->

                    when (response) {
                        is ResultWrapper.Success -> {
                            Timber.e("Success ${response.value}")
                            emit(Resource.success(response.value))
                        }
                        is ResultWrapper.Error -> {
                            val errorResponse = response.error
                            val code = response.code

                            Timber.e("ApiError Code : $code  Message : ${errorResponse?.message}")

                            if (errorResponse != null) {
                                emit(
                                    Resource.error(
                                        data = null,
                                        message = errorResponse.message
                                    )
                                )
                            } else {
                                emit(Resource.error(data = null, message = "Unknown Error"))
                            }
                        }
                        is ResultWrapper.NetworkError -> {
                            emit(Resource.error(data = null, message = "NetworkError ."))
                        }

                    }


                }
        }

    }
}