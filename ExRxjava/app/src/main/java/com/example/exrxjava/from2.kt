package com.example.exrxjava

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable


fun main() {
    val mlistNum = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)

//    val observable = Observable.fromArray(*numbers)
//    observable.subscribe { numbers -> println(numbers) }
//        .let { _ -> }

    val observable =Observable.fromIterable(mlistNum)

    val observer = object:Observer<Int>{
        override fun onSubscribe(d: Disposable) {
            println("fromOperator :onSubscribe")
        }

        override fun onError(e: Throwable) {
            println("fromOperator :onError ${e.toString()}")
        }

        override fun onComplete() {
            println("fromOperator :onComplete")
        }

        override fun onNext(t: Int) {
            println("fromOperator :onNext : $t")
        }
    }

    observable.subscribe(observer)
}