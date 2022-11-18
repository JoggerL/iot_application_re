package com.jo99er.iotapplication

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.util.Range
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.LegendEntry
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.jo99er.iotapplication.databinding.ActivityPlotBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.awaitResponse
import retrofit2.converter.gson.GsonConverterFactory


class PlotActivity : AppCompatActivity() {
    private lateinit var _binding: ActivityPlotBinding

    private val api: ApiRequest by lazy {
        Retrofit.Builder()
            .baseUrl("https://joggeriot.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiRequest::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityPlotBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        _binding.testText.text = "Connecting to Server"
        _binding.button2.setOnClickListener { onPlotClicked() }

    }

    private fun onPlotClicked(){
        if (_binding.tsInput.text?.isEmpty() != false) {
            _binding.testText.text = "Invalid Information"
            return
        } else {
            lifecycleScope.launch(Dispatchers.IO) {
//            getData()
                val ts = _binding.tsInput.text.toString().toLong()
                val response = api.getEcgData(ts).awaitResponse()

                withContext(Dispatchers.Main) {
                    val data = response.body()?.data
                    if (response.isSuccessful && data != null) {
                        Log.i(TAG, "Data Successfully Obtained")

//                Log.i(TAG, data)
                        _binding.testText.text = "Connected to Server! :)  Null Document Will Result Blank Plot"
                        addData(data, data.size)
                    } else {
                        Log.i(TAG, "FAILED")
                        _binding.testText.text = "Cannot get data"
                    }

                }

            }

        }
    }


    fun addData(datalist: List<Long>, ecgSize: Int) {
        val entries = ArrayList<Entry>(ecgSize)
        for (i in 0 until ecgSize) {
            val floatIndex = i.toFloat()
            val floatEcg = datalist[i].toFloat()
            entries.add(Entry(floatIndex, floatEcg))
        }
        val vl = LineDataSet(entries, "ECG Signal 01")
        vl.setDrawValues(false)
        vl.setDrawFilled(true)
        vl.lineWidth = 3f
//        vl.fillColor = com.google.android.material.R.color.mtrl_btn_transparent_bg_color
        vl.fillAlpha = R.color.black
        _binding.lineChart.data = LineData(vl)
        _binding.lineChart.xAxis.labelRotationAngle = 0f

        _binding.lineChart.data = LineData(vl)

        _binding.lineChart.setTouchEnabled(true)
        _binding.lineChart.setPinchZoom(true)
//        val floatLen = (ecgSize.toFloat())/10
//        _binding.lineChart.setVisibleXRangeMaximum(floatLen)
        _binding.lineChart.isScaleYEnabled = false
        _binding.lineChart.description.isEnabled = false;

    }

//    fun addData2(datalist: List<Long>, ecgSize: Int) {
//        val entries = ArrayList<Entry>(ecgSize)
//        for (i in 0 until ecgSize) {
//            val floatIndex = i.toFloat()
//            val floatEcg = datalist[i].toFloat()
//            entries.add(Entry(floatIndex, floatEcg))
//        }
//        val vl = LineDataSet(entries, "ECG Signal 02")
//        vl.setDrawValues(false)
//        vl.setDrawFilled(true)
//        vl.lineWidth = 3f
////        vl.fillColor = com.google.android.material.R.color.mtrl_btn_transparent_bg_color
//        vl.fillAlpha = R.color.black
//        _binding.lineChart2.data = LineData(vl)
//        _binding.lineChart2.xAxis.labelRotationAngle = 0f
//
//        _binding.lineChart2.data = LineData(vl)
//
//        _binding.lineChart2.setTouchEnabled(true)
//        _binding.lineChart2.setPinchZoom(true)
////        val floatLen = (ecgSize.toFloat())/10
////        _binding.lineChart.setVisibleXRangeMaximum(floatLen)
//        _binding.lineChart2.isScaleYEnabled = false
//        _binding.lineChart2.description.isEnabled = false;
////        val l1 = LegendEntry("hey", Legend.LegendForm.CIRCLE, 10f, 2f, null, Color.YELLOW)
//////        val l2 = LegendEntry("Female", Legend.LegendForm.CIRCLE, 10f, 2f, null, Color.RED)
////        _binding.lineChart2.legend.setCustom(arrayOf(l1))
//    }

    companion object {
        private val TAG = PlotActivity::class.simpleName
    }

//    private fun getData(ts: Number) {
//        val api = Retrofit.Builder()
//            .baseUrl("a")
//            .build()
//            .create(ApiRequest::class.java)
//        lifecycleScope.launch(Dispatchers.IO){
//            val response = api.getEcgData(ts).awaitResponse()
//            if (response.isSuccessful){
//                val data = response.body()!!
//            }
//            withContext(Dispatchers.Main){
//
//            }
//        }
//
//    }
}

