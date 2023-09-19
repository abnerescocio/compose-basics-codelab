package com.abnesc.basicscodelab

data class MainUiState(
    val items: List<MainItem> = emptyList()
)

data class MainItem(
    val name: String = "",
    val selected: Boolean = false,
)