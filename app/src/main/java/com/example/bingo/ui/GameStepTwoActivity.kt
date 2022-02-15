package com.example.bingo.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bingo.R
import com.example.bingo.databinding.ActivityGameBinding
import com.google.android.material.snackbar.Snackbar
import custom.Adapter
import models.ViewModel
import org.koin.android.ext.android.inject

class GameStepTwoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameBinding


    private lateinit var actionBar: ActionBar

    private val viewModel: ViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        actionBar = supportActionBar!!
        actionBar.title = "Bingo"

        binding.back.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
        val balls = intent.getStringArrayExtra("balls")
        for (i in viewModel.balls.value!!){
            println(i + "dd")
        }

    }

}