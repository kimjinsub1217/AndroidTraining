package com.example.diffutil

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.diffutil.databinding.LayoutViewholderBinding
import kotlin.random.Random


class Adapter : ListAdapter<Pokemon, RecyclerView.ViewHolder>(diffCallback()) {
//    뷰홀더의 XML를 Inflater해서 전달을 해준다.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewHolder = ViewHolder(
            LayoutViewholderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
        return viewHolder
    }

//    포지션을 전달받아 해당되는 데이터와 뷰홀더를 묶어준다.
//    전달받은 Holder가 ViewHolder라면 getItem으로 해당 되는 포지션을 받아와서 포켓몬 데이터를 꺼내온다.
//    꺼내온 데이터를 holder와 bind를 시키고
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is ViewHolder){
            val pokemon =getItem(position) as Pokemon
            holder.bind(pokemon)
        }
    }

    fun add() {
        val newPokemon = mutableListOf<Pokemon>()
        newPokemon.addAll(currentList)
        newPokemon.add(PokemonList.random())
        submitList(newPokemon)
    }

    fun delete() {
        val newPokemon = mutableListOf<Pokemon>()
        newPokemon.addAll(currentList)
        newPokemon.removeAt(0)
        submitList(newPokemon)
    }

    fun deleteRandom() {
        val newPokemon = mutableListOf<Pokemon>()
        newPokemon.addAll(currentList)
        val index = (Random.nextDouble() * currentList.size).toInt()
        newPokemon.removeAt(index)
        submitList(newPokemon)
    }

}