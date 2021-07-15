package com.ahmedorabi.nutritiontask.ui.presentation.home

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.ahmedorabi.nutritiontask.R
import com.ahmedorabi.nutritiontask.databinding.FragmentHomeBinding
import com.ahmedorabi.nutritiontask.uils.toRecipe
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber


@AndroidEntryPoint
class HomeFragment : Fragment() {


    private lateinit var binding: FragmentHomeBinding
    private var foodText: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)


        initViews()


        return binding.root
    }


    private fun initViews() {

        binding.ed.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                foodText = s.toString()
                Timber.e(foodText)

                binding.analyzeBtn.isEnabled = foodText.length >= 5

            }

        })


        binding.analyzeBtn.setOnClickListener {

            val recipe = foodText.toRecipe()

            val bundle = Bundle()
            bundle.putParcelable("recipe", recipe)

            Navigation.findNavController(binding.root)
                .navigate(R.id.action_homeFragment_to_userDetailFragment, bundle)


        }


    }

}