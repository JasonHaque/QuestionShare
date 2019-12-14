package com.example.questionshare.Admin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.questionshare.R
import kotlinx.android.synthetic.main.activity_set_question.*

class SetQuestion : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_question)
        bindWigets()
    }

    fun bindWigets(){
        type_mcq.setOnClickListener {
            val intent =Intent(this,CreateMCQ::class.java)
            startActivity(intent)
        }
        type_cq.setOnClickListener {
            val intent = Intent(this,CreateCQ::class.java)
            startActivity(intent)
        }
    }
}
