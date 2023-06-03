package com.example.exrxjava

import io.reactivex.rxjava3.core.Observable

fun flatmap(): Observable<NewJeans> {
    return Observable.fromIterable(newJeansList)
}

fun main() {
    Observable.range(1, 3)
        .flatMap { number -> Observable.just(number, number * 2, number * 3) }
        .subscribe { result -> println(result) }
        .let { }
}
