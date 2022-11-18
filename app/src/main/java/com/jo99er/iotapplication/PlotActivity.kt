package com.jo99er.iotapplication

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.LegendEntry
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.jo99er.iotapplication.databinding.ActivityPlotBinding



class PlotActivity : AppCompatActivity() {
    //Part1
    //    private lateinit var mongoClient:MongoClients
//    private lateinit var databaseName:MongoDatabase
//    private lateinit var collection:MongoCollection<Document>
    private lateinit var _binding: ActivityPlotBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityPlotBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        addData()
        addData2()
//        lifecycleScope.launch(Dispatchers.Main) {
//            _binding.testText.text = "Connecting"
//            MongodbUtils.getInstance().connect()
//            _binding.testText.text = "DB Connected"
//            val a = MongodbUtils.getInstance().dbConnection()
////            _binding.testText.text = a
//
//        }
    }


    fun addData() {
        val entries = ArrayList<Entry>()
        entries.add(Entry(1f, 10f))
        entries.add(Entry(2f, 2f))
        entries.add(Entry(3f, 7f))
        entries.add(Entry(4f, 20f))
        entries.add(Entry(5f, 16f))
        val vl = LineDataSet(entries, "My Type")
        vl.setDrawValues(false)
        vl.setDrawFilled(true)
        vl.lineWidth = 3f
        vl.fillColor = com.google.android.material.R.color.mtrl_btn_transparent_bg_color
        vl.fillAlpha = R.color.black
        _binding.lineChart.data = LineData(vl)
        _binding.lineChart.xAxis.labelRotationAngle = 0f

        _binding.lineChart.data = LineData(vl)

        _binding.lineChart.setTouchEnabled(true)
        _binding.lineChart.setPinchZoom(true)
    }
    fun addData2() {
        val entries = ArrayList<Entry>()
        entries.add(Entry(1f, 10f))
        entries.add(Entry(2f, 2f))
        entries.add(Entry(3f, 7f))
        entries.add(Entry(4f, 20f))
        entries.add(Entry(5f, 16f))
        val vl = LineDataSet(entries, "Second")
        vl.setDrawValues(false)
        vl.setDrawFilled(true)
        vl.lineWidth = 3f
        vl.fillColor = com.google.android.material.R.color.mtrl_btn_transparent_bg_color
        vl.fillAlpha = R.color.black
        _binding.lineChart2.data = LineData(vl)
        _binding.lineChart2.xAxis.labelRotationAngle = 0f

        _binding.lineChart2.data = LineData(vl)

        _binding.lineChart2.setTouchEnabled(true)
        _binding.lineChart2.setPinchZoom(true)
        _binding.lineChart2.setVisibleXRangeMaximum(2f);
        _binding.lineChart2.description.isEnabled = false;
//        val l1 = LegendEntry("hey", Legend.LegendForm.CIRCLE, 10f, 2f, null, Color.YELLOW)
////        val l2 = LegendEntry("Female", Legend.LegendForm.CIRCLE, 10f, 2f, null, Color.RED)
//        _binding.lineChart2.legend.setCustom(arrayOf(l1))
    }

    companion object {
        private val TAG = PlotActivity::class.simpleName
    }
}

