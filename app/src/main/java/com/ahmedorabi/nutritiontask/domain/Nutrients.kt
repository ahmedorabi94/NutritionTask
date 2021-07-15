package com.ahmedorabi.nutritiontask.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Nutrients (

   @SerializedName("RIBF") var RIBF : DefaultNutrients,
   @SerializedName("VITD") var VITD : DefaultNutrients,
   @SerializedName("THIA") var THIA : DefaultNutrients,
   @SerializedName("FAPU") var FAPU : DefaultNutrients,
   @SerializedName("NIA") var NIA : DefaultNutrients,
   @SerializedName("ENERC_KCAL") var ENERCKCAL : DefaultNutrients,
   @SerializedName("FASAT") var FASAT : DefaultNutrients,
   @SerializedName("VITA_RAE") var VITARAE : DefaultNutrients,
   @SerializedName("VITC") var VITC : DefaultNutrients,
   @SerializedName("PROCNT") var PROCNT : DefaultNutrients,
   @SerializedName("CHOLE") var CHOLE : DefaultNutrients,
   @SerializedName("FAMS") var FAMS : DefaultNutrients,
   @SerializedName("CHOCDF") var CHOCDF : DefaultNutrients,
   @SerializedName("FAT") var FAT : DefaultNutrients,
   @SerializedName("VITB6A") var VITB6A : DefaultNutrients,
   @SerializedName("VITB12") var VITB12 : DefaultNutrients,
   @SerializedName("FIBTG") var FIBTG : DefaultNutrients,
   @SerializedName("WATER") var WATER : DefaultNutrients,
   @SerializedName("K") var K : DefaultNutrients,
   @SerializedName("P") var P : DefaultNutrients,
   @SerializedName("NA") var NA : DefaultNutrients,
   @SerializedName("ZN") var ZN : DefaultNutrients,
   @SerializedName("CA") var CA : DefaultNutrients,
   @SerializedName("MG") var MG : DefaultNutrients,
   @SerializedName("FE") var FE : DefaultNutrients,
   @SerializedName("FOLFD") var FOLFD : DefaultNutrients,
   @SerializedName("FOLAC") var FOLAC : DefaultNutrients,
   @SerializedName("FOLDFE") var FOLDFE : DefaultNutrients

) : Parcelable