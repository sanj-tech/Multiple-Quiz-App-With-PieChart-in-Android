package com.jsstech.multiplequiz;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView questionTv, questionNoTv;
    private Button btoption1, btoption2;
    private ArrayList<QuestionModel> questionModelArrayList;
    Random random;
    int currentScore = 0, questionattempted = 0, currentPos;
    LinearLayout linearLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionTv = findViewById(R.id.idTvQues);
        questionNoTv = findViewById(R.id.idtvQuestionAttempted);
        btoption1 = findViewById(R.id.bt_ok);
        btoption2 = findViewById(R.id.not_ok);
        questionModelArrayList = new ArrayList<>();

        linearLayout = findViewById(R.id.lineearscore);
        random = new Random();

        getQuizQuestion(questionModelArrayList);

        currentPos = random.nextInt(questionModelArrayList.size());

        setDataView(currentPos);

        btoption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questionModelArrayList.get(currentPos).getAnsResult().trim().toLowerCase().equals(btoption1.getText().toString().trim().toLowerCase())) {
                    currentScore++;

                }
                questionattempted++;
                currentPos = random.nextInt(questionModelArrayList.size());
                setDataView(currentPos);

            }
        });

        btoption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (questionModelArrayList.get(currentPos).getAnsResult().trim().toLowerCase().equals(btoption2.getText().toString().trim().toLowerCase())) {
                    currentScore++;

                }
                questionattempted++;
                currentPos = random.nextInt(questionModelArrayList.size());
                setDataView(currentPos);


            }
        });


    }

    private void showBottomRes() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
        View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.displyscore,linearLayout);
        TextView scoretv = view.findViewById(R.id.score);

        Button restart = view.findViewById(R.id.btrestart);

        Button getScoreBoard=view.findViewById(R.id.scoreBoard);
        getScoreBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,PieChartActivity.class);
                startActivity(intent);
            }
        });




        scoretv.setText("Your Score is\n" + currentPos + "/5");

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPos = random.nextInt(questionModelArrayList.size());
                setDataView(currentPos);
                questionattempted = 1;
                currentScore = 0;
                bottomSheetDialog.dismiss();
            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(view);
        bottomSheetDialog.show();
    }


    private void setDataView(int currentPos) {

        if (questionattempted == 6) {
            showBottomRes();
        } else {
        questionNoTv.setText("Question Attempted:" + questionattempted + "/5");

        questionTv.setText(questionModelArrayList.get(currentPos).getQues());
        btoption1.setText(questionModelArrayList.get(currentPos).getOpt1());
        btoption2.setText(questionModelArrayList.get(currentPos).getOp2());


         }

    }

    private void getQuizQuestion(ArrayList<QuestionModel> questionModelArrayList) {
        questionModelArrayList.add(new QuestionModel("Android is operating system","ok","notOk","ok"));
        questionModelArrayList.add(new QuestionModel("Java is object oriented programming language","ok","not Ok","ok"));
        questionModelArrayList.add(new QuestionModel("Android is  not linux based operating system","ok","not ok","not Ok"));
        questionModelArrayList.add(new QuestionModel("Android is developed by Android Inc?","ok","not Ok","ok"));
        questionModelArrayList.add(new QuestionModel("Jvm is stand for java virtual machine","ok","not ok","ok"));


    }


}
