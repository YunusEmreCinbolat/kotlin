package com.ubuntuyouiwe.firebasemvvm.view_model.category_details

import com.ubuntuyouiwe.firebasemvvm.model.CategoryDetailsModel

data class CategoryDetailsState(
    val isSuccess: Boolean = false,
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val data:  List<CategoryDetailsModel> = emptyList(),
    val errorMessage: String = "",
)
