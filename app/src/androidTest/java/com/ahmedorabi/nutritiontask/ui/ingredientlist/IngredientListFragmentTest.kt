package com.ahmedorabi.nutritiontask.ui.ingredientlist

import android.os.Bundle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.ahmedorabi.nutritiontask.R
import com.ahmedorabi.nutritiontask.atPosition
import com.ahmedorabi.nutritiontask.data.model.Recipe
import com.ahmedorabi.nutritiontask.launchFragmentInHiltContainer
import com.ahmedorabi.nutritiontask.ui.EspressoIdlingResourceRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class IngredientListFragmentTest {


    @get: Rule
    val espressoIdlingResoureRule = EspressoIdlingResourceRule()


    @Test
    fun isIngredientListFragmentDisplayed() {


        val recipe = Recipe(arrayListOf("1 cup rice", "10 oz chickpeas"))
        val bundle = Bundle()
        bundle.putParcelable("recipe", recipe)

        launchFragmentInHiltContainer<IngredientListFragment>(bundle)


        onView(withId(R.id.ingredientListFragmentId)).check(matches(isDisplayed()))
        onView(withId(R.id.recycler_view_main)).check(matches(isDisplayed()))
        onView(withId(R.id.showTotalBtn)).check(matches(isDisplayed()))


        onView(withId(R.id.recycler_view_main))
            .check(matches(atPosition(0, hasDescendant(withText("rice")))))


    }


}