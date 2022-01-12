package com.example.bingo.ui

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bingo.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment() {

    private lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)

        binding.btnBack.setOnClickListener {
            startActivity(Intent(activity, HomeActivity::class.java))
            requireActivity().finish()
        }

        ObjectAnimator.ofFloat(binding.btnBack, "alpha", 0.0F, 1.0F).setDuration(700L)
            .start()
        ObjectAnimator.ofFloat(binding.title, "alpha", 0.0F, 1.0F).setDuration(700L)
            .start()
       ObjectAnimator.ofFloat(binding.btnLogOut, "alpha", 0.0F, 1.0F).setDuration(700L)
            .start()
       ObjectAnimator.ofFloat(binding.btnProfile, "alpha", 0.0F, 1.0F).setDuration(700L)
            .start()

        return binding.root


    }

}