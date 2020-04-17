package com.example.akb_tugas_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val nama = intent.getStringExtra("username")
        val goldar = intent.getStringExtra("goldar")

        tv_nama_home.setText(nama)
        tv_bloodtype_home.setText("Blood type : "+goldar)
    }
}
