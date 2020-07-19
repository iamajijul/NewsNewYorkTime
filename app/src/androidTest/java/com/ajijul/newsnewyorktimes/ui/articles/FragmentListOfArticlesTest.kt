/*
package com.ajijul.newsnewyorktimes.ui.articles

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.ajijul.newsnewyorktimes.R
import com.ajijul.newsnewyorktimes.helper.TestUtils
import com.ajijul.newsnewyorktimes.ui.MainActivity
import com.ajijul.newsnewyorktimes.ui.adapters.viewholders.NewsViewHolders
import org.hamcrest.CoreMatchers
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class FragmentListOfArticlesTest{

    val LIST_ITEM_IN_TEST = 1
    val ARTICLE_IN_TEST = TestUtils.createTestArticle()[0]

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun a_test_isArticleListFragmentVisible_onAppLaunch() {
        Espresso.onView(withId(R.id.rvArticles))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(withId(R.id.progressBar))
            .check(ViewAssertions.matches(CoreMatchers.not(ViewMatchers.isDisplayed())))
    }

    @Test
    fun test_itemClickOnRecyclerView() {

        // Click list item
        Espresso.onView(withId(R.id.rvArticles))
            .perform(actionOnItemAtPosition<NewsViewHolders>(LIST_ITEM_IN_TEST, ViewActions.click()))


    }
}*/
