package com.example.exrxjava

import io.reactivex.rxjava3.core.Observable

fun distinct(): Observable<NewJeans> {
    return Observable.fromIterable(newJeansList)
}
//fun main(){
//    Observable.just(1, 2, 2, 3, 4, 4, 5)
//        .distinct()
//        .subscribe { println(it) }
//}
