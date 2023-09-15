package com.ubuntuyouiwe.firebasemvvm.view_model.category_details

import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObjects
import com.google.firebase.ktx.Firebase
import com.ubuntuyouiwe.firebasemvvm.model.CategoryDetailsModel
import kotlinx.coroutines.flow.MutableStateFlow

class CategoryDetailsViewModel() : ViewModel() {
    private val fireStore = Firebase.firestore
    val categoryDetails = MutableStateFlow<CategoryDetailsState>(CategoryDetailsState())

    init {
        getCategoryDetails()
    }

    fun getCategoryDetails() {
        val categoryDetailsCollection = fireStore
            .collection("ChildCategory")
            .document("bJwtn9ljAZYBqupIbdr9")
            .collection("Masallar").addSnapshotListener { value, error ->


                if (value != null) {
                    categoryDetails.value = categoryDetails.value.copy(
                        isSuccess = true,
                        isError = false,
                        isLoading = false,
                        data = value.toObjects<CategoryDetailsModel>()
                    )
                }
            }


    }
}