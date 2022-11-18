package com.jo99er.iotapplication
import android.content.Context
import org.eclipse.paho.android.service.MqttAndroidClient
import org.eclipse.paho.android.service.MqttService
import android.util.Log
import org.eclipse.paho.client.mqttv3.*

class MqttUtils {
//    private lateinit var mqttClient: MqttAndroidClient
//    // TAG
//
//    fun connect(context: Context) {
//        val serverURI = "tcp://199.212.33.168:1883"
//        mqttClient = MqttAndroidClient(context, serverURI, "kotlin_client")
//        mqttClient.setCallback(object : MqttCallback {
//            override fun messageArrived(topic: String?, message: MqttMessage?) {
//                Log.d(TAG, "Receive message: ${message.toString()} from topic: $topic")
//            }
//
//            override fun connectionLost(cause: Throwable?) {
//                Log.d(TAG, "Connection lost ${cause.toString()}")
//            }
//
//            override fun deliveryComplete(token: IMqttDeliveryToken?) {
//
//            }
//        })
//        val options = MqttConnectOptions()
//        try {
//            mqttClient.connect(options, null, object : IMqttActionListener {
//                override fun onSuccess(asyncActionToken: IMqttToken?) {
//                    Log.d(TAG, "Connection success")
//                }
//
//                override fun onFailure(asyncActionToken: IMqttToken?, exception: Throwable?) {
//                    Log.d(TAG, "Connection failure")
//                }
//            })
//        } catch (e: MqttException) {
//            e.printStackTrace()
//        }
//
//    }
//
//
//    companion object {
//        const val TAG = "AndroidMqttClient"
//
//    }
}