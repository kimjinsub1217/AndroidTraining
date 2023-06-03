package com.example.exrxjava

import io.reactivex.rxjava3.core.Observable

fun groupBy(): Observable<NewJeans> {
    return Observable.fromIterable(newJeansList)
}