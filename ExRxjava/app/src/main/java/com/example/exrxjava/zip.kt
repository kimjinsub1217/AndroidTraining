package com.example.exrxjava

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.functions.BiFunction

fun zip(): Observable<Any> {
    val num = Observable.just(1, 2, 3, 4, 5)
    val char = Observable.just("A", "B", "C", "D")
    return Observable.zip(num, char, BiFunction { t1, t2 ->
        "$t1$t2"
    })
}