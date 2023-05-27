package com.example.exrxjava

import io.reactivex.rxjava3.core.Observable

fun filter():Observable<NewJeans>{
    return Observable.fromIterable(newJeansList)
}

val newJeansList= mutableListOf<NewJeans>(
    NewJeans(1,"민지",20),
    NewJeans(2,"하니",20),
    NewJeans(3,"다니엘",19),
    NewJeans(4,"해린",18),
    NewJeans(5,"혜인",16),
)

data class NewJeans
(
    val id: Long,
    val name: String,
    val age: Int
)