package com.android.maifia

data class UiState(
    val title: String?,
) {
    companion object {
        fun empty(
            title: String? = null,
        ) = UiState(
            title = title
        )
    }
}
