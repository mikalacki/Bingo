package com.example.bingo.ui


import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bingo.databinding.ActivityLoginBinding
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth


class LogInActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)

        FirebaseApp.initializeApp(this);

        binding.apply {
            signupText.setOnClickListener {
                val intent = Intent(
                    applicationContext,
                    SignUpActivity::class.java
                )
                startActivity(intent)
                finish()
            }
            btnLogin.setOnClickListener {
                if (emailLogin.text.toString()
                        .isEmpty() || passwordLogin.text.toString().isEmpty()
                ) {
                    FirebaseAuth.getInstance().signInWithEmailAndPassword(
                        emailLogin.text.toString(),
                        passwordLogin.text.toString()
                    ).addOnCompleteListener { task ->
                        if (task.isSuccessful()) {
                            Toast.makeText(this@LogInActivity, "User loged in", Toast.LENGTH_SHORT)
                                .show()
                            startActivity(Intent(applicationContext, HomeActivity::class.java))
                            finish()
                        } else {
                            Toast.makeText(
                                this@LogInActivity,
                                "Error" + task.exception?.message,
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }
        }
    }
}