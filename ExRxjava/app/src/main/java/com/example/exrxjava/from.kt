package com.example.exrxjava

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import java.util.Arrays

val mlistNum = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)

//fun from() {
//    val observable = Observable.just(mlistNum)
//    val observer = object : Observer<List<Int>> {
//        override fun onSubscribe(d: Disposable) {
//            println("onSubscribe")
//        }
//
//        override fun onError(e: Throwable) {
//            println("onError ${e.toString()}")
//        }
//
//        override fun onComplete() {
//            println("onComplete")
//        }
//
//        override fun onNext(t: List<Int>) {
//            println("onNext : $t")
//        }
//
//
//    }
//    // Observer를 Observable에 구독한다. 이를 통해 Observable은 데이터를 발행하고
//    // Observer는 해당 데이터를 처리하게 됩니다.
//    observable.subscribe(observer)
//}
val arrayNum = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)
val arrayNum2 = arrayOf(10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120)
fun main() {
    val observable = Observable.fromArray(arrayNum,arrayNum2)

    val observer = object : Observer<Array<Int>> {
        override fun onSubscribe(d: Disposable) {
            println("fromOperator :onSubscribe")
        }

        override fun onError(e: Throwable) {
            println("fromOperator :onError ${e.toString()}")
        }

        override fun onComplete() {
            println("fromOperator :onComplete")
        }

        override fun onNext(t: Array<Int>) {
            println("fromOperator :onNext : ${t.contentToString()}")
        }
    }
    observable.subscribe(observer)
}
