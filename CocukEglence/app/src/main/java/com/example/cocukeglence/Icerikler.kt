package com.example.cocukeglence

import java.io.Serializable

data class Icerikler(var icerik_id:Int?=0, var icerik_ad:String?="", var icerik_isim:String?="", var icerik_resim:String?="", var kategoriler: kategoriler?=null, var IcerikDetay:IcerikDetay?=null):Serializable
