
package com.jo99er.iotapplication
/*
import android.util.Log
import com.mongodb.client.FindIterable
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoClients
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.bson.Document


class MongodbUtils {
    private lateinit var mongoClient: MongoClient
    private lateinit var databaseName: MongoDatabase
    private lateinit var collection: MongoCollection<Document>

    suspend fun connect() {
        withContext(Dispatchers.IO) {
            mongoClient = MongoClients.create(BuildConfig.MONGODB_URL)
        }
    }

    suspend fun dbConnection(){
        withContext(Dispatchers.IO){
            databaseName = mongoClient.getDatabase("ecg_data")
            collection = databaseName.getCollection("record")
//        var data1 = collection.listIndexes()

//        val doc  = collection.find().sort(Document("ts", 1642130745129))
            val findDoc = collection.find(Document("ts", 1642130745129))
            findDoc.forEach { Log.d(TAG, it.toJson()) }
            Log.i(TAG, "got")
            Log.i(TAG, collection.toString())
//        return findDoc
        }
    }

    companion object {
        private val TAG = MongodbUtils::class.simpleName
        private var _instance: MongodbUtils? = null
        fun getInstance(): MongodbUtils {
            if (_instance == null) {
                _instance = MongodbUtils()
            }
            return _instance!!
        }
    }
}

*/