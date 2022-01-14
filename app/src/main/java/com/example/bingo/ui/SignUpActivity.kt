package com.example.bingo.ui

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bingo.databinding.ActivitySignupBinding
import com.google.android.gms.tasks.Task
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import models.User


class SignUpActivity : AppCompatActivity() {

   /* private lateinit var binding: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        FirebaseApp.initializeApp(this);

        binding.apply {
            loginText.setOnClickListener {
                val intent = Intent(
                    applicationContext,
                    LogInActivity::class.java
                )
                startActivity(intent)
                finish()
            }
            btnRegister.setOnClickListener {
                val username = usernameSignup.text.toString().trim { it <= ' ' }
                val fullname = fullName.text.toString().trim { it <= ' ' }
                val email = tvEmail.text.toString().trim { it <= ' ' }
                val password = passwordSignup.text.toString()
                val user = User(username, fullname, email)
                if (TextUtils.isEmpty(username)) {
                    usernameSignup.error = "Username is Required"
                }
                if (TextUtils.isEmpty(fullname)) {
                    fullName.error = "Fullname is Required"
                }
                if (TextUtils.isEmpty(email)) {
                    tvEmail.error = "Email is Required"
                }
                if (TextUtils.isEmpty(password)) {
                    passwordSignup.error = "Password is Required"
                }
                if (password.length < 6) {
                    passwordSignup.error = "Password is too short"
                }
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task: Task<AuthResult?> ->
                        if (task.isSuccessful) {
                            FirebaseDatabase.getInstance().getReference("Users")
                                .child(FirebaseAuth.getInstance().currentUser!!.uid)
                                .setValue(user)
                                .addOnCompleteListener { task1: Task<Void?> ->
                                    if (task1.isSuccessful) {
                                        Toast.makeText(
                                            this@SignUpActivity,
                                            "User has been registered successfully",
                                            Toast.LENGTH_SHORT
                                        ).show()

                                        val intent =
                                            Intent(applicationContext, LogInActivity::class.java)
                                        startActivity(intent)
                                        finish()
                                    } else {
                                        Toast.makeText(
                                            this@SignUpActivity,
                                            "Failed to register! Try again!",
                                            Toast.LENGTH_SHORT
                                        ).show()

                                    }
                                }
                        } else {
                            Toast.makeText(
                                this@SignUpActivity,
                                "Failed to register! Try again!",
                                Toast.LENGTH_SHORT
                            ).show()

                        }
                    }
            }
        }
    }*/
}