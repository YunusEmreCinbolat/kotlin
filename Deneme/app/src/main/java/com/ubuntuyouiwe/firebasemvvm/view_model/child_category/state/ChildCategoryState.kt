package com.ubuntuyouiwe.firebasemvvm.view_model.child_category.state


import com.ubuntuyouiwe.firebasemvvm.model.ChildCategoryModel

data class ChildCategoryState(
    val isSuccess: Boolean = false,
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val data:  List<ChildCategoryModel> = emptyList(),
    val errorMessage: String = "",
)