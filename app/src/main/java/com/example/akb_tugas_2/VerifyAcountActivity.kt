package com.example.akb_tugas_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_verify_acount.*

class VerifyAcountActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verify_acount)

        val goldar = intent.getStringExtra("goldar")
        val nama = intent.getStringExtra("username")

        btn_send_verify.setOnClickListener(){
            val intent = Intent(this,ProfileActivity::class.java)
            intent.putExtra("username",nama)
            intent.putExtra("goldar",goldar)
            startActivity(intent)
        }

    }
}
