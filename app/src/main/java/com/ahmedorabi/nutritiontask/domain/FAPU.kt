package com.ahmedorabi.nutritiontask.domain

import com.google.gson.annotations.SerializedName

   
data class FAPU (

   @SerializedName("label") var label : String,
   @SerializedName("quantity") var quantity : Double,
   @SerializedName("unit") var unit : String

)