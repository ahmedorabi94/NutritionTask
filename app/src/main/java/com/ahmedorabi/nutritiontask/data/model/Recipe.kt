package com.ahmedorabi.nutritiontask.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Recipe(
    val ingr: ArrayList<String>
) : Parcelable
