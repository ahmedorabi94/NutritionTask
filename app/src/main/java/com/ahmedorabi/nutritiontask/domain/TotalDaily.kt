package com.ahmedorabi.nutritiontask.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TotalDaily (

   @SerializedName("ENERC_KCAL") var ENERCKCAL : DefaultNutrients?,
   @SerializedName("FAT") var FAT : DefaultNutrients?,
   @SerializedName("FASAT") var FASAT : DefaultNutrients?,
   @SerializedName("CHOCDF") var CHOCDF : DefaultNutrients?,
   @SerializedName("FIBTG") var FIBTG : DefaultNutrients?,
   @SerializedName("PROCNT") var PROCNT : DefaultNutrients?,
   @SerializedName("CHOLE") var CHOLE : DefaultNutrients?,
   @SerializedName("NA") var NA : DefaultNutrients?,
   @SerializedName("CA") var CA : DefaultNutrients?,
   @SerializedName("MG") var MG : DefaultNutrients?,
   @SerializedName("K") var K : DefaultNutrients?,
   @SerializedName("FE") var FE : DefaultNutrients?,
   @SerializedName("ZN") var ZN : DefaultNutrients?,
   @SerializedName("P") var P : DefaultNutrients?,
   @SerializedName("VITA_RAE") var VITARAE : DefaultNutrients?,
   @SerializedName("VITC") var VITC : DefaultNutrients?,
   @SerializedName("THIA") var THIA : DefaultNutrients?,
   @SerializedName("RIBF") var RIBF : DefaultNutrients?,
   @SerializedName("NIA") var NIA : DefaultNutrients?,
   @SerializedName("VITB6A") var VITB6A : DefaultNutrients?,
   @SerializedName("FOLDFE") var FOLDFE : DefaultNutrients?,
   @SerializedName("VITB12") var VITB12 : DefaultNutrients?,
   @SerializedName("VITD") var VITD : DefaultNutrients?,
   @SerializedName("TOCPHA") var TOCPHA : DefaultNutrients?,
   @SerializedName("VITK1") var VITK1 : DefaultNutrients?

) : Parcelable