package com.mysasse.propscout.data.models

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.gson.annotations.SerializedName
import com.mysasse.propscout.R
import com.mysasse.propscout.data.PROPERTY_IMAGE_BONDING

data class Property(
    val id: Int,
    val category: String,
    val name: String,
    val price: Double,
    val period: String,
    val location: String,
    val lat: Double,
    val lng: Double,
    @SerializedName("file")
    private val _file: String
) {
    val file: String
        get() = "https://old.propscout.co.ke${_file}"

    companion object {
        @JvmStatic
        @BindingAdapter(PROPERTY_IMAGE_BONDING)
        fun loadImage(view: ImageView, url: String) {
            Glide.with(view.context).load(url).centerCrop()
                .placeholder(R.drawable.ic_baseline_house).into(view)
        }
    }
}