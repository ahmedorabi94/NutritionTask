package com.ahmedorabi.nutritiontask.ui.totalnutritionfacts

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.ahmedorabi.nutritiontask.R
import com.ahmedorabi.nutritiontask.data.model.NutritionResponse
import com.ahmedorabi.nutritiontask.databinding.FragmentTotalNutritionFactsBinding
import com.ahmedorabi.nutritiontask.uils.getRoundFloat
import kotlin.math.roundToInt


class TotalNutritionFacts : Fragment() {

    private var response: NutritionResponse? = null
    private lateinit var binding: FragmentTotalNutritionFactsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            response = it.getParcelable("NutritionResponse")
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_total_nutrition_facts,
            container,
            false
        )

        updateUI()



        return binding.root
    }

    @SuppressLint("SetTextI18n")
    fun updateUI() {
        response?.let {


            binding.nutritionResponse = it
            binding.totalDaily = it.totalDaily
            binding.totalNutrient = it.totalNutrients





            if (it.totalNutrients.FIBTG != null) {
                binding.fiberName.text =
                    "${it.totalNutrients.FIBTG?.label ?: ""} ${it.totalNutrients.FIBTG?.quantity?.getRoundFloat()} ${it.totalNutrients.FIBTG?.unit ?: ""}"
            } else {
                binding.fiberName.text =
                    "${"Dietary Fiber"} ${"-"}"
            }


            if (it.totalDaily.FIBTG != null) {
                binding.fiberValueTv.text =
                    "${it.totalDaily.FIBTG?.quantity?.roundToInt()} ${it.totalDaily.FIBTG?.unit ?: ""}"
            } else {
                binding.fiberValueTv.text =
                    "-"
            }

            if (it.totalNutrients.SUGAR != null) {
                binding.sugarsName.text =
                    "${it.totalNutrients.SUGAR?.label ?: ""} ${it.totalNutrients.SUGAR?.quantity?.getRoundFloat()} ${it.totalNutrients.SUGAR?.unit ?: ""}"

            } else {
                binding.sugarsName.text =
                    "${"Total Sugars"} ${"-"}"
            }


        }


    }

}