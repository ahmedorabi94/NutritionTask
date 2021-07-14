package com.ahmedorabi.nutritiontask.uils

import com.ahmedorabi.nutritiontask.data.model.Recipe
import timber.log.Timber
import kotlin.math.roundToInt


fun String.toRecipe(): Recipe {

    val arr = this.split("\n")
    val arrayList = ArrayList<String>()

    for (item in arr) {
        Timber.e(item)
        if (item.isNotEmpty()){
            arrayList.add(item)
        }


    }

    return Recipe(arrayList)

}


fun Double.getRoundFloat(): Double {

    return "%.1f".format(this).toDouble()

}

fun Double.getRoundToInt(): Int {

    return this.roundToInt()

}