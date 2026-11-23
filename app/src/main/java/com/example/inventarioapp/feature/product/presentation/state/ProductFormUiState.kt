package com.example.inventarioapp.feature.product.presentation.state

data class ProductFormUiState(
    val name: String = "",
    val description: String = "",
    val price: String = "",
    val quantity: String = "0",
    val saving: Boolean = false,
    val error: String? = null,
    val saved: Boolean = false
)