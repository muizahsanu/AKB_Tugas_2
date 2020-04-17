package com.example.akb_tugas_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class VerifyAcountActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verify_acount)

        val intent = Intent(this,ProfileActivity::class.java)
        startActivity(intent)

    }
}
