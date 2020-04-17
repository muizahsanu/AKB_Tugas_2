package com.example.akb_tugas_2

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.text.Editable
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //Memanggil Fungsi Spinner
        iniSpinners()
        //Setting Toolbar
        toolbar_register.setNavigationIcon(R.drawable.ic_header_back)
        toolbar_register.setTitle("Register")
        setSupportActionBar(toolbar_register)

        //Saat user menekan button register
        btn_register_register.setOnClickListener(){
            //Memanggil validasi form
            validasiForm()
        }
    }

    // Validasi Form
    private fun validasiForm(){
        val username = frm_username_register.text.toString()
        val email = frm_email_register.text.toString()
        val phone = frm_phone_register.text.toString()
        val pass = frm_password_register.text.toString()
        val repas = frm_repassword_regsiter.text.toString()
        val address = frm_address_register.text.toString()
        val location = frm_location_register.text.toString()
        val goldar = spn_goldar_register.selectedItem.toString()
        val rhesus = spn_rhesus_register.selectedItem.toString()
        val job = job_spinner.selectedItem.toString()

        if(username.isEmpty()){
            frm_username_register.setError("Username tidak boleh kosong")
            return
        }
        if(email.isEmpty()){
            frm_email_register.setError("Email tidak boleh kosong")
            return
        }
        if(phone.isEmpty()){
            frm_phone_register.setError("No Telepon harus diisi")
            return
        }
        if(goldar == "Blood Type"){
            val asd = spn_goldar_register.selectedView
            val errorTextView : TextView = asd as TextView
            errorTextView.setError("Pilih golongan darah")
            return
        }
        if(rhesus == "Rhesus"){
            val errorTextView : TextView = spn_rhesus_register.selectedView as TextView
            errorTextView.setError("Pilih rhesus")
            return
        }
        if(pass.isEmpty()){
            frm_password_register.setError("Password tidak boleh kosong")
            return
        }
        if(repas != pass){
            frm_repassword_regsiter.setError("Password doesn't match")
            return
        }
        if(job == "Job"){
            val errorTextView : TextView = job_spinner.selectedView as TextView
            errorTextView.setError("Pilih  job")
            return
        }
        if(address.isEmpty()){
            frm_address_register.setError("Address tidak boleh kosong")
            return
        }
        if(location.isEmpty()){
            frm_location_register.setError("Location tidak boleh kosong")
            return
        }

        val wibu = spn_goldar_register.selectedItem.toString()
        val intent = Intent(this,SuccessActivity::class.java)
        //intent.putExtra("username",username)
        intent.putExtra("goldar",wibu)
        intent.putExtra("username",username)
        startActivity(intent)
    }

    // Function Check box
    fun onCheckboxClicked(view: View) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

            when (view.id) {
                R.id.cb_terms_register -> {
                    if (checked) {
                        btn_register_register.isClickable = true
                    } else {
                        btn_register_register.isClickable = false
                    }
                }
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