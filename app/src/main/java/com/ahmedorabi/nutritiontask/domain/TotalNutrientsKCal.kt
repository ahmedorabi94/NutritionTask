package com.ahmedorabi.nutritiontask.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TotalNutrientsKCal (

   @SerializedName("ENERC_KCAL") var ENERCKCAL : DefaultNutrients,
   @SerializedName("PROCNT_KCAL") var PROCNTKCAL : DefaultNutrients,
   @SerializedName("FAT_KCAL") var FATKCAL : DefaultNutrients,
   @SerializedName("CHOCDF_KCAL") var CHOCDFKCAL : DefaultNutrients

) : Parcelable