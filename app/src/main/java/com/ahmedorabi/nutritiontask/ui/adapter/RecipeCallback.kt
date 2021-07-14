package com.ahmedorabi.nutritiontask.ui.adapter

import com.ahmedorabi.nutritiontask.data.model.Parsed

interface RecipeCallback {


    fun onItemClick(data: Parsed)
}