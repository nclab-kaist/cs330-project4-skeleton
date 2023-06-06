package com.example.pj4test

import android.Manifest.permission.CAMERA
import android.Manifest.permission.RECORD_AUDIO
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import java.util.*


class RegisterActivity : AppCompatActivity() {
    private val TAG = "RegisterActivity"
    var button: Button? = null

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        addListenerOnButton()
    }


    fun addListenerOnButton() {
        val context = this
        button = findViewById<View>(R.id.register_button) as Button
        button!!.setOnClickListener {
            val intent = Intent(context, InUseActivity::class.java)
            startActivity(intent)
        }
    }
}