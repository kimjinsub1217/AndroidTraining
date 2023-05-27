package com.example.exrxjava

import android.util.Log
import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

fun main() {

// 중지하거나 앱이 종료할 때까지 돌아감
}



fun intervalOperator(): Observable<Long> {
    return Observable.interval(5, 2, TimeUnit.SECONDS).takeWhile { value ->
        value <= 5
    }
}