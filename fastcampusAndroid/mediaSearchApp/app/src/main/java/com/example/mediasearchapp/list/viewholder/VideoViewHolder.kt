package com.example.mediasearchapp.list.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.mediasearchapp.databinding.ItemVideoBinding
import com.example.mediasearchapp.list.ItemHandler
import com.example.mediasearchapp.model.ListItem
import com.example.mediasearchapp.model.VideoItem

class VideoViewHolder(
    private val binding: ItemVideoBinding,
    private val itemHandler: ItemHandler? = null
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: ListItem) {
        item as VideoItem
        binding.item = item
        binding.handler = itemHandler
    }
}