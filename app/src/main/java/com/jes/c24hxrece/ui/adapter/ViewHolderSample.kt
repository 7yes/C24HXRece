package com.jes.c24hxrece.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.jes.c24hxrece.data.model.SampleResponseItem
import com.jes.c24hxrece.databinding.ItemSmallBinding

class ViewHolderSample(view: View) : RecyclerView.ViewHolder(view) {
    //class ViewHolder ( view : View ) : RecyclerView.ViewHolder ( view ) {
    private val binding = ItemSmallBinding.bind(view)

    fun bind(item: SampleResponseItem) {
        binding.tvName.text = item.name
        binding.tvDescription.text = item.description
    }
}

