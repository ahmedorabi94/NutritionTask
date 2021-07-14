package com.ahmedorabi.nutritiontask.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class DefaultNutrients(

    @SerializedName("label") var label : String = "",
    @SerializedName("quantity") var quantity : Double = 0.0,
    @SerializedName("unit") var unit : String = ""
) : Parcelable