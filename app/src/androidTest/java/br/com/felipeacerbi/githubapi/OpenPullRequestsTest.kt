package br.com.felipeacerbi.githubapi

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import br.com.felipeacerbi.githubapi.repos.view.ReposActivity
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class OpenPullRequestsTest {

    @Rule
    @JvmField
    val activityTestRule: ActivityTestRule<ReposActivity>
            = ActivityTestRule(ReposActivity::class.java, true, false)

    @Test
    fun navigateTabs() {
        activityTestRule.launchActivity(null)

        onView(withText("JAVA")).check(matches(isDisplayed()))
        onView(withText("JAVASCRIPT")).check(matches(isDisplayed()))
        onView(withText("NODE.JS")).check(matches(isDisplayed()))

        onView(withText("JAVASCRIPT")).perform(click())
        onView(withText("JAVASCRIPT")).check(matches(isSelected()))

        onView(withText("NODE.JS")).perform(click())
        onView(withText("NODE.JS")).check(matches(isSelected()))

        onView(withText("JAVA")).perform(click())
        onView(withText("JAVA")).check(matches(isSelected()))

        onView(allOf(withId(R.id.rv_list), isDisplayed())).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
    }

}
