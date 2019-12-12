package com.example.questionshare.Views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.questionshare.R
import kotlinx.android.synthetic.main.activity_question_view.*

class QuestionView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question_view)
        bindListeners()
    }
    fun bindListeners(){
        goto_cq.setOnClickListener {
            val intent=Intent(this,CreativeQuestionView::class.java)
            startActivity(intent)
        }

        goto_mcq.setOnClickListener {
            val intent=Intent(this,MultipleChoiceQuestionView::class.java)
            startActivity(intent)
        }
    }
}
