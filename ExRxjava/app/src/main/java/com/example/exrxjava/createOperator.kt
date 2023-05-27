package com.example.exrxjava

import android.os.Build.VERSION_CODES.O
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.ObservableOnSubscribe
import java.lang.Exception

fun createOperator(): Observable<Int> {
    val mListNum = mutableListOf(1, 2, 3, 4, 5)
    return Observable.create(ObservableOnSubscribe {
        try {
            for (i in mListNum) {
                it.onNext(i * 5)
            }

            it.onComplete()

        } catch (e: Exception) {
            it.onError(e)
        }
    })
}