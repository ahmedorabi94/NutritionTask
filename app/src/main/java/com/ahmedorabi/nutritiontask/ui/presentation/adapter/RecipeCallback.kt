package com.ahmedorabi.nutritiontask.ui.presentation.adapter

import com.ahmedorabi.nutritiontask.domain.Parsed

interface RecipeCallback {


    fun onItemClick(data: Parsed)
}