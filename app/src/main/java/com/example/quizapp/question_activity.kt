package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class question_activity : AppCompatActivity(), View.OnClickListener {

    /*  private var mCurrentPosition: Int = 1 // Default and the first question position
    private var mQuestionsList: ArrayList<Question>? = null
    private var mCorrectAnswers: Int = 0
*/

    var progressbar: ProgressBar? = null
    var progressview: TextView? = null
    var tvquestion: TextView? = null
    var iv_image: ImageView? = null
    var tv_optionone: TextView? = null
    var tv_optiontwo: TextView? = null
    var tv_optionthree: TextView? = null
    var tv_optionfour: TextView? = null
    var buttonsumbit: Button? = null

    private var mUser_NAME : String? = null
    private var mCorrectAnswers : Int = 0

    private var mselectedoptionposition: Int = 0
    private var mCurrentposition: Int = 1
    private var mQuestionslist = Constants.getQuestions()

    //@SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        mUser_NAME = intent.getStringExtra(Constants.USER_NAME)


        progressbar = findViewById(R.id.progressBar)
        progressview = findViewById(R.id.tvprogress)
        tvquestion = findViewById(R.id.tv_question)
        iv_image = findViewById(R.id.iv_flag)
        tv_optionone = findViewById(R.id.optionone)
        tv_optiontwo = findViewById(R.id.optiontwo)
        tv_optionthree = findViewById(R.id.optionthree)
        tv_optionfour = findViewById(R.id.optionfour)
        buttonsumbit = findViewById(R.id.button_submit)

        // set question
         setquestion()


        //defaultoptionview

        tv_optionone?.setOnClickListener(this)
        tv_optiontwo?.setOnClickListener(this)
        tv_optionthree?.setOnClickListener(this)
        tv_optionfour?.setOnClickListener(this)
        buttonsumbit?.setOnClickListener(this)


    }

    /* fun setQuestion() {
      /*  Log.i("Questionlist size is", "${questionlist.size}")

        for (i in questionlist) {
            Log.e("question", i.question)
        }

*/
         if ( mCurrentposition == mQuestionslist!!.size) {
             button_submit?.text = "FINISH"
         } else {

             button_submit?.text = "SUBMIT"
         }

         progressbar?.progress = mCurrentposition
         progressview?.text = "$mCurrentposition/${progressbar?.max}"
         tvquestion?.text = questionmain.question
         tv_optionone?.text = questionmain.optionone
         tv_optiontwo?.text = questionmain.optiontwo
         tv_optionthree?.text = questionmain.optionthree
         tv_optionfour?.text = questionmain.optionfour
         iv_image?.setImageResource(questionmain.image)



    }
*/


    private fun setquestion(){

        defaultoptionview()
        val questionmain: Question = mQuestionslist!![mCurrentposition - 1]
        progressbar?.progress = mCurrentposition
        progressview?.text = "$mCurrentposition/10"
        tvquestion?.text = questionmain.question
        tv_optionone?.text = questionmain.optionone
        tv_optiontwo?.text = questionmain.optiontwo
        tv_optionthree?.text = questionmain.optionthree
        tv_optionfour?.text = questionmain.optionfour
        iv_image?.setImageResource(questionmain.image)

        if (mCurrentposition == mQuestionslist!!.size) {
            buttonsumbit?.text = "FINISH"
        } else {
            buttonsumbit?.text = "SUBMIT"
        }

    }

    private fun defaultoptionview() {
        val options = ArrayList<TextView>()
        tv_optionone?.let {
            options.add(0, it)
        }
        tv_optiontwo?.let {
            options.add(1, it)
        }
        tv_optionthree?.let {
            options.add(2, it)
        }
        tv_optionfour?.let {
            options.add(3, it)
        }

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border_bg
            )
        }
    }
    private fun selectedoptionview(tv: TextView, selectedoptionnum: Int) {

        defaultoptionview()
        mselectedoptionposition = selectedoptionnum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.typeface = Typeface.DEFAULT
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_option_border_bg
        )
    }
    private fun answerView(answer: Int, drawableView: Int) {

        when (answer) {

            1 -> {
                tv_optionone?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            2 -> {
                tv_optiontwo?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            3 -> {
                tv_optionthree?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
            4 -> {
                tv_optionfour?.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }
    }
    override fun onClick(view: View?) {
        when (view?.id) {

            R.id.optionone -> {
                tv_optionone?.let {
                    selectedoptionview(it, 1)
                }

            }

            R.id.optiontwo -> {
                tv_optiontwo?.let {
                    selectedoptionview(it, 2)
                }

            }

            R.id.optionthree -> {
                tv_optionthree?.let {
                    selectedoptionview(it, 3)
                }

            }

            R.id.optionfour -> {
                tv_optionfour?.let {
                    selectedoptionview(it, 4)
                }

            }
            R.id.button_submit -> {

                if (mselectedoptionposition == 0) {
                    mCurrentposition++

                    when {

                        mCurrentposition <= mQuestionslist!!.size -> {
                            setquestion()
                        }
                        else -> {
                            val intent =
                        Intent(this,finish::class.java)
                        intent.putExtra(Constants.USER_NAME, mUser_NAME)
                        intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                        intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionslist?.size)
                        startActivity(intent)
                        finish()

                        }
                    }
                }
                else{
                    val question = mQuestionslist?.get(mCurrentposition - 1)

                    // This is to check if the answer is wrong
                    if (question!!.correctoption != mselectedoptionposition) {
                        answerView(mselectedoptionposition, R.drawable.wrong_option_border_bg)
                        answerView(question.correctoption, R.drawable.correct_option_border_bg)
                    }
                    else{
                        mCorrectAnswers++
                        answerView(question.correctoption, R.drawable.correct_option_border_bg)
                    }



                   // This is for correct answer
                    //answerView(question.correctoption, R.drawable.correct_option_border_bg)

                    if (mCurrentposition == mQuestionslist!!.size) {
                        buttonsumbit?.text= "FINISH"
                    } else {
                        buttonsumbit?.text = "GO TO NEXT QUESTION"
                    }

                    mselectedoptionposition = 0

                     }
                }
            }
        }

    }




