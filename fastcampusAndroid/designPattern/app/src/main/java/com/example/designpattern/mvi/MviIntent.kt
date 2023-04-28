package com.example.designpattern.mvi

sealed class MviIntent {
    object LoadImage:MviIntent()
}