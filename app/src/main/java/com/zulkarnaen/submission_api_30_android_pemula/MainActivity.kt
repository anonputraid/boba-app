package com.zulkarnaen.submission_api_30_android_pemula

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.view.View

class MainActivity : AppCompatActivity(),  View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnTokoBoba: Button = findViewById<Button>(R.id.buttonTokoBoba)
        btnTokoBoba.setOnClickListener(this)

        val btnAbout: Button    = findViewById<Button>(R.id.buttonAbout)
        btnAbout.setOnClickListener(this)

    }

    override fun onClick(dapatkanid: View?) {
        when(dapatkanid?.id){
            R.id.buttonTokoBoba -> {
                val moveIntent = Intent(this@MainActivity, ActivityTentangToko::class.java)
                startActivity(moveIntent)
            }

            R.id.buttonAbout -> {
                val moveIntent = Intent(this@MainActivity, ActivityTentangAplikasi::class.java)
                startActivity(moveIntent)
            }
        }
    }
}