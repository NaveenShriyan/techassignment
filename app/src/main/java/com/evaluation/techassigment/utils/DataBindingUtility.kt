package com.evaluation.techassigment.utils

import android.graphics.Typeface
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter

/**
 * Created by Naveen on 27-07-2020.
 */
object DataBindingUtility {
    @JvmStatic
    @BindingAdapter("app:typeface")
    fun setTypeface(textView: AppCompatTextView, style: String) {
        when (style) {
            "bold" -> textView.setTypeface(null, Typeface.BOLD)
            "italic" -> {
                textView.setTypeface(null, Typeface.ITALIC)
                textView.setTypeface(null, Typeface.NORMAL)
            }
            else -> textView.setTypeface(null, Typeface.NORMAL)
        }
    }
}