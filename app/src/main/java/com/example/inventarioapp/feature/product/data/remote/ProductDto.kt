package com.example.inventarioapp.feature.product.data.remote

import com.google.firebase.firestore.PropertyName

data class ProductDto(
    val id: String = "",
    val name: String = "",
    val description: String = "",
    val priceCop: Long = 0L,
    val quantity: Int = 0,
    val updatedAt: Long = 0L,
    @get:PropertyName("isDeleted")
    @set:PropertyName("isDeleted")
    var isDeleted: Boolean = false
)