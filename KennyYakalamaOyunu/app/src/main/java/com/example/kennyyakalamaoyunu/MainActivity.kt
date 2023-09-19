package com.example.kennyyakalamaoyunu

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.kennyyakalamaoyunu.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    var skor = 0
    var runnable= Runnable {}
    var kennyList = ArrayList<ImageView>()
    var handler = Handler(Looper.getMainLooper())
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        kennyList.add(binding.imageView2)
        kennyList.add(binding.imageView3)
        kennyList.add(binding.imageView4)
        kennyList.add(binding.imageView5)
        kennyList.add(binding.imageView6)
        kennyList.add(binding.imageView7)
        kennyList.add(binding.imageView8)
        kennyList.add(binding.imageView9)
        kennyList.add(binding.imageView10)
        kennyList.add(binding.imageView11)
        kennyList.add(binding.imageView12)
        kennyList.add(binding.imageView13)
        kennyList.add(binding.imageView14)
        kennyList.add(binding.imageView15)
        kennyList.add(binding.imageView16)
        kennyList.add(binding.imageView17)

        resimGoster()
        object :CountDownTimer(15500,1000){
            override fun onTick(p0: Long) {
               binding.sayac.text="Kalan süre ${p0/1000}"
            }

            override fun onFinish() {
                binding.sayac.text="Süre bitti"
                handler.removeCallbacks(runnable)
                for (kenny in kennyList){
                    kenny.visibility=View.GONE
                }
                var alert=AlertDialog.Builder(this@MainActivity)
                alert.setTitle("Oyun bitti")
                alert.setMessage("Yeniden oynamak istiyor musunuz")
                alert.setPositiveButton("Yes") {dialog, which ->
                    var intentMore=intent
                    finish()
                    startActivity(intentMore)
                    //OnClick Listener
                }
                alert.setNegativeButton("No") {dialog, which ->

                    //OnClick Listener
                    finish()

                }

                alert.show()
            }

        }.start()
    }

    fun resimTikla(view: View) {
        skor+=1
        binding.skor.text="Skor ${skor}"
    }

    fun resimGoster() {
      runnable =  object :Runnable{
            override fun run() {
                for (kenny in kennyList) {
                    kenny.visibility = View.INVISIBLE
                }

                val random = Random()
                val index = random.nextInt(kennyList.size)
                kennyList[index].visibility = View.VISIBLE

                // Belirli bir süre sonra resmi gizlemek için bir zamanlayıcı başlatın.
                handler.postDelayed( runnable, 1000) // 1000 milisaniye (1 saniye) sonra resmi gizle
            }
            }
            handler.post(runnable)
        }

}
