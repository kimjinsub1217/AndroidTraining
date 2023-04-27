package com.example.designpattern.mvvm.repository

import com.example.designpattern.RetrofitManger
import com.example.designpattern.mvvm.model.Image
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit

class ImageRepositoryImpl:ImageRepository {
    override fun getRandomImage() = RetrofitManger.imageService.getRandomImageRx()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .flatMap { item->
            Single.just(Image(item.urls.regular,item.color))
        }
}