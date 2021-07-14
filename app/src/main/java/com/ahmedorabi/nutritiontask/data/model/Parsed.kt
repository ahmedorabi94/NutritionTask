package com.ahmedorabi.nutritiontask.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Parsed (

   @SerializedName("quantity") var quantity : Int,
   @SerializedName("measure") var measure : String,
   @SerializedName("foodMatch") var foodMatch : String,
   @SerializedName("food") var food : String,
   @SerializedName("foodId") var foodId : String,
   @SerializedName("specificFoodURI") var specificFoodURI : String,
   @SerializedName("weight") var weight : Double,
   @SerializedName("retainedWeight") var retainedWeight : Double,
   @SerializedName("nutrients") var nutrients : Nutrients,
   @SerializedName("measureURI") var measureURI : String,
   @SerializedName("status") var status : String

) : Parcelable