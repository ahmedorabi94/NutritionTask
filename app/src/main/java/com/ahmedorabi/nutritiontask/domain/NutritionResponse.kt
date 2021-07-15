package com.ahmedorabi.nutritiontask.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NutritionResponse (

   @SerializedName("uri") val uri : String,
   @SerializedName("yield") val yield : Int,
   @SerializedName("calories") val calories : Int,
   @SerializedName("glycemicIndex") val glycemicIndex : Int,
   @SerializedName("totalWeight") val totalWeight : Double,
   @SerializedName("dietLabels") val dietLabels : List<String>,
   @SerializedName("healthLabels") val healthLabels : List<String>,
   @SerializedName("cautions") val cautions : List<String>,

   @SerializedName("totalNutrients") val totalNutrients : TotalNutrients,
   @SerializedName("totalDaily") val totalDaily : TotalDaily,
   @SerializedName("ingredients") val ingredients : List<Ingredients?>,
   @SerializedName("totalNutrientsKCal") val totalNutrientsKCal : TotalNutrientsKCal

) : Parcelable