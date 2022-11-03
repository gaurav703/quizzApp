package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Button_start : Button = findViewById(R.id.Button_start)
        val name : EditText = findViewById(R.id.name)
        Button_start.setOnClickListener {
          if( name.text.isEmpty()){

              Toast.makeText(this,
                  "Please enter your name", Toast.LENGTH_LONG).show()

          }else{
           val  intent = Intent(this, question_activity::class.java)
              intent.putExtra(Constants.USER_NAME,name.text.toString())
              startActivity(intent)
              finish()  // stop the current activity
          }

        }
    }
}


