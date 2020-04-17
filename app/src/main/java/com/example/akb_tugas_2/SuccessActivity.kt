package com.example.akb_tugas_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_success.*

class SuccessActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_success)


        val goldar = intent.getStringExtra("goldar")
        val nama = intent.getStringExtra("username")

        btn_verify_success.setOnClickListener(){
            val intent = Intent(this,VerifyAcountActivity::class.java)
            intent.putExtra("username",nama)
            intent.putExtra("goldar",goldar)
            startActivity(intent)
        }
    }
}
