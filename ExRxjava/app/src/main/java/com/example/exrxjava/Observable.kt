package com.example.exrxjava

import android.util.Log
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.CompletableObserver
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Maybe
import io.reactivex.rxjava3.core.MaybeObserver
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.core.SingleObserver
import io.reactivex.rxjava3.disposables.Disposable

lateinit var disposable: Disposable
fun createObservable(): Observable<Int> {
    return Observable.create { emitter ->
        try {
            if (!emitter.isDisposed) {
                for (i in 0..100) {
                    emitter.onNext(i)
                }
                emitter.onComplete()
            }
        } catch (e: Exception) {
            emitter.onError(e)
        }

    }
}

fun observer(): Observer<Int> {
    return object : Observer<Int> {
        override fun onSubscribe(d: Disposable) {
            d.let { _ ->
                disposable = d
            }
            Log.d("getObserver", "onSubscribe")
        }

        override fun onError(e: Throwable) {
            Log.d("getObserver", "onError : $e")
        }

        override fun onComplete() {
            Log.d("getObserver", "onComplete")
        }

        override fun onNext(t: Int) {
            Log.d("getObserver", "onNext : $t")
        }

    }
}

fun createSingleObservable(): Single<List<NewJeans>> {
    return Single.create { emitter ->
        try {
            if (!emitter.isDisposed) {
                emitter.onSuccess(newJeansList)

            }
        } catch (e: Exception) {
            emitter.onError(e)
        }

    }
}

fun observerSingleObservable(): SingleObserver<List<NewJeans>> {
    return object : SingleObserver<List<NewJeans>> {
        override fun onSubscribe(d: Disposable) {
            Log.d("observerSingleObservable", "onSubscribe")
        }

        override fun onError(e: Throwable) {
            Log.d("observerSingleObservable", "onError")
        }

        override fun onSuccess(t: List<NewJeans>) {
            t.forEach { _ ->
                Log.d("observerSingleObservable", "onSuccess $t")
            }
        }


    }
}

fun createMaybeObservable(): Maybe<List<NewJeans>> {
    return Maybe.just(newJeansList)
}

fun observerMaybeObservable(): MaybeObserver<List<NewJeans>> {
    return object : MaybeObserver<List<NewJeans>> {
        override fun onSubscribe(d: Disposable) {
            Log.d("observerMaybeObservable", "onSubscribe")
        }

        override fun onError(e: Throwable) {
            Log.d("observerMaybeObservable", "onError : $e")
        }

        override fun onComplete() {
            Log.d("observerMaybeObservable", "onComplete")
        }

        override fun onSuccess(t: List<NewJeans>) {
            t.forEach { _ ->
                Log.d("observerMaybeObservable", "onSuccess : $t")
            }
        }
    }
}

fun createCompletableObservable(): Completable {
    return Completable.create { emitter ->
        try {
            if (!emitter.isDisposed) {
                Log.d("createCompletableObservable", "createCompletableObservable")
                emitter.onComplete()
            }
        } catch (e: Exception) {
            emitter.onError(e)
        }

    }
}

fun observerCompletableObservable(): CompletableObserver {
    return object : CompletableObserver {
        override fun onSubscribe(d: Disposable) {
            Log.d("observerCompletableObservable", "onSubscribe")
        }

        override fun onComplete() {
            Log.d("observerCompletableObservable", "onComplete")
        }

        override fun onError(e: Throwable) {
            Log.d("observerCompletableObservable", "onError")
        }

    }


}

// Flowable은 RxJava에서 제공하는 백압(Backpressure)을 지원하는 옵저버블(Observable)
// 백압은 발행자(Publisher)와 구독자(Subscriber) 간의 데이터 흐름을 제어하여 구독자가 처리할 수 있는 양의 데이터만 발행자에 요청하도록 하는 메커니즘
fun createFlowableObservable(): Flowable<Int> {
    return Flowable.range(1, 100)
}