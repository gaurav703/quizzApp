package com.example.quizapp

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

     fun getQuestions():ArrayList<Question>{
          val questionlist = ArrayList<Question>()

            // 1
            val que1 = Question(
                1, "Guess the country" ,
                  R.drawable.ic_flag_of_argentina,
                "Agrentina",
                "India",
                "Austria",
                "Fiji",
                1
            )
            questionlist.add(que1)


             // 2
            val que2 = Question(
                1,"Guess the country",
                R.drawable.ic_flag_of_belgium,
                "Fiji",
                "Sri lanka",
                "Belgium",
                "Argentina",
                3
            )
            questionlist.add(que2)
            // 3
             val que3 = Question(
                 1,"Guess the country",
                 R.drawable.ic_flag_of_australia,
                 "Fiji",
                 "Australia",
                 "Belgium",
                 "Argentina",
                 2
             )
            questionlist.add(que3)


             //4
             val que4 = Question(
             1,"Guess the country",
             R.drawable.ic_flag_of_brazil,
             "Fiji",
             "Brazil",
             "Belgium",
             "Argentina",
             2
             )
             questionlist.add(que4)


             // 5
            val que5 = Question(
                1,"Guess the country",
                R.drawable.ic_flag_of_denmark,
                "Fiji",
                "Sri lanka",
                "Denmark",
                "Australia",
                3
            )
            questionlist.add(que5)

            // 6
            val que6 = Question(
                1,"Guess the country",
                R.drawable.ic_flag_of_fiji,
                "Fiji",
                "Sri lanka",
                "Belgium",
                "Argentina",
                1
            )
            questionlist.add(que6)

            // 7
            val que7 = Question(
                1,"Guess the country",
                R.drawable.ic_flag_of_germany,
                "Fiji",
                "Germany",
                "Belgium",
                "Argentina",
                2
            )
            questionlist.add(que7)

            // 8
            val que8 = Question(
                1,"Guess the country",
                R.drawable.ic_flag_of_india,
                "Fiji",
                "India",
                "Germany",
                "Argentina",
                2
            )
            questionlist.add(que8)

            // 9
            val que9 = Question(
                1,"Guess the country",
                R.drawable.ic_flag_of_kuwait,
                "Fiji",
                "kuwait",
                "Belgium",
                "Argentina",
                2
            )
            questionlist.add(que9)

            // 10
            val que10 = Question(
                1,"Guess the country",
                R.drawable.ic_flag_of_new_zealand,
                "Fiji",
                "China",
                "Belgium",
                "New zealand",
               4
            )
         questionlist.add(que10)

            return questionlist


     }
}