package com.abnesc.basicscodelab

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

    init {
        populateItems()
    }

    private fun populateItems() {
        _uiState.update { it ->
            it.copy(items = List(1000) {
                MainItem(name = "$it", selected = false)
            })
        }
    }

    fun onFavoriteItem(itemToUpdate: MainItem) {
        _uiState.update {
            val newItems = mutableListOf<MainItem>()

            it.items.forEach { item ->
                if (itemToUpdate == item) {
                    newItems.add(item.copy(selected = !itemToUpdate.selected))
                } else {
                    newItems.add(item)
                }
            }

            return@update it.copy(items = newItems)
        }
    }
}
