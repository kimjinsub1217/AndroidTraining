package com.example.designpattern.mvvm.repository

import com.example.designpattern.mvvm.model.Image
import io.reactivex.Single

interface ImageRepository {

    fun getRandomImage(): Single<Image>
}