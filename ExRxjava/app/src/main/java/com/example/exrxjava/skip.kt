package com.example.exrxjava

import io.reactivex.rxjava3.core.Observable

fun skip(): Observable<NewJeans> {
    return Observable.fromIterable(newJeansList)
}

fun main(){
    Observable.range(1, 10)
        .skipLast(2)
        .subscribe(System.out::println)
        .let {  }
}