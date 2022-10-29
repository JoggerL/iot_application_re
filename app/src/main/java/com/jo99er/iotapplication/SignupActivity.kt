package com.jo99er.iotapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.jo99er.iotapplication.databinding.ActivitySignupBinding

class SignupActivity : AppCompatActivity() {
    private lateinit var _binding: ActivitySignupBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        // Initialize Firebase Auth
        _binding.signUpButton.setOnClickListener { onSignupClicked() }
        _binding.textView.setOnClickListener { onLoginClicked() }
        auth = Firebase.auth
    }
    // Edit from here
    private fun onSignupClicked() {
        _binding.signupMessage.visibility = View.VISIBLE

        if (_binding.emailEt.text?.isEmpty() != false || _binding.passET.text?.isEmpty() != false) {
            _binding.signupMessage.text = "Invalid email or password"
            return
        }

        _binding.signupMessage.text = "Loading"
        _binding.signUpButton.isEnabled = false
        _binding.textView.isEnabled = false

        auth.createUserWithEmailAndPassword(
            _binding.emailEt.text.toString(),
            _binding.passET.text.toString()
        ).addOnCompleteListener(this) { task ->
            if (task.isSuccessful) { // Sign in success, update UI with the signed-in user's information
                Log.i(TAG, "signup successful")
                FirebaseAuthenticationUtils.instance.currentUser = auth.currentUser
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                Log.w(TAG, "signInWithEmail:failure")
                _binding.signupMessage.text = "Failed to sign up"
                _binding.signUpButton.isEnabled = true
                _binding.textView.isEnabled = true
                // If sign in fails, display a message to the user.
            }
        }
    }

    private fun onLoginClicked() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    companion object {
        private val TAG = MainActivity::class.simpleName
    }
}