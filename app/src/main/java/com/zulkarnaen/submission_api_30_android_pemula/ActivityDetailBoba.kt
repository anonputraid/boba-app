package com.zulkarnaen.submission_api_30_android_pemula

import android.content.Intent
import android.content.res.TypedArray
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import android.net.Uri
import android.view.View
import android.widget.Button


class ActivityDetailBoba : AppCompatActivity(),  View.OnClickListener {
    companion object {
        const val KEY_BOBA = "Key_Boba"
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_boba)


        var dataBoba = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            intent.getParcelableExtra<Boba>(KEY_BOBA, Boba::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Boba>(KEY_BOBA)
        }

        val BannerBoba: ImageView = findViewById<ImageView>(R.id.bannerImage)
        val subHargaBoba: TextView = findViewById<TextView>(R.id.subHargaBoba)
        val titleBoba: TextView = findViewById<TextView>(R.id.titleBoba)
        val descBoba: TextView = findViewById<TextView>(R.id.description)
        val btnHargaBoba: Button = findViewById<Button>(R.id.btnHargaBoba)

        val fileName = dataBoba?.photoStr?.substringAfterLast("/")?.substringBeforeLast(".")

        val resourceId = resources.getIdentifier(fileName, "drawable", packageName)

        if (resourceId != 0) {
            BannerBoba.setImageResource(resourceId)
        } else {
            Toast.makeText(this, "Drawable not found", Toast.LENGTH_SHORT).show()
        }

        titleBoba.text    = "Boba ${dataBoba?.name}"
        subHargaBoba.text = "Rp. ${dataBoba?.harga}"
        descBoba.text     = dataBoba?.description
        btnHargaBoba.text = "Rp. ${dataBoba?.harga}"

        btnHargaBoba.setOnClickListener(this)
    }

    override fun onClick(dapatkanid: View?) {
        when(dapatkanid?.id){
            R.id.btnHargaBoba -> {
                Toast.makeText(this, "Maaf kak keranjang Belum Dibuat", Toast.LENGTH_SHORT).show()
            }

        }
    }
}