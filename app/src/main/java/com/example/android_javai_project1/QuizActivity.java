package com.example.android_javai_project1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {
   private ArrayList<QuizQuestion> quizQuestionList = null;
   QuizQuestion currentQuestion = null;
    int currentQuestionNumber = 1;

    private int currentScore = 0;
    private int maxScore = 0;

    TextView textViewQuestionTitle = null;
    TextView textViewQuestion = null;
    TextView textViewScore = null;
    TextView textViewQuizQuestion = null;

    RadioGroup radioGroupQuestion = null;
    RadioButton radioButtonA = null;
    RadioButton radioButtonB = null;
    RadioButton radioButtonC = null;
    RadioButton radioButtonD = null;

    Button buttonSubmit = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        // Initialize widgets.
        this.textViewQuestionTitle = (TextView)findViewById(R.id.textViewQuestionTitle);    // The question title
        this.textViewQuestion = (TextView)findViewById(R.id.textViewQuestion);              // The question asked.
        this.textViewScore = (TextView)findViewById(R.id.textViewScore);                    // The current score.
        this.textViewQuizQuestion = (TextView)findViewById(R.id.textViewQuizQuestion);      // The question number.

        // Intialize the radio buttons for question multiple choice answers.
        radioGroupQuestion = (RadioGroup)findViewById(R.id.radioGroupQuestion);             // Create a group for radio buttons.
        radioButtonA = (RadioButton)findViewById(R.id.radioButtonA);
        radioButtonB = (RadioButton)findViewById(R.id.radioButtonB);
        radioButtonC = (RadioButton)findViewById(R.id.radioButtonC);
        radioButtonD = (RadioButton)findViewById(R.id.radioButtonD);

        // Initialize the submit question answer along with the callback function.
        this.buttonSubmit = (Button)findViewById(R.id.buttonSubmit);
        this.buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Step 1: Call validateAnswer() to check if the current answer (provided by user) is correct (valid).
                // Step 2: Compare the current question number with the max score. If the case where the current question number
                //         is less than the max score (we have more questions to go.
                // Step 3: If we still have questions to ask: (1) Set the currentQuestion variable, (2) prompt the user with setQuestionView.
                //         and (3) remember to increment the currentQuestionNumber.
                // Step 4: If there are now questions left in the array, transition the user to the results activity.
                if(validateAnswer()) {
                    if(currentQuestionNumber < maxScore) {
                        ///////////////////////////////////////////////////////////////////////////////////////////////////////
                        // TO-DO: Set currentQuestion to the next question (because we want to process what is next).
                        // You can set the reference from the quizQuestionList.
                        // Use currentQuestionNumber as the index (remember to increment this at the end so that we can fetch the next question index).
                        ///////////////////////////////////////////////////////////////////////////////////////////////////////
                       currentQuestion = quizQuestionList.get(currentQuestionNumber);
                       currentQuestionNumber++;
                       setQuestionView(currentQuestion);
                       String mxScore = Integer.toString(maxScore);
                       Log.d("current question: ", String.valueOf(currentQuestionNumber));
                       Log.d("maxScore: ", String.valueOf(maxScore));

                    }
                    else {
                        // No questions left to ask. Transition the user to the results page.

                        ///////////////////////////////////////////////////////////////////////////////////////////////////////
                        // TO-DO: Create a new intent that will transition to user to next ResultsActivity.
                        // HINT: We want to pass in some extra values for the results class to use. So use something like:
                        //       intent.putExtra(...);
                        ///////////////////////////////////////////////////////////////////////////////////////////////////////
                        Intent intent = new Intent(QuizActivity.this,com.example.android_javai_project1.ResultActivity.class);
                        intent.putExtra("currentScore", currentScore);
                        intent.putExtra("maxScore",maxScore);
                        startActivity(intent);
                    }
                }

            }
        });

        // Initiate all questions first.
        this.initQuestions();

        // Ask use the first question when this activity loads.
        this.setQuestionView(this.currentQuestion);
    }

    private void initQuestions() {
        // Create some questions to ask the questions.

        this.quizQuestionList = new ArrayList<QuizQuestion>();  // Initialize our question array.

        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        // TO-DO: Create instances (using the new QuizQuestion()) of your questions.
        // You will have to call into QuizQuestion() setters to set the follow:
        // - The question to ask.
        // - Set choice options for A, B, C, and D.
        // - Set the correct answer (so that class knows which one is correct or not).
        // - Remember to add the object to our quizQuestionList array. Hint: Use .add(...) function here.
        // NOTE: No widgets should be set in this method.
        ///////////////////////////////////////////////////////////////////////////////////////////////////////

        QuizQuestion q1 = new QuizQuestion();
        QuizQuestion q2 = new QuizQuestion();
        QuizQuestion q3 = new QuizQuestion();
        QuizQuestion q4 = new QuizQuestion();
        QuizQuestion q5 = new QuizQuestion();

        //Question 1
        q1.setQuestion("What is largest state in America?");
        q1.setChoiceA("Alaska");
        q1.setChoiceB("Arizona");
        q1.setChoiceC("California");
        q1.setChoiceD("Texas");
        q1.setCorrectAnswer("Texas");
        quizQuestionList.add(q1);

        //Question 2
        q2.setQuestion("Who is the first United States of America President?");
        q2.setChoiceA("Bill Clinton");
        q2.setChoiceB("George Washington");
        q2.setChoiceC("George Bush");
        q2.setChoiceD("Barack Obama");
        q2.setCorrectAnswer("George Washington");
        quizQuestionList.add(q2);

        //Question 3
        q3.setQuestion("What is the name of the snowman in Frozen?");
        q3.setChoiceA("Anna");
        q3.setChoiceB("Elsa");
        q3.setChoiceC("Kristoff");
        q3.setChoiceD("Olaf");
        q3.setCorrectAnswer("Olaf");
        quizQuestionList.add(q3);

        //Question 4
        q4.setQuestion("Who is the first astronaut to walk on moon?");
        q4.setChoiceA("Alan Bean");
        q4.setChoiceB("Alan Shepard");
        q4.setChoiceC("Neil Armstrong");
        q4.setChoiceD("Buzz Aldrin");
        q4.setCorrectAnswer("Neil Armstrong");
        quizQuestionList.add(q4);

        //Question 5
        q5.setQuestion("Who invented electricity?");
        q5.setChoiceA("Albert Einstein");
        q5.setChoiceB("Henry Ford");
        q5.setChoiceC("Benjamin Franklin");
        q5.setChoiceD("Thomas Edison");
        q5.setCorrectAnswer("Thomas Edison");
        quizQuestionList.add(q5);

        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        // TO-DO: Set your currentQuestion to point to your first question here (uncomment out the code below).
        ///////////////////////////////////////////////////////////////////////////////////////////////////////

        //this.currentQuestion = /*Your first question*/;
        this.currentQuestion = q1;
        this.currentQuestionNumber = 1;
        this.maxScore = this.quizQuestionList.size();
        this.currentScore = 0;
    }

    private void setQuestionView(QuizQuestion quizQuestion) {
        if(quizQuestion == null) {
            Log.d("[DEBUG]", "quizQuestion is null in setQuestionView.");
            return;
        }

        // Clear the radio button checks just encase it was been set previously.
        radioGroupQuestion.clearCheck();
        String score = Integer.toString(currentScore);
        String questionNumber = Integer.toString(currentQuestionNumber);
        textViewScore.setText(score);
        textViewQuizQuestion.setText(questionNumber);
        textViewQuestion.setText(quizQuestion.getQuestion());
        radioButtonA.setText(quizQuestion.getChoiceA());
        radioButtonB.setText(quizQuestion.getChoiceB());
        radioButtonC.setText(quizQuestion.getChoiceC());
        radioButtonD.setText(quizQuestion.getChoiceD());

        // Loads the current question view.
        ///////////////////////////////////////////////////////////////////////////////////////////////////////
        // TO-DO: Set the UI view (all your widgets) with the current QuizQuestion passed in.
        // Hint: Use your getters from the QuizQuestion class to get the values stored there.
        // Set the following widget text:
        // - The question text (i.e. Question #1).
        // - Set the question to ask.
        // - Set all for radio button text.
        // - Set the score view with the current score (remember to convert integer to string).
        //   Example: Score: 2
        ///////////////////////////////////////////////////////////////////////////////////////////////////////

    }

    private boolean validateAnswer() {
        // Validate the current answer selected.
        int selectedButtonId = this.radioGroupQuestion.getCheckedRadioButtonId();
        if(selectedButtonId != -1) {
            String answerSelectedStr = ((RadioButton)findViewById(selectedButtonId)).getText().toString();

            if (currentQuestion.isCorrectAnswer(answerSelectedStr)) {
                // Answer is correct.
                Log.d("ANSWER: ", "Correct");
                currentScore++;
                Log.d("Current Score: ", toString(currentScore));
            }
            else {
                Log.d("ANSWER: ", "Incorrect");
            }
            return true; // Allow to continue to next question.
        }
        else {
            // No answer selected.
            Toast.makeText(getApplicationContext(), "Please Select An Answer",
                    Toast.LENGTH_SHORT).show();
            return false;
        }
    }

}