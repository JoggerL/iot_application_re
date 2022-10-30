package com.jo99er.iotapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.jo99er.iotapplication.databinding.ActivityHomeBinding
import com.jo99er.iotapplication.R

class HomeActivity : AppCompatActivity() {



    private lateinit var _binding : ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(_binding.root)

        _binding.text.text = FirebaseAuthenticationUtils.instance.currentUser?.email ?: "Email is null"

        _binding.SignoutButton.setOnClickListener { onSignoutClicked() }
    }

    private fun onSignoutClicked(){
        Firebase.auth.signOut()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}