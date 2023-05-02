package com.example.mediasearchapp.model

import java.util.Date

interface ListItem {

    val thumbnailUrl:String
    val dateTime:Date
    var isFavorite:Boolean
}