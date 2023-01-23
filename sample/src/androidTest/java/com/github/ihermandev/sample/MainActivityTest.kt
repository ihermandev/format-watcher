package com.github.ihermandev.sample

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

internal class MainActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testFormatWatcherSet1WorksAsExpected() {
        onView(withId(R.id.editText1)).perform(typeText(USER_INPUT_CHAR_5))
            .check(matches(withText("+1(234)-5")))
    }

    @Test
    fun testFormatWatcherSet2WorksAsExpected() {
        onView(withId(R.id.editText2)).perform(typeText(USER_INPUT_CHAR_8))
            .check(matches(withText("12/34/5678")))
    }

    @Test
    fun testFormatWatcherSet3WorksAsExpected() {
        onView(withId(R.id.editText3)).perform(typeText(USER_INPUT_CHAR_6))
            .check(matches(withText("12:34:56")))
    }

    @Test
    fun testFormatWatcherSet4WorksAsExpected() {
        onView(withId(R.id.editText4)).perform(typeText(USER_INPUT_CHAR_1))
            .check(matches(withText("September 1")))
    }

    @Test
    fun testFormatWatcherSet5WorksAsExpected() {
        onView(withId(R.id.editText5)).perform(typeText(USER_INPUT_CHAR_2))
            .check(matches(withText("$ 12")))
    }

    @Test
    fun testFormatWatcherSet6WorksAsExpected() {
        onView(withId(R.id.editText6)).perform(typeText(USER_INPUT_CHAR_5))
            .check(matches(withText("12-345")))
    }

    @Test
    fun testFormatWatcherSet7WorksAsExpected() {
        onView(withId(R.id.editText7)).perform(typeText(USER_INPUT_CHAR_16))
            .check(matches(withText("0123 4567 8912 3456")))
    }

    private companion object {
        const val USER_INPUT_CHAR_1 = "1"
        const val USER_INPUT_CHAR_2 = "12"
        const val USER_INPUT_CHAR_5 = "12345"
        const val USER_INPUT_CHAR_6 = "123456"
        const val USER_INPUT_CHAR_8 = "12345678"
        const val USER_INPUT_CHAR_16 = "0123456789123456"
    }
}