package com.example.exrxjava

import io.reactivex.rxjava3.core.Observable

fun map(): Observable<NewJeans> {
    return Observable.fromIterable(newJeansList)
}
fun main(){
    Observable.range(1, 5)
        .map { number -> number * 2 }
        .subscribe { result -> println(result) }
        .let {  }
}
