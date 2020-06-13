package com.mysasse.propscout.ui.properties

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mysasse.propscout.R
import com.mysasse.propscout.data.models.Property
import com.mysasse.propscout.databinding.ItemPropertyBinding

class PropertiesAdapter : RecyclerView.Adapter<PropertiesAdapter.PropertyHolder>() {

    var properties: List<Property>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PropertyHolder(
        DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_property,
            parent,
            false
        )
    )


    override fun getItemCount() = properties?.size ?: 0

    override fun onBindViewHolder(holder: PropertyHolder, position: Int) {
        holder.binding.property = properties!![position]
    }


    inner class PropertyHolder(val binding: ItemPropertyBinding) :
        RecyclerView.ViewHolder(binding.root)
}