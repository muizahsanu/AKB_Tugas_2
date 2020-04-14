package com.example.akb_tugas_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Spinner

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val jobSpinner: Spinner = findViewById(R.id.job_spinner)
        val goldarSpinner: Spinner = findViewById(R.id.spn_goldar_register)
        val rhesusSpinner: Spinner = findViewById(R.id.spn_rhesus_register)

        ArrayAdapter.createFromResource(
            this, R.array.job_array,R.layout.spinner_text_style
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            jobSpinner.adapter = adapter
        }
        ArrayAdapter.createFromResource(
            this,R.array.arr_goldar_register,R.layout.spinner_text_style
        ).also {adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            goldarSpinner.adapter = adapter
        }
        ArrayAdapter.createFromResource(
            this,R.array.arr_rhesus_register,R.layout.spinner_text_style
        ).also {adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            rhesusSpinner.adapter = adapter
        }
    }

    fun onRadioButtonClicked(view: View){
        if(view is RadioButton){
            val checked = view.isChecked
        }
    }
}
