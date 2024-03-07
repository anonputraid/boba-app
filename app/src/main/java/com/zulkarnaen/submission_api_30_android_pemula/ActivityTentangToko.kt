package com.zulkarnaen.submission_api_30_android_pemula

import ListBobaAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ActivityTentangToko : AppCompatActivity() {
    private lateinit var rvBoba: RecyclerView
    private val list = ArrayList<Boba>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tentang_toko)

        rvBoba = findViewById(R.id.rv_menu_boba)
        rvBoba.setHasFixedSize(true)

        list.addAll(getListBoba())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_list -> {
                rvBoba.layoutManager = LinearLayoutManager(this)
            }
            R.id.action_grid -> {
                rvBoba.layoutManager = GridLayoutManager(this, 2)
            }
        }
        return super.onOptionsItemSelected(item)
    }


    private fun getListBoba(): ArrayList<Boba> {
        val dataName        = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto       = resources.obtainTypedArray(R.array.data_photo)
        val dataHarga       = resources.getStringArray(R.array.data_harga)
        val dataPhotoStr    = resources.getStringArray(R.array.data_photo_string)
        val listBoba        = ArrayList<Boba>()

        for (i in dataName.indices) {
            val boba = Boba(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), dataHarga[i], dataPhotoStr[i])
            listBoba.add(boba)
        }

        return listBoba
    }

    private fun showRecyclerList() {
        rvBoba.layoutManager = LinearLayoutManager(this)
        val listBobaAdapter = ListBobaAdapter(list)
        rvBoba.adapter = listBobaAdapter

        listBobaAdapter.setOnItemClickCallback(object : ListBobaAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Boba) {
                showSelectedBoba(data)
            }
        })
    }

    private fun showSelectedBoba(boba: Boba) {
        val moveIntent = Intent(this@ActivityTentangToko, ActivityDetailBoba::class.java)
        moveIntent.putExtra(ActivityDetailBoba.KEY_BOBA, boba)
        startActivity(moveIntent)
    }
}