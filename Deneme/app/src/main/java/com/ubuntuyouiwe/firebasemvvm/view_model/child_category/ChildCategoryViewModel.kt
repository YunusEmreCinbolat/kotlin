package com.ubuntuyouiwe.firebasemvvm.view_model.child_category

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObjects
import com.google.firebase.ktx.Firebase
import com.ubuntuyouiwe.firebasemvvm.model.ChildCategoryModel
import com.ubuntuyouiwe.firebasemvvm.view_model.child_category.state.ChildCategoryState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.observeOn

class ChildCategoryViewModel(): ViewModel() {
    private val fireStore = Firebase.firestore
    val childCategoryState = MutableLiveData<ChildCategoryState>(ChildCategoryState())

    init {
        childCategoryDatabase()
    }
    private fun childCategoryDatabase() {
        val childCategory = fireStore.collection("ChildCategory")
        childCategory.get().addOnCompleteListener {
            if (it.isSuccessful) {

                if (!it.result.isEmpty) {
                    childCategoryState.value = childCategoryState.value?.copy(
                        isSuccess = true,
                        isError = false,
                        isLoading = false,
                        data = it.result.toObjects<ChildCategoryModel>()
                    )
                }

            } else {
                childCategoryState.value = childCategoryState.value?.copy(
                    isSuccess = false,
                    isError = true,
                    isLoading = false,
                    errorMessage = it.exception?.message?: "Hata bilinmiyor"
                )
            }
        }
    }
}