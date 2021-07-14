package com.ahmedorabi.nutritiontask.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Ingredients (

   @SerializedName("text") val text : String,
   @SerializedName("parsed") val parsed : List<Parsed?>?

) : Parcelable