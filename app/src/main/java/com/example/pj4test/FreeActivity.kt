package com.example.pj4test

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class FreeActivity : AppCompatActivity() {
    private val TAG = "FreeActivity"
    var button: Button? = null


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_free)
        addListenerOnButton()
    }


    fun addListenerOnButton() {
        val context = this
        button = findViewById<View>(R.id.free_button_2) as Button
        button!!.setOnClickListener {
            val intent = Intent(context, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}