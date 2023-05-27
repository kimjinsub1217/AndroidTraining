package com.example.exrxjava

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.rxjava3.core.Observable
import java.util.concurrent.TimeUnit

fun timerOperator(): Observable<Long> {
    return Observable.timer(10, TimeUnit.SECONDS)
}
