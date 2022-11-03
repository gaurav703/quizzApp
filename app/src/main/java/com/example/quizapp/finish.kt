package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class finish : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        var tv_name: TextView = findViewById(R.id.textView5)
        var tv_score: TextView = findViewById(R.id.textView6)
        var button: Button = findViewById(R.id.button)

        tv_name.text = intent.getStringExtra(Constants.USER_NAME)
        var totalquestion: Int = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        var correctquestion: Int = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)


        tv_score.text = " Your Score is ${correctquestion} out of ${totalquestion} "

        button.setOnClickListener() {
            startActivity(Intent(this, MainActivity::class.java))

        }
    }

}
