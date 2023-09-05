package com.example.quiz_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView questionTV,questionNumberTV;
    private Button option1btn,option2btn,option3btn,option4btn;
    private ArrayList<QuizModel> quizModalArrayList;
    Random random;
    int currentScore = 0,questionAttempted = 1,currentPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionTV = findViewById(R.id.idTVQuestion);
        questionNumberTV = findViewById(R.id.idTVQuestionAttempted);
        option1btn = findViewById(R.id.idBtnOption1);
        option2btn = findViewById(R.id.idBtnOption2);
        option3btn = findViewById(R.id.idBtnOption3);
        option4btn = findViewById(R.id.idBtnOption4);
        quizModalArrayList = new ArrayList<>();
        random = new Random();
        getQuizQuestion(quizModalArrayList);
        currentPos = random.nextInt(quizModalArrayList.size());
        setDataToViews(currentPos);
        option1btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option1btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);

            }
        });
        option2btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option2btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);

            }
        });
        option3btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option3btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);

            }
        });
        option4btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option4btn.getText().toString().trim().toLowerCase())){
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);

            }
        });
    }
    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.LLscore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTVScore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your Score is \n"+currentScore + "/10");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
                questionAttempted = 1;
                currentScore = 0;
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();


    }
    private void setDataToViews(int currentPos){
        questionNumberTV.setText("Questions Attempted : "+questionAttempted + "/10");
        if(questionAttempted == 10){
            showBottomSheet();
        }else {
            questionTV.setText(quizModalArrayList.get(currentPos).getQuestion());
            option1btn.setText(quizModalArrayList.get(currentPos).getOption1());
            option2btn.setText(quizModalArrayList.get(currentPos).getOption2());
            option3btn.setText(quizModalArrayList.get(currentPos).getOption3());
            option4btn.setText(quizModalArrayList.get(currentPos).getOption4());
        }



    }
    private void getQuizQuestion(ArrayList<QuizModel> quizModalArrayList) {
        quizModalArrayList.add(new QuizModel("89 + 45 =","124","134","154","168","134"));
        quizModalArrayList.add(new QuizModel("82 - 35 =","37","67","57","47","47"));
        quizModalArrayList.add(new QuizModel("79 * 6 =","478","464","474","484","474"));
        quizModalArrayList.add(new QuizModel("47 + 91 =","118","138","148","128","138"));
        quizModalArrayList.add(new QuizModel("27 / 9 * 3 =","18","3","9","1","9"));
        quizModalArrayList.add(new QuizModel("56 - 41 = ","9","15","14","12","15"));
        quizModalArrayList.add(new QuizModel("34 + 81 =","115","145","105","125","115"));
        quizModalArrayList.add(new QuizModel("9 * 9 / 6 * 2 =","3","18","27","9","27"));
        quizModalArrayList.add(new QuizModel("31 + 99 =","129","130","140","120","130"));
        quizModalArrayList.add(new QuizModel("58 + 27 =","85","55","95","75","85"));
        quizModalArrayList.add(new QuizModel("163 - 84 =","89","69","59","79","79"));
        quizModalArrayList.add(new QuizModel("536 / 4 =","134","154","124","164","134"));
        quizModalArrayList.add(new QuizModel("78 - 49 =","24","14","29","19","29"));
        quizModalArrayList.add(new QuizModel("55 + 65 =","110","120","130","115","120"));
        quizModalArrayList.add(new QuizModel("145 - 87 =","59","58","57","56","58"));
        quizModalArrayList.add(new QuizModel("201 - 145 =","56","66","54","46","56"));
        quizModalArrayList.add(new QuizModel("78 + 14 =","91","102","92","101","92"));
        quizModalArrayList.add(new QuizModel("92 - 45 =","57","47","87","67","47"));
        quizModalArrayList.add(new QuizModel("71 * 2 =","144","146","142","152","142"));
        quizModalArrayList.add(new QuizModel("105 / 3 =","45","35","43","25","35"));
           }
}