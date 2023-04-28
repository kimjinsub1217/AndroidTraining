package com.example.designpattern.mvi

import com.example.designpattern.mvi.model.Image

sealed class MviState{
    object Idle:MviState()
    object Loading:MviState()
    data class loadedImage(val image: Image, val count:Int):MviState()

}
