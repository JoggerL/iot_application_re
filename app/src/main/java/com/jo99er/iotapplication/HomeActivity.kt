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
import android.app.Application
import android.util.Log
//import io.realm.DynamicRealm
//import io.realm.DynamicRealmObject
//import io.realm.RealmCollection
//import io.realm.RealmConfiguration
//import io.realm.kotlin.query.RealmQuery
//import io.realm.kotlin.types.RealmList
//import io.realm.kotlin.where
//import io.realm.mongodb.App
//import io.realm.mongodb.AppConfiguration
//import io.realm.mongodb.Credentials
//import io.realm.mongodb.RealmResultTask
//import io.realm.mongodb.User
//import io.realm.mongodb.sync.SyncConfiguration
//import io.realm.Realm


import org.json.JSONStringer


class HomeActivity : AppCompatActivity() {
    private lateinit var _binding : ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        // Ready our SDK
//// Creating our db with custom properties
//        val config = RealmConfiguration.Builder()
//            .name("test.db")
//            .allowQueriesOnUiThread(false)
//            .schemaVersion(1)
//            .deleteRealmIfMigrationNeeded()
//            .build()
//        Realm.setDefaultConfiguration(config)

//        val db = Realm.getDefaultInstance()
//        db.executeTransactionAsync {
//            val info = VisitInfo().apply {
//                visitCount = count
//            }
//            it.insert(info)
//        }
//  Forget About Realm, doesn't work!
//        Realm.init(this)
//        val app = App(
//            AppConfiguration.Builder(BuildConfig.RealmAppId)
//            .build())
//
//
//        val credentials: Credentials = Credentials.anonymous()
//
//        val user: User? = null
//        app.loginAsync(credentials) {
//            if (it.isSuccess) {
//                Log.v(TAG, "Successfully authenticated anonymously.")
//            } else {
//                Log.e(TAG, it.error.toString())
//            }
//        }
//        //Successfully connected to the App service
//
//        val user1: User? = app.currentUser()
//        val partitionValue: String = "myPartition"
//        val config = SyncConfiguration.Builder(user1!!, partitionValue)
//            .allowQueriesOnUiThread(true)
//            .allowWritesOnUiThread(true)
//            .build()
//        var realm: Realm
//// Sync all realm changes via a new instance, and when that instance has been
//// successfully created connect it to an on-screen list (a recycler view)
//        Realm.getInstanceAsync(config, object: Realm.Callback() {
//            override fun onSuccess(_realm: Realm) {
//                // the realm should live exactly as long as the activity, so assign the realm to a member variable
//                realm = _realm
//                Log.i(TAG, "Realm Opened Successfully")
//                val requ_doc = realm.where(Record::class.java).equalTo("deviceName","SN-001").findAll().isNullOrEmpty()
//                Log.v(TAG, requ_doc.toString())
//            }
//        })
//
//        val realm_app = Realm.getDefaultInstance()





//        val config = RealmConfiguration.Builder()
//            .allowWritesOnUiThread(true)
//            .allowQueriesOnUiThread(true)
//            .name("kt.dynamic.realm")
//            .build()
//        val dynamicRealm = DynamicRealm.getInstance(config)
//// all objects in a DynamicRealm are DynamicRealmObjects
//        var record: DynamicRealmObject? = null
//        dynamicRealm.executeTransaction { transactionDynamicRealm: DynamicRealm ->
//            // add type Frog to the schema with name and age fields
//            dynamicRealm.schema
//                .create("Record")
//                .addField("_id", String::class.java)
//                .addRealmListField("data",Long::class.java)
//                .addField("deviceName", String::class.java)
//                .addField("ts", Long::class.java)
////            record = transactionDynamicRealm.createObject("Record")
////            record?.set("name", "Wirt Jr.")
////            record?.set("age", 42)
//        }
//// access all fields in a DynamicRealm using strings





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