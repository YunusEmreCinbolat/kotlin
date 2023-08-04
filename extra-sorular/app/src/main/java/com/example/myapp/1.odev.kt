package com.example.myapp

import android.os.Build
import androidx.annotation.RequiresApi
import java.util.Scanner
import kotlin.random.Random
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.O)
fun main(){
    val takvimHaftagun= listOf<String>("Pt","Sa","Ca","Pe","Cu","Ct","Pa")
    val takvimHaftaguneslesme= listOf<String>("MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY","SUNDAY")
    val takvimGun= listOf<Int>(Random.nextInt(1,32))
    val aylar= hashMapOf<Int,String>(1 to "OCAK", 2 to "SUBAT",3 to "MART", 4 to "NISAN",5 to "MAYIS", 6 to "HAZIRAN",7 to "TEMMUZ", 8 to "AGUSTOS",9 to "EYLUL", 10 to "EKIM",11 to "KASIM", 12 to "ARALIK")
    var gun: Int?=null
    var ay: Int?=null
    var yil: Int?=null
    var oyna=1
    val girdi=Scanner(System.`in`)
    while (oyna==1){
        gun= Random.nextInt(1,32)
        ay=Random.nextInt(1,13)
        yil=Random.nextInt(1922,2023)
        var tarih="$gun/$ay/$yil"
        if(yil%4==0 && ay==2 && gun>28){
            println("$tarih tarihi gecersiz tarihtir")
            break
        }
        println("$tarih tarihi hangi güne denk gelmektedir ?")
        var gunTahmin=girdi.next().toUpperCase()
        var haftaninGunu= gunBul(tarih)
        if(gunTahmin.contains(haftaninGunu)){
            println("Tahmin dogru")
        }
        else{
            println("Tahmin yanlis dogru gun $haftaninGunu")
        }
        takvim(gun,ay,yil,haftaninGunu,takvimHaftagun,takvimHaftaguneslesme,takvimGun, aylar)

        println("Devam etmek istiyor musunuz: (evet ise 'e' karakterini giriniz)")
        var yanit=girdi.next().toUpperCase()
        if(!yanit.contains('E'))
            oyna=2
      }
}
@RequiresApi(Build.VERSION_CODES.O)
fun gunBul(yil:String): String {
    val format = DateTimeFormatter.ofPattern("d/M/yyyy", Locale.ENGLISH)
    val tarih = LocalDate.parse(yil, format)
    val haftaninGunu = tarih.dayOfWeek
    return haftaninGunu.toString()
}
fun takvim(
    gun:Int,
    ay:Int,
    yil:Int,
    esasGun:String,
    takvimHaftagun:List<String>,
    takvimHaftaguneslesme: List<String>,
    takvimGun: List<Int>,
    aylar: HashMap<Int, String>
){
        aylar.forEach { (numberAy,stringAy) -> if(numberAy==ay){ println("     $stringAy $yil") }  }
        takvimHaftagun.forEach{ print("$it ") }
    println()
    var baslangicGun=gun%7
    var index=takvimHaftaguneslesme.indexOf(esasGun)
    while (baslangicGun>1) {
        baslangicGun--
        index--
        if (index == -1) {
            index = takvimHaftaguneslesme.size -1
        }
    }
        for (i in 0..index){
            print("   ")
        }
        for (i in 1..31){
            print("$i ")
            index++
            if(index==7){
                println()
                index=0

            }


        }
        println()

}