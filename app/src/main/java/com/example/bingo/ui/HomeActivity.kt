package com.example.bingo.ui

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.example.bingo.R
import com.example.bingo.databinding.ActivityHomeBinding
import startAnimation

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


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
}