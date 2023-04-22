package com.example.designpattern.mvp.repository

interface ImageRepository {

    fun getRandomImage(callBack:CallBack)

    interface CallBack {
        fun loadImage(url: String, color: String)
    }
}