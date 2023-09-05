package com.example.login
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()

        val editTextLoginEmail = findViewById<EditText>(R.id.editTextLoginEmail)
        val editTextLoginPassword = findViewById<EditText>(R.id.editTextLoginPassword)
        val buttonLogin = findViewById<Button>(R.id.buttonLogin)
        val textViewSignUp = findViewById<TextView>(R.id.textViewSignUp)

        buttonLogin.setOnClickListener {
            val email = editTextLoginEmail.text.toString()
            val password = editTextLoginPassword.text.toString()

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Kullanıcı başarıyla giriş yaptı, istediğiniz ekranı açabilirsiniz
                        // Örneğin, ana ekranı açabilirsiniz
                      Toast.makeText(this,"Giriş başarılı",Toast.LENGTH_LONG).show()
                        finish()
                    } else {
                        // Giriş işlemi başarısız oldu, kullanıcıya bir uyarı gösterin
                        Toast.makeText(baseContext, "Giriş işlemi başarısız.", Toast.LENGTH_SHORT).show()
                    }
                }
        }

        textViewSignUp.setOnClickListener {
            // Kayıt olma ekranına yönlendirme yapabilirsiniz
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}