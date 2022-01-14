package com.example.bingo.ui

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import com.example.bingo.databinding.FragmentSettingsBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class SettingsFragment : Fragment() {

    private lateinit var binding: FragmentSettingsBinding

    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)

        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()


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

        binding.btnLogOut.setOnClickListener {
            firebaseAuth.signOut()
            checkUser()
        }

        return binding.root


    }
    private fun checkUser() {
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser != null){
            var numb = 1
        }
        else{
            val intent = Intent(activity, LogInActivity::class.java)
            (activity as HomeActivity?)!!.startActivity(intent)
        }
    }

}