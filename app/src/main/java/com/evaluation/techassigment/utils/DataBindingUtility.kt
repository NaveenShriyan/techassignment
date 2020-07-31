package com.evaluation.techassigment.utils

import android.graphics.Typeface
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.evaluation.techassigment.application.Constants

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

    @JvmStatic
    @BindingAdapter("app:loadImage")
    fun loadImage(imageView: ImageView, url: String?) {

        val imageURL: String? = url ?: Constants.DEFAULT_IMAGE_URL

        Glide.with(imageView.context)
            .load(imageURL)
            .into(imageView)
    }

    @JvmStatic
    @BindingAdapter("app:title")
    fun setTitle(textView: TextView, title: String?) {
        textView.text = title ?: Constants.DEFAULT_TITLE
    }

    @JvmStatic
    @BindingAdapter("app:description")
    fun setDescription(textView: TextView, desc: String?) {
        textView.text =
            desc ?: Constants.DEFAULT_DESC
    }
}