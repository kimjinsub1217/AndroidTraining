package com.example.exrxjava

import io.reactivex.rxjava3.core.Observable

fun merge(): Observable<NewJeans> {
    return Observable.fromIterable(newJeansList)
}

fun mergea2(): Observable<NewJeans> {
    return Observable.fromIterable(newJeansList2)
}

fun newJeansMerge(): Observable<Any> {
    return Observable.merge(merge(), mergea2())
}
