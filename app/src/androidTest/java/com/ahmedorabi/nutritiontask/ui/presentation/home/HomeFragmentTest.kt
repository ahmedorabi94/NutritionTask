package com.ahmedorabi.nutritiontask.ui.presentation.home

import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.ahmedorabi.nutritiontask.R
import com.ahmedorabi.nutritiontask.ui.presentation.EspressoIdlingResourceRule
import com.ahmedorabi.nutritiontask.ui.presentation.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class HomeFragmentTest {

    @get:Rule
    val activityTestRule = ActivityScenarioRule(MainActivity::class.java)

    @get: Rule
    val espressoIdlingResoureRule = EspressoIdlingResourceRule()


    @Test
    fun isHomeFragmentDis() {
        onView(withId(R.id.homeFragmentId)).check(matches(isDisplayed()))

    }


    @Test
    fun isAnalyzeButtonEnabled() {

        onView(withId(R.id.ed)).check(matches(isDisplayed()))
        onView(withId(R.id.ed)).perform(
            typeText(
                "1 cup rice\n" +
                        "10 oz chickpeas"
            )
        )
        onView(withId(R.id.analyzeBtn)).check(matches(isDisplayed()))
        onView(withId(R.id.analyzeBtn)).check(matches(isEnabled()))


    }

    @Test
    fun isIngredientListFragmentDisplayed() {

        onView(withId(R.id.ed)).check(matches(isDisplayed()))
        onView(withId(R.id.ed)).perform(
            typeText(
                "1 cup rice\n" +
                        "10 oz chickpeas"
            )
        )

        closeSoftKeyboard()
        onView(withId(R.id.analyzeBtn)).perform(click())

        // check IngredientListFragment is Displayed
        onView(withId(R.id.ingredientListFragmentId)).check(matches(isDisplayed()))
        onView(withId(R.id.recycler_view_main)).check(matches(isDisplayed()))
        onView(withId(R.id.showTotalBtn)).check(matches(isDisplayed()))

        onView(withId(R.id.showTotalBtn)).perform(click())

        // check TotalNutritionFactsFragment is Displayed
        onView(withId(R.id.totalNutritionFactsId)).check(matches(isDisplayed()))
        onView(withId(R.id.title)).check(matches((withText("Nutrition Facts"))))

    }


}