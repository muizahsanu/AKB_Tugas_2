package com.example.akb_tugas_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val goldar = intent.getStringExtra("goldar")
        val nama = intent.getStringExtra("username")

        tv_nama_home.text = nama
        tv_bloodtype_home.text = "Blood Type : "+goldar
    }
}
