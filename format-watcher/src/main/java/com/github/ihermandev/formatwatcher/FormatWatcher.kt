package com.github.ihermandev.formatwatcher

import android.text.Editable
import android.text.TextWatcher
import kotlin.math.abs

/**
 * A class which implements [android.text.TextWatcher] interface and applies custom format to EditText input
 *
 * Example
 * <code>
 *     editText.addTextChangedListener(FormatWatcher("***-***-***-***"))
 * </code>
 *
 * @property format format string to be applied to the input. Example: ***-***-***-***
 * @property placeholderInFormat character to be used as a placeholder in the format, by default is '*"
 *
 */
class FormatWatcher(
    private val format: String,
    private val placeholderInFormat: Char = DEFAULT_CHAR_IN_FORMAT,
) : TextWatcher {

    // flag to indicate whether the formatting is active
    private var isFormatApplying = false

    // flag to indicate whether the input is removing
    private var isCharRemoving = false

    // flag to indicate whether the input is copied from somewhere
    private var isInputCopied = false

    // Length of format mask
    private val formatLength by lazy {
        format.length
    }

    /**
     * @see [android.text.TextWatcher.onTextChanged]
     */
    override fun onTextChanged(charSequence: CharSequence, start: Int, before: Int, count: Int) {
        // Check if the format is already in use
        if (isFormatApplying) return
        // Check removing and copied text
        if (abs(count - before) == 1) {
            isCharRemoving = before > count
            isInputCopied = true
        } else {
            isCharRemoving = false
            isInputCopied = false
        }
    }

    /**
     * @see [android.text.TextWatcher.afterTextChanged]
     */
    override fun afterTextChanged(editable: Editable) {
        // Check if the format is already in use
        if (isFormatApplying) return
        // Check if the editable is removing
        if (isCharRemoving) return

        isFormatApplying = true

        if (!isInputCopied) {
            // apply the format to copied text
            applyFormat(editable)
        } else {
            // apply the format to new input
            val editableLength = editable.length
            if (editableLength <= formatLength) {
                var internalEditableLength = editableLength
                if (format[editableLength - 1] != placeholderInFormat && editable.last() != format[internalEditableLength - 1]) {
                    var formatIndex = internalEditableLength - 1
                    editable.insert(internalEditableLength - 1, format[formatIndex].toString())

                    for (i in formatIndex until formatLength - 1) {
                        val checkNext = format.zipWithNext()[formatIndex]
                        if (checkNext.second != placeholderInFormat) {
                            editable.insert(internalEditableLength++, checkNext.second.toString())
                            formatIndex++
                        } else {
                            break
                        }
                    }
                }
            }

        }
        // Reset flags
        isFormatApplying = false
        isInputCopied = false
    }

    /**
     * @see [android.text.TextWatcher.beforeTextChanged]
     */
    override fun beforeTextChanged(
        charSequence: CharSequence,
        start: Int,
        count: Int,
        after: Int,
    ) {
    }

    /**
     * Applies the format to the editable
     *
     * @param editable the pasted text
     */
    private fun applyFormat(editable: Editable) {
        format.forEachIndexed { index, currentChar ->
            if (currentChar != placeholderInFormat && editable.getOrElse(index) { return } != currentChar) {
                editable.insert(index, currentChar.toString())
            } else {
                return@forEachIndexed
            }
        }
    }

    companion object {
        const val DEFAULT_CHAR_IN_FORMAT = '*'
    }
}
