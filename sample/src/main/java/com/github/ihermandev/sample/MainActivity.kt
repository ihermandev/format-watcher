package com.github.ihermandev.sample

import android.os.Bundle
import android.widget.EditText
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.github.ihermandev.formatwatcher.FormatWatcher
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private val rootContainer by lazy {
        findViewById<ConstraintLayout>(R.id.container)
    }

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

    private val formatWatcher1 by lazy {
        FormatWatcher(getStringResource(R.string.format_set1),
            placeholderInFormat = '#')
    }

    private val formatWatcher2 by lazy {
        FormatWatcher(getStringResource(R.string.format_set2),
            placeholderInFormat = '*')
    }

    private val formatWatcher3 by lazy {
        FormatWatcher(getStringResource(R.string.format_set3),
            placeholderInFormat = '#')
    }

    private val formatWatcher4 by lazy {
        FormatWatcher(getStringResource(R.string.format_set4),
            placeholderInFormat = '#')
    }

    private val formatWatcher5 by lazy {
        FormatWatcher(getStringResource(R.string.format_set5),
            placeholderInFormat = '*')
    }

    private val formatWatcher6 by lazy {
        FormatWatcher(getStringResource(R.string.format_set6),
            placeholderInFormat = '#')
    }

    private val formatWatcher7 by lazy {
        FormatWatcher(getStringResource(R.string.format_set7),
            placeholderInFormat = '#')
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText1.handleEditTextFormatting(formatWatcher1)
        editText2.handleEditTextFormatting(formatWatcher2)
        editText3.handleEditTextFormatting(formatWatcher3)
        editText4.handleEditTextFormatting(formatWatcher4)
        editText5.handleEditTextFormatting(formatWatcher5)
        editText6.handleEditTextFormatting(formatWatcher6)
        editText7.handleEditTextFormatting(formatWatcher7)
    }

    private fun EditText.handleEditTextFormatting(
        formatWatcher: FormatWatcher,
    ) = this.apply {
        addTextChangedListener(formatWatcher)
        setOnLongClickListener {
            showSnackbarMessage(formatWatcher.rawInput, formatWatcher.currentInput)
            true
        }
    }

    private fun getStringResource(@StringRes id: Int): String = resources.getString(id)

    private fun showSnackbarMessage(rawInput: String, formattedInput: String) =
        Snackbar.make(rootContainer,
            "Raw input is ${rawInput.ifEmpty { "empty" }}; the length is ${rawInput.length} \n" +
                    "Formatted input is ${formattedInput.ifEmpty { "empty" }}; the length is ${formattedInput.length}",
            Snackbar.LENGTH_SHORT).show()
}