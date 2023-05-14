package com.example.mediasearchapp

import android.os.Build.VERSION_CODES.S
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mediasearchapp.model.ImageItem
import com.example.mediasearchapp.model.ListItem
import com.example.mediasearchapp.model.VideoItem
import com.example.mediasearchapp.repository.SearchRepository
import io.reactivex.rxjava3.disposables.CompositeDisposable

class SearchViewModel(private val searchRepository: SearchRepository) : ViewModel() {

    private val _listLivaData = MutableLiveData<List<ListItem>>()
    val listLiveData: LiveData<List<ListItem>> get() = _listLivaData

    private val _showLoading = MutableLiveData<Boolean>()
    val showLoading: LiveData<Boolean> get() = _showLoading

    private var disposable: CompositeDisposable? = CompositeDisposable()

    fun search(query: String) {
        disposable?.add(searchRepository.search(query)
            .doOnSubscribe { _showLoading.value = true }
            .doOnTerminate { _showLoading.value = false }
            .subscribe({ list -> _listLivaData.value = list },
                { _listLivaData.value = emptyList() })
        )
    }

    fun toggleFavorite(item: ListItem) {
        _listLivaData.value = _listLivaData.value?.map {
            if (it == item) {
                when (it) {
                    is ImageItem -> {
                        it.copy(isFavorite = !item.isFavorite)
                    }

                    is VideoItem -> {
                        it.copy(isFavorite = !item.isFavorite)
                    }

                    else -> {
                        it
                    }
                }.also { changItem ->
                    if (Common.favoritesList.contains(item)) {
                        Common.favoritesList.remove(item)
                    } else {
                        Common.favoritesList.add(changItem)
                    }
                }
            } else {
                it
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
        disposable = null
    }

    class SearchViewModelFactory(private val searchRepository: SearchRepository) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return SearchViewModel(searchRepository) as T
        }
    }
}