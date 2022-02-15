package com.example.bingo.ui

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.example.bingo.R
import com.example.bingo.databinding.ActivityHomeBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GithubAuthCredential
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module
import startAnimation

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private lateinit var firebaseAuth: FirebaseAuth

    private lateinit var actionBar: ActionBar

    var listOfModules = module {
        single { emptyList<Module>() }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startKoin {
            androidLogger()
            androidContext(this@HomeActivity)
            modules(listOfModules)
        }

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        //checkUser()

        actionBar = supportActionBar!!
        actionBar.title = "Home"

        binding.btnPlayGame.setOnClickListener {
            startActivity(Intent(this, GameActivity::class.java))
            finish()
        }

        val animation = AnimationUtils.loadAnimation(this, R.anim.circle_explosion_anim).apply {
            duration = 700
            interpolator = AccelerateDecelerateInterpolator()
        }

        binding.btnSettings.setOnClickListener {
            binding.btnSettings.isVisible = false
            binding.circle.isVisible = true
            binding.circle.startAnimation(animation){

                binding.root.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary))
                binding.circle.isVisible = false
                binding.btnPlayGame.isVisible = false
                binding.title.isVisible = false
                supportFragmentManager.beginTransaction()
                    .add(android.R.id.content, SettingsFragment()).commit()
            }

        }
    }

    private fun checkUser() {
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser != null){
            var numb = 1
        }
        else{
            startActivity(Intent(this, LogInActivity::class.java))
            finish()
        }
    }
}