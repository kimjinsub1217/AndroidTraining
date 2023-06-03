package com.example.exrxjava

import io.reactivex.rxjava3.core.Observable

fun buffer(): Observable<NewJeans> {
    return Observable.fromIterable(newJeansList)
}