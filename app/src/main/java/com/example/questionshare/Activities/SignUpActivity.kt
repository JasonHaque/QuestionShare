package com.example.questionshare.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.questionshare.R
import com.example.questionshare.Views.ProfileView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        bindListeners()
    }
    fun bindListeners(){
        SignUpButton.setOnClickListener {
            val email=SignUPMail.text.toString()
            val pass=SignUpPassword.text.toString()
            val validator =validateInputs(email,pass)
            if(!validator){
                toastify("Fill up the fields properly")
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,pass).addOnSuccessListener {
                toastify("Successfully Signed up")
                val intent=Intent(this,ProfileView::class.java)
                startActivity(intent)
            }


        }
    }
    fun validateInputs(email:String,pass:String): Boolean{

        if(email.isEmpty() || pass.isEmpty()){
            return false

        }
        return true
    }
    fun toastify(message:String){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }
}
