package com.ahmedorabi.nutritiontask.ui.ingredientlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.ahmedorabi.nutritiontask.R
import com.ahmedorabi.nutritiontask.data.api.Resource
import com.ahmedorabi.nutritiontask.data.model.NutritionResponse
import com.ahmedorabi.nutritiontask.data.model.Parsed
import com.ahmedorabi.nutritiontask.data.model.Recipe
import com.ahmedorabi.nutritiontask.databinding.FragmentIngredientListBinding
import com.ahmedorabi.nutritiontask.ui.adapter.RecipeAdapter
import com.ahmedorabi.nutritiontask.ui.adapter.RecipeCallback
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber


@AndroidEntryPoint
class IngredientListFragment : Fragment() {

    private var foodText: Recipe? = null


    private val viewModel: IngredientListViewModel by viewModels()
    private lateinit var binding: FragmentIngredientListBinding

    private var response: NutritionResponse? = null


    private val callback = object : RecipeCallback {
        override fun onItemClick(data: Parsed) {
            Timber.e(data.food)

        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            foodText = it.getParcelable("recipe")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_ingredient_list, container, false)



        foodText?.let {
            viewModel.foodText.value = it
        }


        viewModel.items.observe(viewLifecycleOwner, {
            it?.let { resource ->


                when (resource.status) {
                    Resource.Status.SUCCESS -> {

                        resource.data?.let { currencyResponse ->
                            Timber.e("SUCCESS")
                            Timber.e("${currencyResponse.calories}")

                            response = currencyResponse


                            val intg = currencyResponse.ingredients


                            val arrlist = ArrayList<Parsed>()

                            for (item in intg) {
                                item?.let { ing ->
                                    ing.parsed?.let { parse ->
                                        arrlist.add(parse[0]!!)
                                    }

                                }

                            }

                            binding.progressbar.visibility = View.GONE
                            binding.recyclerViewMain.visibility = View.VISIBLE

                            val adapter = RecipeAdapter(callback, viewModel)
                            adapter.submitList(arrlist)
                            binding.recyclerViewMain.adapter = adapter

                        }

                    }
                    Resource.Status.ERROR -> {

                        Timber.e(it.message)
                        binding.progressbar.visibility = View.GONE
                        binding.recyclerViewMain.visibility = View.VISIBLE

                        Toast.makeText(activity, it.message, Toast.LENGTH_LONG).show()
                    }
                    Resource.Status.LOADING -> {
                        Timber.e("LOADING")
                        binding.progressbar.visibility = View.VISIBLE
                        binding.recyclerViewMain.visibility = View.GONE
                    }
                }
            }
        })


        binding.showTotalBtn.setOnClickListener {

            val bundle = Bundle()
            bundle.putParcelable("NutritionResponse", response)

            Navigation.findNavController(it)
                .navigate(R.id.action_userDetailFragment_to_totalNutritionFacts, bundle)
        }




        return binding.root
    }

}