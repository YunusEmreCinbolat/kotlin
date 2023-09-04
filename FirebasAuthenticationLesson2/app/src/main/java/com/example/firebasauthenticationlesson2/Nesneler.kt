package com.example.firebasauthenticationlesson2

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class Nesneler(var nenneAdi:String?="",var nesneAdet:Int?=0,var nesneAlani:String?="")
