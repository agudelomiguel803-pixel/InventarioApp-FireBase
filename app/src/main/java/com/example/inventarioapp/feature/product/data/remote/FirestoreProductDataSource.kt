package com.example.inventarioapp.feature.product.data.remote

import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FirestoreProductDataSource @Inject constructor(
    private val firestore: FirebaseFirestore
) {
    private fun productsCollection(uid: String) =
        firestore.collection("users")
            .document(uid)
            .collection("products")

    suspend fun push(uid: String, dto: ProductDto) {
        productsCollection(uid)
            .document(dto.id)
            .set(dto)
            .await()
    }

    suspend fun fetchFromServer(uid: String): List<ProductDto> {
        val snapshot = productsCollection(uid)
            .get()
            .await()

        return snapshot.documents.mapNotNull { doc ->
            val dto = doc.toObject(ProductDto::class.java) ?: return@mapNotNull null
            dto.copy(id = dto.id.ifBlank { doc.id })
        }
    }
}