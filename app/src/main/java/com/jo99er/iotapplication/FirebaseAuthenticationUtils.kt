package com.jo99er.iotapplication

import android.app.Activity
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class FirebaseAuthenticationUtils {


    var currentUser : FirebaseUser? = null

    companion object {
        private var _instance = FirebaseAuthenticationUtils()

        private val TAG = FirebaseAuthenticationUtils::class.simpleName
        val instance : FirebaseAuthenticationUtils get() = _instance
    }
}