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

class GameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameBinding

    private lateinit var actionBar: ActionBar

    private val viewModel: ViewModel = ViewModel()

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

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val adapter = Adapter(fetchData(), {
            val imageName = resources.getResourceName(it)
            Snackbar.make(binding.root, "Pressed ball ${imageName.drop(32)}", Snackbar.LENGTH_SHORT).show()
        }, viewModel, resources)
        recyclerView.layoutManager = GridLayoutManager(this, 8)
        recyclerView.adapter = adapter

    }

    private fun fetchData() : ArrayList<Int>{

        val item = ArrayList<Int>()
        item.add(R.drawable.ball_1)
        item.add(R.drawable.ball_2)
        item.add(R.drawable.ball_3)
        item.add(R.drawable.ball_4)
        item.add(R.drawable.ball_5)
        item.add(R.drawable.ball_6)
        item.add(R.drawable.ball_7)
        item.add(R.drawable.ball_8)
        item.add(R.drawable.ball_9)
        item.add(R.drawable.ball_10)
        item.add(R.drawable.ball_11)
        item.add(R.drawable.ball_12)
        item.add(R.drawable.ball_13)
        item.add(R.drawable.ball_14)
        item.add(R.drawable.ball_15)
        item.add(R.drawable.ball_16)
        item.add(R.drawable.ball_17)
        item.add(R.drawable.ball_18)
        item.add(R.drawable.ball_19)
        item.add(R.drawable.ball_20)
        item.add(R.drawable.ball_21)
        item.add(R.drawable.ball_22)
        item.add(R.drawable.ball_23)
        item.add(R.drawable.ball_24)
        item.add(R.drawable.ball_25)
        item.add(R.drawable.ball_26)
        item.add(R.drawable.ball_27)
        item.add(R.drawable.ball_28)
        item.add(R.drawable.ball_29)
        item.add(R.drawable.ball_30)
        item.add(R.drawable.ball_31)
        item.add(R.drawable.ball_32)
        item.add(R.drawable.ball_33)
        item.add(R.drawable.ball_34)
        item.add(R.drawable.ball_35)
        item.add(R.drawable.ball_36)
        item.add(R.drawable.ball_37)
        item.add(R.drawable.ball_38)
        item.add(R.drawable.ball_39)
        item.add(R.drawable.ball_40)
        item.add(R.drawable.ball_41)
        item.add(R.drawable.ball_42)
        item.add(R.drawable.ball_43)
        item.add(R.drawable.ball_44)
        item.add(R.drawable.ball_45)
        item.add(R.drawable.ball_46)
        item.add(R.drawable.ball_47)
        item.add(R.drawable.ball_48)

        return item
    }
}