package com.example.mediasearchapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.mediasearchapp.model.ImageItem
import com.example.mediasearchapp.model.ListItem
import com.example.mediasearchapp.model.VideoItem
import com.example.mediasearchapp.repository.SearchRepository
import androidx.lifecycle.Observer
import io.reactivex.rxjava3.core.Observable
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import java.util.Date

@RunWith(MockitoJUnitRunner::class)
class SearchViewModelTest {

    @Rule
    @JvmField
    var rule = InstantTaskExecutorRule()

    @Mock
    lateinit var searchRepository: SearchRepository

    @Mock
    lateinit var mockLoadingObserver: Observer<Boolean>
    @Mock
    lateinit var mockListObserver: Observer<List<ListItem>>

    private lateinit var viewModel: SearchViewModel
    @Before
    fun setUp() {
        viewModel = SearchViewModel(searchRepository)
        viewModel.showLoading.observeForever(mockLoadingObserver)
        viewModel.listLiveData.observeForever(mockListObserver)
    }

    @Test
    fun searchNotEmptyList() {
        Mockito.`when`(searchRepository.search(anyString())).thenReturn(Observable.just(mockList()))
        viewModel.search("query")

        Mockito.verify(mockLoadingObserver, Mockito.times(1)).onChanged(true)
        Mockito.verify(mockListObserver, Mockito.times(1)).onChanged(Mockito.anyList())
        assertTrue(!viewModel.listLiveData.value.isNullOrEmpty())
    }

    @Test
    fun searchEmptyList() {
        Mockito.`when`(searchRepository.search(anyString())).thenReturn(Observable.just(emptyList()))
        viewModel.search("query")

        Mockito.verify(mockLoadingObserver, Mockito.times(1)).onChanged(true)
        Mockito.verify(mockListObserver, Mockito.times(1)).onChanged(Mockito.anyList())
        assertTrue(viewModel.listLiveData.value.isNullOrEmpty())
    }

    private fun mockList() = listOf(
        ImageItem("thumbnailUrl", "collection", "siteName", "docUrl", Date(), false),
        ImageItem("thumbnailUrl", "collection", "siteName", "docUrl", Date(), true),
        VideoItem("thumbnailUrl", "title", 3, "author", Date(), false)
    )
}