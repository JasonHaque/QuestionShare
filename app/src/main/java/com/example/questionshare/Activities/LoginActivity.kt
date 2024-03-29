package com.example.questionshare.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.questionshare.R
import com.example.questionshare.Views.ProfileView
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        checkUserStatus()
        bindListeners()
    }

    fun bindListeners(){
        GotoSignUpButton.setOnClickListener {
            val intent= Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }
        logInButton.setOnClickListener {
            val email=LoginMail.text.toString()
            val pass=LoginPassword.text.toString()
            val validator=validateInputs(email,pass)
            if(validator==false){
                toastify("Fill up the fields properly")
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email,pass).addOnSuccessListener {
                toastify("Successfully Logged in")
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
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
    }
    fun checkUserStatus(){
        if (FirebaseAuth.getInstance().currentUser != null){
            val intent=Intent(this,ProfileView::class.java)
            startActivity(intent)
        }
    }
}
