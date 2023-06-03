package com.example.exrxjava

import io.reactivex.rxjava3.core.Observable

fun getNum1To100(): Observable<Int> {
    return Observable.range(1, 100)
}

fun getNum101To150(): Observable<Int> {
    return Observable.range(101, 50)
}

fun concat(): Observable<Int> {
    return Observable.concat(getNum1To100(), getNum101To150())
}