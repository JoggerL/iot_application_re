package com.jo99er.iotapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mongodb.client.MongoClients
import com.mongodb.ServerAddress
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import org.bson.Document

class PlotActivity : AppCompatActivity() {
    private lateinit var mongoClient:MongoClients
    private lateinit var databaseName:MongoDatabase
    private lateinit var collection:MongoCollection<Document>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plot)
    }
    companion object {
        private val TAG = PlotActivity::class.simpleName
    }
}