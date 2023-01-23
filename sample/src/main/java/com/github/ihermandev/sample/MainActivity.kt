package com.github.ihermandev.sample

import android.os.Bundle
import android.widget.EditText
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.github.ihermandev.formatwatcher.FormatWatcher

class MainActivity : AppCompatActivity() {

    private val editText1 by lazy {
        findViewById<EditText>(R.id.editText1)
    }

    private val editText2 by lazy {
        findViewById<EditText>(R.id.editText2)
    }

    private val editText3 by lazy {
        findViewById<EditText>(R.id.editText3)
    }

    private val editText4 by lazy {
        findViewById<EditText>(R.id.editText4)
    }

    private val editText5 by lazy {
        findViewById<EditText>(R.id.editText5)
    }

    private val editText6 by lazy {
        findViewById<EditText>(R.id.editText6)
    }

    private val editText7 by lazy {
        findViewById<EditText>(R.id.editText7)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText1.addTextChangedListener(FormatWatcher(getStringResource(R.string.format_set1),
            placeholderInFormat = '#'))
        editText2.addTextChangedListener(FormatWatcher(getStringResource(R.string.format_set2),
            placeholderInFormat = '*'))
        editText3.addTextChangedListener(FormatWatcher(getStringResource(R.string.format_set3),
            placeholderInFormat = '#'))
        editText4.addTextChangedListener(FormatWatcher(getStringResource(R.string.format_set4),
            placeholderInFormat = '#'))
        editText5.addTextChangedListener(FormatWatcher(getStringResource(R.string.format_set5),
            placeholderInFormat = '*'))
        editText6.addTextChangedListener(FormatWatcher(getStringResource(R.string.format_set6),
            placeholderInFormat = '#'))
        editText7.addTextChangedListener(FormatWatcher(getStringResource(R.string.format_set7),
            placeholderInFormat = '#'))
    }

    private fun getStringResource(@StringRes id: Int): String = resources.getString(id)
}