package com.example.designpattern.mvi.repository

import com.example.designpattern.RetrofitManger
import com.example.designpattern.mvi.model.Image
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ImageRepositoryImpl(private val dispatcher : CoroutineDispatcher = Dispatchers.IO):ImageRepository {
    override suspend fun getRandomImage() = withContext(dispatcher){
        RetrofitManger.imageService.getRandomImageSuspend().let {
            Image(it.urls.regular,it.color)
        }
    }
}