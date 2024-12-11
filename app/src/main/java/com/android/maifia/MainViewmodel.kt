package com.android.maifia

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewmodel : ViewModel() {
    private val _uiState = MutableStateFlow(UiState.empty())
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()
}