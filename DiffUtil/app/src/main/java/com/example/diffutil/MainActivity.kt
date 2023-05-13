package com.example.diffutil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diffutil.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }



    private val myRecyclerViewAdapter: Adapter by lazy {
        Adapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 4)
            adapter = myRecyclerViewAdapter
        }

        binding.deleteButton.setOnClickListener{
            myRecyclerViewAdapter.delete()
        }

        binding.addButton.setOnClickListener{
            myRecyclerViewAdapter.add()
        }

        binding.randomButton.setOnClickListener{
            myRecyclerViewAdapter.deleteRandom()
        }

        myRecyclerViewAdapter.submitList(PokemonList)
    }
}