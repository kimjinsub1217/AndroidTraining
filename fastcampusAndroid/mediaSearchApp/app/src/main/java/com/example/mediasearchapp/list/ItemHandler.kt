package com.example.mediasearchapp.list

import com.example.mediasearchapp.model.ListItem

interface ItemHandler {
    fun onClickFavorite(item: ListItem)
}