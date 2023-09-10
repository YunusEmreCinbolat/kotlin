package com.example.kisileruygulamasimvvm.util

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.example.kisileruygulamasimvvm.data.entity.Kisiler

fun Navigation.gecisYap(id:Int,it:View){
    findNavController(it).navigate(id)
}
fun Navigation.gecisYap(it: View,id: NavDirections){
    findNavController(it).navigate(id)
}