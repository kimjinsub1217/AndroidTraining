package com.example.exrxjava

import io.reactivex.rxjava3.core.Observable

fun getNewJeansProgile(id: Long): Observable<NewJeansProfile> {
    return Observable.fromIterable(newJeansProfileList)
        .filter {
            it.id == id
        }
}