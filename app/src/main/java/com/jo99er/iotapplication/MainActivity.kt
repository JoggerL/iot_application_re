package com.jo99er.iotapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.jo99er.iotapplication.R
import com.jo99er.iotapplication.databinding.ActivityLoginBinding


class MainActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var _binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        // Initialize Firebase Auth
        _binding.signInButton.setOnClickListener { onLoginClicked() }
        _binding.textView.setOnClickListener { onSignupClicked() }
        auth = Firebase.auth
    }

    private fun onLoginClicked() {
        _binding.loginMessage.visibility = View.VISIBLE

        if (_binding.emailInput.text?.isEmpty() != false || _binding.passwordInput.text?.isEmpty() != false) {
            _binding.loginMessage.text = "Invalid Information"
            return
        }

        _binding.loginMessage.text = "Loading"
        _binding.signInButton.isEnabled = false
        _binding.textView.isEnabled = false

        auth.signInWithEmailAndPassword(
            _binding.emailInput.text.toString(),
            _binding.passwordInput.text.toString()
        ).addOnCompleteListener(this) { task ->
            if (task.isSuccessful) { // Sign in success, update UI with the signed-in user's information
                Log.i(TAG, "login successful")
                FirebaseAuthenticationUtils.instance.currentUser = auth.currentUser
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            } else {
                Log.w(TAG, "signInWithEmail:failure")
                _binding.loginMessage.text = "Failed to sign in"
                _binding.signInButton.isEnabled = true
                _binding.textView.isEnabled = true
                // If sign in fails, display a message to the user.
            }
        }
    }

    private fun onSignupClicked() {
        val intent = Intent(this, SignupActivity::class.java)
        startActivity(intent)
    }

    companion object {
        private val TAG = MainActivity::class.simpleName
    }

}