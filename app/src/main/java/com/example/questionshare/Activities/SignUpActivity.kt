package com.example.questionshare.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.questionshare.R
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        bindListeners()
    }
    fun bindListeners(){
        SignUpButton.setOnClickListener {
            val validator =validateInputs()
            if(!validator){
                Toast.makeText(this,"Fill up the fields properly",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


        }
    }
    fun validateInputs(): Boolean{
        val email=SignUPMail.text.toString()
        val pass=SignUpPassword.text.toString()
        if(email.isEmpty() || pass.isEmpty()){
            return false

        }
        return true
    }
}
