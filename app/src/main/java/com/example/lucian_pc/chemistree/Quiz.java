package com.example.lucian_pc.chemistree;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Quiz logic
 */

public class Quiz extends AppCompatActivity implements View.OnClickListener{

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            //Removes title bar
            this.requestWindowFeature(Window.FEATURE_NO_TITLE);

            //Removes notification bar
            this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

            setContentView(R.layout.question_one);

            // Watches for user press, scores user
            Button finish_quiz = findViewById(R.id.finish_quiz);
            finish_quiz.setOnClickListener(this);
        }

        // Awards 1 point per correct answer, and calculates final score as a percentage
        public void finishQuiz (View view) {
            int correctQuestionOne;
            int correctQuestionTwo;
            int correctQuestionThree;
            int correctQuestionFour;
            int correctQuestionFive;
            int correctQuestionSix;
            int correctQuestionSeven;
            int correctQuestionEight;
            int correctQuestionNine;
            int correctQuestionTen;
            int correctQuestionEleven;
            int Score;
            int finalScore;
            int highScore = 80;

            // Updates score TextView
            TextView scoreView = findViewById(R.id.finish_score);

            // Question 1-6 button declarations
            RadioButton questionOne = this.findViewById(R.id.question_one_d);
            RadioButton questionTwo = this.findViewById(R.id.question_two_a);
            RadioButton questionThree = this.findViewById(R.id.question_three_a);
            RadioButton questionFour = this.findViewById(R.id.question_four_b);
            RadioButton questionFive = this.findViewById(R.id.question_five_b);
            RadioButton questionSix = this.findViewById(R.id.question_six_b);

            // Question 7,8 checkbox declarations
            CheckBox questionSevenA = this.findViewById(R.id.question_seven_a);
            CheckBox questionSevenB = this.findViewById(R.id.question_seven_b);
            CheckBox questionSevenC = this.findViewById(R.id.question_seven_c);
            CheckBox questionSevenD = this.findViewById(R.id.question_seven_d);
            CheckBox questionEightA = this.findViewById(R.id.question_eight_a);
            CheckBox questionEightB = this.findViewById(R.id.question_eight_b);
            CheckBox questionEightC = this.findViewById(R.id.question_eight_c);
            CheckBox questionEightD = this.findViewById(R.id.question_eight_d);

            // Question 9-11 editable declarations
            EditText questionNine =findViewById(R.id.answer_nine);
            EditText questionTen = findViewById(R.id.answer_ten);
            EditText questionEleven = findViewById(R.id.answer_eleven);

            // Converts answers to strings
            String answerNine = questionNine.getText().toString();
            String answerTen = questionTen.getText().toString();
            String answerEleven = questionEleven.getText().toString();
            String answerNineCompare = getResources().getString(R.string.answer_nine);
            String answerTenCompare = getResources().getString(R.string.answer_ten);
            String answerElevenCompare = getResources().getString(R.string.answer_eleven);

            // Determines if buttons are pressed
            Boolean checkQuestionOne = questionOne.isChecked();
            Boolean checkQuestionTwo = questionTwo.isChecked();
            Boolean checkQuestionThree = questionThree.isChecked();
            Boolean checkQuestionFour = questionFour.isChecked();
            Boolean checkQuestionFive = questionFive.isChecked();
            Boolean checkQuestionSix = questionSix.isChecked();
            Boolean checkQuestionSevenA = questionSevenA.isChecked();
            Boolean checkQuestionSevenB = questionSevenB.isChecked();
            Boolean checkQuestionSevenC = questionSevenC.isChecked();
            Boolean checkQuestionSevenD = questionSevenD.isChecked();
            Boolean checkQuestionEightA = questionEightA.isChecked();
            Boolean checkQuestionEightB = questionEightB.isChecked();
            Boolean checkQuestionEightC = questionEightC.isChecked();
            Boolean checkQuestionEightD = questionEightD.isChecked();

            // Checks for correct answers
            correctQuestionOne = (checkQuestionOne) ? 1 : 0;
            correctQuestionTwo = (checkQuestionTwo) ? 1 : 0;
            correctQuestionThree = (checkQuestionThree) ? 1 : 0;
            correctQuestionFour = (checkQuestionFour) ? 1 : 0;
            correctQuestionFive = (checkQuestionFive) ? 1 : 0;
            correctQuestionSix = (checkQuestionSix) ? 1 : 0;
            correctQuestionSeven = (checkQuestionSevenA) && (checkQuestionSevenB) && (checkQuestionSevenC) && (!checkQuestionSevenD) ? 1 : 0;
            correctQuestionEight = (checkQuestionEightA) && (checkQuestionEightB) && (!checkQuestionEightC) && (!checkQuestionEightD) ? 1 : 0;
            correctQuestionNine = (answerNine.equals(answerNineCompare))? 1 : 0;
            correctQuestionTen = (answerTen.equals(answerTenCompare))? 1 : 0;
            correctQuestionEleven = (answerEleven.equals(answerElevenCompare))? 1 : 0;

            // Calculates the final quiz score
            Score = correctQuestionOne + correctQuestionTwo + correctQuestionThree + correctQuestionFour
                       + correctQuestionFive + correctQuestionSix + correctQuestionSeven + correctQuestionEight
                       + correctQuestionNine + correctQuestionTen + correctQuestionEleven ;
            finalScore = Score * 100 / 11;
            scoreView.setText(String.valueOf(finalScore) + "%");

            // Displays a toast message based on score earned
            if (finalScore <= highScore ) {
                Toast.makeText(getApplicationContext(), "Your score is: " + finalScore + "%", Toast.LENGTH_LONG).show();
            }
            else {
                Toast.makeText(getApplicationContext(), "Congratulations! High score of : " + finalScore + "%", Toast.LENGTH_LONG).show();
            }
        }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.finish_quiz:
                this.finishQuiz(null);
            default:
                break;
        }
    }
}
