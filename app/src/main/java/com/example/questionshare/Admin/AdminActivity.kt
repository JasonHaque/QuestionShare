package com.example.questionshare.Admin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.questionshare.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_admin.*

class AdminActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)
        bindWidgets()
    }

    fun bindWidgets(){
        unlock_question_pannel.setOnClickListener {
            val passcode =admin_password.text.toString()
            if (passcode.isEmpty()){
                Toast.makeText(this,"Enter the passcode Please",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (FirebaseAuth.getInstance().currentUser?.email.toString() != "zahinjason220434@gmail.com"){
                Toast.makeText(this,"Not authorised User",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
        }
    }
}
