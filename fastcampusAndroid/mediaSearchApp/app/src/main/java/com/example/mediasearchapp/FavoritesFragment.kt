package com.example.mediasearchapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mediasearchapp.databinding.FragmentFavoritesBinding
import com.example.mediasearchapp.list.ListAdapter


class FavoritesFragment : Fragment() {
    private var binding: FragmentFavoritesBinding? = null

    private val adapter by lazy { ListAdapter() }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentFavoritesBinding.inflate(inflater, container, false).apply {
            binding = this
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            recyclerView.adapter = adapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}