package com.example.exrxjava

import io.reactivex.rxjava3.core.Observable

fun startWith(): Observable<Int> {
    return getNum101To150().startWith(getNum1To100())
}

fun main(){
    val originalObservable = Observable.just("D", "F", "G")
    val startObservable = Observable.just("A", "B", "C")

    originalObservable
        .startWith(startObservable)
        .subscribe { value ->
            println(value)
        }.let {  }
}