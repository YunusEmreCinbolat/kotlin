package com.example.login

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        auth = FirebaseAuth.getInstance()

        val editTextEmail = findViewById<EditText>(R.id.editTextEmail)
        val editTextPassword = findViewById<EditText>(R.id.editTextPassword)
        val buttonSignUp = findViewById<Button>(R.id.buttonSignUp)

        buttonSignUp.setOnClickListener {
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()

            // Kayıt işlemi başarıyla tamamlandığında
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // E-posta doğrulama e-postası gönder
                        val user = auth.currentUser
                        user?.sendEmailVerification()
                            ?.addOnCompleteListener { verificationTask ->
                                if (verificationTask.isSuccessful) {
                                    // E-posta doğrulama e-postası başarıyla gönderildi
                                    Toast.makeText(baseContext, "Kayıt işlemi başarıyla tamamlandı. Lütfen e-postanızı doğrulayın.", Toast.LENGTH_SHORT).show()

                                    // E-posta doğrulamasını kontrol et
                                    checkEmailVerificationStatus()
                                } else {
                                    // E-posta doğrulama e-postası gönderilemedi, hata mesajını kullanıcıya gösterin
                                    Toast.makeText(baseContext, "E-posta doğrulama e-postası gönderme hatası.", Toast.LENGTH_SHORT).show()
                                }
                            }
                    } else {
                        // Kayıt işlemi başarısız oldu, kullanıcıya bir uyarı gösterin
                        Toast.makeText(baseContext, "Kayıt işlemi başarısız.", Toast.LENGTH_SHORT).show()
                    }
                }

            // E-posta doğrulama durumunu kontrol etmek için ayrı bir fonksiyon


        }
    }
    private fun checkEmailVerificationStatus() {
        val user = FirebaseAuth.getInstance().currentUser

        if (user != null && user.isEmailVerified) {
            // Kullanıcı giriş yapmış ve e-posta doğrulamasını tamamlamış
            // Burada gerekli yönlendirmeyi yapabilirsiniz
        } else {
            // Kullanıcı ya giriş yapmamış ya da e-posta doğrulamasını tamamlamamış
            Toast.makeText(baseContext, "Lütfen e-postanızı doğrulayın.", Toast.LENGTH_SHORT).show()
        }
    }
}
