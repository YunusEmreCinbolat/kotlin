package com.example.myapplication

import android.os.Parcel
import android.os.Parcelable
import android.text.Editable

data class User(var adSoyad:String , var yas: String , var hakkinda :String) : Parcelable {

}