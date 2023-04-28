package com.example.designpattern.mvi.repository

import com.example.designpattern.mvi.model.Image

interface ImageRepository {

    suspend fun getRandomImage(): Image
}