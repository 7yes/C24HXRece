package com.jes.c24hxrece.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jes.c24hxrece.R
import com.jes.c24hxrece.data.model.SampleResponseItem

class AdapterSample(private val list: List<SampleResponseItem>) :
    RecyclerView.Adapter<ViewHolderSample>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderSample {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolderSample(layoutInflater.inflate(R.layout.item_small, parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolderSample, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

}
