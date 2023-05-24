package com.example.exrxjava

import io.reactivex.rxjava3.core.Observable

fun main(){
    // 단일 항목을 발행하는 Observable 생성
    Observable.just("치토스", "포카칩", "빼빼로")
        .subscribe(::println)
        .let { _ -> }


}