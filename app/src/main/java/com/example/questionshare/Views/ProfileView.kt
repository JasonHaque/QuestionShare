package com.example.questionshare.Views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.questionshare.Activities.LoginActivity
import com.example.questionshare.Admin.AdminActivity
import com.example.questionshare.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_profile_view.*

class ProfileView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_view)
        bindListeners()
    }
    private fun bindListeners(){
        goto_question_view.setOnClickListener {
            val intent=Intent(this,QuestionView::class.java)
            startActivity(intent)
        }
        log_out.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val intent=Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
        goto_admin_prompt.setOnClickListener {
            val intent=Intent(this,AdminActivity::class.java)
            startActivity(intent)
        }
    }
}
