package com.jo99er.iotapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
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
        _binding.buttonOneLead.setOnClickListener { onOneLeadClicked() }
        _binding.buttonThreeLead.setOnClickListener { onThreeLeadClicked() }
        _binding.buttonTwelveLead.setOnClickListener { onTwelveLeadClicked() }
        _binding.buttonReal.setOnClickListener { onRealtimeClicked() }
//
//        var plot_names = arrayOf("ECG Plot #1", "ECG Plot #2")
//        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter(
//            this, android.R.layout.simple_list_item_1, plot_names
//        )
//
//        _binding.ListView.adapter = arrayAdapter
//
//        _binding.ListView.setOnItemClickListener { adapterView, view, i, l ->
//            when(i){
//                0-> startActivity(Intent(this, PlotActivity::class.java))
//            }
//        }
//        onBackPressedDispatcher.onBackPressed()




    }


    private fun onSignoutClicked(){
        Firebase.auth.signOut()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private  fun onOneLeadClicked(){
        val intent = Intent(this, PlotActivity::class.java)
        startActivity(intent)
    }
    private  fun onThreeLeadClicked(){
        val intent = Intent(this, PlotThreeActivity::class.java)
        startActivity(intent)
    }
    private  fun onTwelveLeadClicked(){
        val intent = Intent(this, PlotTwelveActivity::class.java)
        startActivity(intent)
    }
    private  fun onRealtimeClicked(){
        val intent = Intent(this, RealtimeActivity::class.java)
        startActivity(intent)
    }

    companion object{
        const val TAG = "HomeActivity"
    }
}