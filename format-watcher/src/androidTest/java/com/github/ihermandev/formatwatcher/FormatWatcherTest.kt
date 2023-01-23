package com.github.ihermandev.formatwatcher

import android.text.Editable
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
internal class FormatWatcherTest {
    private lateinit var formatWatcher: FormatWatcher
    private lateinit var editable: Editable

    @Before
    fun setUp() {
        editable = Editable.Factory.getInstance().newEditable("")
    }

    @Test
    fun testFormattingSet1() {
        formatWatcher = FormatWatcher("#.#-#.##", '#')
        editable.append("123456789")
        formatWatcher.afterTextChanged(editable)
        assertEquals("1.2-3.456789", editable.toString())
    }

    @Test
    fun testFormattingSet2() {
        formatWatcher = FormatWatcher("+##-###-###-###", '#')
        editable.append("123456789")
        formatWatcher.afterTextChanged(editable)
        assertEquals("+12-345-678-9", editable.toString())
    }

    @Test
    fun testFormattingSet3() {
        formatWatcher = FormatWatcher("++##--###--###--###-", '#')
        editable.append("123456789000")
        formatWatcher.afterTextChanged(editable)
        assertEquals("++12--345--678--900-0", editable.toString())
    }
}