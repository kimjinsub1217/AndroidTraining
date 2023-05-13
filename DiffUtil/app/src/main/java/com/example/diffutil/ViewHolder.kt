package com.example.diffutil


import androidx.recyclerview.widget.RecyclerView
import com.example.diffutil.databinding.LayoutViewholderBinding
import com.google.android.material.snackbar.Snackbar

class ViewHolder(private val binding: LayoutViewholderBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(data: Pokemon){
        with(binding){
            imageView.setImageResource(data.Image)
            textView.text =data.name

            layoutViewHolder.setOnClickListener{
                Snackbar.make(it,"${data.name} 입니다",Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}