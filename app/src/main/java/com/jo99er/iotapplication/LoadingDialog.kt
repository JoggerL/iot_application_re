package com.jo99er.iotapplication

import android.content.Context
import android.widget.ProgressBar

class LoadingDialog(context: Context) {

    private val dialog : ProgressBar

    init {
        dialog = ProgressBar(context)
    }

    fun setText(string: String) {
        dialog.showContextMenu()
    }


}