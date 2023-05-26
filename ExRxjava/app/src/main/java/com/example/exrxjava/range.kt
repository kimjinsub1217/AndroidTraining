package com.example.exrxjava

import io.reactivex.rxjava3.core.Observable

fun main() {
//    rangeOperator().subscribe(
//        {
//            println("rangeOperator :onNext : $it")
//        },
//        {
//            println("rangeOperator :onError ${it}")
//        },
//        {
//            println("rangeOperator :onComplete")
//        }
//    ).let { _ -> }

    repeatOperator().subscribe(
        {
            println("rangeOperator :onNext : $it")
        },
        {
            println("rangeOperator :onError ${it}")
        },
        {
            println("rangeOperator :onComplete")
        }
    ).let { _ -> }

}

fun rangeOperator(): Observable<Int> {
    return Observable.range(2, 10)
}

fun repeatOperator(): Observable<Int> {
    return Observable.range(1, 10).repeat(2)
}
