package com.example.akb_tugas_2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        //Memanggil Fungsi Spinner
        iniSpinners()

        //Setting Toolbar
        toolbar_register.setNavigationIcon(R.drawable.ic_header_back)
        toolbar_register.setTitle("Register")
        setSupportActionBar(toolbar_register)

        //Validasi Form
        btn_register_register.setOnClickListener(){
            val username = frm_username_register.text.toString()
            val email = frm_email_register.text.toString()
            val phone = frm_phone_register.text.toString()
            val pass = frm_password_register.text.toString()
            val repas = frm_repassword_regsiter.text.toString()
            val address = frm_address_register.text.toString()
            val location = frm_location_register.text.toString()
            val spinnerGoldar: Spinner = findViewById(R.id.spn_goldar_register)
            val goldar = spinnerGoldar.selectedItem.toString()

            if(username.isEmpty()){
                frm_username_register.hasFocus()
                frm_username_register.setError("Username tidak boleh kosong")
            }
            else if(email.isEmpty()){
                frm_email_register.hasFocus()
                frm_email_register.setError("Email tidak boleh kosong")
            }
            else if(phone.isEmpty()){
                frm_email_register.hasFocus()
                frm_email_register.setError("No Telepon harus diisi")
            }
            else if(pass.isEmpty()){
                frm_email_register.hasFocus()
                frm_email_register.setError("Password tidak boleh kosong")
            }
            else if(address.isEmpty()){
                frm_email_register.hasFocus()
                frm_email_register.setError("Address tidak boleh kosong")
            }
            else if(location.isEmpty()){
                frm_email_register.hasFocus()
                frm_email_register.setError("Location tidak boleh kosong")
            }
            else if(repas != pass){
                frm_email_register.hasFocus()
                frm_email_register.setError("Password doesn't match")
            }
            else{
                val intent = Intent(this,SuccessActivity::class.java)
                intent.putExtra("username",username)
                intent.putExtra("goldar",goldar)
                val intent2 = Intent(this,SuccessActivity::class.java)
                startActivity(intent2)
            }
        }
    }

    fun onRadioButtonClicked(view: View){
        if(view is RadioButton){
            val checked = view.isChecked
        }
    }

    //Function Spinner
    fun iniSpinners() {
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
}