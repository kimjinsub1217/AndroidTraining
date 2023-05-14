package com.example.mediasearchapp.repository


import com.example.mediasearchapp.model.ListItem
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.Query

interface SearchRepository {
    fun search(query: String): Observable<List<ListItem>>
}